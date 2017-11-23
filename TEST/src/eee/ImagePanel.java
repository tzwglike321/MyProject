package eee;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
 
import javax.swing.JPanel;
 
public class ImagePanel extends JPanel{
    private Image image;
    public ImagePanel(Image img){
        this.image = img;
        Dimension dime = new Dimension(image.getWidth(null),image.getHeight(null));
        this.setPreferredSize(dime);
        this.setMaximumSize(dime);
        this.setMinimumSize(dime);
        this.setSize(dime);
        this.setLayout(null);
    }
     
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0,0,null);
    }
}