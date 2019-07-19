package cn.tedu.demo;

public class GooTest {
	public static void main(String[] args) {
		/*
		 * 通过lambda表达式创建匿名内部类对象
		 */
//		Goo goo = (str,a)->{System.out.println("执行demo方法");};
//		goo.demo("hello", 2);
		
//		Goo goo = a->System.out.println(a);
//		goo.test(4);
		
		Goo goo = str->str;
		System.out.println(goo.test("hello"));
	}

}







