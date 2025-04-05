/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.swing.table;

import com.dai.model.Model_Danh_Muc;
import com.dai.model.Model_Khach_Hang;
import com.dai.model.Model_Nguoi_Ban;
import com.dai.model.Model_Quan_Tri_Vien;
import com.dai.model.model_Duyet_Nguoi_Ban;
import com.dai.swing.table.EventAction.EventActionDanhMuc;
import com.dai.swing.table.EventAction.EventActionDuyetNguoiBan;
import com.dai.swing.table.EventAction.EventActionNguoiBan;
import com.dai.swing.table.EventAction.EventActionNguoiMua;
import com.dai.swing.table.EventAction.EventActionQuanTriVien;

/**
 *
 * @author ThinkPad
 */
public class ModelAction {

    public EventActionQuanTriVien getEventQuanTriVien() {
        return eventQuanTriVien;
    }

    public void setEventQuanTriVien(EventActionQuanTriVien eventQuanTriVien) {
        this.eventQuanTriVien = eventQuanTriVien;
    }

    public Model_Quan_Tri_Vien getQuanTriVien() {
        return quanTriVien;
    }

    public void setQuanTriVien(Model_Quan_Tri_Vien quanTriVien) {
        this.quanTriVien = quanTriVien;
    }

    public EventActionDuyetNguoiBan getEventDuyetNguoiBan() {
        return eventDuyetNguoiBan;
    }

    public void setEventDuyetNguoiBan(EventActionDuyetNguoiBan eventDuyetNguoiBan) {
        this.eventDuyetNguoiBan = eventDuyetNguoiBan;
    }

    public model_Duyet_Nguoi_Ban getDuyetNguoiBan() {
        return duyetNguoiBan;
    }

    public void setDuyetNguoiBan(model_Duyet_Nguoi_Ban duyetNguoiBan) {
        this.duyetNguoiBan = duyetNguoiBan;
    }

    public EventActionDanhMuc getEventDanhMuc() {
        return eventDanhMuc;
    }

    public void setEventDanhMuc(EventActionDanhMuc eventDanhMuc) {
        this.eventDanhMuc = eventDanhMuc;
    }

    public Model_Danh_Muc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Model_Danh_Muc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Model_Nguoi_Ban getNguoiBan() {
        return nguoiBan;
    }

    public void setNguoiBan(Model_Nguoi_Ban nguoiBan) {
        this.nguoiBan = nguoiBan;
    }

    public EventActionNguoiBan getEventNguoiBan() {
        return eventNguoiBan;
    }

    public void setEventNguoiBan(EventActionNguoiBan eventNguoiBan) {
        this.eventNguoiBan = eventNguoiBan;
    }

    public EventActionNguoiMua getEventNguoiMua() {
        return eventNguoiMua;
    }

    public void setEventNguoiMua(EventActionNguoiMua eventNguoiMua) {
        this.eventNguoiMua = eventNguoiMua;
    }

    private Model_Khach_Hang khachHang;
    private EventActionNguoiMua eventNguoiMua;

    private EventActionNguoiBan eventNguoiBan;
    private Model_Nguoi_Ban nguoiBan;

    private Model_Danh_Muc danhMuc;
    private EventActionDanhMuc eventDanhMuc;

    private EventActionDuyetNguoiBan eventDuyetNguoiBan;
    private model_Duyet_Nguoi_Ban duyetNguoiBan;

    private EventActionQuanTriVien eventQuanTriVien;
    private Model_Quan_Tri_Vien quanTriVien;

    public ModelAction(Model_Khach_Hang khachHang, EventActionNguoiMua event) {
        this.eventNguoiMua = event;
        this.khachHang = khachHang;
    }

    public Model_Khach_Hang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(Model_Khach_Hang khachHang) {
        this.khachHang = khachHang;
    }

    public ModelAction(Model_Nguoi_Ban nguoiBan, EventActionNguoiBan event) {
        this.eventNguoiBan = event;
        this.nguoiBan = nguoiBan;
    }

    public ModelAction(Model_Danh_Muc danhMuc, EventActionDanhMuc event) {
        this.eventDanhMuc = event;
        this.danhMuc = danhMuc;
    }

    public ModelAction(model_Duyet_Nguoi_Ban duyetNguoiBan, EventActionDuyetNguoiBan event) {
        this.eventDuyetNguoiBan = event;
        this.duyetNguoiBan = duyetNguoiBan;
    }

    public ModelAction(Model_Quan_Tri_Vien quanTriVien, EventActionQuanTriVien event) {
        this.eventQuanTriVien = event;
        this.quanTriVien = quanTriVien;
    }
}
