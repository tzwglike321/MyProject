package eee;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
public class TestProject1 {
	public static void main(String []arg){
	JDialog j=new JDialog();
	j.setTitle("蚁群算法");
	j.setSize(700, 600);
	JDialog d = new JDialog();
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	
	
	JLabel l1=new JLabel("k值:");
	JLabel l2=new JLabel("β值:");
	JLabel l3=new JLabel("m值:");
	JLabel l4=new JLabel("ξ值:");
	JLabel l5=new JLabel("q值:");
	JLabel l6=new JLabel("j值:");
	JLabel l7=new JLabel("结果显示:");
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	
	p1.setLayout(new GridLayout(3,4,10,10));
	p1.setBorder(new EmptyBorder(40, 40, 20, 40));
	p1.add(l1);
	p1.add(t1);
	p1.add(l2);
	p1.add(t2);
	//p2.setLayout(new FlowLayout());
	p1.add(l3);
	p1.add(t3);
	p1.add(l4);
	p1.add(t4);
	//p3.setLayout(new FlowLayout());
	p1.add(l5);
	p1.add(t5);
	p1.add(l6);
	p1.add(t6);
	
	JButton b1=new JButton("初始化");
	JButton b2=new JButton("开始运行");
	
	b1.setPreferredSize(new Dimension(100,40));
	b2.setPreferredSize(new Dimension(100,40));
	p2.setLayout(new FlowLayout());
	p2.add(b1);
	p2.add(b2);
	
	JScrollBar s1=new JScrollBar(JScrollBar.VERTICAL,10,10,0,100);
	s1.setUnitIncrement(1);
	s1.setBlockIncrement(10);
	JScrollBar s2=new JScrollBar();
	s2.setOrientation(JScrollBar.HORIZONTAL);
	s2.setValue(0);
	s2.setVisibleAmount(20);
	s2.setMinimum(10);
	s2.setMaximum(60);
	s2.setBlockIncrement(5);
	
	Object [][] IoData={
		{1.1,1.1,1.1,1.1,1.12,1.1,1.1,1.1,1.17,1.1,1.1,1.1,1.1,1.1,1.1,}
		,{1.21,1.2,1.2,1.2,1.2,1.2,1.26,1.2,1.2,1.223,1.2,1.2,1.2,1.2,1.2}
	};
	String []Names={"R1","R2","R3","R4","R5","O1","O2","O3","O4","O5","C1","C2","C3","C4","C5"};
	JTable table=new JTable(IoData,Names);
	table.setPreferredScrollableViewportSize(new Dimension(400,30));
	table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	//table.getColumnModel().getColumn(0).setPreferredWidth(3);
	JScrollPane sp = new JScrollPane(table);
	
	p3.setLayout(new BorderLayout());
	p3.setBorder(new EmptyBorder(0, 40, 40,40));
	p3.add(l7,BorderLayout.NORTH);
	p3.add(sp,BorderLayout.CENTER);
	p3.add(s1,BorderLayout.EAST);
	p3.add(s2,BorderLayout.SOUTH);
	p5.setLayout(new BorderLayout());
	p5.add(p2,BorderLayout.NORTH);
	p5.add(p3,BorderLayout.CENTER);
	
	j.setLayout(new BorderLayout());
	j.add(p1,BorderLayout.NORTH);
	//j.add(p2,BorderLayout.CENTER);
	j.add(p5,BorderLayout.CENTER);
	//j.add(p4,BorderLayout.CENTER);
	j.setLocationRelativeTo(null);
	j.setVisible(true);
}
}
