package com.dai.swing.icon;

public class DefaultIconCode implements IconCode{

    private final char unicode;
    private final String fontFamily;

    /**
     * Construtor.
     *
     * @param fontFamily the font family.
     * @param unicode the icon code.
     */
    public DefaultIconCode(String fontFamily, char unicode) {
        this.fontFamily = fontFamily;
        this.unicode = unicode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return "[" + getUnicode() + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char getUnicode() {
        return unicode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFontFamily() {
        return fontFamily;
    }

}
