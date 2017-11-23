package antColony;
import java.lang.Math;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
public class solutionSpace {
	int AntNum;	//蚂蚁数量
	int SpaceNum; //解空间大小
	double []w;	//权重数组
	double []p;	//概率数组
	int Sum; //已有解数
	int Rn;  //R的规模
	int On;	 //O的规模
	int Cn;	 //C的规模
	double q;  //算法参数q
	double [][]Space;
	int []Rank;
	Continuous R ;//连续变量R的对象
	Ordinal O;	//有序变量O的对象
	Categorical C;//分类变量C的对象
	public solutionSpace(int R,int O,int C,int k,int m,int q){	//构造函数
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
	public void UpdateW(){  //更新权重w数组
		for(int j = 0;j < SpaceNum;j++){
			w[j] = (1.0 / (q * SpaceNum * Math.sqrt(2*Math.PI))) * Math.exp(-Math.pow((Rank[j] - 1),2) / 2 * Math.pow(q, 2) * Math.pow(SpaceNum, 2));
		}
	}
	public void UpdateP(){	//更新概率p数组
		double sum = 0;
		for(int j = 0;j < SpaceNum;j++){
			sum += w[j];
		}
		for(int j = 0;j < SpaceNum;j++){
			p[j] = w[j] / sum;
		}
	}
	//http://blog.sina.com.cn/s/blog_5a15b7d101014ngm.html
	public void Sort(){		//排序函数
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
	public void Best(int k){		//取前多少最佳的值
		Sort();
		Sum = k;//取前k个有效值
	}
	//http://www.jb51.net/article/60129.htm
	public void rank(){		//更新Rank数组
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
	public int Choose(){	//选择一个解操作（轮盘赌算法）
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
	public void Construct(){	//构造一个新解
		int who = Choose();
		Sum++;
		R.consultR(Space, who, Sum);
	}
	public double f(double []d){//解的评估函数
		double index;//指数
		double value=0;
		double β=5;
		for(int i=1;i<Rn+Cn+On;i++)
			{
				index=(i-1)/(Rn+Cn+On-1);
				value+=Math.pow(β,2*index)*Math.pow(d[i-1], 2);
			}
		return value;
	}
}
