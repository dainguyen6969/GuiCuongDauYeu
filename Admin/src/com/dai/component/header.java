/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.dai.component;

import java.awt.event.ActionListener;

/**
 *
 * @author ThinkPad
 */
public class header extends javax.swing.JPanel {

    /**
     * Creates new form header
     */
    public header() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdmenu = new com.dai.swing.Button();
        Avatar = new com.dai.swing.ImageAvatar();
        lbl_username = new javax.swing.JLabel();
        lbl_role = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dai/icon/menu.png"))); // NOI18N
        cmdmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdmenuActionPerformed(evt);
            }
        });

        Avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dai/icon/WIN_20241215_16_00_30_Pro.jpg"))); // NOI18N

        lbl_username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(127, 127, 127));
        lbl_username.setText("User Name");

        lbl_role.setForeground(new java.awt.Color(127, 127, 127));
        lbl_role.setText("Admin");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_username, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_role, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_username)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_role)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addMenuEvent(ActionListener event){
        cmdmenu.addActionListener(event);
    }
    
    private void cmdmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdmenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdmenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.dai.swing.ImageAvatar Avatar;
    private com.dai.swing.Button cmdmenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_role;
    private javax.swing.JLabel lbl_username;
    // End of variables declaration//GEN-END:variables
}
