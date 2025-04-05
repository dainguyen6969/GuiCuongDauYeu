/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.model;
import com.dai.swing.table.ModelAction;
import com.dai.swing.table.EventAction.EventActionNguoiBan;

/**
 *
 * @author dainguyen
 */
public class Model_Nguoi_Ban {

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getID_Nguoi_Ban() {
        return ID_Nguoi_Ban;
    }

    public void setID_Nguoi_Ban(String ID_Nguoi_Ban) {
        this.ID_Nguoi_Ban = ID_Nguoi_Ban;
    }

    public String getID_Nguoi_Mua() {
        return ID_Nguoi_Mua;
    }

    public void setID_Nguoi_Mua(String ID_Nguoi_Mua) {
        this.ID_Nguoi_Mua = ID_Nguoi_Mua;
    }

    public String getTen_Cua_Hang() {
        return Ten_Cua_Hang;
    }

    public void setTen_Cua_Hang(String Ten_Cua_Hang) {
        this.Ten_Cua_Hang = Ten_Cua_Hang;
    }

    public String getDia_Chi() {
        return Dia_Chi;
    }

    public void setDia_Chi(String Dia_Chi) {
        this.Dia_Chi = Dia_Chi;
    }

    public String getSo_Dien_Thoai() {
        return So_Dien_Thoai;
    }

    public void setSo_Dien_Thoai(String So_Dien_Thoai) {
        this.So_Dien_Thoai = So_Dien_Thoai;
    }

    public String getNgay_Tham_Gia() {
        return Ngay_Tham_Gia;
    }

    public void setNgay_Tham_Gia(String Ngay_Tham_Gia) {
        this.Ngay_Tham_Gia = Ngay_Tham_Gia;
    }

    public String getTrang_Thai() {
        return Trang_Thai;
    }

    public void setTrang_Thai(String Trang_Thai) {
        this.Trang_Thai = Trang_Thai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    private String ID_Nguoi_Ban;
    private String ID_Nguoi_Mua;
    private String Ten_Cua_Hang;
    private String Dia_Chi;
    private String So_Dien_Thoai;
    private String Ngay_Tham_Gia;
    private String Trang_Thai;
    private String cccd;
    private String Email;

    public Model_Nguoi_Ban() {
    }

    public Model_Nguoi_Ban(String Ten_Cua_Hang, String ID_Nguoi_Ban, String Ngay_Tham_Gia, String Trang_Thai) {
        this.ID_Nguoi_Ban = ID_Nguoi_Ban;
        this.Ten_Cua_Hang = Ten_Cua_Hang;
        this.Ngay_Tham_Gia = Ngay_Tham_Gia;
        this.Trang_Thai = Trang_Thai;

    }

    public Model_Nguoi_Ban(String ID_Nguoi_Ban, String ID_Nguoi_Mua, String Ten_Cua_Hang, String Dia_Chi, String So_Dien_Thoai, String Ngay_Tham_Gia, String Trang_Thai, String cccd, String Email) {
        this.ID_Nguoi_Ban = ID_Nguoi_Ban;
        this.ID_Nguoi_Mua = ID_Nguoi_Mua;
        this.Ten_Cua_Hang = Ten_Cua_Hang;
        this.Dia_Chi = Dia_Chi;
        this.So_Dien_Thoai = So_Dien_Thoai;
        this.Ngay_Tham_Gia = Ngay_Tham_Gia;
        this.Trang_Thai = Trang_Thai;
        this.cccd = cccd;
        this.Email = Email;
    }

    public Object[] toRowTable(EventActionNguoiBan event) {
        return new Object[]{Ten_Cua_Hang, ID_Nguoi_Ban, Ngay_Tham_Gia, Trang_Thai, new ModelAction(this, event)};
    }
}
