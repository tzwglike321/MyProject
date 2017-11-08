package FCFS;

import java.util.ArrayList;
import java.text.DecimalFormat; 

public class TwoQueue {
	int [][]getTask;//获取文件里面任务信息
	InOutFile file1;
	ArrayList<Task> list = new ArrayList<Task>();
	ArrayList<Task> list1 = new ArrayList<Task>();
	ArrayList<Task> list2 = new ArrayList<Task>();
	
	public void listAdd(){//list获取task队列
		file1 = new InOutFile();
		if(!file1.fileExist())
			file1.writeFile();
		getTask = file1.readFile();
		for(int i = 0;i < getTask.length;i++)
		{
			Task tmp = new Task();
			tmp.setTask(getTask[i][0], getTask[i][1], getTask[i][2]);
			list.add(tmp);
		}
			
	}
	
	public void beginTwoQueue(){
		int i = 0;
		int numOfList = 0;
		int tmpTime1 = 0;//保存当前完成时间作为下一个的开始时间
		int tmpTime2 = 0;//保存当前完成时间作为下一个的开始时间
		int lastOfLis1 = 0;
		int lastOfLis2 = 0;
		do{
			if(i == 0){
				list1.add(list.get(numOfList));//0
				numOfList++;//1
				list2.add(list.get(numOfList));

				Task tmp1 = new Task();
				tmp1 = list1.get(i);
				tmp1.calculateTime(0);
				list1.set(i, tmp1);//list1添加第一个task对象
				
				Task tmp2 = new Task();
				tmp2 = list2.get(i);
				tmp2.calculateTime(1);
				list2.set(i, tmp2);//list2添加第一个task对象
				if(list1.get(i).finishingTime < list2.get(i).finishingTime){//比较finshTime,谁小就添加一个新的task对象
					numOfList++;//2
					list1.add(list.get(numOfList));
					tmpTime1 = list1.get(i).finishingTime;//获取当前队列上一个finishTime作为新添加对象的startTime
					//
					lastOfLis1 = list1.size() -1;
					Task tmp = new Task();
					tmp = list1.get(lastOfLis1);
					tmp.calculateTime(tmpTime1);
					list1.set(lastOfLis1, tmp);
				}
				else {
					numOfList++;//2
					list2.add(list.get(numOfList));
					tmpTime2 = list2.get(i).finishingTime;
					//
					lastOfLis2 = list2.size() -1;
					Task tmp = new Task();
					tmp = list2.get(lastOfLis2);
					tmp.calculateTime(tmpTime2);
					list2.set(lastOfLis2, tmp);
				}
			}
			i++;
			lastOfLis1 = list1.size() - 1;
			lastOfLis2 = list2.size() - 1;
			if(list1.get(lastOfLis1).finishingTime < list2.get(lastOfLis2).finishingTime){
				tmpTime1 = list1.get(lastOfLis1).finishingTime;
				numOfList++;
				//
				list1.add(list.get(numOfList));
				lastOfLis1 = list1.size() -1;
				Task tmp = new Task();
				tmp = list1.get(lastOfLis1);
				tmp.calculateTime(tmpTime1);
				list1.set(lastOfLis1, tmp);
				
			}
			else{
				tmpTime2 = list2.get(lastOfLis2).finishingTime;
				numOfList++;
				list2.add(list.get(numOfList));
				//
				lastOfLis2 = list2.size() -1;
				Task tmp = new Task();
				tmp = list2.get(lastOfLis2);
				tmp.calculateTime(tmpTime2);
				list2.set(lastOfLis2, tmp);
			}
			
		}while((list1.size() + list2.size()) < 100);
	}
	
	public void showQueue(){
		DecimalFormat df = new DecimalFormat( "0.00");
		System.out.println("分队列1"+" "+"开始时间"+" "+"服务时间"+" "+"完成时间"+" "+"周转时间"+" "+"带权周转时间");
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
		System.out.println("分队列2"+" "+"开始时间"+" "+"服务时间"+" "+"完成时间"+" "+"周转时间"+" "+"带权周转时间");
		for(int j = 0;j < list2.size();j++){
			Task tmp = new Task();
			tmp = list2.get(j);
			System.out.println(tmp.taskID+"	"  
					   +tmp.startingTime+"   "
					   +tmp.serviceTime+"	"
					   +tmp.finishingTime+"	"
					   +tmp.turnAroundTime+"    "
					   +df.format(tmp.weightTurnAround));
		}
	}
	
	/*public static void main(String []args){
		TwoQueue test = new TwoQueue();
		test.listAdd();
		test.beginTwoQueue();
		test.showQueue();
	}*/
}
