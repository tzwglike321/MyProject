package gui.panel;
import java.awt.*;
import javax.swing.*;
import util.GUIUtil;
import util.ColorUtil;
public class Form2Panel {
	static{
        GUIUtil.useLNF();
    }
	public JLabel CofID=new JLabel("ConfigID:");
	public JLabel SolSpace=new JLabel("解空间k:");
	public JLabel AntNum=new JLabel("蚂蚁数:");
	public JLabel ProImpact=new JLabel("方案影响度:");
	public JLabel SearWidth=new JLabel("搜索宽度:");
	public JLabel StopNum=new JLabel("终止num:");
	public JLabel gap=new JLabel("差距gap:");
	public JLabel continuity=new JLabel("连续Rn:");
	public JLabel order=new JLabel("有序On:");
	public JLabel discrete=new JLabel("离散Cn:");
	public JLabel IniData=new JLabel("初始数据:");
	public JLabel ResData=new JLabel("结果数据:");
	
	public JTextArea ConfText=new JTextArea("0000001",1,10);
	public JTextArea SolText=new JTextArea("20",1,10);
	public JTextArea AntText=new JTextArea("5",1,10);
	public JTextArea ProText=new JTextArea("0.559",1,10);
	public JTextArea SearText=new JTextArea("0.6795",1,10);
	public JTextArea StopText=new JTextArea("90",1,10);
	public JTextArea GapText=new JTextArea("0.03",1,10);
	public JTextArea ContinuText=new JTextArea("1",1,10);
	public JTextArea OrderText=new JTextArea("1",1,10);
	public JTextArea DiscText=new JTextArea("1",1,10);
	
	public Form2Panel(){
		/*ConfText.setBackground(ColorUtil.grayColor);
		SolText.setBackground(Color.GRAY);
		AntText.setBackground(Color.GRAY);
		ProText.setBackground(Color.GRAY);
		SearText.setBackground(Color.GRAY);
		StopText.setBackground(Color.GRAY);
		GapText.setBackground(Color.GRAY);
		ContinuText.setBackground(Color.GRAY);
		OrderText.setBackground(Color.GRAY);
		DiscText.setBackground(Color.GRAY);*/
		JFrame j=new JFrame("Form2");
		j.setSize(700,700);
		//j.setLayout(new BorderLayout());
		j.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(10,10,10,10);
		gbc.gridy=1;
		gbc.gridx=0;
		j.add(part1(),gbc);
		gbc.gridy=2;
		gbc.gridx=0;
		j.add(part2(),gbc);
		gbc.gridy=3;
		gbc.gridx=0;
		j.add(part3(),gbc);
		//j.add(part1(),BorderLayout.NORTH);
		//j.add(part2(),BorderLayout.CENTER);
		j.setLocationRelativeTo(null);
		j.setVisible(true);
	}
	
	public JPanel part1(){
		JPanel p1=new JPanel();
		p1.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(10,10,10,4);
		gbc.gridy=1;
		gbc.gridx=0;
		p1.add(CofID,gbc);
		gbc.gridx=1;
		p1.add(ConfText,gbc);
		gbc.gridy=2;
		gbc.gridx=0;
		p1.add(SolSpace,gbc);
		gbc.gridx=1;
		p1.add(SolText,gbc);
		gbc.gridx=2;
		p1.add(AntNum,gbc);
		gbc.gridx=3;
		p1.add(AntText,gbc);
		gbc.gridx=4;
		p1.add(ProImpact,gbc);
		gbc.gridx=5;
		p1.add(ProText,gbc);
		gbc.gridy=3;
		gbc.gridx=0;
		p1.add(SearWidth,gbc);
		gbc.gridx=1;
		p1.add(SearText,gbc);
		gbc.gridx=2;
		p1.add(StopNum,gbc);
		gbc.gridx=3;
		p1.add(StopText,gbc);
		gbc.gridx=4;
		p1.add(gap,gbc);
		gbc.gridx=5;
		p1.add(GapText,gbc);
		gbc.gridy=4;
		gbc.gridx=0;
		p1.add(continuity,gbc);
		gbc.gridx=1;
		p1.add(ContinuText,gbc);
		gbc.gridx=2;
		p1.add(order,gbc);
		gbc.gridx=3;
		p1.add(OrderText,gbc);
		gbc.gridx=4;
		p1.add(discrete,gbc);
		gbc.gridx=5;
		p1.add(DiscText,gbc);
		return p1;
	}
	
	public JPanel part2(){
		JPanel p2=new JPanel();
		p2.setLayout(new GridBagLayout());
		JTable table1=new JTable();
		table1.setPreferredScrollableViewportSize(new Dimension(500,150));
		JScrollPane sp1=new JScrollPane(table1);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(10,10,10,10);
		gbc.gridy=1;
		gbc.gridx=0;
		p2.add(IniData,gbc);
		gbc.gridy=2;
		gbc.gridx=0;
		p2.add(sp1,gbc);
		return p2;
	}
	
	public JPanel part3(){
		JPanel p3=new JPanel();
		p3.setLayout(new GridBagLayout());
		JTable table1=new JTable();
		table1.setPreferredScrollableViewportSize(new Dimension(500,150));
		JScrollPane sp2=new JScrollPane(table1);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(10,10,10,10);
		gbc.gridy=1;
		gbc.gridx=0;
		p3.add(ResData,gbc);
		gbc.gridy=2;
		gbc.gridx=0;
		p3.add(sp2,gbc);
		return p3;
	}
	
	public static void main(String []arg){
		new Form2Panel();
	}
}
