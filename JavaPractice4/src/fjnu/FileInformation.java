package fjnu;

import java.util.Collections;
import java.util.Comparator;
import java.text.Collator;
import java.util.Locale;

public class FileInformation implements Comparable<FileInformation>{//存储文件/文件夹信息的类
	String name;//名称
	String date;//修改日期
	long length = 0;//大小
	
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
	
	public int compareTo(FileInformation f){//重载比较函数为以name进行比较排序
		/*if(this.getName().compareTo(f.getName()) > 0){
			return 1;
		}
		else if(this.getName().compareTo(f.getName()) < 0){
			return -1;
		}
		else{
			return 0;
		}*/
		Collator instance = Collator.getInstance(Locale.CHINA);
		return instance.compare(this.name,f.name);//按中文字符进行排序
		 
	}
}
