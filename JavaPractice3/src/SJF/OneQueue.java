package SJF;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;  
import java.util.Comparator;

public class OneQueue {
	int [][]getTask;//��ȡ�ļ�����������Ϣ
	InOutFile file1;
	ArrayList<Task> list1 = new ArrayList<Task>();
	
	public void listAdd(){//arraylist��ȡtask����
		file1 = new InOutFile();
		if(!file1.fileExist())
			file1.writeFile();
		getTask = file1.readFile();
		for(int i = 0;i < getTask.length;i++)
		{
			Task tmp = new Task();
			tmp.setTask(getTask[i][0], getTask[i][1], getTask[i][2]);
			list1.add(tmp);
		}
			
	}
	
	public void beginQueue(){
		for(int i = 0;i < list1.size();i++){
			Task tmp = new Task();
			if(i == 0){
				tmp = list1.get(i);
				tmp.calculateTime(0);
			}
			else{
				int right = (int)list1.get(i - 1).finishingTime + 1;//��ǰһ�����ʱ����Ϊȡ�ѵ���������ұ߽�
				if(right > list1.size()) right = list1.size();//�ұ߽����list1��С��ȡlist1��С
				Collections.sort(list1.subList(i, right));//��ȡsublist��serviceTime��С��������ʵ���Ͼ��Ƕ�list1��Ӧ���ֽ��в���
				tmp = list1.get(i);
				tmp.calculateTime(list1.get(i - 1).finishingTime);
			}
			list1.set(i, tmp);//����task����
		}
	}
	
	public void showQueue(){
		DecimalFormat df = new DecimalFormat( "0.00");
		System.out.println("taskID"+" "+"��ʼʱ��"+" "+"����ʱ��"+" "+"���ʱ��"+" "+"��תʱ��"+" "+"��Ȩ��תʱ��");
		for(int i = 0;i < list1.size();i++){
			Task tmp = new Task();
			tmp = list1.get(i);
			System.out.println(tmp.taskID+"	"  
					   +tmp.startingTime+"   "
					   +tmp.serviceTime+"	"
					   +tmp.finishingTime+"	"
					   +tmp.turnAroundTime+"    "
					   +df.format(tmp.weightTurnAround));
		}
	}
	
	/*public static void main(String []args){
		OneQueue test = new OneQueue();
		test.listAdd();
		test.beginQueue();
		test.showQueue();
	}*/
}

