/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.model;

import javax.swing.Icon;

/**
 *
 * @author ThinkPad
 */
public class ModelCard {

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public ModelCard() {
    }

    public ModelCard(String tieuDe, double values, int percentage, Icon icon) {
        this.tieuDe = tieuDe;
        this.values = values;
        this.percentage = percentage;
        this.icon = icon;
    }
    
    private String tieuDe;
    private double values;
    private int percentage; //Dịch ra tiếng Việt là phần trăm
    private Icon icon;
}
