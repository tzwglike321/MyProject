package Monday;
class People{
	void work(String s){
		System.out.println("���෽��work()"+s);
	}
}
class Student extends People{
	void Work(String s){
		//System.out.println("���෽��work()"+s);
		super.work("���෽��work()"+s);
	}
}
class Teachers extends People{
	
}
public class Demo {
	public static void main(String []ar){
		Student s=new Student();
		Teachers t=new Teachers();
		s.work("ѧJAVA");
		t.work("��Java");
	}
}
