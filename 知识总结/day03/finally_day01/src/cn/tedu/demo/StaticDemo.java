package cn.tedu.demo;

public class StaticDemo {
	public static void main(String[] args) {
		StaticDemo demo = new StaticDemo();
		demo.test();
	}
	
	public void test() {
		System.out.println(Test1.a);
		Test1 demo = new Test1();
		int x = demo.a;
		System.out.println(x);
	}

}

class Test1{
	public static int a = 4;

}







