/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.swing.table;

import com.dai.form.Form_Home;
import com.dai.scrollbar.ScrollBarCustom;
import com.dai.swing.table.ModelAction;
import com.dai.swing.table.ModelProfile;
import com.dai.swing.table.Profile;
import com.dai.swing.table.TableCellAction;
import com.dai.swing.table.TableHeader;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author ThinkPad
 */
public class Table extends JTable {
//XIN HỨA MAI TÌM HIỂU HẾT LẠI CÂU LỆNH NGÀY HÔM NAY
    
    public Table() {

        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object o, boolean selected, boolean focus, int i, int i1) {
                if (o instanceof ModelProfile) {
                    ModelProfile data = (ModelProfile) o;
                    Profile cell = new Profile(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.white);
                    }
                    return cell;

                } else if (o instanceof ModelAction) {
                    ModelAction data = (ModelAction) o;
                    HanhDong cell = new HanhDong(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.white);
                    }
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(table, o, selected, focus, i, i1);
                    //com.setBackground(Color.white);
                    setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                        com.setBackground(Color.white);
                    }
                    return com;
                }
            }

        });
    }

    
    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 4) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }
    
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.white);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
