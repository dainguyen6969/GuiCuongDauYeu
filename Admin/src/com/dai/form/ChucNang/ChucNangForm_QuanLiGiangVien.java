/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.form.ChucNang;

import com.dai.model.ModelGiangVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dainguyen
 */
public class ChucNangForm_QuanLiGiangVien {

    static String connectionUrl = "jdbc:sqlserver://DESKTOP-UPR9NGG:1433;databaseName=CSDL_SOF2042;user=sa;password=123;trustServerCertificate=true";
    static String readAllGiangVien = "SELECT * FROM Giang_Vien";
    static String maGiangVien, tenGiangVien, boMon, trangThai;
    static String deleteGiangVien = "DELETE Giang_Vien WHERE Ma_Giang_Vien = ?";

    
    public static ArrayList<ModelGiangVien> getAll(){
        ArrayList<ModelGiangVien> MGV = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = con.prepareStatement(readAllGiangVien);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ModelGiangVien gv = new ModelGiangVien();
                gv.setMaGiangVien(rs.getString("Ma_Giang_Vien"));
                gv.setTenGiangVien(rs.getString("Ho_Va_Ten"));
                gv.setBoMon(rs.getString("Bo_Mon"));
                gv.setTrangThai(rs.getString("Trang_Thai"));
                
//                tenGiangVien = rs.getString("Ho_Va_Ten");
//                boMon = rs.getString("Bo_Mon");
//                trangThai = rs.getString("Trang_Thai");
                MGV.add(gv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MGV;
    }
    
        public static boolean Delete(String ma) {
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = con.prepareStatement(deleteGiangVien);) {
            stmt.setString(1, ma);

            int row = stmt.executeUpdate();
            if (row > 0) {
                return true;
            } else {
                //JOptionPane.showMessageDialog(this, "Xóa không thành công!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
