package com.mycompany.oop_final_project2;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class StrokeLabel extends JLabel {
    private Color strokeColor;
    private float strokeWidth;

    public StrokeLabel(String text, Color strokeColor, float strokeWidth) {
        super(text);
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensure the parent class's paintComponent is called
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Get the font metrics
        Font font = getFont();
        Rectangle2D bounds = font.getStringBounds(getText(), g2.getFontRenderContext());

        // Calculate the position to center the text
        int x = (getWidth() - (int) bounds.getWidth()) / 2;
        int y = (getHeight() - (int) bounds.getHeight()) / 2 + g2.getFontMetrics().getAscent();

        // Draw the stroke
        g2.setColor(strokeColor);
        g2.setStroke(new java.awt.BasicStroke(strokeWidth));
        AffineTransform originalTransform = g2.getTransform();
        g2.translate(x, y);
        g2.draw(font.createGlyphVector(g2.getFontRenderContext(), getText()).getOutline());
        g2.setTransform(originalTransform);

        // Draw the text
        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);

        g2.dispose();
    }
}