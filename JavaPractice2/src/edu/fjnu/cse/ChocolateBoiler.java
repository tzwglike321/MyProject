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
			System.out.println("����ɿ�����ţ��");
			empty = false;
		}
		else {
			System.out.println("��¯���ˣ��޷����");
		}
	}
	
	public void boil(){
		if(isEmpty() == false && isBoiled() == false){
			System.out.println("�Ѿ����");
			boiled = true;
		}
		else{
			System.out.println("��¯δ����δ���");
		}
	}
	
	public void drain(){
		if(isEmpty() == false && isBoiled() == true){
			System.out.println("�ų������");
			empty = true;
			boiled = false;
		}
		else{
			System.out.println("��¯δ����δ��У���ǰ�޷��ų������");
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
