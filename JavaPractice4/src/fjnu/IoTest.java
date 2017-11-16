package fjnu;

import java.io.*;
import java.util.*;

public class IoTest {//����IO����
	public static void main(String []args){
		File file1 = new File("src.txt");
		File file2 = new File("dest.txt");
		int a;
		try{//�Ӽ��̽����ֽ�����д�뵽��ǰĿ¼�µ�src.txt�ļ���
			FileOutputStream fo1 = new FileOutputStream(file1);
			System.out.println("Enter a line:");
			while((a = System.in.read()) != '\n'){
				fo1.write(a);
			}
			fo1.close(); 
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		int b;
		try{//��src.txt�ļ����ݸ��Ƶ���ǰĿ¼��dest.txt�ļ���
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			
			while((b = fr.read()) != -1){
				fw.write(b);
			}
			fr.close();
			fw.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
		try{//��dest.txt�ļ�������ʾ����Ļ��
			FileInputStream fi1 = new FileInputStream(file2);
			byte byt[] = new byte[1024];
			int len = fi1.read(byt);
			System.out.println("�ļ��е���Ϣ�ǣ�"+new String(byt,0,len));
			fi1.close();
		}catch(Exception e3){
			e3.printStackTrace();
		}
	}
}
