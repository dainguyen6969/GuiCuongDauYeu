/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.swing.table;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ThinkPad
 */
public class ModelProfile {

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelProfile(String ngayBatDau) {
        this.anh = ngayBatDau;
    }

    public ModelProfile(Icon icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public ModelProfile(Icon icon) {
        this.icon = icon;
    }

    private Icon icon;
    private String name;
    private String anh;
}
