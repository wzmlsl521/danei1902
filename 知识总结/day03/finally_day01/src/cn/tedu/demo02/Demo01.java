package cn.tedu.demo02;

public class Demo01 {

	public static void main(String[] args) {
		//ͳ��һ���ַ�����ÿ��Ӣ�Ĵ�д�ַ���������
		//ͳ��һ���ַ�����ÿ�������ַ��������� 
		String str = "hajkhASUHJKHWUIHGAAHJ�����������";
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
