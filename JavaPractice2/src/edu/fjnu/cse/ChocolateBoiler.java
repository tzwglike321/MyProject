package edu.fjnu.cse;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler instance;
	
	private ChocolateBoiler(){
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance(){
		if(instance == null){
			instance = new ChocolateBoiler();
		}
		return instance;
	}
	
	public void fill(){
		if(isEmpty()){
			System.out.println("填充巧克力和牛奶");
			empty = false;
		}
		else {
			System.out.println("锅炉满了，无法填充");
		}
	}
	
	public void boil(){
		if(isEmpty() == false && isBoiled() == false){
			System.out.println("已经煮沸");
			boiled = true;
		}
		else{
			System.out.println("锅炉未满或未煮沸");
		}
	}
	
	public void drain(){
		if(isEmpty() == false && isBoiled() == true){
			System.out.println("排出混合物");
			empty = true;
			boiled = false;
		}
		else{
			System.out.println("锅炉未满或未煮沸，当前无法排出混合物");
		}
	}
	
	private boolean isEmpty(){
		if(empty == true){
			return true;
		}
		else{
			return  false;
		}
	}
	
	private boolean isBoiled(){
		if(boiled == true){
			return true;
		}
		else{
			return false;
		}
	}
		
}
