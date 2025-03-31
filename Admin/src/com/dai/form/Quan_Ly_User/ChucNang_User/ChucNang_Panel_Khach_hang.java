/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.form.Quan_Ly_User.ChucNang_User;

import com.dai.model.Model_Khach_Hang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dainguyen
 */
public class ChucNang_Panel_Khach_hang {

    static String url = "jdbc:mysql://localhost:3306/DATN";
    static String user = "root";
    static String password = "";
    static String readAllDB = "SELECT * FROM `Người_Mua`"; //Ho_Ten, ID_Nguoi_Mua, So_Dien_Thoai, Trang_Thai 
    static String readAllHoatDong = "SELECT * FROM `Người_Mua` WHERE Trang_Thai = 'Hoạt động'";
    static String readAllVutGay = "SELECT * FROM `Người_Mua` WHERE Trang_Thai = 'Vụt gậy'";
    static String readUser = "SELECT * FROM `Người_Mua` WHERE ID_Nguoi_Mua = ?";
    static String UpdateTrangThaiVutGay = "UPDATE Người_Mua SET Trang_Thai = 'Vụt gậy' WHERE ID_Nguoi_Mua = ?";
    static String UpdateTrangThaiHoatDong = "UPDATE Người_Mua SET Trang_Thai = 'Hoạt động' WHERE ID_Nguoi_Mua = ?";

    public static ArrayList<Model_Khach_Hang> getAll() {
        ArrayList<Model_Khach_Hang> MKH = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDB);) {
            ResultSet rs = stmt.executeQuery(readAllDB);

            while (rs.next()) {
                Model_Khach_Hang kh = new Model_Khach_Hang();
                kh.setHo_Ten(rs.getString("Ho_Ten"));
                kh.setMa_Khach_Hang(rs.getString("ID_Nguoi_Mua"));
                kh.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                kh.setTrang_Thai(rs.getString("Trang_Thai"));
                MKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MKH;
    }

    public static ArrayList<Model_Khach_Hang> getAllHoatDong() {
        ArrayList<Model_Khach_Hang> MKH = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllHoatDong);) {
            ResultSet rs = stmt.executeQuery(readAllHoatDong);

            while (rs.next()) {
                Model_Khach_Hang kh = new Model_Khach_Hang();
                kh.setHo_Ten(rs.getString("Ho_Ten"));
                kh.setMa_Khach_Hang(rs.getString("ID_Nguoi_Mua"));
                kh.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                kh.setTrang_Thai(rs.getString("Trang_Thai"));
                MKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MKH;
    }

    public static ArrayList<Model_Khach_Hang> getAllVutGay() {
        ArrayList<Model_Khach_Hang> MKH = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllVutGay);) {
            ResultSet rs = stmt.executeQuery(readAllVutGay);

            while (rs.next()) {
                Model_Khach_Hang kh = new Model_Khach_Hang();
                kh.setHo_Ten(rs.getString("Ho_Ten"));
                kh.setMa_Khach_Hang(rs.getString("ID_Nguoi_Mua"));
                kh.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                kh.setTrang_Thai(rs.getString("Trang_Thai"));
                MKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MKH;
    }

    public static Model_Khach_Hang getUser(String ma_Khach_Hang) {
        Model_Khach_Hang kh = null;
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readUser);) {
            stmt.setString(1, ma_Khach_Hang);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                kh = new Model_Khach_Hang();
                kh.setHo_Ten(rs.getString("Ho_Ten"));
                kh.setMa_Khach_Hang(rs.getString("ID_Nguoi_Mua"));
                kh.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                kh.setTrang_Thai(rs.getString("Trang_Thai"));
                kh.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                kh.setEmail(rs.getString("Email"));
                kh.setGioi_Tinh(rs.getString("Gioi_Tinh"));
                kh.setNgay_Sinh(rs.getString("Ngay_Sinh"));
                kh.setDia_Chi(rs.getString("Dia_Chi"));
                kh.setNgay_Tao(rs.getString("Ngay_Tao"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public static ArrayList<Model_Khach_Hang> getUser1(String ma_Khach_Hang) {
        ArrayList<Model_Khach_Hang> MKH = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readUser);) {
            stmt.setString(1, ma_Khach_Hang);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Model_Khach_Hang kh = new Model_Khach_Hang();
                kh.setHo_Ten(rs.getString("Ho_Ten"));
                kh.setMa_Khach_Hang(rs.getString("ID_Nguoi_Mua"));
                kh.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                kh.setTrang_Thai(rs.getString("Trang_Thai"));
                MKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MKH;
    }

    public static Boolean UpdateTrangThaiVutGay(String ma_Khach_Hang) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(UpdateTrangThaiVutGay)) {
            stmt.setString(1, ma_Khach_Hang);

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

    public static Boolean UpdateTrangThaiHoatDong(String ma_Khach_Hang) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(UpdateTrangThaiHoatDong)) {
            stmt.setString(1, ma_Khach_Hang);

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
