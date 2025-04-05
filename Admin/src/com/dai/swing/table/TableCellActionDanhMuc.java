/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author ThinkPad
 */
public class TableCellActionDanhMuc extends DefaultCellEditor {

    private ModelAction data;
    public TableCellActionDanhMuc() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object o, boolean isSelected, int row, int column) {
        data = (ModelAction) o;
        HanhDongDanhMuc cell = new HanhDongDanhMuc(data);
        cell.setBackground(new Color(239,244,255));
        return cell;
    }
    
    //Phương thức này dùng để truyền dữ liệu cho ô hiển thị khi mất điểm
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
