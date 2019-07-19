package cn.tedu.demo;

public class Person {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("释放对象相关的资源");
	}

}
