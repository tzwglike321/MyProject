package fjnu;

import java.io.*;
import java.util.*;

public class FlattenStudent {
	public static void main(String []args){
		File file = new File("list.txt");
		ArrayList<Student> List = new ArrayList<Student>();
		try{
			//FileInputStream finS = new FileInputStream(file);
			//DataInputStream inDataFile = new DataInputStream(finS);
			//inDataFile.rea
			FileReader filR = new FileReader(file);
			BufferedReader bufR = new BufferedReader(filR);
			String str;
			while((str = bufR.readLine()) != null){
				String []tmp = str.split(" ");
				//int i = 0;
				/*for(String a:tmp){
					i++;
					System.out.print(a+" ");
					if(i == 3){
						System.out.print("\n");
						i = 0;
					}
					
				}*/
				Student student = new Student();
				student.setStudentID(Long.parseLong(tmp[0]));
				student.setName(tmp[1]);
				student.setSex(tmp[2]);
				List.add(student);
			}
			bufR.close();
			filR.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		Collections.sort(List);
		int j = 0;
		/*for(int i = 0;i < List.size();i++){
			Student tmp = new Student();
			tmp = List.get(i);
			System.out.print(tmp.getStudentID()+" ");
			j++;
			System.out.print(tmp.getName()+" ");
			j++;
			System.out.print(tmp.getSex()+" ");
			j++;
			if(j == 3){
				System.out.print("\n");
				j = 0;
			}
		}*/
		//
		try{
			String filename = "student.bin";
			FileOutputStream fouS = new FileOutputStream(filename);
			ObjectOutputStream objOS = new ObjectOutputStream(fouS);
			for(int i = 0;i < List.size();i++){
				Student tmp = new Student();
				tmp = List.get(i);
				objOS.writeObject(tmp);
			}
			objOS.writeObject(null);
			objOS.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
		//
		try{
			String filename = "student.bin";
			FileInputStream finS = new FileInputStream(filename);
			ObjectInputStream objIS = new ObjectInputStream(finS);
			Student student = new Student();
			while((student = (Student) objIS.readObject()) != null){
				//student = (Student) objIS.readObject();
				System.out.println(student.getStudentID() + " " + student.getName() + " " + student.getSex());
			}
			objIS.close();
			finS.close();
		}catch(Exception e3){
			e3.printStackTrace();
		}
	}
}