package cn.tedu.demo;

public class GooTest {
	public static void main(String[] args) {
		/*
		 * ͨ��lambda���ʽ���������ڲ������
		 */
//		Goo goo = (str,a)->{System.out.println("ִ��demo����");};
//		goo.demo("hello", 2);
		
//		Goo goo = a->System.out.println(a);
//		goo.test(4);
		
		Goo goo = str->str;
		System.out.println(goo.test("hello"));
	}

}







