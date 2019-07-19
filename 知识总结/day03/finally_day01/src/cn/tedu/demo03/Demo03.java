package cn.tedu.demo03;

public class Demo03 {

	public static void main(String[] args) {
		//比较对象的大小
		String s1 = "熊大";
		String s2 = "熊二";
		String s3 = "熊二";
		String s4 = "熊三";
		
		int val = s2.compareTo(s3);
		System.out.println(val); //0 一样大
		
		val = s1.compareTo(s2);
		System.out.println(val); //2715 正数 s1大 s2小
		
		val = s4.compareTo(s1); //-2846 负数 s4小 s1大
		System.out.println(val);
		
		
	}

}
