package edu.fjnu.cs;

public class ToGradeScore {
	public void toGradeScore(int []arr){
		for(int i = 0;i < arr.length;i++){
			if(arr[i] >= 90 && arr[i] <= 100){
				System.out.println(arr[i]+"����");
			}//
			else if(arr[i] >= 80 && arr[i] < 90){
				System.out.println(arr[i]+"����");
			}
			else if(arr[i] >= 70 && arr[i] < 80){
				System.out.println(arr[i]+"����");
			}
			else if(arr[i] >= 60 && arr[i] < 70){
				System.out.println(arr[i]+"�Ǽ���");
			}
			else if(arr[i] >= 0 && arr[i] < 60){
				System.out.println(arr[i]+"�ǲ�����");
			}
			else{
				System.out.println(arr[i]+"�ɼ����벻�淶��");
			}
		}
		return ;
	}
	public static void main(String []args){
		int []arr1 = new int[]{15,60,81,70,35,55,90,100,101,92,69,79,89,59};
		ToGradeScore t = new ToGradeScore();
		t.toGradeScore(arr1);
	}
}
