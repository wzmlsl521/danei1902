package cn.tedu.demo;

public class ForDemo {
	public static void main(String[] args) {
		String[] ary = {"hello","world","interview"};
		//遍历
		for(int i=0;i<ary.length;i++) {
			System.out.println("位置"+i+"的元素是："+ary[i]);
		}
		
		for (String str : ary) {
			System.out.println(str);
		}
	}

}
