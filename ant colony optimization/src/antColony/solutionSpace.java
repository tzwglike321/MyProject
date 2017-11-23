package antColony;
import java.lang.Math;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
public class solutionSpace {
	int AntNum;	//��������
	int SpaceNum; //��ռ��С
	double []w;	//Ȩ������
	double []p;	//��������
	int Sum; //���н���
	int Rn;  //R�Ĺ�ģ
	int On;	 //O�Ĺ�ģ
	int Cn;	 //C�Ĺ�ģ
	double q;  //�㷨����q
	double [][]Space;
	int []Rank;
	Continuous R ;//��������R�Ķ���
	Ordinal O;	//�������O�Ķ���
	Categorical C;//�������C�Ķ���
	public solutionSpace(int R,int O,int C,int k,int m,int q){	//���캯��
		AntNum = m;
		SpaceNum = k;
		w = new double[AntNum + SpaceNum];
		p = new double[AntNum + SpaceNum];
		Rank = new int[AntNum + SpaceNum];
		Sum = SpaceNum;
		Rn = R;
		On = O;
		Cn = C;
		this.q = q;
		Space = new double[AntNum + SpaceNum][Rn + On + Cn];
		
	}
	public void UpdateW(){  //����Ȩ��w����
		for(int j = 0;j < SpaceNum;j++){
			w[j] = (1.0 / (q * SpaceNum * Math.sqrt(2*Math.PI))) * Math.exp(-Math.pow((Rank[j] - 1),2) / 2 * Math.pow(q, 2) * Math.pow(SpaceNum, 2));
		}
	}
	public void UpdateP(){	//���¸���p����
		double sum = 0;
		for(int j = 0;j < SpaceNum;j++){
			sum += w[j];
		}
		for(int j = 0;j < SpaceNum;j++){
			p[j] = w[j] / sum;
		}
	}
	//http://blog.sina.com.cn/s/blog_5a15b7d101014ngm.html
	public void Sort(){		//������
		Arrays.sort(Space, 0, Sum, new Comparator<Object>() {    
            public int compare(Object o1, Object o2) {    
                double[] one = (double[]) o1;    
                double[] two = (double[]) o2;    
                double fOne = f(one),fTwo = f(two);
                if (fOne < fTwo) {    
                    return 1;    
                }else if(fOne > fTwo)   
                    return -1;    
                else
                	return 0;    
            }    
        });   
	}
	public void Best(int k){		//ȡǰ������ѵ�ֵ
		Sort();
		Sum = k;//ȡǰk����Чֵ
	}
	//http://www.jb51.net/article/60129.htm
	public void rank(){		//����Rank����
		int num;
		for(int i = 0;i < Sum;i++){
			num = GetArrayValues(i);
			Rank[i] = Sum - num + 1;
		}
	}
	public int GetArrayValues(int i){
		int num = 0;
		for(int j = 0;j < Sum;j++){
			if(f(Space[j]) < f(Space[i])){
				num++;
			}
		}
		return num;
	}
	public int Choose(){	//ѡ��һ������������̶��㷨��
		Random a = new Random();
		double seed = a.nextDouble();
		int x = 0;
		for(int i = 0;i < SpaceNum;i++){
			if(x < seed && seed <= x + p[i]){
				x = i;
				break;
			}
		}
		return x;
	}
	public void Construct(){	//����һ���½�
		int who = Choose();
		Sum++;
		R.consultR(Space, who, Sum);
	}
	public double f(double []d){//�����������
		double index;//ָ��
		double value=0;
		double ��=5;
		for(int i=1;i<Rn+Cn+On;i++)
			{
				index=(i-1)/(Rn+Cn+On-1);
				value+=Math.pow(��,2*index)*Math.pow(d[i-1], 2);
			}
		return value;
	}
}
