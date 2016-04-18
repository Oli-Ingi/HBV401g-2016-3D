package hbv.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBManager {

	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet res = null;
	
	// Bý til tengingu við sqlite gagnagrunninn
	private static void setUp() throws SQLException,ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		File database = new File("src\\HBV.db");
		String dbPath = database.getAbsolutePath();
		conn = DriverManager.getConnection("JDBC:sqlite:"+dbPath);
	}
	
	// Loka öllum tengingum
	private static void closeAll(){
		try {
			pst.close();
			res.close();
			conn.close();	
		} catch (SQLException e) {
                    System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Sendir SELECT fyrirspurn til gagnagrunnsins og skilar niðurstöðunum í 2D fylki.
	 */
	public static String[][] getData(String columns, String table, HashMap<String,Object> whereParams) throws NoSuchElementException{
		String prepWhere = "";
                if(!whereParams.isEmpty()) prepWhere = buildWhereString(whereParams);
                
		String rowCounter = "SELECT COUNT(*) FROM "+table;
		String search = "SELECT "+columns+" FROM "+table;
		// data mun innihalda gögnin sem fást úr SQL-fyrirspurninni og verður þá skilagildi fallsins.
		String[][] data = null;
		
		try {
			setUp();
			// Sækjum fjölda raða sem munu koma út úr SQL-fyrirspurninni.
			pst = conn.prepareStatement(rowCounter+prepWhere);
			bindParams(1,whereParams);
                        
			res = pst.executeQuery();
			// Fáum fjölda raða í leitarniðurstöðunum til að stilla fjölda raða í data fylkinu á eftir.
			int rows = Integer.valueOf(res.getString(1));
			// Ef engar raðir eru í res, þá hendum við exception í staðinn fyrir að skila tómu fylki.
			if(rows==0) throw new NoSuchElementException("No match found in "+table+".");

			// Sækjum gögnin sjálf.			
			pst = conn.prepareStatement(search+prepWhere);
			bindParams(1,whereParams);
			res = pst.executeQuery();

			// Fáum fjölda dálka í leitarniðurstöðunum til að geta upphafsstillt data fylkið.
 			ResultSetMetaData rsmd = res.getMetaData();
			int cols = rsmd.getColumnCount();
			
			// Færum gögnin í res yfir í data fylkið.
			data = new String[rows][cols];
			int i = 0;
			while(res.next()){
				for(int j = 0; j<cols;j++){
					data[i][j] = res.getString(j+1);
				}
				i++;
			}
		} catch (ClassNotFoundException | SQLException e) {
                    System.out.println(e.getMessage());
		} finally{
                    closeAll();
		}
		return data;
	}
	
	// Sendir UPDATE statement til gagnagrunnsins.
	public static void updateData(String table, String ColName, String newValue, HashMap<String,Object> whereParams){
		try {
			setUp();
			
			String prepared = "UPDATE "+table+" SET "+ColName+"=?"+buildWhereString(whereParams);
			pst = conn.prepareStatement(prepared);
			pst.setString(1, newValue);
			bindParams(2,whereParams);
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
                    System.out.println(e.getMessage());
		} finally{
			closeAll();
		}
	}
	
        public static void insertData(String table, HashMap<String,Object> values){
            try {
                setUp();
                
                StringBuilder cols = new StringBuilder("(");
                StringBuilder placeHolders = new StringBuilder("(");
                for(String key: values.keySet()){
                    cols.append(key).append(",");
                    placeHolders.append("?,");
                }
                cols.deleteCharAt(cols.length()-1).append(')');
                placeHolders.deleteCharAt(placeHolders.length()-1).append(')');
                
                String prepared = "INSERT INTO "+table+cols.toString()+" VALUES"+placeHolders.toString();
                pst = conn.prepareStatement(prepared);
                bindParams(1,values);
                pst.execute();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
	/*
	 * Búum til streng fyrir WHERE-hlutann af SQL-fyrirspurn
	 * sem er á formi sem preparedStatement getur notað, þ.e. með '?' sem
	 * placeholders fyrir search parametrana.
	 */
	private static String buildWhereString(HashMap<String,Object> whereParams){
		StringBuilder prepWhere = new StringBuilder(" WHERE ");
		for(String key: whereParams.keySet()){
			prepWhere.append(key+"? AND ");
		}
		// Losna við síðasta 'AND'.
		prepWhere.delete(prepWhere.length()-5, prepWhere.length());
		prepWhere.append(';');
		
		return prepWhere.toString();
	}
        
        
	
	/*
	 * Stingum inn search parametrunum í placeholder-ana í
	 * prepared statementinu. index segir til um hvaða placeholder 
	 * er byrjað á.
	 */
	private static void bindParams(int index,HashMap<String,Object> params) throws SQLException{
		for(String key: params.keySet()){
			if(key.contains("LIKE")){
				pst.setString(index, "%"+params.get(key)+"%");
			}else{
				pst.setString(index, String.valueOf(params.get(key)));
			}
			index++;
		}
	}

	
	//TODO insert statement eða sleppa?
}
