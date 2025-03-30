/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.form.Duyet_Nguoi_Ban;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dai.model.model_Duyet_Nguoi_Ban;
import java.util.ArrayList;

/**
 *
 * @author dainguyen
 */
public class ChucNang_Panel_Duyet_Nguoi_Ban {

    static String url = "jdbc:mysql://localhost:3306/DATN";
    static String user = "root";
    static String password = "";
    static String readAllDB = "SELECT dnm.ID_Duyet_Nguoi_Mua, dnm.ID_Nguoi_Mua, dnm.Ten_Shop, nm.Email, nm.So_Dien_Thoai, dnm.Trang_Thai, dnm.Dia_Chi_Lay_Hang "
            + "FROM Duyet_Nguoi_Mua dnm INNER JOIN Người_Mua nm "
            + "ON dnm.ID_Duyet_Nguoi_Mua = nm.ID_Nguoi_Mua";

    static String duyetNguoiMua = "INSERT INTO Nguoi_Ban(ID_Nguoi_Mua, Ten_Cua_Hang, Dia_Chi, So_Dien_Thoai, Trang_Thai, Role, Email)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";

    static String readAllDB2 = "SELECT dnm.ID_Nguoi_Mua, dnm.Ten_Shop, nm.Email, nm.So_Dien_Thoai, dnm.Trang_Thai, dnm.Dia_Chi_Lay_Hang "
            + "FROM Duyet_Nguoi_Mua dnm INNER JOIN Người_Mua nm "
            + "ON dnm.ID_Duyet_Nguoi_Mua = nm.ID_Nguoi_Mua WHERE dnm.ID_Nguoi_Mua = ?";

    public static ArrayList<model_Duyet_Nguoi_Ban> getAll() {
        ArrayList<model_Duyet_Nguoi_Ban> MDNB = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDB)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model_Duyet_Nguoi_Ban dnb = new model_Duyet_Nguoi_Ban();
                dnb.setID_Duyet_Nguoi_Ban(rs.getString("ID_Duyet_Nguoi_Mua"));
                dnb.setID_Nguoi_Mua(rs.getString("ID_Nguoi_Mua"));
                dnb.setTen_Shop(rs.getString("Ten_Shop"));
                dnb.setEmail(rs.getString("Email"));
                dnb.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                dnb.setTrang_Thai(rs.getString("Trang_Thai"));
                dnb.setDia_Chi_Lay_Hang(rs.getString("Dia_Chi_Lay_Hang"));
                MDNB.add(dnb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MDNB;
    }

    public static boolean duyet_Nguoi_Ban(String idNguoiMua, String tenCuaHang, String diaChi, String soDienThoai, String email) {

        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(duyetNguoiMua)) {
            stmt.setString(1, idNguoiMua);
            stmt.setString(2, tenCuaHang);
            stmt.setString(3, diaChi);
            stmt.setString(4, soDienThoai);
            stmt.setString(5, "Hoạt động");
            stmt.setString(6, "3");
            stmt.setString(7, email);

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

    public static model_Duyet_Nguoi_Ban getDuyetNguoiBan(String ma_Nguoi_Mua) {
        model_Duyet_Nguoi_Ban dnb = null;
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readAllDB2)) {
            stmt.setString(1, ma_Nguoi_Mua);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dnb = new model_Duyet_Nguoi_Ban();
                dnb.setID_Nguoi_Mua(rs.getString("ID_Nguoi_Mua"));
                dnb.setTen_Shop(rs.getString("Ten_Shop"));
                dnb.setEmail(rs.getString("Email"));
                dnb.setSo_Dien_Thoai(rs.getString("So_Dien_Thoai"));
                dnb.setTrang_Thai(rs.getString("Trang_Thai"));
                dnb.setDia_Chi_Lay_Hang(rs.getString("Dia_Chi_Lay_Hang"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dnb;
    }
}
