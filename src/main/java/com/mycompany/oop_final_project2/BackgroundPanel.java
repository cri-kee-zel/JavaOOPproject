package com.mycompany.oop_final_project2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
  private Image backgroundImage;

  public BackgroundPanel(String fileName) {
      backgroundImage = new ImageIcon(fileName).getImage();
  }

  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
  }
}
