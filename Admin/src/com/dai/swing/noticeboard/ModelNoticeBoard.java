/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.swing.noticeboard;

import java.awt.Color;

/**
 *
 * @author ThinkPad
 */
public class ModelNoticeBoard {
    Color titleColor;
    String title;
    String time;
    String description;

    public ModelNoticeBoard(Color titleColor, String title, String time, String description) {
        this.titleColor = titleColor;
        this.title = title;
        this.time = time;
        this.description = description;
    }

    public ModelNoticeBoard() {
    }

    public Color getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
