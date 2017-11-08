package FCFS;

public class Task {
	int taskID; //����ID
	int arrivalTime;//����ʱ��
	int serviceTime;//����ʱ��
	int  startingTime;//��ʼʱ��
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
}
