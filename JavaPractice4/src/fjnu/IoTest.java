package fjnu;

import java.io.*;
import java.util.*;

public class IoTest {//基本IO操作
	public static void main(String []args){
		File file1 = new File("src.txt");
		File file2 = new File("dest.txt");
		int a;
		try{
			FileOutputStream fo1 = new FileOutputStream(file1);
			System.out.println("Enter a line:");
			while((a = System.in.read()) != '\n'){//从键盘接收字节流
				fo1.write(a);//写入到当前目录下的src.txt文件中
			}
			fo1.close(); 
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		int b;
		try{
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			while((b = fr.read()) != -1){
				fw.write(b);//将src.txt文件内容复制到当前目录下dest.txt文件中
			}
			fr.close();
			fw.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
		try{//将dest.txt文件内容显示到屏幕上
			FileInputStream fi1 = new FileInputStream(file2);
			byte byt[] = new byte[1024];
			int len = fi1.read(byt);
			System.out.println(file2.getName()+":"+new String(byt,0,len));
			fi1.close();
		}catch(Exception e3){
			e3.printStackTrace();
		}
	}
}
