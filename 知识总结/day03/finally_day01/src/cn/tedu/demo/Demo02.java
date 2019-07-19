package cn.tedu.demo;

public class Demo02 {
	public static void main(String[] args) {
		int a = 3;
		int[] ary = {1,2,3};
		change(a,ary);
		System.out.println(a);  //3
		System.out.println(ary[0]);  //2
		
	}
	
	public static void change(int a,int[] ary) {
		a++;
		ary[0]++;
	}

}
