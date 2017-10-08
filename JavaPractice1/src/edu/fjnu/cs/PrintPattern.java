package edu.fjnu.cs;

public class PrintPattern {
	public void printPattern(int num){
		int k = (num + 1) / 2;
		int z = num / 2;
		for(int i = 0;i < k;i++){
			for(int j = 0;j < z;j++){
				System.out.print(" ");
			}
			z--;
			for(int l = 0;l < (2 * (i + 1) - 1);l++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
		z = 1;
		for(int i = num - k;i >= 1;i--){
			for(int j =0;j < z;j++){
				System.out.print(" ");
			}
			z++;
			for(int l = 0;l < (2 * i - 1);l++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
	}
	public static void main(String []args){
		int n = 7;
		PrintPattern p = new PrintPattern();
		p.printPattern(n);
	}
}
