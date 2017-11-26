package fjnu;

public class MainStudent {//对象序列化
	public static void main(String []args){
		FlattenStudent fs = new FlattenStudent();
		InflateStudent is = new InflateStudent();
		fs.flattenStudent();
		is.falateStudent();
	}
}
