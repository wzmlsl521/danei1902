package cn.tedu.demo;

public class ForDemo {
	public static void main(String[] args) {
		String[] ary = {"hello","world","interview"};
		//����
		for(int i=0;i<ary.length;i++) {
			System.out.println("λ��"+i+"��Ԫ���ǣ�"+ary[i]);
		}
		
		for (String str : ary) {
			System.out.println(str);
		}
	}

}
