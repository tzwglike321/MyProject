package SJF;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import FCFS.SortTask;

public class TwoQueue {
	int [][]getTask;//获取文件里面任务信息
	InOutFile file1;
	ArrayList<Task> list = new ArrayList<Task>();
	ArrayList<Task> list1 = new ArrayList<Task>();//
	ArrayList<Task> list2 = new ArrayList<Task>();
	ArrayList<SortTask> list3 = new ArrayList<SortTask>();
	
	public void listAdd(){//list获取task队列
		file1 = new InOutFile();
		/*if(!file1.fileExist())
			file1.writeFile();*/
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
			}
			i++;
			if(list1.get(lastOfLis1).finishingTime < list2.get(lastOfLis2).finishingTime){
				tmpTime1 = list1.get(lastOfLis1).finishingTime;//临时存储当前队列最后一个作为等下新添加的Task的开始时间
				numOfList++;//3
				
				int right = (int)list.get(numOfList).finishingTime + 1;//获取右边界
				if(right > list.size()) right = list.size();//右边界大于list大小则取list大小
				if(right < numOfList) right = numOfList;
				Collections.sort(list.subList(numOfList, right));//numOfList - right短作业排序
				
				list1.add(list.get(numOfList));
				lastOfLis1 = list1.size() - 1;
				Task tmp = new Task();
				tmp = list1.get(lastOfLis1);
				tmp.calculateTime(tmpTime1);
				list1.set(lastOfLis1, tmp);
			}
			else{
				tmpTime2 = list2.get(lastOfLis2).finishingTime;
				numOfList++;//3
				
				int right = (int)list.get(numOfList).finishingTime + 1;//获取右边界
				if(right > list.size()) right = list.size();//右边界大于list大小则取list大小
				if(right < numOfList) right = numOfList;
				Collections.sort(list.subList(numOfList, right));//numOfList - right短作业排序
				
				list2.add(list.get(numOfList));
				lastOfLis2 = list2.size() -1;
				Task tmp = new Task();
				tmp = list2.get(lastOfLis2);
				tmp.calculateTime(tmpTime2);
				list2.set(lastOfLis2, tmp);
			}
			
		}while((list1.size() + list2.size()) < 100);
	}
	public void sortTwoQueue(){
		for(int i = 0;i < list1.size();i++){
			SortTask st = new SortTask();
			Task t=  list1.get(i);
			st.setValue(t.getTaskID(), t.getArrivalTime(), t.getServiceTime(), t.getStartTime(), t.getFinishTime(), t.getTurnAriundTime(), t.getWeightTurnAround());
			list3.add(st);
		}
		for(int j = 0;j < list2.size();j++){
			SortTask st = new SortTask();
			Task t=  list2.get(j);
			st.setValue(t.getTaskID(), t.getArrivalTime(), t.getServiceTime(), t.getStartTime(), t.getFinishTime(), t.getTurnAriundTime(), t.getWeightTurnAround());
			list3.add(st);
		}
		Collections.sort(list3);
	}
	
	public void showQueue(){
		/*DecimalFormat df = new DecimalFormat( "0.00");
		System.out.println("分队列1"+"\t\t"+"开始时间"+"\t\t"+"服务时间"+"\t\t"+"完成时间"+"\t\t"+"周转时间"+"\t\t"+"带权周转时间");
		for(int i = 0;i < list1.size();i++){
			Task tmp = new Task();
			tmp = list1.get(i);
			System.out.println(tmp.taskID+"\t\t"  
					   +tmp.startingTime+"\t\t"
					   +tmp.serviceTime+"\t\t"
					   +tmp.finishingTime+"\t\t"
					   +tmp.turnAroundTime+"\t\t"
					   +df.format(tmp.weightTurnAround));
		}
		System.out.println("分队列2"+"\t\t"+"开始时间"+"\t\t"+"服务时间"+"\t\t"+"完成时间"+"\t\t"+"周转时间"+"\t\t"+"带权周转时间");
		for(int j = 0;j < list2.size();j++){
			Task tmp = new Task();
			tmp = list2.get(j);
			System.out.println(tmp.taskID+"\t\t"  
					   +tmp.startingTime+"\t\t"
					   +tmp.serviceTime+"\t\t"
					   +tmp.finishingTime+"\t\t"
					   +tmp.turnAroundTime+"\t\t"
					   +df.format(tmp.weightTurnAround));
		}*/
		File SJF_Data = new File("SJF_Two_Queue.txt");
		try{
			FileWriter fw = new FileWriter(SJF_Data);
			String str = "\t\t\t\t\tSJF Two Queue";
			System.out.println(str);
			fw.write(str+"\r\n");
			String str1 ="TaskID"+"\t\t"
					+"到达时间"+"\t\t"
					+"服务时间"+"\t\t"
					+"开始时间"+"\t\t"
					+"完成时间"+"\t\t"
					+"周转时间"+"\t\t"+"带权周转时间";
			System.out.println(str1);
			fw.write(str1+"\r\n");
			for(int k = 0;k < list3.size();k++){
				SortTask tmp = new SortTask();
				tmp = list3.get(k);
				String str2 =tmp.getTaskID()+"\t\t"+tmp.getArrivalTime()+"\t\t"
						   +tmp.getServiceTime()+"\t\t"
						   +tmp.getStartTime()+"\t\t"
						   +tmp.getFinishTime()+"\t\t"
						   +tmp.getTurnAriundTime()+"\t\t"
						   +tmp.getWeightTurnAround();
				System.out.println(str2);
				fw.write(str2+"\r\n");
			}
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String []args){
		TwoQueue test = new TwoQueue();
		test.listAdd();
		test.beginTwoQueue();
		test.sortTwoQueue();
		test.showQueue();
	}
}