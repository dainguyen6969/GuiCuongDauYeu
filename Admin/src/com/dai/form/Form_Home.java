/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.dai.form;

import com.dai.dialog.Message;
import static com.dai.form.Form_QuanLiChuyenDe.connectionUrl;
import static com.dai.form.Form_QuanLiChuyenDe.deleteHocVien;
import static com.dai.form.Form_QuanLiChuyenDe.maChuyenDe;
import static com.dai.form.Form_QuanLiChuyenDe.ngayBatDau;
import static com.dai.form.Form_QuanLiChuyenDe.ngayKetThuc;
import static com.dai.form.Form_QuanLiChuyenDe.readAllChuyenDe;
import static com.dai.form.Form_QuanLiChuyenDe.tenChuyenDe;

import com.dai.main.Main;
import com.dai.model.ModelCard;
import com.dai.model.ModelChuyenDE;
import com.dai.model.ModelGiangVien;
import com.dai.model.ModelHocVien;
import com.dai.model.ModelKhoaHoc;
import com.dai.model.ModelNhanVien;
import com.dai.model.ModelStudent;
import com.dai.swing.icon.GoogleMaterialDesignIcons;
import com.dai.swing.icon.IconFontSwing;
import com.dai.swing.noticeboard.ModelNoticeBoard;
import com.dai.swing.table.EventAction.EventAction;
import com.dai.swing.table.Table;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThinkPad
 */
public class Form_Home extends javax.swing.JPanel {

    /**
     * Creates new form Form_Home
     */
    static String connectionUrl = "jdbc:sqlserver://DESKTOP-UPR9NGG:1433;databaseName=CSDL_SOF2042;user=sa;password=123;trustServerCertificate=true";
    static String readAllHocVien = "SELECT * FROM Hoc_Vien ORDER BY LEN(Ma_Hoc_Vien), Ma_Hoc_Vien;";
    static String maChuyenDe, tenChuyenDe, ngayBatDau, ngayKetThuc;
    static String deleteHocVien = "DELETE Hoc_Vien WHERE Ma_Hoc_Vien = ?";
    private MainForm form = new MainForm();

    public Form_Home() {
        initComponents();
        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
    }

    private void initData() {
        initCardData();
        //initNoticeBoard();
        initTableSinhVienData();
    }

    private void initTableSinhVienData() {
        EventAction eventAction = new EventAction() {

            @Override
            public void deleteChuyenDe(ModelChuyenDE chuyenDe) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void updateChuyenDe(ModelChuyenDE chuyenDe) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void deleteGiangVien(ModelGiangVien giangVien) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void updateGiangVien(ModelGiangVien giangVien) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                Delete_HocVienData(hocVien.getMaHocVien());
                initTableSinhVienData();

            }

            @Override
            public void update(ModelHocVien hocVien) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        };

        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/dai/icon/z6313553837914_7b2bb164bcf654eed1048b6d9d99888e.jpg")), "Tiến", "Nữ", "Java", 9000000).toRowTable(eventAction));
        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/dai/icon/z6313551177323_16de2a5bbd8390f68adcbc489e2397d5.jpg")), "Dara", "Nữz", "C++", 12000000).toRowTable(eventAction));
        
        table1.addRow(new ModelHocVien("123", "Nữz", new ImageIcon(getClass().getResource("/com/dai/icon/z6313551177323_16de2a5bbd8390f68adcbc489e2397d5.jpg")), "Hoat dong").toRowTable(eventAction));

//        DefaultTableModel model = (DefaultTableModel) table1.getModel();
//        model.setRowCount(0);

//        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = con.prepareStatement(readAllHocVien);) {
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                maChuyenDe = rs.getString("Ma_Hoc_Vien");
//                tenChuyenDe = rs.getString("Ho_Va_Ten");
//                ngayBatDau = rs.getString("Anh");
//                ngayKetThuc = rs.getString("TrangThai");
//                //model.addRow(new Object[]{maChuyenDe, tenChuyenDe, ngayBatDau, ngayKetThuc,eventAction});
//                model.addRow(new ModelHocVien(maChuyenDe, tenChuyenDe, new ImageIcon(ngayBatDau), ngayKetThuc).toRowTable(eventAction));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void initCardData() {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("Sinh viên", 5100, 20, icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card2.setData(new ModelCard("Doanh thu", 2000, 60, icon2));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card3.setData(new ModelCard("Khóa học", 3000, 80, icon3));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card4.setData(new ModelCard("Giảng viên", 550, 95, icon4));
    }

    //XIN HỨA SẼ TÌM HIỂU
    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    public void Delete_HocVienData(String maHocVien) {
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = con.prepareStatement(deleteHocVien);) {
            stmt.setString(1, maHocVien);

            int row = stmt.executeUpdate();
            if (row > 0) {
                showMessage("Đã xóa học : " + maHocVien);
            } else {
                JOptionPane.showMessageDialog(this, " không thành công!");
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

        card1 = new com.dai.component.Card();
        card2 = new com.dai.component.Card();
        card3 = new com.dai.component.Card();
        card4 = new com.dai.component.Card();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.dai.swing.table.Table();

        card1.setBackground(new java.awt.Color(200, 70, 90));
        card1.setBorder(null);
        card1.setForeground(new java.awt.Color(255, 180, 140));
        card1.setColorGradient(new java.awt.Color(255, 180, 140));

        card2.setBackground(new java.awt.Color(190, 70, 90));
        card2.setBorder(null);
        card2.setColorGradient(new java.awt.Color(120, 180, 250));

        card3.setBackground(new java.awt.Color(210, 90, 110));
        card3.setBorder(null);
        card3.setForeground(new java.awt.Color(255, 160, 190));
        card3.setColorGradient(new java.awt.Color(255, 160, 190));

        card4.setBackground(new java.awt.Color(200, 80, 100));
        card4.setBorder(null);
        card4.setForeground(new java.awt.Color(200, 130, 230));
        card4.setColorGradient(new java.awt.Color(200, 130, 230));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Dữ liệu học sinh");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã học viên", "Họ và tên", "Ảnh", "Trạng thái", "Sửa/Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:

                new Test().setVisible(true);
            
        
    }//GEN-LAST:event_table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.dai.component.Card card1;
    private com.dai.component.Card card2;
    private com.dai.component.Card card3;
    private com.dai.component.Card card4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.dai.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
