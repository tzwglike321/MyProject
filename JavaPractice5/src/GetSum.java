
public class GetSum {
	private Thread thread1;
	private Thread thread2;
	private Thread thread3;
	private Thread thread4;
	private int sum1=0;
	private int sum2=0;
	private int sum3=0;
	private int sum4=0;

	public GetSum(){
		thread1=new Thread(new Runnable(){
				@Override
			public void run() {
				synchronized(this){
					try{
						Thread.sleep(100);
						thread2.join();
						for(int i=76;i<=100;i++){
							sum4+=i;
						}
						System.out.println("第四个执行的进程:"+sum4);
						System.out.println("最后的求和结果是:"+(sum1+sum2+sum3+sum4));
					}catch(Exception e){
						e.printStackTrace();
					}
				}			
			}	
		});
		thread1.start();
		thread2=new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized(this){
					try{
						Thread.sleep(100);
						thread3.join();
						for(int i=51;i<=75;i++){
							sum3+=i;
						}
						System.out.println("第三个执行的进程:"+sum3);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}	
		});
		thread2.start();		
		thread3=new Thread(new Runnable(){
			@Override
			public void run() {				
				synchronized(this){
					try{
						Thread.sleep(100);
						thread4.join();
						for(int i=26;i<=50;i++){
							sum2+=i;
						}
						System.out.println("第二个执行的进程:"+sum2);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			
			}
		});
		thread3.start();
		thread4=new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized(this){
					try{
						Thread.sleep(100);
						for(int i=1;i<=25;i++){
							sum1+=i;
						}
						System.out.println("第一个执行的进程:"+sum1);

					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		thread4.start();							
	}
}
