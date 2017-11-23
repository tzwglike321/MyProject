package fjnu;

import java.util.Collections;
import java.util.Comparator;


public class FileInformation implements Comparable<FileInformation>{//获取文件信息的对象
	String name;//文件/文件名
	String date;//修改时间
	long length = 0;//文件大小
	
	public void setFile(String name,String date,long length){
		this.name = name;
		this.date = date;
		this.length = length;
	}
	
	public void setFolder(String name,String date){
		this.name = name;
		this.date = date;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public long getLength(){
		return this.length;
	}
	
	public int compareTo(FileInformation f){//重构比较函数
		if(this.getName().compareTo(f.getName()) > 0){
			return 1;
		}
		else if(this.getName().compareTo(f.getName()) < 0){
			return -1;
		}
		else{
			return 0;
		}
	}
}
