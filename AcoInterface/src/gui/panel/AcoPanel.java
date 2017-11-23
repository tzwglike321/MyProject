package gui.panel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import util.ColorUtil;
import util.GUIUtil;
public class AcoPanel {
	 static{
	        GUIUtil.useLNF();
	    }
	 //public static AcoPanel instance=new AcoPanel();
	 
	 public	JLabel kValue=new JLabel("kÖµ:");
	 public JLabel ¦ÂValue=new JLabel("¦ÂÖµ:");
	 public	JLabel mValue=new JLabel("mÖµ:");
	 public JLabel ¦ÎValue=new JLabel("¦ÎÖµ:");
	 public JLabel qValue=new JLabel("qÖµ:");
	 public JLabel jValue=new JLabel("jÖµ:");
	 public JLabel rDisplay=new JLabel("½á¹ûÏÔÊ¾:");
	 
	 public JTextField kInput=new JTextField(10);
	 public JTextField ¦ÂInput=new JTextField(10);
	 public JTextField mInput=new JTextField(10);
	 public JTextField ¦ÎInput=new JTextField(10);
	 public JTextField qInput=new JTextField(10);
	 public JTextField jInput=new JTextField(10);
	 
	 public JButton initialize;
	 public JButton run;
	 
	 public JScrollPane sp;
	 public JScrollBar s1;
	 public JScrollBar s2;
	 
	 
	 
	 public AcoPanel(){
		JDialog j=new JDialog();
		j.setTitle("ÒÏÈºËã·¨");
		j.setSize(700, 700);
		kValue.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		¦ÂValue.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		mValue.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		¦ÎValue.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		qValue.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		jValue.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		rDisplay.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		j.setLayout(new BorderLayout());
		j.add(north(),BorderLayout.NORTH);
		j.add(center(),BorderLayout.CENTER);
		j.setLocationRelativeTo(null);
		j.setVisible(true);
	 }
	 
	 private JPanel north(){
		 JPanel p1=new JPanel();
		// p1.setLayout(new GridLayout(3,4,10,10));
		 //p1.setBorder(new EmptyBorder(40, 40, 40, 40));
		 p1.setLayout(new GridBagLayout());
		 GridBagConstraints gbc=new GridBagConstraints();
		 gbc.anchor=GridBagConstraints.WEST;
		 gbc.insets=new Insets(10,2,10,10);
		 gbc.gridy=1;
		 gbc.gridx=0;
		 p1.add(kValue,gbc);
		 gbc.gridx=1;
		 p1.add(kInput,gbc);
		 gbc.gridx=2;
		 p1.add(¦ÂValue,gbc);
		 gbc.gridx=3;
		 p1.add(¦ÂInput,gbc);
		 gbc.gridy=2;
		 gbc.gridx=0;
		 p1.add(mValue,gbc);
		 gbc.gridx=1;
		 p1.add(mInput,gbc);
		 gbc.gridx=2;
		 p1.add(¦ÎValue,gbc);
		 gbc.gridx=3;
		 p1.add(¦ÎInput,gbc);
		 gbc.gridy=3;
		 gbc.gridx=0;
		 p1.add(qValue,gbc);
		 gbc.gridx=1;
		 p1.add(qInput,gbc);
		 gbc.gridx=2;
		 p1.add(jValue,gbc);
		 gbc.gridx=3;
		 p1.add(jInput,gbc);
		 return p1;
	 }
	 
	 private JPanel center(){
		JPanel p4=new JPanel();
		p4.setLayout(new BorderLayout());
		p4.setBorder(new EmptyBorder(0, 40, 40,40));
		p4.add(north1(),BorderLayout.NORTH);
		p4.add(center1(),BorderLayout.CENTER);
		return p4;
	 }
	 
	 private JPanel north1(){
		JPanel p2=new JPanel();
		//p2.setLayout(new FlowLayout());
		p2.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(20,56,20,20);
		gbc.gridy=1;
		gbc.gridx=0;
		p2.add(initialize(),gbc);
		gbc.gridx=1;
		p2.add(run(),gbc);
		return p2;
	 }
	 
	 private JPanel center1(){
		JTable table=new JTable(new MyTable());
		table.setPreferredScrollableViewportSize(new Dimension(550,30));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		//table.setRowHeight(10);
		
		JScrollPane sp = new JScrollPane(table);
		//sp.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		//sp.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel p3=new JPanel();
		p3.setLayout(new BorderLayout());
		p3.setBorder(new EmptyBorder(0, 40, 40,40));
		p3.add(rDisplay,BorderLayout.NORTH);
		p3.add(sp,BorderLayout.CENTER);
		//p3.add(s1(),BorderLayout.EAST);
		//p3.add(s2(),BorderLayout.SOUTH);
		return p3;
	 }
	 
	 public JButton initialize(){
		 JButton initialize=new JButton("³õÊ¼»¯");
		 initialize.setPreferredSize(new Dimension(120,45));
		 initialize.setBackground(Color.WHITE);
		 return initialize;
	 }
	 
	 public JButton run(){
		 JButton run=new JButton("¿ªÊ¼ÔËÐÐ");
		 run.setPreferredSize(new Dimension(120,45));
		 run.setBackground(Color.WHITE);
		 return run;
	 }
	 
	 public JScrollBar s1(){
		JScrollBar s1=new JScrollBar(JScrollBar.VERTICAL,10,10,0,100);
		s1.setUnitIncrement(1);
		s1.setBlockIncrement(10);
		return s1;
	 }
	 
	 public JScrollBar s2(){
		JScrollBar s2=new JScrollBar();
		s2.setOrientation(JScrollBar.HORIZONTAL);
		s2.setValue(0);
		s2.setVisibleAmount(5);
		s2.setMinimum(5);
		s2.setMaximum(60);
		s2.setBlockIncrement(5);
		return s2;
	 }
	 
	 public static void main(String []arg){
		 AcoPanel test=new AcoPanel();
	 }
	 
}
class MyTable extends AbstractTableModel{
	Object [][] IoData={
			{1.1,1.1,1.1,1.1,1.12,1.1,1.1,1.1,1.17,1.1,1.1,1.1,1.1,1.1,1.1,}
			,{1.21,1.2,1.2,1.2,1.2,1.2,1.26,1.2,1.2,1.223,1.2,1.2,1.2,1.2,1.2}
		};
	String []Names={"R1","R2","R3","R4","R5","O1","O2","O3","O4","O5","C1","C2","C3","C4","C5"};
	public int getColumnCount(){
		return Names.length;
	}
	public int getRowCount(){
		return IoData.length;
	}
	public Object getValueAt(int row,int col){
		return IoData[row][col];
	}
	public String getColumnName(int col){
		return Names[col];
	}
}
