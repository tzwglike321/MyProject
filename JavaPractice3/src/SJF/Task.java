package SJF;
import java.util.Collections;
import java.util.Comparator;

public class Task<Int> implements Comparable<Task>{
	int taskID; //����ID
	int arrivalTime;//����ʱ��
	int serviceTime;//����ʱ��
	int startingTime;//��ʼʱ��
	int finishingTime;//���ʱ��=��ʼʱ��+����ʱ��
	int turnAroundTime;//��תʱ��=���ʱ��-�ﵽʱ��
	double weightTurnAround;//��Ȩ��תʱ��=��תʱ��/����ʱ�� 
	
	public void setTask(int taskID,int arrivalTime,int serviceTime){
		this.taskID = taskID;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}
	
	public void calculateTime(int staTime){
		startingTime = staTime;
		finishingTime = startingTime + serviceTime;
		turnAroundTime = finishingTime -arrivalTime;
		weightTurnAround = turnAroundTime * 1.0 / serviceTime;
	}
	
	public int compareTo(Task t){
//		return this.getTime().compareTo(t.getTime());
		if(this.serviceTime > t.serviceTime) {
	    	  return 1;
	    }
	    else if (this.serviceTime < t.serviceTime) {
			 return -1;
		}
		else
			 return 0;
	}
}
