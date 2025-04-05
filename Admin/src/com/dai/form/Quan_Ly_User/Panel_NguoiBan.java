package com.dai.form.Quan_Ly_User;

import com.dai.dialog.MessageCancel;
import com.dai.dialog.MessageThongBao;
import com.dai.form.Quan_Ly_User.ChucNang_User.ChucNang_Panel_Khach_hang;
import com.dai.form.Quan_Ly_User.ChucNang_User.ChucNang_Panel_Nguoi_Ban;
import com.dai.main.MainAdmin;
import com.dai.model.Model_Nguoi_Ban;
import com.dai.swing.table.EventAction.EventActionNguoiBan;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dainguyen
 */
public class Panel_NguoiBan extends javax.swing.JPanel {

    /**
     * Creates new form Panel_KhachHang
     */
    EventActionNguoiBan eventActionNguoiBan;

    public Panel_NguoiBan() {
        initComponents();
        tbl_Nguoi_Ban.fixTable(jScrollPane1);
        setOpaque(false);
        initTableNguoiBanData();
        fillTableData(ChucNang_Panel_Nguoi_Ban.getAll());
    }

    private void initTableNguoiBanData() {
        eventActionNguoiBan = new EventActionNguoiBan() {
            @Override
            public void banRemoved(Model_Nguoi_Ban nguoiBan) {
                if (showMessageBanCoMuon("Gỡ gậy cho Shop " + nguoiBan.getTen_Cua_Hang())) {
                    ChucNang_Panel_Nguoi_Ban.UpdateTrangThaiHoatDong(nguoiBan.getID_Nguoi_Ban());
                    fillTableData(ChucNang_Panel_Nguoi_Ban.getAll());
                    
                    if (nguoiBan.getTrang_Thai().equals("Hoạt động")) {
                        showMessage("Người bán đang hoạt động.");
                    }
                    
                } else {
                    System.out.println("User click Cancel");
                }

            }

            @Override
            public void ban(Model_Nguoi_Ban nguoiBan) {
                if (showMessageBanCoMuon("Vụt gậy Shop " + nguoiBan.getTen_Cua_Hang())) {
                    ChucNang_Panel_Nguoi_Ban.UpdateTrangThaiVutGay(nguoiBan.getID_Nguoi_Ban());
                    fillTableData(ChucNang_Panel_Nguoi_Ban.getAll());
                    
                    if (nguoiBan.getTrang_Thai().equals("Banned")) {
                        showMessage("Nguời bán đang bị đánh gậy.");
                    }
                    
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
    }

    public void fillTableData(ArrayList<Model_Nguoi_Ban> nB) {
        DefaultTableModel model = (DefaultTableModel) tbl_Nguoi_Ban.getModel();
        model.setRowCount(0);
        for (Model_Nguoi_Ban model_Nguoi_Ban : nB) {
            model.addRow(new Model_Nguoi_Ban(model_Nguoi_Ban.getTen_Cua_Hang(), model_Nguoi_Ban.getID_Nguoi_Ban(), model_Nguoi_Ban.getNgay_Tham_Gia(), model_Nguoi_Ban.getTrang_Thai()).toRowTable(eventActionNguoiBan));
        }
    }

    private boolean showMessageBanCoMuon(String message) {
        MessageThongBao obj = new MessageThongBao(MainAdmin.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    private boolean showMessage(String message) {
        MessageCancel obj = new MessageCancel(MainAdmin.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Nguoi_Ban = new com.dai.swing.table.Table();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_VutGay = new javax.swing.JLabel();
        lbl_TatCa = new javax.swing.JLabel();
        lbl_HoatDong = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Nguoi_Ban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Shop", "Mã người mua", "Ngày tham gia", "Trạng thái", "Thao tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Nguoi_Ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_Nguoi_BanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Nguoi_Ban);
        if (tbl_Nguoi_Ban.getColumnModel().getColumnCount() > 0) {
            tbl_Nguoi_Ban.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Người bán");

        lbl_VutGay.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_VutGay.setText("Vụt gậy");
        lbl_VutGay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_VutGayMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_VutGayMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_VutGayMouseReleased(evt);
            }
        });

        lbl_TatCa.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_TatCa.setText("Tất cả");
        lbl_TatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_TatCaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_TatCaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_TatCaMouseReleased(evt);
            }
        });

        lbl_HoatDong.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_HoatDong.setText("Hoạt động ");
        lbl_HoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_HoatDongMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_HoatDongMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_HoatDongMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_HoatDongMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("0");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("0");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setText("0");

        txt_TimKiem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_TimKiem.setName(""); // NOI18N
        txt_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TimKiemActionPerformed(evt);
            }
        });

        jLabel2.setText("Tìm kiếm theo mã");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_TatCa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(lbl_HoatDong)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(lbl_VutGay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TatCa)
                    .addComponent(lbl_HoatDong)
                    .addComponent(lbl_VutGay)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimKiemActionPerformed
        // TODO add your handling code here:
        String maNguoiBanTimKiem = txt_TimKiem.getText();
        fillTableData(ChucNang_Panel_Nguoi_Ban.getTimKiem(maNguoiBanTimKiem));
    }//GEN-LAST:event_txt_TimKiemActionPerformed

    private void lbl_TatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TatCaMouseClicked
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Nguoi_Ban.getAll());
    }//GEN-LAST:event_lbl_TatCaMouseClicked

    private void lbl_HoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HoatDongMouseClicked
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Nguoi_Ban.getAllHoatDong());
    }//GEN-LAST:event_lbl_HoatDongMouseClicked

    private void lbl_HoatDongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HoatDongMouseExited
        // TODO add your handling code here:
        //lbl_HoatDong.setForeground(Color.red);
    }//GEN-LAST:event_lbl_HoatDongMouseExited

    private void lbl_HoatDongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HoatDongMouseReleased
        // TODO add your handling code here:
        lbl_HoatDong.setForeground(Color.black);
    }//GEN-LAST:event_lbl_HoatDongMouseReleased

    private void lbl_HoatDongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HoatDongMousePressed
        // TODO add your handling code here:
        lbl_HoatDong.setForeground(Color.red);
    }//GEN-LAST:event_lbl_HoatDongMousePressed

    private void lbl_TatCaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TatCaMouseReleased
        // TODO add your handling code here:
        lbl_TatCa.setForeground(Color.BLACK);
    }//GEN-LAST:event_lbl_TatCaMouseReleased

    private void lbl_TatCaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TatCaMousePressed
        // TODO add your handling code here:
        lbl_TatCa.setForeground(Color.red);
    }//GEN-LAST:event_lbl_TatCaMousePressed

    private void lbl_VutGayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_VutGayMouseReleased
        // TODO add your handling code here:
        lbl_VutGay.setForeground(Color.black);
    }//GEN-LAST:event_lbl_VutGayMouseReleased

    private void lbl_VutGayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_VutGayMousePressed
        // TODO add your handling code here:
        lbl_VutGay.setForeground(Color.red);
    }//GEN-LAST:event_lbl_VutGayMousePressed

    private void tbl_Nguoi_BanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Nguoi_BanMouseClicked
        // TODO add your handling code here:
        int selected = tbl_Nguoi_Ban.getSelectedRow();
        String ma_Nguoi_Ban = tbl_Nguoi_Ban.getValueAt(selected, 1).toString();
        Form_ChiTiet_Nguoi_Ban form_CT_NB = new Form_ChiTiet_Nguoi_Ban(ma_Nguoi_Ban);
        form_CT_NB.setVisible(true);

    }//GEN-LAST:event_tbl_Nguoi_BanMouseClicked

    private void lbl_VutGayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_VutGayMouseClicked
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Nguoi_Ban.getAllVutGay());
    }//GEN-LAST:event_lbl_VutGayMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_HoatDong;
    private javax.swing.JLabel lbl_TatCa;
    private javax.swing.JLabel lbl_VutGay;
    private com.dai.swing.table.Table tbl_Nguoi_Ban;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables

}
