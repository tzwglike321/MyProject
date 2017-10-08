package edu.fjnu.cs;

public class LeapYear {
	public static void main(String []args){
		int j = 0;
		for(int i = 1990;i <= 2007;i++){
			if(i % 4 == 0&& i % 100 != 0){
				System.out.print(i+"  ");
				j++;
			}
			else if(i % 400 == 0){
				System.out.print(i+"  ");
				j++;
			}
			if(j == 2){
				System.out.print("\n");
				j = 0;
			}
		}
	}
}
