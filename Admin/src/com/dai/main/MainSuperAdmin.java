/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.dai.main;

import com.dai.component.Menu;
import com.dai.component.Menu_SuperAdmin;
import com.dai.component.header;
import com.dai.event.EventMenuSelected;
import com.dai.event.EventShowPopupMenu;
import com.dai.form.Duyet_Nguoi_Ban.Panel_Duyet_Nguoi_Ban1;
import com.dai.form.MainForm;
import com.dai.form.Quan_Ly_User.Panel_KhachHang;
import com.dai.form.Quan_Ly_User.Panel_NguoiBan;
import com.dai.form.Quan_Ly_Danh_Muc.Panel_DanhMuc;
import com.dai.form.Quan_Ly_Danh_Muc.Panel_Them_Danh_Muc;
import com.dai.form.Tao_Quan_Tri_Vien.Panel_DanhSachQuanTriVien;
import com.dai.form.Tao_Quan_Tri_Vien.Panel_ThemQuanTriVien;
import com.dai.swing.MenuItem;
import com.dai.swing.MenuPopup;
import com.dai.swing.icon.GoogleMaterialDesignIcons;
import com.dai.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author ThinkPad
 */
public class MainSuperAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private MigLayout layout;
    private Menu_SuperAdmin menu;
    private header header;
    private MainForm form;
    private Animator animator;

    public MainSuperAdmin() {
        initComponents();
        init();
        setLocationRelativeTo(null);
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu_SuperAdmin();
        header = new header();
        form = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu index: " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    form.showForm(new Panel_Duyet_Nguoi_Ban1());
                } else if (menuIndex == 1) {
                    form.showForm(new Panel_DanhMuc());
                    if (subMenuIndex == 0) {
                        form.showForm(new Panel_DanhMuc());
                    } else if (subMenuIndex == 1) {
                        form.showForm(new Panel_Them_Danh_Muc());
                    }
                } else if (menuIndex == 2) {
                    form.showForm(new Panel_KhachHang());
                    if (subMenuIndex == 0) {
                        form.showForm(new Panel_KhachHang());
                    } else if (subMenuIndex == 1) {
                        form.showForm(new Panel_NguoiBan());
                    }
                } else if (menuIndex == 3) {
                    form.showForm(new Panel_DanhSachQuanTriVien());
                    if (subMenuIndex == 0) {
                        form.showForm(new Panel_DanhSachQuanTriVien());
                    } else if (subMenuIndex == 1) {
                        form.showForm(new Panel_ThemQuanTriVien());
                    }
                }
            }
        });

        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) { //Câu lệnh này để hiện vị trí của popup ở đâu
                MenuItem item = (MenuItem) com;
                MenuPopup popup = new MenuPopup(MainSuperAdmin.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = MainSuperAdmin.this.getX() + 59;
                int y = MainSuperAdmin.this.getY() + com.getY() + 126;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });

        menu.initMenuItem();
        bg.add(menu, "w 260!, spany 2"); // span Y 2cell là gì????
        bg.add(header, "h 50!, wrap");
        bg.add(form, "w 100%, h 100%");

        //Cần có thư viện TimingFrameword
        //TimingTarget dùng để xử lý sự kiện trong quá trình chạy animation
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) { //Fraction là phân số theo GG dịch
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (200 * (1f - fraction)); //Điều chỉnh chiều rộng của menu về 61
                } else {
                    width = 60 + (200 * fraction); //Điều chỉnh lại chiều rộng của menu từ 61 về lại 230
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                //spany 2 ràng buộc cho việc menu chiếm hai hàng
                //setComponentConstrants là dùng để thay đổi ràng buộc(constraint) của một thành phần trong layout
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hidealMenu();
                }
            }
        });
        //Khởi kích cỡ icon google
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //Trang chủ
        //form.showForm(new Form_Home());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSuperAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
