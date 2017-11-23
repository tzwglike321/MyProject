package fjnu;

import java.io.*;

public class TestTime {
	public static void main(String []args){
		
		File file = new File("list.txt");
		try{
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
		
		try{
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
