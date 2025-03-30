/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.model;

import com.dai.swing.table.EventAction.EventActionDuyetNguoiBan;
import com.dai.swing.table.EventAction.EventActionNguoiBan;
import com.dai.swing.table.ModelAction;

/**
 *
 * @author dainguyen
 */
public class model_Duyet_Nguoi_Ban {

    public String getTrang_Thai() {
        return Trang_Thai;
    }

    public void setTrang_Thai(String Trang_Thai) {
        this.Trang_Thai = Trang_Thai;
    }

    public String getID_Duyet_Nguoi_Ban() {
        return ID_Duyet_Nguoi_Ban;
    }

    public void setID_Duyet_Nguoi_Ban(String ID_Duyet_Nguoi_Ban) {
        this.ID_Duyet_Nguoi_Ban = ID_Duyet_Nguoi_Ban;
    }

    public String getID_Nguoi_Mua() {
        return ID_Nguoi_Mua;
    }

    public void setID_Nguoi_Mua(String ID_Nguoi_Mua) {
        this.ID_Nguoi_Mua = ID_Nguoi_Mua;
    }

    public String getTen_Shop() {
        return Ten_Shop;
    }

    public void setTen_Shop(String Ten_Shop) {
        this.Ten_Shop = Ten_Shop;
    }

    public String getSo_Dien_Thoai() {
        return So_Dien_Thoai;
    }

    public void setSo_Dien_Thoai(String So_Dien_Thoai) {
        this.So_Dien_Thoai = So_Dien_Thoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDia_Chi_Lay_Hang() {
        return Dia_Chi_Lay_Hang;
    }

    public void setDia_Chi_Lay_Hang(String Dia_Chi_Lay_Hang) {
        this.Dia_Chi_Lay_Hang = Dia_Chi_Lay_Hang;
    }

    private String ID_Duyet_Nguoi_Ban;
    private String ID_Nguoi_Mua;
    private String Ten_Shop;
    private String So_Dien_Thoai;
    private String Email;
    private String Dia_Chi_Lay_Hang;
    private String Trang_Thai;

    public model_Duyet_Nguoi_Ban() {
    }

    public model_Duyet_Nguoi_Ban(String ID_Duyet_Nguoi_Ban, String ID_Nguoi_Mua, String Ten_Shop, String So_Dien_Thoai, String Email, String Dia_Chi_Lay_Hang, String Trang_Thai) {
        this.ID_Duyet_Nguoi_Ban = ID_Duyet_Nguoi_Ban;
        this.ID_Nguoi_Mua = ID_Nguoi_Mua;
        this.Ten_Shop = Ten_Shop;
        this.So_Dien_Thoai = So_Dien_Thoai;
        this.Email = Email;
        this.Dia_Chi_Lay_Hang = Dia_Chi_Lay_Hang;
        this.Trang_Thai = Trang_Thai;
    }

    public model_Duyet_Nguoi_Ban(String ID_Nguoi_Mua, String Ten_Shop, String Dia_Chi_Lay_Hang, String So_Dien_Thoai, String Email, String Trang_Thai) {
        this.ID_Nguoi_Mua = ID_Nguoi_Mua;
        this.Ten_Shop = Ten_Shop;
        this.So_Dien_Thoai = So_Dien_Thoai;
        this.Email = Email;
        this.Dia_Chi_Lay_Hang = Dia_Chi_Lay_Hang;
        this.Trang_Thai = Trang_Thai;
    }

    public model_Duyet_Nguoi_Ban(String Ten_Shop, String ID_Nguoi_Mua, String Email, String So_Dien_Thoai, String Trang_Thai) {
        this.Ten_Shop = Ten_Shop;
        this.ID_Nguoi_Mua = ID_Nguoi_Mua;
        this.So_Dien_Thoai = So_Dien_Thoai;
        this.Email = Email;
        this.Trang_Thai = Trang_Thai;
    }

//    public Object[] toRowTable(EventActionDuyetNguoiBan event) {
//        return new Object[]{Ten_Shop, ID_Nguoi_Mua, Email, So_Dien_Thoai, Trang_Thai, new ModelAction(this, event)};
//    }
    public Object[] toRowTable(EventActionDuyetNguoiBan event) {
        return new Object[]{Ten_Shop, ID_Nguoi_Mua, Email, So_Dien_Thoai, Trang_Thai, new ModelAction(this, event), ID_Duyet_Nguoi_Ban, Dia_Chi_Lay_Hang};
    }
}
