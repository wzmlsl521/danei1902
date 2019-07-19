package cn.tedu.demo;

public class LambdaDemo {
	public static void main(String[] args) {
		//使用匿名内部类创建一个任务类，创建线程执行任务
//		Runnable runnable = new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("通过匿名内部类创建任务类");
//			}
//		};
		
		Runnable runnable = ()->
		{System.out.println("lambda表达式创建任务类");};
		
		new Thread(runnable).start();
	}

}
