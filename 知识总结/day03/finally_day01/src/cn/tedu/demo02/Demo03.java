package cn.tedu.demo02;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo03 {
	static BlockingQueue<String> queue;
	public static void main(String[] args) 
			throws Exception{
		queue = new LinkedBlockingQueue<String>(10);
		Thread t = new Thread() {
			public void run() {
				try {
					System.out.println("开始消费数据");
					String s = queue.take();
					System.out.println(s);
				} catch (InterruptedException e) {
 					e.printStackTrace();
				}
			}
		};
		t.start();
		Thread.sleep(5000); 
		System.out.println("生产数据");
		queue.put("Hello World!"); 
	}

}
