package FCFS;

public class Task {
	int taskID; //任务ID
	int arrivalTime;//到达时间
	int serviceTime;//服务时间
	int  startingTime;//开始时间
	int finishingTime;//完成时间=开始时间+服务时间
	int turnAroundTime;//周转时间=完成时间-达到时间
	double weightTurnAround;//带权周转时间=周转时间/服务时间 
	
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
}
