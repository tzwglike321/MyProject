package eee;

public class qwqe {
	public static void main(String[] args)
	{
		byte buf[]=new byte[50];
		double n=1;
		String str;
		try{
			System.in.read(buf);
			str=new String(buf,0);
			n=Double.parseDouble(str.trim());
		}
		catch(Exception e){}
		if(n>0) System.out.println(+n+" >0"+" is +;");
		else{
			if(n<0) System.out.println(+n+" <0"+" is -;");
			else
				System.out.println(+n+" =0"+" is 0;");
		}
	}

}
