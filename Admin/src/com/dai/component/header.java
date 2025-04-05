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


    public header() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdmenu = new com.dai.swing.Button();
        lbl_role = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dai/icon/menu.png"))); // NOI18N
        cmdmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdmenuActionPerformed(evt);
            }
        });

        lbl_role.setForeground(new java.awt.Color(127, 127, 127));
        lbl_role.setText("Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                .addComponent(lbl_role)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lbl_role)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addMenuEvent(ActionListener event) {
        cmdmenu.addActionListener(event);
    }

    private void cmdmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdmenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdmenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.dai.swing.Button cmdmenu;
    private javax.swing.JLabel lbl_role;
    // End of variables declaration//GEN-END:variables
}
