package Monday;

interface Formater {
	void formater(String s);//�ӿڵĶ���
}/*
class Factory{
	static Formater getConnection(){
		return new PerformData();
	}
}
class PerformData implements Formater{
	public void formater(){
		System.out.println("����PerformData����ĸ�ʽ");//�ӿڵ�ʵ��
	}
}
public class inputData{
	public void intpur(Formater s){
		s.formater();
	}
	public static void main(String[] args){
		inputData i=new inputData();
		Formater s=Factory.getConnection();
		i.intpur(s);
	}
}*/
class OutData implements Formater{
	public void formater(String s){
	 System.out.println("����ʵ���˽ӿڷ���"+this.getClass().getName()+s);
	}
}
class Stu extends OutData{
	String name;
	int cla;
	void setStu(String n,int c){name=n;cla=c;}
	//int getCla(){return cla;}
	//String getName(){return name;}
}
class Tea extends OutData{
	String name;
	int cla;
}
public class inputData{
	public static void main(String[] args){
		Stu s=new Stu();
		Tea t=new Tea();
		s.formater("ѧJAVA");t.formater("��JAVA");
	}
}
