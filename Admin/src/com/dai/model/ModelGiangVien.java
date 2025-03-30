/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.model;

import com.dai.swing.table.EventAction.EventAction;
import com.dai.swing.table.ModelAction;

/**
 *
 * @author ThinkPad
 */
public class ModelGiangVien {

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getBoMon() {
        return boMon;
    }

    public void setBoMon(String boMon) {
        this.boMon = boMon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ModelGiangVien() {
    }

    public ModelGiangVien(String maGiangVien, String tenGiangVien, String boMon, String trangThai) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.boMon = boMon;
        this.trangThai = trangThai;
    }

    private String maGiangVien;
    private String tenGiangVien;
    private String boMon;
    private String trangThai;

    public Object[] toRowTable(EventAction event) {

        return new Object[]{maGiangVien, tenGiangVien, boMon, trangThai, new ModelAction(this, event)};
    }

}
