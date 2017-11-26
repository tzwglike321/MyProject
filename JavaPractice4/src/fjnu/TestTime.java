package fjnu;

import java.io.*;

public class TestTime {//用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况
	public static void main(String []args){
		
		File file = new File("list.txt");
		try{//不带缓冲的字符流实现文件复制
			File frFile = new File("FileReader.txt");
			FileReader fr = new FileReader(file);
			FileWriter fw = new FileWriter(frFile);
			int i;
			long startTime = System.currentTimeMillis();
			while((i = fr.read()) != -1){
				fw.write(i);
			}
			long endTime = System.currentTimeMillis();
			fr.close();
			fw.close();
			System.out.println("FileStream runTime is:" + (endTime - startTime) + "ms");
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		try{//用带缓冲的字符流实现文件复制
			File brFile = new File("BufferedReader.txt");
			FileReader fr = new FileReader(file);
			FileWriter fw = new FileWriter(brFile);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			int i;
			long startTime = System.currentTimeMillis();
			while((i = br.read()) != -1){
				bw.write(i);
			}
			long endTime = System.currentTimeMillis();
			br.close();
			bw.close();
			fr.close();
			fw.close();
			System.out.println("BufferedStream runTime is:" + (endTime - startTime) + "ms");
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
}
