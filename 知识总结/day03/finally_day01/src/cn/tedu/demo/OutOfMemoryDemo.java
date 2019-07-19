package cn.tedu.demo;

public class OutOfMemoryDemo {
	public static void main(String[] args) {
		int[] ary = new int[800000000];
		System.out.println(ary[0]);
	}

}
