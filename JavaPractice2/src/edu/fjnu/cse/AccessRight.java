package edu.fjnu.cse;

public class AccessRight {
	public int pu;
	private int pr;
	protected int po;
	int de;
	
	AccessRight(int a,int b,int c,int d){
		pu = a;
		pr = b;
		po = c;
		de = d;
	}
	
	public int getPub(){
		return pu;
	}
	
	private int getPri(){
		return pr;
	}
	
	protected int getPro(){
		return po;
	}
	
	int getDef(){
		return de;
	}
	
	public static void main(String []args){
		int a = 1,b= 2,c = 3,d = 4;
		AccessRight arr = new AccessRight(a,b,c,d);
		int p1,p2,p3,p4;
		p1 = arr.getPub();
		System.out.println(p1);
		p2 = arr.getPri();
		System.out.println(p2);
		p3 = arr.getPro();
		System.out.println(p3);
		p4 = arr.getDef();
		System.out.println(p4);
	}
}
