/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.model;

import com.dai.swing.table.EventAction.EventAction;
import com.dai.swing.table.ModelAction;
import com.dai.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

/**
 *
 * @author ThinkPad
 */
public class ModelStudent {

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public ModelStudent() {
    }

    public ModelStudent(Icon icon, String name, String gender, String course, double fees) {
        this.icon = icon;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.fees = fees;
    }
    
    
    private Icon icon;
    private String name;
    private String gender;
    private String course;
    private double fees;
    
    public Object[]toRowTable(EventAction event){
        DecimalFormat df = new DecimalFormat("$#, ##0");
        return new Object[]{new ModelProfile(icon, name),gender,course,df.format(fees),new ModelAction(this, event)};
    }
}
