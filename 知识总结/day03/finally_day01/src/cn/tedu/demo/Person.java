package cn.tedu.demo;

public class Person {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("�ͷŶ�����ص���Դ");
	}

}
