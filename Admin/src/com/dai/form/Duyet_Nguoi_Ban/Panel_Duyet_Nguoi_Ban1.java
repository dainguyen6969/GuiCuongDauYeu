package com.dai.form.Duyet_Nguoi_Ban;

import com.dai.dialog.Message;
import com.dai.dialog.MessageThongBao;
import com.dai.main.MainAdmin;
import com.dai.model.model_Duyet_Nguoi_Ban;
import com.dai.swing.table.EventAction.EventActionDuyetNguoiBan;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dainguyen
 */
public class Panel_Duyet_Nguoi_Ban1 extends javax.swing.JPanel {

    /**
     * Creates new form Panel_KhachHang
     */
    EventActionDuyetNguoiBan evenActionDuyetNguoiBan;

    public Panel_Duyet_Nguoi_Ban1() {
        initComponents();
        tbl_Duyet_Nguoi_Ban.fixTable(jScrollPane2);
        setOpaque(false);
        initTableNguoiMuaData();
        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAll());
    }

    private void initTableNguoiMuaData() {
        evenActionDuyetNguoiBan = new EventActionDuyetNguoiBan() {
            @Override
            public void duyet(model_Duyet_Nguoi_Ban duyetNguoiBan) {
//                ChucNang_Panel_Duyet_Nguoi_Ban.duyet_Nguoi_Ban(
//                        duyetNguoiBan.getID_Nguoi_Mua(),
//                        duyetNguoiBan.getTen_Shop(),
//                        duyetNguoiBan.getDia_Chi_Lay_Hang(),
//                        duyetNguoiBan.getSo_Dien_Thoai(),
//                        duyetNguoiBan.getEmail(),
//                        duyetNguoiBan.getCccd());
//                if (showMessage("Duyệt : " + duyetNguoiBan.getTen_Shop())) {
//                    ChucNang_Panel_Duyet_Nguoi_Ban.UpdateTrangThaiDaDuyet(duyetNguoiBan.getID_Duyet_Nguoi_Ban());
//                    fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAll());
//                } else {
//                    System.out.println("User click Cancel");
//                }
                if (duyetNguoiBan.getTrang_Thai().equals("Đã duyệt")) {
                    showMessage("Người mua đã được duyệt");
                } else if (duyetNguoiBan.getTrang_Thai().equals("Hủy duyệt")) {
                    showMessage("Người mua đã bị hủy duyệt");
                } else if (duyetNguoiBan.getTrang_Thai().equals("Chờ duyệt")) {
                    if (showMessageBanCoMuon("Duyệt Shop: " + duyetNguoiBan.getTen_Shop())) {
                        ChucNang_Panel_Duyet_Nguoi_Ban.duyet_Nguoi_Ban(
                                duyetNguoiBan.getID_Nguoi_Mua(),
                                duyetNguoiBan.getTen_Shop(),
                                duyetNguoiBan.getDia_Chi_Lay_Hang(),
                                duyetNguoiBan.getSo_Dien_Thoai(),
                                duyetNguoiBan.getEmail(),
                                duyetNguoiBan.getCccd());
                        ChucNang_Panel_Duyet_Nguoi_Ban.UpdateTrangThaiDaDuyet(duyetNguoiBan.getID_Duyet_Nguoi_Ban());
                        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAll());
                    } else {
                        System.out.println("User click Cancel");
                    }
                }
            }

            @Override
            public void huyDuyet(model_Duyet_Nguoi_Ban duyetNguoiBan) {
                if (duyetNguoiBan.getTrang_Thai().equals("Hủy duyệt")) {
                    showMessage("Người mua đã bị hủy duyệt trước đó");
                } else if (duyetNguoiBan.getTrang_Thai().equals("Đã duyệt")) {
                    showMessage("Không thể hủy duyệt người đã được duyệt");
                } else if (duyetNguoiBan.getTrang_Thai().equals("Chờ duyệt")) {
                    if (showMessageBanCoMuon("Hủy duyệt : " + duyetNguoiBan.getTen_Shop())) {
                        ChucNang_Panel_Duyet_Nguoi_Ban.UpdateTrangThaiHuyDuyet(duyetNguoiBan.getID_Duyet_Nguoi_Ban());
                        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAll());
                    }
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };

    }

    public void fillTableData(ArrayList<model_Duyet_Nguoi_Ban> dnb) {
        DefaultTableModel model = (DefaultTableModel) tbl_Duyet_Nguoi_Ban.getModel();
        model.setRowCount(0);
        for (model_Duyet_Nguoi_Ban duyet_Nguoi_Ban : dnb) {
            model.addRow(new model_Duyet_Nguoi_Ban(duyet_Nguoi_Ban.getID_Nguoi_Mua(), duyet_Nguoi_Ban.getTen_Shop(), duyet_Nguoi_Ban.getDia_Chi_Lay_Hang(), duyet_Nguoi_Ban.getID_Duyet_Nguoi_Ban(), duyet_Nguoi_Ban.getCccd(), duyet_Nguoi_Ban.getSo_Dien_Thoai(), duyet_Nguoi_Ban.getEmail(), duyet_Nguoi_Ban.getTrang_Thai()).toRowTable(evenActionDuyetNguoiBan));
        }

//        for (model_Duyet_Nguoi_Ban duyet_Nguoi_Ban : dnb) {
//            model.addRow(duyet_Nguoi_Ban.toRowTable(evenActionDuyetNguoiBan));
//        }
    }

    private boolean showMessageBanCoMuon(String message) {
        MessageThongBao obj = new MessageThongBao(MainAdmin.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    private boolean showMessage(String message) {
        Message obj = new Message(MainAdmin.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Duyet_Nguoi_Ban = new com.dai.swing.table.Table_DuyetNguoiBan();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_HuyDuyet = new javax.swing.JLabel();
        lbl_TatCa = new javax.swing.JLabel();
        lbl_DaDuyet = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_ChoDuyet = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Duyet_Nguoi_Ban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên cửa hàng", "ID Người mua", "Email", "Số điện thoại", "Trạng thái", "Thao tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Duyet_Nguoi_Ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_Duyet_Nguoi_BanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Duyet_Nguoi_Ban);
        if (tbl_Duyet_Nguoi_Ban.getColumnModel().getColumnCount() > 0) {
            tbl_Duyet_Nguoi_Ban.getColumnModel().getColumn(4).setMaxWidth(100);
            tbl_Duyet_Nguoi_Ban.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Duyệt người bán");

        lbl_HuyDuyet.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_HuyDuyet.setText("Hủy duyệt");
        lbl_HuyDuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_HuyDuyetMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_HuyDuyetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_HuyDuyetMouseReleased(evt);
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

        lbl_DaDuyet.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_DaDuyet.setText("Đã duyệt");
        lbl_DaDuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_DaDuyetMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_DaDuyetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_DaDuyetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_DaDuyetMouseReleased(evt);
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

        jLabel2.setText("Tìm kiếm theo mã duyệt mua");

        lbl_ChoDuyet.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbl_ChoDuyet.setText("Chờ duyệt");
        lbl_ChoDuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ChoDuyetMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_ChoDuyetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_ChoDuyetMouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_TatCa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(lbl_DaDuyet)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(lbl_HuyDuyet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(lbl_ChoDuyet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_ChoDuyet)
                        .addComponent(jLabel8)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_TatCa)
                        .addComponent(lbl_DaDuyet)
                        .addComponent(lbl_HuyDuyet)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addGap(5, 5, 5)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        String maDuyetNguoiDung = txt_TimKiem.getText();
        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getTimKiemDuyetNguoiBan(maDuyetNguoiDung));
    }//GEN-LAST:event_txt_TimKiemActionPerformed

    private void lbl_TatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TatCaMouseClicked
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAll());
    }//GEN-LAST:event_lbl_TatCaMouseClicked

    private void lbl_DaDuyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DaDuyetMouseClicked
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAllDaDuyet());
    }//GEN-LAST:event_lbl_DaDuyetMouseClicked

    private void lbl_DaDuyetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DaDuyetMouseExited
        // TODO add your handling code here:
        //lbl_HoatDong.setForeground(Color.red);
    }//GEN-LAST:event_lbl_DaDuyetMouseExited

    private void lbl_DaDuyetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DaDuyetMouseReleased
        // TODO add your handling code here:
        lbl_DaDuyet.setForeground(Color.black);
    }//GEN-LAST:event_lbl_DaDuyetMouseReleased

    private void lbl_DaDuyetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DaDuyetMousePressed
        // TODO add your handling code here:
        lbl_DaDuyet.setForeground(Color.red);
    }//GEN-LAST:event_lbl_DaDuyetMousePressed

    private void lbl_TatCaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TatCaMouseReleased
        // TODO add your handling code here:
        lbl_TatCa.setForeground(Color.BLACK);
    }//GEN-LAST:event_lbl_TatCaMouseReleased

    private void lbl_TatCaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TatCaMousePressed
        // TODO add your handling code here:
        lbl_TatCa.setForeground(Color.red);
    }//GEN-LAST:event_lbl_TatCaMousePressed

    private void lbl_HuyDuyetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HuyDuyetMouseReleased
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAllHuyDuyet());
        lbl_HuyDuyet.setForeground(Color.black);
    }//GEN-LAST:event_lbl_HuyDuyetMouseReleased

    private void lbl_HuyDuyetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HuyDuyetMousePressed
        // TODO add your handling code here:
        lbl_HuyDuyet.setForeground(Color.red);
    }//GEN-LAST:event_lbl_HuyDuyetMousePressed

    private void tbl_Duyet_Nguoi_BanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Duyet_Nguoi_BanMouseClicked
        // TODO add your handling code here:
        int selected = tbl_Duyet_Nguoi_Ban.getSelectedRow();
        String ma_Khach_hang = tbl_Duyet_Nguoi_Ban.getValueAt(selected, 1).toString();
        Form_ChiTiet_Duyet_Nguoi_Ban form_CT_KH = new Form_ChiTiet_Duyet_Nguoi_Ban(ma_Khach_hang);
        form_CT_KH.setVisible(true);
    }//GEN-LAST:event_tbl_Duyet_Nguoi_BanMouseClicked

    private void lbl_ChoDuyetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ChoDuyetMousePressed
        // TODO add your handling code here:
        lbl_ChoDuyet.setForeground(Color.red);
    }//GEN-LAST:event_lbl_ChoDuyetMousePressed

    private void lbl_ChoDuyetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ChoDuyetMouseReleased
        // TODO add your handling code here:
        lbl_ChoDuyet.setForeground(Color.black);
    }//GEN-LAST:event_lbl_ChoDuyetMouseReleased

    private void lbl_HuyDuyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HuyDuyetMouseClicked
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAllHuyDuyet());
    }//GEN-LAST:event_lbl_HuyDuyetMouseClicked

    private void lbl_ChoDuyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ChoDuyetMouseClicked
        // TODO add your handling code here:
        fillTableData(ChucNang_Panel_Duyet_Nguoi_Ban.getAllChoXacNhan());
    }//GEN-LAST:event_lbl_ChoDuyetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_ChoDuyet;
    private javax.swing.JLabel lbl_DaDuyet;
    private javax.swing.JLabel lbl_HuyDuyet;
    private javax.swing.JLabel lbl_TatCa;
    private com.dai.swing.table.Table_DuyetNguoiBan tbl_Duyet_Nguoi_Ban;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables

}
