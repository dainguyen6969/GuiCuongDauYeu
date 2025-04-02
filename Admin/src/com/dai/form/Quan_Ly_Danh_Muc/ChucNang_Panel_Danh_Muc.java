/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.form.Quan_Ly_Danh_Muc;

import com.dai.model.Model_Danh_Muc;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author dainguyen
 */
public class ChucNang_Panel_Danh_Muc {

    static String url = "jdbc:mysql://localhost:3306/DATN";
    static String user = "root";
    static String password = "";
    static String readTabelDanhMuc = "SELECT dm.Anh_Danh_Muc_Blob, dm.Ten_Danh_Muc, dm.ID_Danh_Muc, dm.Trang_Thai, "
            + "COUNT(sp.ID_San_Pham) AS SoLuongSanPham "
            + "FROM Danh_Muc dm "
            + "LEFT JOIN San_Pham sp ON dm.ID_Danh_Muc = sp.ID_Danh_Muc "
            + "GROUP BY dm.ID_Danh_Muc, dm.Ten_Danh_Muc, dm.Anh_Danh_Muc_Blob";
    static String themDanhMuc = "INSERT INTO Danh_Muc(Ten_Danh_Muc, Anh_Danh_Muc_Blob, Trang_Thai, Mo_Ta)"
            + "VALUES(?, ?, 'Hoạt động',?)";

    static String UpdateTrangThaiNgungHoatDong = "UPDATE Danh_Muc SET Trang_Thai = 'Ngưng hoạt động' WHERE ID_Danh_Muc = ?";
    static String UpdateTrangThaiHoatDong = "UPDATE Danh_Muc SET Trang_Thai = 'Hoạt động' WHERE ID_Danh_Muc = ?";

    static String readDanhMucHoatDong = "SELECT dm.Anh_Danh_Muc_Blob, dm.Ten_Danh_Muc, dm.ID_Danh_Muc, dm.Trang_Thai, "
            + "COUNT(sp.ID_San_Pham) AS SoLuongSanPham "
            + "FROM Danh_Muc dm "
            + "LEFT JOIN San_Pham sp ON dm.ID_Danh_Muc = sp.ID_Danh_Muc "
            + "WHERE dm.Trang_Thai = 'Hoạt động' "
            + "GROUP BY dm.ID_Danh_Muc, dm.Ten_Danh_Muc, dm.Anh_Danh_Muc_Blob ";

    static String readDanhMucNgungHoatDong = "SELECT dm.Anh_Danh_Muc_Blob, dm.Ten_Danh_Muc, dm.ID_Danh_Muc, dm.Trang_Thai, "
            + "COUNT(sp.ID_San_Pham) AS SoLuongSanPham "
            + "FROM Danh_Muc dm "
            + "LEFT JOIN San_Pham sp ON dm.ID_Danh_Muc = sp.ID_Danh_Muc "
            + "WHERE dm.Trang_Thai = 'Ngưng hoạt động' "
            + "GROUP BY dm.ID_Danh_Muc, dm.Ten_Danh_Muc, dm.Anh_Danh_Muc_Blob ";

    public static ArrayList<Model_Danh_Muc> getAll() {
        ArrayList<Model_Danh_Muc> MDM = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readTabelDanhMuc);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tenDanhMuc = rs.getString("Ten_Danh_Muc");
                String idDanhMuc = rs.getString("ID_Danh_Muc");
                String trangThai = rs.getString("Trang_Thai");
                int soLuongSanPham = rs.getInt("SoLuongSanPham");
                // Lấy ảnh từ BLOB
                byte[] imageBytes = rs.getBytes("Anh_Danh_Muc_Blob");
                Icon icon = null;

                if (imageBytes != null && imageBytes.length > 0) {
                    ImageIcon imgIcon = new ImageIcon(imageBytes);
                    Image img = imgIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                }

                // Thêm vào danh sách
                MDM.add(new Model_Danh_Muc(icon, tenDanhMuc, idDanhMuc, soLuongSanPham, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MDM;
    }

    public static boolean themDanhMuc(String tenDanhMuc, File imageFile, String moTa) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(themDanhMuc); FileInputStream fis = new FileInputStream(imageFile)) {

            stmt.setString(1, tenDanhMuc);
            stmt.setBinaryStream(2, fis, (int) imageFile.length());
            stmt.setString(3, moTa);

            int row = stmt.executeUpdate();
            if (row > 0) {
                System.out.println("Them danh muc thanh cong");
                return true;
            } else {
                System.out.println("Them danh muc that bai");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean UpdateTrangThaiNgungHoatDong(String ma_Danh_MUc) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(UpdateTrangThaiNgungHoatDong)) {
            stmt.setString(1, ma_Danh_MUc);

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

    public static Boolean UpdateTrangThaiHoatDong(String ma_Danh_Muc) {
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(UpdateTrangThaiHoatDong)) {
            stmt.setString(1, ma_Danh_Muc);

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

    public static ArrayList<Model_Danh_Muc> getAllHoatDong() {
        ArrayList<Model_Danh_Muc> MDM = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readDanhMucHoatDong);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tenDanhMuc = rs.getString("Ten_Danh_Muc");
                String idDanhMuc = rs.getString("ID_Danh_Muc");
                String trangThai = rs.getString("Trang_Thai");
                int soLuongSanPham = rs.getInt("SoLuongSanPham");
                // Lấy ảnh từ BLOB
                byte[] imageBytes = rs.getBytes("Anh_Danh_Muc_Blob");
                Icon icon = null;

                if (imageBytes != null && imageBytes.length > 0) {
                    ImageIcon imgIcon = new ImageIcon(imageBytes);
                    Image img = imgIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                }

                // Thêm vào danh sách
                MDM.add(new Model_Danh_Muc(icon, tenDanhMuc, idDanhMuc, soLuongSanPham, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MDM;
    }

    public static ArrayList<Model_Danh_Muc> getAllNgungHoatDong() {
        ArrayList<Model_Danh_Muc> MDM = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement stmt = con.prepareStatement(readDanhMucNgungHoatDong);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tenDanhMuc = rs.getString("Ten_Danh_Muc");
                String idDanhMuc = rs.getString("ID_Danh_Muc");
                String trangThai = rs.getString("Trang_Thai");
                int soLuongSanPham = rs.getInt("SoLuongSanPham");
                // Lấy ảnh từ BLOB
                byte[] imageBytes = rs.getBytes("Anh_Danh_Muc_Blob");
                Icon icon = null;

                if (imageBytes != null && imageBytes.length > 0) {
                    ImageIcon imgIcon = new ImageIcon(imageBytes);
                    Image img = imgIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(img);
                }

                // Thêm vào danh sách
                MDM.add(new Model_Danh_Muc(icon, tenDanhMuc, idDanhMuc, soLuongSanPham, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MDM;
    }
}
