import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
public class MyClient extends JFrame{
	private BufferedReader reader;
	private PrintWriter writer;
	Socket socket;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container container;
	
	public MyClient(String title){
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
	private void connect(){
		ta.append("尝试连接\n");
		try{
			socket = new Socket("127.0.0.1",8770);
			
			writer = new  PrintWriter(socket.getOutputStream(),true);
		
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ta.append("连接成功\n");
			getTcpMessage();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void getTcpMessage(){
		try{
			while(true){
				//获得客户端信息
				ta.append("服务器:"+reader.readLine()+'\n');
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
	public static void main(String[] args) {
		
		MyClient client = new MyClient("向服务器发送数据");
		client.setSize(400,400);
		client.setVisible(true);
		client.connect();
	}
}
