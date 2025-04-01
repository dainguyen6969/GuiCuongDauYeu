/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.form.Tao_Quan_Tri_Vien;

import com.dai.model.Model_Quan_Tri_Vien;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dainguyen
 */
public class ChucNang_QuanTriVien {

    static String url = "jdbc:mysql://localhost:3306/DATN";
    static String user = "root";
    static String password = "";
    static String readAllDB = "SELECT * FROM `Admin` ";
    static String themQuanTriVien = "INSERT INTO Admin(Ten_Admin, Ten_Tai_Khoan, Mat_Khau, Trang_Thai, Role)"
            + "VALUES(?, ?, ?, 'Hoạt động', '4')";

    public static ArrayList<Model_Quan_Tri_Vien> getAll() {
        ArrayList<Model_Quan_Tri_Vien> MQTV = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDB)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Model_Quan_Tri_Vien qtv = new Model_Quan_Tri_Vien();
                qtv.setIdAdmin(rs.getString("ID_Admin"));
                qtv.setTenAdmin(rs.getString("Ten_Admin"));
                qtv.setTrangThai(rs.getString("Trang_Thai"));
                qtv.setNgayTao(rs.getString("Ngay_Tao"));
                MQTV.add(qtv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MQTV;
    }

    public static boolean themQuanTriVien(String tenAdmin, String tenDangNhap, String matKhau) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(themQuanTriVien);) {

            stmt.setString(1, tenAdmin);
            stmt.setString(2, tenDangNhap);
            stmt.setString(3, matKhau);

            int row = stmt.executeUpdate();
            if (row > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
