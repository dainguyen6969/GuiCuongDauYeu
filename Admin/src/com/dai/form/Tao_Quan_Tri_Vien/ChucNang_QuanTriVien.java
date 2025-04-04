package com.dai.form.Tao_Quan_Tri_Vien;

import com.dai.model.Model_Quan_Tri_Vien;
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
    static String themQuanTriVien = "INSERT INTO Admin(Ten_Admin, Ten_Dang_Nhap, Mat_Khau, Trang_Thai, Role)"
            + "VALUES(?, ?, ?, 'Hoạt động', '4')";
    static String readAllDBHoatDong = "SELECT * FROM `Admin` WHERE Trang_Thai = 'Hoạt động'";
    static String readAllDBDungHoatDong = "SELECT * FROM `Admin` WHERE Trang_Thai = 'Dừng hoạt động'";
    static String updateHoatDongQTV = "UPDATE Admin SET Trang_Thai = 'Hoạt động' WHERE ID_Admin = ? ";
    static String updateDungHoatDongQTV = "UPDATE Admin SET Trang_Thai = 'Dừng hoạt động' WHERE ID_Admin = ? ";

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

    public static ArrayList<Model_Quan_Tri_Vien> getAllHoatDong() {
        ArrayList<Model_Quan_Tri_Vien> MQTV = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDBHoatDong)) {
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

    public static ArrayList<Model_Quan_Tri_Vien> getAllNgungHoatDong() {
        ArrayList<Model_Quan_Tri_Vien> MQTV = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDBDungHoatDong)) {
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

    public static Boolean UpdateTrangThaiHoatDong(String ma_Admin) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(updateHoatDongQTV)) {
            stmt.setString(1, ma_Admin);

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

    public static Boolean UpdateTrangThaiDungHoatDong(String ma_Admin) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(updateDungHoatDongQTV)) {
            stmt.setString(1, ma_Admin);

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
