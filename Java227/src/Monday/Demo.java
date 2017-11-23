package Monday;
class People{
	void work(String s){
		System.out.println("父类方法work()"+s);
	}
}
class Student extends People{
	void Work(String s){
		//System.out.println("子类方法work()"+s);
		super.work("子类方法work()"+s);
	}
}
class Teachers extends People{
	
}
public class Demo {
	public static void main(String []ar){
		Student s=new Student();
		Teachers t=new Teachers();
		s.work("学JAVA");
		t.work("教Java");
	}
}
