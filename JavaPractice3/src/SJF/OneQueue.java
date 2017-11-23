package SJF;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;  
import java.util.Comparator;

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
	
	public void showQueue(){
		DecimalFormat df = new DecimalFormat( "0.00");
		System.out.println("taskID"+" "+"开始时间"+" "+"服务时间"+" "+"完成时间"+" "+"周转时间"+" "+"带权周转时间");
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


