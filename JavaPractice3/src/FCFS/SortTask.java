package FCFS;

import java.util.Collections;
import java.util.Comparator;

public class SortTask implements Comparable<SortTask>{
	int taskID; //任务ID
	int arrivalTime;//到达时间
	int serviceTime;//服务时间
	int  startingTime;//开始时间
	int finishingTime;//完成时间=开始时间+服务时间
	int turnAroundTime;//周转时间=完成时间-达到时间
	double weightTurnAround;//带权周转时间=周转时间/服务时间 
	
	public void setValue(int taskID,int arrivalTime,int serviceTime,int  startingTime,int finishingTime,int turnAroundTime,double weightTurnAround){
		this.taskID = taskID;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.startingTime = startingTime;
		this.finishingTime = finishingTime;
		this.turnAroundTime = turnAroundTime;
		this.weightTurnAround = weightTurnAround;
	}
	
	public int getTaskID(){
		return this.taskID;
	}
	
	public int getArrivalTime(){
		return this.arrivalTime;
	}
	
	public int getServiceTime(){
		return this.serviceTime;
	}
	public int getStartTime(){
		return this.startingTime;
	}
	
	public int getFinishTime(){
		return this.finishingTime;
	}
	
	public int getTurnAriundTime(){
		return this.turnAroundTime;
	}
	
	public double getWeightTurnAround(){
		return this.weightTurnAround;
	}
	
	public int compareTo(SortTask st){
		if(this.taskID > st.taskID){
			return 1;
		}
		else if(this.taskID < st.taskID){
			return -1;
		}
		else{
			return 0;
		}
	}
}
