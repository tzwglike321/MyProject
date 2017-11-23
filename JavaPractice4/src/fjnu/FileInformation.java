package fjnu;

import java.util.Collections;
import java.util.Comparator;
import java.text.Collator;
import java.util.Locale;

public class FileInformation implements Comparable<FileInformation>{//��ȡ�ļ���Ϣ�Ķ���
	String name;//�ļ�/�ļ���
	String date;//�޸�ʱ��
	long length = 0;//�ļ���С
	
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
	
	public int compareTo(FileInformation f){//�ع��ȽϺ���
		if(this.getName().compareTo(f.getName()) > 0){
			return 1;
		}
		else if(this.getName().compareTo(f.getName()) < 0){
			return -1;
		}
		else{
			return 0;
		}
		/*Collator instance = Collator.getInstance(Locale.CHINA);
		return instance.compare(this.name,f.name);
		 * 
		 */
	}
}
