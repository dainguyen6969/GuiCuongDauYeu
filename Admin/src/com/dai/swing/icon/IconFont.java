/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dai.swing.icon;

import java.io.InputStream;

/**
 *
 * @author ThinkPad
 */
public interface IconFont {

    /**
     * Gets the font family name.
     *
     * @return String
     */
    String getFontFamily();

    /**
     * Gets a stream to the font.
     *
     * @return InputStream
     */
    InputStream getFontInputStream();
}
