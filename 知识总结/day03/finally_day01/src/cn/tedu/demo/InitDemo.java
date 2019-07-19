package cn.tedu.demo;
/**
 * 实例化时对象初始化的顺序
 * @author adminitartor
 *
 */
public class InitDemo {
	public static void main(String[] args) {
		new SubCls();
	}
}

class SuperCls {
	int a = 6;
	public SuperCls(){
		super();
		test();
	}
	public void test(){
		System.out.println(a);
	}
}
class SubCls extends SuperCls {
	int a = 8;
	public SubCls(){
		super();
		test();
	}
	public void test(){
		System.out.println(a);
	}
}
