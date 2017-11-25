package FCFS;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.*;

public class OneQueue {
	int [][]getTask;//获取文件里面任务信息
	InOutFile file1;
	ArrayList<Task> list1 = new ArrayList<Task>();
	
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
			Task tmp = list1.get(i);
			if(i == 0) tmp.calculateTime(0);//根据开始时间，计算其它时间
			else tmp.calculateTime(list1.get(i - 1).finishingTime);
			list1.set(i, tmp);//更新task对象
//			System.out.println(tmp.startingTime+" "+tmp.serviceTime+" "+tmp.finishingTime+" "+tmp.turnAroundTime+" "+tmp.weightTurnAround);
		}
	}
	
	public void showQueue(){
		//DecimalFormat df = new DecimalFormat( "0.00");
		File FCFS_Data = new File("FCFS_One_Queue.txt");
		try{
			FileWriter fw = new FileWriter(FCFS_Data);
			String str = "\t\t\t\t\tFCFS One Queue";
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
			for(int i = 0;i < list1.size();i++){
				Task tmp = new Task();
				tmp = list1.get(i);
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
	
	/*public static void main(String []args){
		OneQueue test = new OneQueue();
		test.listAdd();
		test.beginQueue();
		test.showQueue();
	}*/
}
