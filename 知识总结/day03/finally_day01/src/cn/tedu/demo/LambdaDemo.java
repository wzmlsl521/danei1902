package cn.tedu.demo;

public class LambdaDemo {
	public static void main(String[] args) {
		//ʹ�������ڲ��ഴ��һ�������࣬�����߳�ִ������
//		Runnable runnable = new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("ͨ�������ڲ��ഴ��������");
//			}
//		};
		
		Runnable runnable = ()->
		{System.out.println("lambda���ʽ����������");};
		
		new Thread(runnable).start();
	}

}
