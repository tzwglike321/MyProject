package edu.fjnu.cse;

public class Test {
	public static void main(String []args){
		ChocolateBoiler cho1 = ChocolateBoiler.getInstance();
		cho1.fill();
		cho1.boil();
		ChocolateBoiler cho2 = ChocolateBoiler.getInstance();
		cho2.fill();
		cho2.boil();
		cho1.drain();
	}
}
