package com.dai.swing;

import com.dai.event.EventMenu;
import com.dai.event.EventMenuSelected;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.dai.model.ModelMenu;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import net.miginfocom.swing.MigLayout;

public class MenuItem extends javax.swing.JPanel {

    /**
     * @return the menu
     */
    public ModelMenu getMenu() {
        return menu;
    }

    /**
     * @param alpha the alpha to set
     */
    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * @return the eventSelected
     */
    public EventMenuSelected getEventSelected() {
        return eventSelected;
    }

    /**
     * @param eventSelected the eventSelected to set
     */
    public void setEventSelected(EventMenuSelected eventSelected) {
        this.eventSelected = eventSelected;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    private float alpha;
    private ModelMenu menu;
    private boolean open;
    private EventMenuSelected eventSelected;
    private int index;

    public MenuItem(ModelMenu menu, EventMenu event, EventMenuSelected eventSelected, int index) {
        initComponents();
        this.menu = menu;
        this.eventSelected = eventSelected;
        this.index = index;
        setOpaque(false);
        setLayout(new MigLayout("wrap, fillx, insets 0", "fill", "[fill, 40!]0[fill, 35!]"));
        MenuButton firstItem = new MenuButton(menu.getIcon(), menu.getMenuName());
        firstItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu.getSubMenu().length > 0) {
                    if (event.menuPressed(MenuItem.this, !open)) {
                        open = !open;
                    }
                }
                eventSelected.menuSelected(index, -1);
            }
        });
        add(firstItem);
        int subMenuIndex = -1;
        for (String st : menu.getSubMenu()) {
            MenuButton item = new MenuButton(st);
            item.setIndex(++subMenuIndex);
            item.setForeground(Color.white);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    eventSelected.menuSelected(index, item.getIndex());
                }
            });
            add(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //Khi click chuột vào một menItem của menu sẽ hiện ra các item con và tô đậm nó
    @Override
    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getPreferredSize().height;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //float alpha = 0.3f; // Mức độ trong suốt (0.0 - 1.0)
        g2.setColor(new Color(100, 100, 100, (int) (0.3f * 255)));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.fillRect(0, 2, width, 38);      
        g2.setComposite(AlphaComposite.SrcOver);
        g2.fillRect(0, 40, width, height - 40);
        
        //Tạo các đường phân cách của các Item
        g2.setColor(new Color(100, 100, 100));
        g2.drawLine(30, 40, 30, height - 17);
        //Vẽ các đường ngang cho 
        for (int i = 0; i < menu.getSubMenu().length; i++) {
            int y = ((i + 1) * 35 + 40) - 17;
            g2.drawLine(30, y, 38, y);
        }
        
        //Tạo các mũi tên con cho menu
        if (menu.getSubMenu().length > 0) {
            createArrowButton(g2);
            int size = 4;
            int y = 19;
            int x = 205;
            g2.setColor(new Color(230, 230, 230));
            float ay = alpha * size;
            float ay1 = (1f - alpha) * size;
            g2.drawLine(x, y, x, y);
        }
        if (menu.getSubMenu().length > 0) {
            createArrowButton(g2);
        }
        super.paintComponents(g);
    }

    //Tạo mũi tên cho các menuItem 
    //Các câu lệnh bên dưói chả hiểu gì hứa sẽ tìm hiểu tại chatGPT
    private void createArrowButton(Graphics2D g2){
        int size = 4;
        int y = 20;
        int x = 240;
        g2.setColor(new Color(255, 255, 255));
        float ay = alpha * size;
        float ay1 = (1f - alpha) * size;
        g2.drawLine(x, (int) (y + ay), x + 4, (int) (y + ay1));
        g2.drawLine(x + 4, (int) (y + ay1), x + 8, (int) (y + ay));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
