package fjnu;

import java.io.*;
import java.util.*;

public class GetFileTree {//获取系统的文件树
	public static void main(String []args){
		System.out.println("Enter the solute:");
		Scanner scan = new Scanner(System.in);
		String solute = scan.nextLine();//从控制台输入目录
		scan.close();
		File file1 = new File(solute);
		String []list;
		list = file1.list();//获取目录下所有文件或目录的名字列表
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//将获取的修改时间转换成标准的年月日时分秒
		int num1 = 0;//记录文件个数
		int num2 = 0;//记录文件夹个数
		ArrayList<FileInformation> List = new ArrayList<FileInformation>();//List用于存储文件/文件夹信息（FileInformation对象）
		for(int i = 0;i < list.length;i++){
			//System.out.println(list[i]);
			File file2 = new File(solute+"\\"+list[i]);
			if(file2.exists()){
				String dateTime=df.format(new Date(file2.lastModified()));//时间转换
				if(file2.isFile()){//是文件，显示其名称，修改日期和大小
					num1++;
					System.out.println(file2.getName() + "\t修改日期：" + dateTime + "\t大小：" + file2.length() +"字节");
				}
				else{//是文件夹，显示其名称，修改日期
					num2++;
					System.out.println(file2.getName() + "\t修改日期：" + dateTime);
					FileInformation tmp = new FileInformation();//构造临时FileInformation对象tmp
					tmp.setFolder(file2.getName(),dateTime);
					List.add(tmp);//先添加文件夹到List队列
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
				FileInformation tmp = new FileInformation();//构造临时FileInformation对象tmp
				tmp.setFile(file2.getName(),dateTime,file2.length());
				List.add(tmp);//后添加文件到List队列
			}
		}
		Collections.sort(List.subList(0, num2));//对前num2个所有文件夹进行排序
		Collections.sort(List.subList(num2, num2 + num1));//对后num1个所有文件进行排序
		for(int i = 0;i < num1 + num2;i++){//输出排好序的List队列的FileInformation对象的名字属性
			FileInformation tmp = new FileInformation();
			tmp = List.get(i);
			System.out.println(tmp.getName());
		}
		
		File file3 = new File("information.txt");//information.txt存放目录信息
		try{
			FileWriter fw = new FileWriter(file3);
			for(int i = 0;i < num2;i++){//将前num2个所有文件夹信息写入information.txt
				FileInformation tmp = new FileInformation();
				tmp = List.get(i);
				String str = tmp.getName() + "\t修改日期：" + tmp.getDate() + "\r\n";
				fw.write(str);
			}
			for(int j = num2;j < List.size();j++){//将后num1个所有文件信息写入information.txt
				FileInformation tmp = new FileInformation();
				tmp = List.get(j);
				String str = tmp.getName() + "\t修改日期：" + tmp.getDate() + "\t大小：" + tmp.getLength() + "字节" + "\r\n";
				fw.write(str);
			}
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
