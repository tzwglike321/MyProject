package SJF;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class InOutFile {
	int taskNum = 100;//�������
	int []serveTime = {6,2,1,3,9};//����ʱ������
	int [][]getTime = new int [taskNum][3];//��ȡ�ļ�����
	
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
			File task =new File("task.txt");
			FileReader fr =new FileReader(task);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			int row =0;//����
			while ((str = br.readLine())!= null){
				String []arr = str.split(" ");
				for(int i = 0;i < arr.length;i++)
					{
						int tmp = Integer.parseInt(arr[i]);
						getTime[row][i] = tmp;
					}
						row++;	
		
			}
			br.close();
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
