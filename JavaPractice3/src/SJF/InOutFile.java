package SJF;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class InOutFile {
	int taskNum = 100;//任务个数
	int []serveTime = {6,2,1,3,9};//服务时间数据
	int [][]getTime = new int [taskNum][3];//获取文件数据
	
	public void writeFile(){
		try{
			File task = new File("task.txt");
			FileWriter fw = new FileWriter(task);
			Random rand = new Random();
			String str = "";
			for(int i =0;i < 100;i++){
				int randTime = serveTime[rand.nextInt(5)];
				str = ( i + 1 ) + " " + i + " " + randTime + "\r\n";
				fw.write(str);
			}
			fw.close();
		}catch(Exception e1) {
			e1.printStackTrace();	
		}
	}
	
	public int [][]readFile(){
		try {
			//File task =new File("task.txt");
			File task =new File("input.txt");
			//FileReader fr =new FileReader(task);
			Scanner sc = new Scanner(task);
			//BufferedReader br = new BufferedReader(fr);
			String str = null;
			int row =0;//����
			while (sc.hasNext()){
				
				//String []arr = str.split(" ");
				for(int i = 0;i < 3;i++)
					{
						int tmp=0;
						if(sc.hasNext()){
							tmp = sc.nextInt();
							getTime[row][i] = tmp;
						}
						else break;
						
					}
						row++;	
				
			}
			/*for(int i = 0;i < taskNum;i++)
				for(int j = 0;j < 3;j++)
					{
						System.out.print(getTime[i][j]+" ");
						if(j == 2){
							System.out.print("\n");
						}
					}*/
					
		}catch(Exception e2) {
			e2.printStackTrace();	
		}
		return getTime;
		
	}
	
	public boolean fileExist(){
		File task =new File("task.txt");
		if(task.exists())
			return true;
		else 
			return false;
	}
	
	/*public static void main(String []args){
		inOutFile test = new inOutFile();
		if(!test.fileExist())
			test.writeFile();
		test.readFile();
	}*/
}