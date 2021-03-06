package fjnu;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class Student implements  Comparable<Student>, Serializable {
	private long studentID = 0;
	private String name = null;
	private String sex = null;
	
	public void setStudentID(long studentID){
		this.studentID = studentID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public long getStudentID(){
		return this.studentID;
	}
	public String getName(){
		return this.name;
	}
	
	public String getSex(){
		return this.sex;
	}
	
	public int compareTo(Student s){
		if (this.studentID > s.getStudentID()){
			return 1;
		}
		else if(this.studentID < s.getStudentID()){
			return -1;
		}
		else{
			return 0;
		}
	}
}
