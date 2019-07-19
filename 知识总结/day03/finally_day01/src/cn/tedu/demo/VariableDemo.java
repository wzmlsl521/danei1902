package cn.tedu.demo;

public class VariableDemo {
	public static void main(String[] args) {
		VariableDemo demo = new VariableDemo();
//		demo.demo(3,2,3,2,4);
		int[] ary = {1,2,34};
		demo.demo(ary);
	}
	
	public void demo(int...is) {
//		System.out.println(is[1]);
		for (int i : is) {
			System.out.println(i);
		}
		
	}

}
