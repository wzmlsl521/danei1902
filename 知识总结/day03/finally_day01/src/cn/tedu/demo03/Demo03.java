package cn.tedu.demo03;

public class Demo03 {

	public static void main(String[] args) {
		//�Ƚ϶���Ĵ�С
		String s1 = "�ܴ�";
		String s2 = "�ܶ�";
		String s3 = "�ܶ�";
		String s4 = "����";
		
		int val = s2.compareTo(s3);
		System.out.println(val); //0 һ����
		
		val = s1.compareTo(s2);
		System.out.println(val); //2715 ���� s1�� s2С
		
		val = s4.compareTo(s1); //-2846 ���� s4С s1��
		System.out.println(val);
		
		
	}

}
