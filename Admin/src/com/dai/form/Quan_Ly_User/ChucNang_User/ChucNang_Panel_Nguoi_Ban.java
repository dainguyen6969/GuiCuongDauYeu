package com.dai.form.Quan_Ly_User.ChucNang_User;

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

    public static Model_Nguoi_Ban getNguoiBan(String ma_Nguoi_Ban) {
        Model_Nguoi_Ban nb = null;
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readNguoiBan);) {
            stmt.setString(1, ma_Nguoi_Ban);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                nb = new Model_Nguoi_Ban();
                nb.setID_Nguoi_Ban(rs.getString("ID_Nguoi_Ban"));
                nb.setID_Nguoi_Mua(rs.getString("ID_Nguoi_Mua"));
                nb.setTen_Cua_Hang(rs.getString("Ten_Cua_Hang"));
                nb.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                nb.setDia_Chi(rs.getString("Dia_Chi"));
                nb.setEmail(rs.getString("Email"));
                nb.setNgay_Tham_Gia(rs.getString("Ngay_Tham_Gia"));
                nb.setTrang_Thai(rs.getString("Trang_Thai"));
                nb.setCccd(rs.getString("CCCD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nb;
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
