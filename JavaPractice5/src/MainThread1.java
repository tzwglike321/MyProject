
public class MainThread1 implements Runnable{
	private String name;
	public MainThread1(String name){
		this.name=name;
	}
	public static void main(String[] args) {
		
		Thread thread1=new Thread(new MainThread1("进程1"));
		Thread thread2=new Thread(new MainThread1("进程2"));
		thread1.start();
		thread2.start();

 
	}
	@Override
	public void run() {
		ChocolateBoiler.getInstance().chocolatename(name);
		
	}
}
