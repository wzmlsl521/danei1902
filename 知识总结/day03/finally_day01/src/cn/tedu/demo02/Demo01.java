package cn.tedu.demo02;

public class Demo01 {

	public static void main(String[] args) {
		//统计一个字符串中每个英文大写字符的数量。
		//统计一个字符串中每个数字字符的数量。 
		String str = "hajkhASUHJKHWUIHGAAHJ今天你吃了吗？";
		int[] arr = new int[26];
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if('A'<=c && c<='Z') {
				arr[c-'A']++;
			}
		}
		char c = 'A';
		for(int i:arr) {
			System.out.println(
					c++ + ":" + i); 
		}
	}

}
