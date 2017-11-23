package gui.panel;
import java.awt.*;
import javax.swing.*;
//import javax.swing.DefaultListModel;
import util.GUIUtil;
public class Form1Panel {
	static{
        GUIUtil.useLNF();
    }
	public JLabel HistoryQuery=new JLabel("��ʷ��¼��ѯ:");
	
	public TextField text1=new TextField(40);
	
	public JButton seek=new JButton("����");
	public JButton ViewHistory=new JButton("�鿴��ʷ��¼");
	public JButton DeleteHistory=new JButton("ɾ��������¼");
	
	public JList history;
	
	public Form1Panel(){
		//text1.setSize(500, 500);
		HistoryQuery.setFont(new Font("����", Font.BOLD, 15));
		seek.setFont(new Font("����", Font.BOLD, 15));
		ViewHistory.setFont(new Font("����", Font.BOLD, 15));
		DeleteHistory.setFont(new Font("����", Font.BOLD, 15));
		seek.setPreferredSize(new Dimension(80,30));
		seek.setBackground(Color.WHITE);
		ViewHistory.setPreferredSize(new Dimension(140,30));
		ViewHistory.setBackground(Color.WHITE);
		DeleteHistory.setPreferredSize(new Dimension(140,30));
		DeleteHistory.setBackground(Color.WHITE);
		JFrame j=new JFrame("Form1");
		j.setSize(600, 580);
		//j.setLayout(new BorderLayout());
		//j.add(north(),BorderLayout.NORTH);
		//j.add(center(),BorderLayout.CENTER);
		j.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(20,20,20,20);
		gbc.gridy=1;
		gbc.gridx=0;
		j.add(part1(),gbc);
		gbc.gridy=2;
		gbc.gridx=0;
		j.add(part2(),gbc);
		gbc.gridy=3;
		gbc.gridx=0;
		j.add(part3(),gbc);
		j.setLocationRelativeTo(null);
		j.setVisible(true);
	}
	public JPanel part1(){
		JPanel p1=new JPanel();
		p1.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(10,20,10,20);
		gbc.gridy=1;
		gbc.gridx=0;
		p1.add(HistoryQuery,gbc);
		gbc.gridy=2;
		gbc.gridx=0;
		p1.add(text1,gbc);
		gbc.gridx=1;
		p1.add(seek,gbc);
		return p1;
	}
	
	public JPanel part2(){
		JPanel p2=new JPanel();
		p2.setLayout(new GridBagLayout());
		JList history=new JList(new DataModel());
		history.setPreferredSize(new Dimension(450,40));
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(10,20,10,20);
		gbc.gridy=1;
		gbc.gridx=0;
		p2.add(new JScrollPane(history),gbc);
		return p2;
	}
	
	public JPanel part3(){
		JPanel p3=new JPanel();
		p3.setLayout(new GridBagLayout());
		//JList history=new JList(new DataModel());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets=new Insets(10,20,10,20);
		gbc.gridy=1;
		gbc.gridx=0;
		//p3.add(new JScrollPane(history),gbc);
		//gbc.gridy=2;
		//gbc.gridx=0;
		p3.add(ViewHistory,gbc);
		gbc.gridx=1;
		p3.add(DeleteHistory,gbc);
		return p3;
	}
	
	public static void main(String []arg){
		new Form1Panel();
	}
	
}
class DataModel extends DefaultListModel{
	String[] s={"ConfigID  	��ռ�k  	��Ⱥ��   	����Rn ��	��On 	��ɢCn 	xxxx  xxxxx"};
	DataModel(){
		for(int i=0;i<s.length;i++)
			//addElement((i+1)+"."+s[i]);
			addElement(s[i]);
	}
}
