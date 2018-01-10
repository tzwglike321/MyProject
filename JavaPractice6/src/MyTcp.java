import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
public class MyTcp extends JFrame{
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container container;
	PrintWriter writer;
	
	public MyTcp(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = this.getContentPane();
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		container.add(tf,"South");
		tf.addActionListener(new ActionListener(){
			//绑定事件
			public void actionPerformed(ActionEvent e){
				//将文本框中的信息写入流
				writer.println(tf.getText());
				//将文本框中的信息显示在文本域中
				ta.append(tf.getText()+'\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			} 

		});
		
	}
	
	void getserver(){
		try{
			server = new ServerSocket(8770);
			System.out.println("服务器套接字已将创建成功");
			ta.append("连接成功\n");
			while(true){
				System.out.println("等待客户机的连接");
				socket = server.accept();
				writer = new  PrintWriter(socket.getOutputStream(),true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void getClientMessage(){
		try{
			while(true){
				//获得客户端信息
				ta.append("客户机:"+reader.readLine()+'\n');
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		MyTcp tcp = new MyTcp("向客户端发送数据");
		tcp.setSize(400,400);
		tcp.setVisible(true);
		tcp.getserver();
	}
}
