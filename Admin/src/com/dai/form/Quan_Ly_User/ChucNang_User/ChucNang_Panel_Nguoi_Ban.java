/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.form.Quan_Ly_User.ChucNang_User;

import com.dai.model.ModelGiangVien;
import com.dai.model.Model_Khach_Hang;
import com.dai.model.Model_Nguoi_Ban;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dainguyen
 */
public class ChucNang_Panel_Nguoi_Ban {

    static String url = "jdbc:mysql://localhost:3306/DATN";
    static String user = "root";
    static String password = "";
    static String readAllDB = "SELECT * FROM `Nguoi_Ban`";
    static String readAllHoatDong = "SELECT * FROM `Nguoi_Ban` WHERE Trang_Thai = 'Hoạt động'";
    static String readAllVutGay = "SELECT * FROM `Nguoi_Ban` WHERE Trang_Thai = 'Banned'";
    static String readNguoiBan = "SELECT * FROM `Nguoi_Ban` WHERE ID_Nguoi_Ban = ?";
    static String UpdateTrangThaiVutGay = "UPDATE Nguoi_Ban SET Trang_Thai = 'Banned' WHERE ID_Nguoi_Ban = ?";
    static String UpdateTrangThaiHoatDong = "UPDATE Nguoi_Ban SET Trang_Thai = 'Hoạt động' WHERE ID_Nguoi_Ban = ?";

    public static ArrayList<Model_Nguoi_Ban> getAll() {
        ArrayList<Model_Nguoi_Ban> mNB = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDB);) {
            ResultSet rs = stmt.executeQuery(readAllDB);

            while (rs.next()) {
                Model_Nguoi_Ban nb = new Model_Nguoi_Ban();
                nb.setTen_Cua_Hang(rs.getString("Ten_Cua_Hang"));
                nb.setID_Nguoi_Ban(rs.getString("ID_Nguoi_Ban"));
                nb.setNgay_Tham_Gia(rs.getString("Ngay_Tham_Gia"));
                nb.setTrang_Thai(rs.getString("Trang_Thai"));
                mNB.add(nb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mNB;
    }

    public static ArrayList<Model_Nguoi_Ban> getAllHoatDong() {
        ArrayList<Model_Nguoi_Ban> mNB = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllHoatDong);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Model_Nguoi_Ban nb = new Model_Nguoi_Ban();
                nb.setTen_Cua_Hang(rs.getString("Ten_Cua_Hang"));
                nb.setID_Nguoi_Ban(rs.getString("ID_Nguoi_Ban"));
                nb.setNgay_Tham_Gia(rs.getString("Ngay_Tham_Gia"));
                nb.setTrang_Thai(rs.getString("Trang_Thai"));
                mNB.add(nb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mNB;
    }

    public static ArrayList<Model_Nguoi_Ban> getAllVutGay() {
        ArrayList<Model_Nguoi_Ban> mNB = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllVutGay);) {
            ResultSet rs = stmt.executeQuery(readAllDB);

            while (rs.next()) {
                Model_Nguoi_Ban nb = new Model_Nguoi_Ban();
                nb.setTen_Cua_Hang(rs.getString("Ten_Cua_Hang"));
                nb.setID_Nguoi_Ban(rs.getString("ID_Nguoi_Ban"));
                nb.setNgay_Tham_Gia(rs.getString("Ngay_Tham_Gia"));
                nb.setTrang_Thai(rs.getString("Trang_Thai"));
                mNB.add(nb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mNB;
    }

    public static Model_Khach_Hang getNguoiBan(String ma_Nguoi_Ban) {
        Model_Khach_Hang kh = null;
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readNguoiBan);) {
            stmt.setString(1, ma_Nguoi_Ban);
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

    public static ArrayList<Model_Nguoi_Ban> getTimKiem(String ma_Nguoi_Ban) {
        ArrayList<Model_Nguoi_Ban> mNB = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDB);) {
            ResultSet rs = stmt.executeQuery(readAllDB);

            while (rs.next()) {
                Model_Nguoi_Ban nb = new Model_Nguoi_Ban();
                nb.setTen_Cua_Hang(rs.getString("Ten_Cua_Hang"));
                nb.setID_Nguoi_Ban(rs.getString("ID_Nguoi_Ban"));
                nb.setNgay_Tham_Gia(rs.getString("Ngay_Tham_Gia"));
                nb.setTrang_Thai(rs.getString("Trang_Thai"));
                mNB.add(nb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mNB;
    }

    public static Boolean UpdateTrangThaiVutGay(String ma_Nguoi_Ban) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(UpdateTrangThaiVutGay)) {
            stmt.setString(1, ma_Nguoi_Ban);

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

    public static Boolean UpdateTrangThaiHoatDong(String ma_Nguoi_Ban) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(UpdateTrangThaiHoatDong)) {
            stmt.setString(1, ma_Nguoi_Ban);

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
