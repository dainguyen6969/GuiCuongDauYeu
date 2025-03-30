/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.dai.form;

import com.dai.dialog.Message;
import com.dai.form.ChucNang.ChucNangForm_QuanLiGiangVien;
import static com.dai.form.Form_QuanLiChuyenDe.connectionUrl;
import static com.dai.form.Form_QuanLiChuyenDe.deleteHocVien;
import static com.dai.form.Form_QuanLiChuyenDe.maChuyenDe;
import static com.dai.form.Form_QuanLiChuyenDe.ngayBatDau;
import static com.dai.form.Form_QuanLiChuyenDe.ngayKetThuc;
import static com.dai.form.Form_QuanLiChuyenDe.readAllChuyenDe;
import static com.dai.form.Form_QuanLiChuyenDe.tenChuyenDe;
import com.dai.main.Main;
import com.dai.model.ModelChuyenDE;
import com.dai.model.ModelGiangVien;
import com.dai.model.ModelHocVien;
import com.dai.model.ModelKhoaHoc;
import com.dai.model.ModelNhanVien;
import com.dai.model.ModelStudent;
import com.dai.swing.table.EventAction.EventAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThinkPad
 */
public class Form_QuanLiGiangVien extends javax.swing.JPanel {

    /**
     * Creates new form Form_QuanLiGiangVien
     */
    static String connectionUrl = "jdbc:sqlserver://DESKTOP-UPR9NGG:1433;databaseName=CSDL_SOF2042;user=sa;password=123;trustServerCertificate=true";
    static String readAllGiangVien = "SELECT * FROM Giang_Vien";
    static String maGiangVien, tenGiangVien, boMon, trangThai;
    static String deleteGiangVien = "DELETE Giang_Vien WHERE Ma_Giang_Vien = ?";

    public Form_QuanLiGiangVien() {
        initComponents();
        tbl_QuanLiGiangVien.fixTable(jScrollPane1);
        setOpaque(false);
        initTableGiangVienData();
    }

    private void initTableGiangVienData() {
        EventAction eventAction = new EventAction() {

            @Override
            public void deleteChuyenDe(ModelChuyenDE chuyenDe) {

            }

            @Override
            public void updateChuyenDe(ModelChuyenDE chuyenDe) {

            }

            @Override
            public void deleteGiangVien(ModelGiangVien giangVien) {
                Delete(giangVien.getMaGiangVien());
                initTableGiangVienData();
            }

            @Override
            public void updateGiangVien(ModelGiangVien giangVien) {
                if (showMessage("Sửa Chuyên đề: " + giangVien.getTenGiangVien())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void deleteKhoaHoc(ModelKhoaHoc khoaHoc) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void updateKhoaHoc(ModelKhoaHoc khoaHoc) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void deleteNhanVien(ModelNhanVien nhanVien) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void updateNhanVien(ModelNhanVien nhanVien) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void delete(ModelHocVien hocVien) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void update(ModelHocVien hocVien) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        fillTableData(ChucNangForm_QuanLiGiangVien.getAll());
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    public void fillTableData(ArrayList<ModelGiangVien> mgv) {
        DefaultTableModel model = (DefaultTableModel) tbl_QuanLiGiangVien.getModel();
        model.setRowCount(0);
        for (ModelGiangVien modelGiangVien : mgv) {
            model.addRow(new Object[]{modelGiangVien.getMaGiangVien(), modelGiangVien.getTenGiangVien(), modelGiangVien.getBoMon(), modelGiangVien.getTrangThai()});
        }
    }

    public void Delete(String ma) {
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = con.prepareStatement(deleteGiangVien);) {
            stmt.setString(1, ma);

            int row = stmt.executeUpdate();
            if (row > 0) {
                showMessage("Đã xóa giảng viên: " + ma);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa không thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_QuanLiGiangVien = new com.dai.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quản lí giảng viên");

        tbl_QuanLiGiangVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảng viên", "Tên giảng viên", "Bộ môn", "Trạng thái", "Sửa/Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_QuanLiGiangVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(922, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.dai.swing.table.Table tbl_QuanLiGiangVien;
    // End of variables declaration//GEN-END:variables
}
