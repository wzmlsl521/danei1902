package cn.tedu.demo;

public class PersonTest {
	public static void main(String[] args) {
		Person person = new Person();
		//.....
		person = null;
		System.gc();
	}

}
