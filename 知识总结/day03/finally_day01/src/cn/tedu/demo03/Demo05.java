package cn.tedu.demo03;

public class Demo05 {

	public static void main(String[] args) {
		/**
		 * main 方法和 appendTo 方法共享同一个StringBuilder对象
		 */
		StringBuilder buf = new StringBuilder();
		buf.append("Hello ");
		appendTo(buf);
		System.out.println(buf); 
	}
	
	public static void appendTo(StringBuilder buf) {
		buf.append("A");
	}

}


