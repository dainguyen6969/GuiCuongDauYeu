/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.dai.component;

import com.dai.event.EventMenu;
import com.dai.event.EventMenuSelected;
import com.dai.event.EventShowPopupMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import com.dai.model.ModelMenu;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import com.dai.scrollbar.ScrollBarCustom;
import com.dai.swing.MenuAnimation;
import com.dai.swing.MenuItem;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.UIManager;

/**
 *
 * @author ThinkPad
 */
public class Menu extends javax.swing.JPanel {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(com.dai.event.EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    /**
     * Creates new form Menu
     */
    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());

        // Ẩn thanh cuộn    
        //JScrollBar verticalScrollBar = sp.getVerticalScrollBar();
        //verticalScrollBar.setUI(null); // Ẩn UI mặc định nếu muốn
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
    }

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/realtor.png")), "Duyệt người bán"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/categories.png")), "Quản lí danh mục", "Tất cả danh mục", "Thêm danh mục"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/group.png")), "Quản lí người dùng","Người mua","Người bán"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/7.png")), "Library", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/8.png")), "Holiday", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/9.png")), "Calendar", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/10.png")), "Chat App", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/11.png")), "Contace", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/12.png")), "File Manager", "Menu 001", "Menu 002", "Menu 003"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/13.png")), "Our Centres"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/dai/icon/14.png")), "Gallery"));
    }

    //Để add các menu vào panel
    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    //Câu lệnh bên dưới dùng để xử lý các sự kiện khi menu được nhấn
    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                System.out.println("Nhấn vào Menu");
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else{ //Qua sai ở đây tìm lỗi sửa lòi trĩ, NGÀY MAI NHỚ COMMENT CÁC CÂU LỆNH CỦA POPUP!!!!  
                         eventShowPopup.showPopup(com);
                    }
                } 
                    
                
                return false;
            }
        };
    }

    public void hidealMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile1 = new com.dai.component.Profile();
        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile2 = new com.dai.component.Profile();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setToolTipText("");

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 828, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(581, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //GradientPaint gra = new GradientPaint(0, 0, new Color(255, 230, 200), getWidth(), 0, new Color(170, 20, 50));
        GradientPaint gra = new GradientPaint(0, 0, new Color(240, 240, 240), getWidth(), 0, new Color(150, 150, 150));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private com.dai.component.Profile profile1;
    private com.dai.component.Profile profile2;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
