package eee;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import eee.ImagePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LeagueOfLegendPanel {
	public JButton p1=new JButton();
	public static void main(String []ar){
	JFrame f=new JFrame("lol");
	JPanel left=new JPanel();
	f.setSize(400,300);
    f.setLocation(200,200);
    f.setLayout(null);
	left.setBounds(50,50,300,60);
	left.setLayout(new BorderLayout());
	JToolBar t1=new JToolBar();
	t1.setLayout(new GridLayout(8,1));
	JButton l1=new JButton("盖伦");
	JButton l2=new JButton("提莫");
	JButton l3=new JButton("安妮");
	//left.add(l1);
	//left.add(l2);
	//left.add(l3);
	t1.add(l1);
	t1.add(l2);
	t1.add(l3);
	left.add(t1,BorderLayout.WEST);
	JPanel right=new JPanel();
	right.setBounds(10, 150, 300,60);
	right.setLayout(new BorderLayout());
	ImagePanel p1=new ImagePanel(new ImageIcon("C:\\Users\\陌年\\Desktop\\pics\\gareen.jpg").getImage());
	  ImagePanel p2=new ImagePanel(new ImageIcon("C:\\Users\\陌年\\Desktop\\pics\\teemo.jpg").getImage());
	  ImagePanel p3=new ImagePanel(new ImageIcon("C:\\Users\\陌年\\Desktop\\pics\\annie.jpg").getImage());
	  JTextField jt = new JTextField(10);
      jt.setBounds(new Rectangle(20, 20, 140, 20));
      //p1.add(jt);
      l1.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
          p2.setVisible(false);
          p3.setVisible(false);
       	  right.add(p1);
       	  p2.setVisible(true);
          p3.setVisible(true);
          }
      });
      
      l2.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
          p1.setVisible(false);
          p3.setVisible(false);
       	  right.add(p2);
       	p1.setVisible(true);
        p3.setVisible(true);
          }
      });
      
      l3.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
          p1.setVisible(false);
          p2.setVisible(false);
       	  right.add(p3);
          }
      });
      
      right.add(p1,BorderLayout.EAST);
      JSplitPane j=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
      j.setDividerLocation(100);
      f.setContentPane(j);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
	}
	
}
