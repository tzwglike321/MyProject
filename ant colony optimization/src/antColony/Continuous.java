package antColony;

import java.util.Random;

public class Continuous {
	int Rn;//R的规模
	int Rx;//下标开始
	int Ry;//下标结束
	int spaceNum;//解空间大小
	int antNum;//蚂蚁数量
	double ξ;//信息素
	double σ;//偏差
	int []R=new int[spaceNum+antNum];
	public double Updateσ(double [][]space,int j){//更新σ
		double sum=0;
		double value;
		for(int l=1;l<=spaceNum;l++)
		{
			value=space[l][Rn]-space[j][Rn];
			if(value<0)
				value=value*(-1);
			sum+=value;
		}
		σ=ξ*sum/(spaceNum-1);
		return σ;
	}
	public double gFunction(double [][]space,int j,int sum){//g函数
		double u=space[j][Rn];//均值
		double v=Updateσ(space,j);
		double b=Math.pow(v,2);//方差
		Random random = new Random();
		double x=Math.sqrt(b)*random.nextGaussian()+u;//产生均值为u，方差为b的随机数
		return x;
	}
	public void consultR(double [][]space,int j,int sum){//生成一个R解并存入R[]数组
		space[sum][Rn]=gFunction(space,j,sum);
	}
	public Continuous(int k,int m,int n,int x,int y,double ξ,double σ){//构造函数
		spaceNum=k;
		antNum=m;
		Rn=n;
		Rx=x;
		Ry=y;
		this.ξ=ξ;
		this.σ=σ;
	}
}



