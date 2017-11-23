package com.imooc;

 class helloworld {

	public static void main(String[] args) {
		float a = 0.1f;
		double b = 0.1d;
		char c='i';
		String s="tangtang545";
		String x="hello world!";
		byte buf[]=new byte[50];
		String str;
		double r=1;
		// TODO Auto-generated method stub
		System.out.println("a="+a+" b="+b+" "+c+" "+s+" "+x+" input the string:");
		try{
			System.in.read(buf);
			str=new String(buf,0);
			r=Double.parseDouble(str.trim());
		}
		catch(Exception e){}
		System.out.println(r);
		
	}

}
