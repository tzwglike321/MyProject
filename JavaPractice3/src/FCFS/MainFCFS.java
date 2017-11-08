package FCFS;

public class MainFCFS {
	public static void main(String []args){
		OneQueue queue1 = new OneQueue();
		queue1.listAdd();
		queue1.beginQueue();
		queue1.showQueue();
		TwoQueue queue2 = new TwoQueue();
		queue2.listAdd();
		queue2.beginTwoQueue();
		queue2.showQueue();
	}
}
