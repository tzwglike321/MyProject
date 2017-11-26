package fjnu;

import java.io.*;
import java.util.*;

public class FlattenStudent {
	public void flattenStudent(){
		File file = new File("list.txt");
		ArrayList<Student> List = new ArrayList<Student>();
		try{
			/*FileReader filR = new FileReader(file);
			BufferedReader bufR = new BufferedReader(filR);
			String str;
			while((str = bufR.readLine()) != null){
				String []tmp = str.split(" ");
				Student student = new Student();
				student.setStudentID(Long.parseLong(tmp[0]));
				student.setName(tmp[1]);
				student.setSex(tmp[2]);
				List.add(student);
			}
			bufR.close();
			filR.close();*/
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				long idTmp = sc.nextLong();
				String nameTmp = sc.next();
				String sexTmp = sc.next();
				Student student = new Student();
				student.setStudentID(idTmp);
				student.setName(nameTmp);
				student.setSex(sexTmp);
				List.add(student);
			}
			sc.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		Collections.sort(List);
		/*int j = 0;
		for(int i = 0;i < List.size();i++){
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
		try{//student对象序列化
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
	}
}
