package Bpnn;
import java.util.Random;
import java.lang.Math;

public class BpAlgorithm {
	
	static double input[];//样本数据1
	static int A[];
	static int B[];
	static int C[];
	static double w[][];//网络连接权重
	static double bias[];//神经元偏置
	static double S[];//总输入
	static double O[];//单元输出
	static double E[];//误差
	
	public BpAlgorithm(int a,int b,int c){
		
		A = new int[a];
		B = new int[b];
		C = new int[c];
		w = new double[a + b + c + 1][a + b + c + 1];
		bias = new double[a + b + c + 1];
		S = new double[a + b + c + 1];
		O = new double[a + b + c + 1];
		E = new double[a + b + c + 1];
		int j = 1;
		for(int i = 0;i < a;i++){
			A[i] = j++;
		}
		for(int i = 0;i < b;i++){
			B[i] = j++;
		}
		for(int i = 0;i < c;i++){
			C[i] = j++;
		}
	}
	public int getNumOfA(){
		return A.length;
	}
	public int getNumOfB(){
		return B.length;
	}
	public int getNumOfC(){
		return C.length;
	}
	public  void countSAndO(){//计算总输入和输出
		int a = getNumOfA();
		int b = getNumOfB();
		int c = getNumOfC();
		double sum = 0;
		for(int j = a + 1;j <= a + b;j++){//计算第二层总输入
			sum = 0;
			for(int i = 1;i <= a;i++){
				sum+= w[i][j] * O[i];
				S[j] = sum;
				if(i == a){
					S[j]+=bias[j];
				}
			}
			O[j] = 1/(1 + Math.exp(-1 * S[j]));
		}	
		sum = 0;
		for(int j = a + b + 1;j <= a + b + c;j++){//计算第三层总输入
			sum = 0;
			for(int i = a + 1;i <= a + b;i++){
				sum+= w[i][j] * O[i];
				S[j] = sum;
				if(i == a + b){
					S[j]+=bias[j];
				}
			}
			O[j] = 1/(1 + Math.exp(-1 * S[j]));
		}
			
		
		/*for(int j1 = a + 1;j1 <= a + b + c;j1++)
			S[j1]+=bias[j1];
		*/
	}
	public void countE(){//计算误差
		int a = getNumOfA();
		int b = getNumOfB();
		int c = getNumOfC();
		for(int j = a + b + c;j >a;j--){
			{
				double sum = 0;
				if(j == a + b + c)
					E[j] = O[j] * (1- O[j]) * (1- O[j]);
				else{
					int k1 = 0;
					for(int k = a + b + 1;k <= a + b + c;k++){
						sum+=w[j][k];
						k1=k;
					}	
					E[j] = O[j] * (1- O[j]) * sum * E[k1];
				}
					
			}
		}
	}
	public void updateW(){//调整权重
		int a = getNumOfA();
		int b = getNumOfB();
		int c = getNumOfC();
		for(int i = a + 1;i <= a + b;i++)//更新第二层的权重
			for(int j = a + b + 1;j <= a + b + c;j++){
				w[i][j]+=0.9 * O[i] * E[j];
			}
		for(int i = 1;i <= a;i++)//更新第一层的权重
			for(int j = a + 1;j <= a + b;j++){
				w[i][j]+=0.9 * O[i] * E[j];
			}		
			
	}
	public void updateBias(){//调整偏置
		int a = getNumOfA();
		int b = getNumOfB();
		int c = getNumOfC();
		for(int j = a + 1;j <= a + b + c;j++)
			bias[j]+= 0.9 * E[j];
	}
	public static void main(String []args){
		input = new double[]{1,0,1};
		/*Random ran = new Random();
		for(int i=0;i<10;i++){
			double v = ran.nextDouble()*2 - 1;
			int u = (int) (v * Math.pow(10, 2));
			double v1 = (double)u / Math.pow(10, 2);
			System.out.println(v1);
		}
		
		for(int a:A)
			System.out.println(a);
		for(int b:B)
			System.out.println(b);
		for(int c:C)
			System.out.println(c);*/
		int numOfA = 3;
		int numOfB = 2;
		int numOfC = 1;
		BpAlgorithm bp=new BpAlgorithm(numOfA,numOfB,numOfC);
		w[1][4] = 0.2;w[1][5] = -0.3;w[2][4] = 0.4;w[2][5] = 0.1;
		w[3][4] = -0.5;w[3][5] = 0.2;w[4][6] = -0.3;w[5][6] = -0.2;
		bias[4] = -0.4;bias[5] = 0.2;bias[6] = 0.1;
		//O[1] = 1;O[2] = 0; O[3] = 1;
		for(int i = 1;i <= input.length;i++)
			O[i] = input[i - 1];
		bp.countSAndO();
		bp.countE();
		bp.updateW();
		bp.updateBias();
		for(int k = numOfA + 1;k <=numOfA + numOfB + numOfC;k++)
			System.out.println("神经元"+k+":"+S[k]);
		for(int  k = numOfA + 1;k <=numOfA + numOfB + numOfC;k++)
			System.out.println("输出O"+k+":"+O[k]);
		for(int k = numOfA + numOfB + numOfC;k >= numOfA + 1;k--)
			System.out.println("误差E"+k+":"+E[k]);
		for(int i = 1;i <= numOfA;i++)
			for(int j = numOfA + 1;j <= numOfA + numOfB;j++)
				System.out.println("更新后W"+i+j+":"+w[i][j]);
		for(int i = numOfA + 1;i <= numOfA + numOfB;i++)
			for(int j = numOfA +numOfB + 1;j <= numOfA + numOfB +numOfC;j++)
				System.out.println("更新后W"+i+j+":"+w[i][j]);
		for(int i = numOfA + 1;i <=numOfA + numOfB + numOfC;i++)
			System.out.println("更新后bias"+i+":"+bias[i]);
	}
}
