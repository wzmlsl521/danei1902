package cn.tedu.demo;

public class Test extends SuperTest implements It{

	public static void main(String[] args) {
		SuperTest superTest = new Test();
		It it = (It)superTest;
		it.demo();
		
	}

	@Override
	public void demo() {
		System.out.println("实现类重写的方法");
	}
}


class SuperTest{}
