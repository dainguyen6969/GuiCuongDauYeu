package com.dai.form.Tao_Quan_Tri_Vien;

import com.dai.dialog.Message;
import com.dai.main.MainAdmin;

/**
 *
 * @author dainguyen
 */
public class Panel_ThemQuanTriVien extends javax.swing.JPanel {

    public Panel_ThemQuanTriVien() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txt_NhapLaiPassword = new javax.swing.JPasswordField();
        bttn_Them = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_TenAdmin = new javax.swing.JTextField();
        txt_TenDangNhap = new javax.swing.JTextField();

        setBackground(new java.awt.Color(250, 250, 250));
        setForeground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Thêm quản trị");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        txt_Password.setText("jPasswordField1");
        txt_Password.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Nhập lại mật khẩu");

        txt_NhapLaiPassword.setText("jPasswordField1");
        txt_NhapLaiPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bttn_Them.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        bttn_Them.setText("Thêm");
        bttn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttn_ThemActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setText("Tên Admin");

        txt_TenAdmin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_TenDangNhap.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addContainerGap(933, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_TenAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bttn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_Password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_NhapLaiPassword))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TenAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_NhapLaiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(bttn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttn_ThemActionPerformed
        // TODO add your handling code here:
        //Thieu validate them quan tri vien
        if (txt_Password.getText().equals(txt_NhapLaiPassword.getText())) {
            ChucNang_QuanTriVien.themQuanTriVien(txt_TenAdmin.getText(), txt_TenDangNhap.getText(), txt_Password.getText());
        } else {
            showMessage("Mật khẩu không trùng khớp!");
        }

    }//GEN-LAST:event_bttn_ThemActionPerformed

    private boolean showMessage(String message) {
        Message obj = new Message(MainAdmin.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttn_Them;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField txt_NhapLaiPassword;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_TenAdmin;
    private javax.swing.JTextField txt_TenDangNhap;
    // End of variables declaration//GEN-END:variables
}
