package cn.tedu.demo;

public class Test extends SuperTest implements It{

	public static void main(String[] args) {
		SuperTest superTest = new Test();
		It it = (It)superTest;
		it.demo();
		
	}

	@Override
	public void demo() {
		System.out.println("ʵ������д�ķ���");
	}
}


class SuperTest{}
