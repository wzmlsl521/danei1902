package cn.tedu.demo03;

public class Demo05 {

	public static void main(String[] args) {
		/**
		 * main ������ appendTo ��������ͬһ��StringBuilder����
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


