package fjnu;

import java.io.*;
import java.util.*;

public class GetFileTree {//��ȡĳ��Ŀ¼�µ�Ŀ¼��Ϣ
	public static void main(String []args){
		System.out.println("Enter the solute:");
		Scanner scan = new Scanner(System.in);
		String solute = scan.nextLine();//�ӿ���̨����Ŀ¼
		scan.close();
		File file1 = new File(solute);
		String []list;
		list = file1.list();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//��ʱ��ת���ɱ�׼��������ʱ����
		int num1 = 0;//��¼�ļ�����
		int num2 = 0;//��¼�ļ��и���
		ArrayList<FileInformation> List = new ArrayList<FileInformation>();//����ļ���Ϣ�Ķ���
		for(int i = 0;i < list.length;i++){
			//System.out.println(list[i]);
			File file2 = new File(solute+"\\"+list[i]);
			if(file2.exists()){
				String dateTime=df.format(new Date(file2.lastModified()));//ת����ı�׼ʱ��
				if(file2.isFile()){
					num1++;
					System.out.println(file2.getName() + "	修改日期：" + dateTime + "	大小：" + file2.length() +"字节");
				}
				else{
					num2++;
					System.out.println(file2.getName() + "	修改日期：" + dateTime);
					FileInformation tmp = new FileInformation();//�ļ�����ʱ����tmp
					tmp.setFolder(file2.getName(),dateTime);
					List.add(tmp);//List������ļ��ж���
				}
			}
			else{
				System.out.println("file do not exist!");
			}	
		}
		System.out.println("");
		for(int i = 0;i < list.length;i++){
			File file2 = new File(solute+"\\"+list[i]);
			String dateTime=df.format(new Date(file2.lastModified()));
			if(file2.isFile()){
				FileInformation tmp = new FileInformation();//�ļ���ʱ����tmp
				tmp.setFile(file2.getName(),dateTime,file2.length());
				List.add(tmp);//List������ļ�����
			}
		}
		Collections.sort(List.subList(0, num2 - 1));//ָ��Listǰ���ļ��в��ֽ�������
		Collections.sort(List.subList(num2, num2 + num1 - 1));//ָ��List�����ļ����ֽ�������
		for(int i = 0;i < num1 + num2;i++){
			FileInformation tmp = new FileInformation();
			tmp = List.get(i);
			System.out.println(tmp.getName());
		}
		
		File file3 = new File("information.txt");//���ڱ���Ŀ¼����Ϣ
		try{
			FileWriter fw = new FileWriter(file3);
			for(int i = 0;i < num2;i++){//�Ƚ��ļ�����Ϣд���ļ�
				FileInformation tmp = new FileInformation();
				tmp = List.get(i);
				String str = tmp.getName() + " 修改日期：:" + tmp.getDate() + "\r\n";
				fw.write(str);
			}
			for(int j = num2;j < List.size();j++){//����ļ���Ϣд���ļ�
				FileInformation tmp = new FileInformation();
				tmp = List.get(j);
				String str = tmp.getName() + " 修改日期：" + tmp.getDate() + " 	大小：" + tmp.getLength() + "字节" + "\r\n";
				fw.write(str);
			}
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
