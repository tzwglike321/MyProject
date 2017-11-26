package fjnu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InflateStudent {
	public void falateStudent(){
		try{//student对象反序列化
			String filename = "student.bin";
			FileInputStream finS = new FileInputStream(filename);
			ObjectInputStream objIS = new ObjectInputStream(finS);
			Student student = new Student();
			while((student = (Student) objIS.readObject()) != null){
				System.out.println(student.getStudentID() + " " + student.getName() + " " + student.getSex());
			}
			objIS.close();
			finS.close();
		}catch(Exception e3){
			e3.printStackTrace();
		}
	}
}
