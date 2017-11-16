package fjnu;

import java.io.*;
import java.util.*;

public class GetFileTree {//获取某个目录下的目录信息
	public static void main(String []args){
		System.out.println("Enter the solute:");
		Scanner scan = new Scanner(System.in);
		String solute = scan.nextLine();//从控制台输入目录
		scan.close();
		File file1 = new File(solute);
		String []list;
		list = file1.list();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//将时间转换成标准的年月日时分秒
		int num1 = 0;//记录文件个数
		int num2 = 0;//记录文件夹个数
		ArrayList<FileInformation> List = new ArrayList<FileInformation>();//存放文件信息的队列
		for(int i = 0;i < list.length;i++){
			//System.out.println(list[i]);
			File file2 = new File(solute+"\\"+list[i]);
			if(file2.exists()){
				String dateTime=df.format(new Date(file2.lastModified()));//转换后的标准时间
				if(file2.isFile()){
					num1++;
					System.out.println(file2.getName() + "	修改日期：" + dateTime + "	文件大小：" + file2.length() +"字节");
				}
				else{
					num2++;
					System.out.println(file2.getName() + "	修改日期：" + dateTime);
					FileInformation tmp = new FileInformation();//文件夹临时对象tmp
					tmp.setFolder(file2.getName(),dateTime);
					List.add(tmp);//List先添加文件夹对象
				}
			}
			else{
				System.out.println("文件或文件夹不存在！");
			}	
		}
		
		for(int i = 0;i < list.length;i++){
			File file2 = new File(solute+"\\"+list[i]);
			String dateTime=df.format(new Date(file2.lastModified()));
			if(file2.isFile()){
				FileInformation tmp = new FileInformation();//文件临时对象tmp
				tmp.setFile(file2.getName(),dateTime,file2.length());
				List.add(tmp);//List后添加文件对象
			}
		}
		Collections.sort(List.subList(0, num2 - 1));//指定List前面文件夹部分进行排序
		Collections.sort(List.subList(num2, num2 + num1 - 1));//指定List后面文件部分进行排序
		/*for(int i = 0;i < num1 + num2;i++){
			FileInformation tmp = new FileInformation();
			tmp = List.get(i);
			System.out.println(tmp.getName());
		}*/
		
		File file3 = new File("information.txt");//用于保存目录的信息
		try{
			FileWriter fw = new FileWriter(file3);
			for(int i = 0;i < num2;i++){//先将文件夹信息写入文件
				FileInformation tmp = new FileInformation();
				tmp = List.get(i);
				String str = tmp.getName() + " 修改日期:" + tmp.getDate() + "\r\n";
				fw.write(str);
			}
			for(int j = num2;j < List.size();j++){//后把文件信息写入文件
				FileInformation tmp = new FileInformation();
				tmp = List.get(j);
				String str = tmp.getName() + " 修改日期:" + tmp.getDate() + " 大小:" + tmp.getLength() + "字节" + "\r\n";
				fw.write(str);
			}
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
