package com.dai.scrollbar;

import com.dai.scrollbar.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setForeground(new Color(255, 102, 102));
        setUnitIncrement(20);
        setOpaque(false);
    }
}
