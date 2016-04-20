/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbv.view;
import hbv.controller.SearchManager;
import java.awt.Color;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class WriteGuideReviewDisplay extends javax.swing.JFrame {

    private static String guideName;
    private static MainDisplay display;

    public WriteGuideReviewDisplay(String name, MainDisplay display) {
        this.display = display;
        initComponents();
        this.setLocationRelativeTo(display);
        guideName = name;
        initExtra();
        this.setResizable(false);
        
    }
    
    private void initExtra(){
        guideNameLab.setText(guideName);
        authorErrorLab.setVisible(false);
        titleErrorLab.setVisible(false);
        submitBtn.requestFocusInWindow();
        
        authorTxt.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                checkLength(authorTxt,authorErrorLab);
            }
            @Override
            public void removeUpdate(DocumentEvent de) {
                checkLength(authorTxt,authorErrorLab);
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
                checkLength(authorTxt,authorErrorLab);
            }
        });
        
        titleTxt.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                checkLength(titleTxt,titleErrorLab);
            }
            @Override
            public void removeUpdate(DocumentEvent de) {
                checkLength(titleTxt,titleErrorLab);
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
                checkLength(titleTxt,titleErrorLab);
            }  
        });
    }
    
    private void checkLength(JTextField txt, JLabel lab){
        if(txt.getText().length()>50) lab.setVisible(true);
        else lab.setVisible(false);
   }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tourReviewBackPan = new javax.swing.JPanel();
        titleLab = new javax.swing.JLabel();
        guideNameLab = new javax.swing.JLabel();
        writerBackgroundPan = new javax.swing.JPanel();
        authorLab = new javax.swing.JLabel();
        authorTxt = new javax.swing.JTextField();
        reviewTitleLab = new javax.swing.JLabel();
        titleTxt = new javax.swing.JTextField();
        titleErrorLab = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTxt = new javax.swing.JTextArea();
        submitBtn = new javax.swing.JButton();
        authorErrorLab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLab.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        titleLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLab.setText("Write a review for the guide:");

        guideNameLab.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        guideNameLab.setForeground(new java.awt.Color(0, 0, 255));
        guideNameLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        authorLab.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        authorLab.setText("Author:");

        authorTxt.setForeground(new java.awt.Color(204, 204, 204));
        authorTxt.setText("Your name here...");
        authorTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                authorTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                authorTxtFocusLost(evt);
            }
        });

        reviewTitleLab.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        reviewTitleLab.setText("Title:");

        titleTxt.setForeground(new java.awt.Color(204, 204, 204));
        titleTxt.setText("Descriptive title here...");
        titleTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                titleTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleTxtFocusLost(evt);
            }
        });

        titleErrorLab.setForeground(new java.awt.Color(255, 0, 0));
        titleErrorLab.setText("Too long (max 50 characters)");

        reviewTxt.setColumns(20);
        reviewTxt.setForeground(new java.awt.Color(204, 204, 204));
        reviewTxt.setRows(5);
        reviewTxt.setText("Write your review here...");
        reviewTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                reviewTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                reviewTxtFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(reviewTxt);

        submitBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        authorErrorLab.setForeground(new java.awt.Color(255, 0, 0));
        authorErrorLab.setText("Too long (max 50 characters)");

        javax.swing.GroupLayout writerBackgroundPanLayout = new javax.swing.GroupLayout(writerBackgroundPan);
        writerBackgroundPan.setLayout(writerBackgroundPanLayout);
        writerBackgroundPanLayout.setHorizontalGroup(
            writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writerBackgroundPanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(writerBackgroundPanLayout.createSequentialGroup()
                        .addGroup(writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorLab)
                            .addComponent(reviewTitleLab))
                        .addGap(18, 18, 18)
                        .addGroup(writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(authorTxt)
                            .addComponent(titleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(authorErrorLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleErrorLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        writerBackgroundPanLayout.setVerticalGroup(
            writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writerBackgroundPanLayout.createSequentialGroup()
                .addGroup(writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLab)
                    .addComponent(authorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorErrorLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(writerBackgroundPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewTitleLab)
                    .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleErrorLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tourReviewBackPanLayout = new javax.swing.GroupLayout(tourReviewBackPan);
        tourReviewBackPan.setLayout(tourReviewBackPanLayout);
        tourReviewBackPanLayout.setHorizontalGroup(
            tourReviewBackPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(writerBackgroundPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(tourReviewBackPanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tourReviewBackPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guideNameLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tourReviewBackPanLayout.setVerticalGroup(
            tourReviewBackPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tourReviewBackPanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideNameLab, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(writerBackgroundPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tourReviewBackPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tourReviewBackPan, javax.swing.GroupLayout.PREFERRED_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void authorTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_authorTxtFocusGained
        if(authorTxt.getText().equals("Your name here...")){
            authorTxt.setText("");
            authorTxt.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_authorTxtFocusGained

    private void authorTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_authorTxtFocusLost
        if(authorTxt.getText().equals("")){
            authorTxt.setForeground(new Color(204,204,204));
            authorTxt.setText("Your name here...");
        }
    }//GEN-LAST:event_authorTxtFocusLost

    private void titleTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleTxtFocusGained
        if(titleTxt.getText().equals("Descriptive title here...")){
            titleTxt.setText("");
            titleTxt.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_titleTxtFocusGained

    private void titleTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleTxtFocusLost
        if(titleTxt.getText().equals("")){
            titleTxt.setText("Descriptive title here...");
            titleTxt.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_titleTxtFocusLost

    private void reviewTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reviewTxtFocusGained
        if(reviewTxt.getText().equals("Write your review here...")){
            reviewTxt.setText("");
            reviewTxt.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_reviewTxtFocusGained

    private void reviewTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reviewTxtFocusLost
        if(reviewTxt.getText().equals("")){
            reviewTxt.setText("Write your review here...");
            reviewTxt.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_reviewTxtFocusLost

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        if(authorErrorLab.isVisible()){
            JOptionPane.showMessageDialog(this, "Please make sure that the author text field contains 50 or less characters.");
        }
        else if(titleErrorLab.isVisible()){
            JOptionPane.showMessageDialog(this, "Please make sure that the title text field contains 50 or less characters.");
        }
        else if(authorTxt.getText().equals("Your name here...")){
            JOptionPane.showMessageDialog(this, "Please enter a name.");
        }
        else if(titleTxt.getText().equals("Descriptive title here...")){
            JOptionPane.showMessageDialog(this, "Please add a title to your review");
        }
        else if(reviewTxt.getText().equals("Write your review here...")){
            JOptionPane.showMessageDialog(this, "You need to write something in your review in order to submit a review.");
        }
        else{
            SearchManager.addGuideReview(guideName, titleTxt.getText(), authorTxt.getText(), reviewTxt.getText(), 
                    new java.sql.Date(new java.util.Date().getTime()));
            display.refreshGuideReviewsList();
            this.dispose();
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WriteTourReviewDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteTourReviewDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteTourReviewDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteTourReviewDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WriteTourReviewDisplay(guideName, display).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorErrorLab;
    private javax.swing.JLabel authorLab;
    private javax.swing.JTextField authorTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel reviewTitleLab;
    private javax.swing.JTextArea reviewTxt;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel titleErrorLab;
    private javax.swing.JLabel titleLab;
    private javax.swing.JTextField titleTxt;
    private javax.swing.JLabel guideNameLab;
    private javax.swing.JPanel tourReviewBackPan;
    private javax.swing.JPanel writerBackgroundPan;
    // End of variables declaration//GEN-END:variables
}
