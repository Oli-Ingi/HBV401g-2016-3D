/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbv.model;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author Hoai Nam Duc Tran
 */
public class ReviewCell extends javax.swing.JPanel {

    /**
     * Creates new form ReviewCell
     */
    public ReviewCell(String reviewTitle, String amt) {
        initComponents();
        this.listReviewTitle.setText(reviewTitle);
        this.listAmtLab.setText(amt);
    }
    
    public void setLettersColor(Color color){
        listReviewTitle.setForeground(color);
        listAmtLab.setForeground(color);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        likes = new javax.swing.JLabel();
        listAmtLab = new javax.swing.JLabel();
        listReviewTitle = new javax.swing.JLabel();

        likes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/likeSign.png"))); // NOI18N

        listAmtLab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listAmtLab.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        listAmtLab.setText("amt");

        listReviewTitle.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        listReviewTitle.setText("Title goes here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listReviewTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(listAmtLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(likes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listAmtLab)
                        .addComponent(listReviewTitle))
                    .addComponent(likes))
                .addGap(0, 2, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel likes;
    private javax.swing.JLabel listAmtLab;
    private javax.swing.JLabel listReviewTitle;
    // End of variables declaration//GEN-END:variables
}
