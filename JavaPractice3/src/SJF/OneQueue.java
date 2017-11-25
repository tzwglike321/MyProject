package SJF;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import FCFS.SortTask;

public class OneQueue {
	int [][]getTask;//获取文件里面任务信息
	InOutFile file1;
	ArrayList<Task> list1 = new ArrayList<Task>();
	ArrayList<SortTask> list2 = new ArrayList<SortTask>();
	
	public void listAdd(){//arraylist获取task队列
		file1 = new InOutFile();
		/*if(!file1.fileExist())
			file1.writeFile();*/
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
				int right = (int)list1.get(i - 1).finishingTime + 1;//将前一个完成时间作为取已到达任务的右边界
				if(right > list1.size()) right = list1.size();//右边界大于list1大小则取list1大小
				Collections.sort(list1.subList(i, right));//截取sublist按serviceTime大小进行排序，实际上就是对list1相应部分进行操作
				tmp = list1.get(i);
				tmp.calculateTime(list1.get(i - 1).finishingTime);
			}
			list1.set(i, tmp);//更新task对象
		}
	}
	
	public void SortOneQueue(){
		for(int i = 0;i < list1.size();i++){
			SortTask st = new SortTask();
			Task t = list1.get(i);
			st.setValue(t.getTaskID(), t.getArrivalTime(), t.getServiceTime(), t.getStartTime(), t.getFinishTime(), t.getTurnAriundTime(), t.getWeightTurnAround());
			list2.add(st);
		}
		Collections.sort(list2);
	}
	
	public void showQueue(){
		//DecimalFormat df = new DecimalFormat( "0.00");
		File SJF_Data = new File("SJF_One_Queue.txt");
		try{
			FileWriter fw = new FileWriter(SJF_Data);
			String str = "\t\t\t\t\tSJF One Queue";
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
			for(int i = 0;i < list2.size();i++){
				SortTask tmp = new SortTask();
				tmp = list2.get(i);
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
		OneQueue test = new OneQueue();
		test.listAdd();
		test.beginQueue();
		test.SortOneQueue();
		test.showQueue();
	}
}


