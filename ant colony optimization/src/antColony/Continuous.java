package antColony;

import java.util.Random;

public class Continuous {
	int Rn;//R�Ĺ�ģ
	int Rx;//�±꿪ʼ
	int Ry;//�±����
	int spaceNum;//��ռ��С
	int antNum;//��������
	double ��;//��Ϣ��
	double ��;//ƫ��
	int []R=new int[spaceNum+antNum];
	public double Update��(double [][]space,int j){//���¦�
		double sum=0;
		double value;
		for(int l=1;l<=spaceNum;l++)
		{
			value=space[l][Rn]-space[j][Rn];
			if(value<0)
				value=value*(-1);
			sum+=value;
		}
		��=��*sum/(spaceNum-1);
		return ��;
	}
	public double gFunction(double [][]space,int j,int sum){//g����
		double u=space[j][Rn];//��ֵ
		double v=Update��(space,j);
		double b=Math.pow(v,2);//����
		Random random = new Random();
		double x=Math.sqrt(b)*random.nextGaussian()+u;//������ֵΪu������Ϊb�������
		return x;
	}
	public void consultR(double [][]space,int j,int sum){//����һ��R�Ⲣ����R[]����
		space[sum][Rn]=gFunction(space,j,sum);
	}
	public Continuous(int k,int m,int n,int x,int y,double ��,double ��){//���캯��
		spaceNum=k;
		antNum=m;
		Rn=n;
		Rx=x;
		Ry=y;
		this.��=��;
		this.��=��;
	}
}



