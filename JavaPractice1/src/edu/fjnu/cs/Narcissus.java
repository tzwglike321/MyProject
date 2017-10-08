package edu.fjnu.cs;

public class Narcissus {
	public static void main(String []args){
		for(int i = 100;i < 1000;i++){
			int x = i / 100;
			int y = (i - x * 100) / 10;
			int z = i - x * 100 - y * 10;
			double sum = Math.pow(x,3) + Math.pow(y,3) + Math.pow(z,3);
			if(sum == i){
				System.out.println(i);
			}
		}
	}
}
