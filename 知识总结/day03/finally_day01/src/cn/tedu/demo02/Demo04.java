package cn.tedu.demo02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo04 {
	static BlockingQueue<String> queue;
	public static void main(String[] args) 
		throws Exception {
		queue = new LinkedBlockingQueue<>(5);
		queue.put("Tom");
		queue.put("Jerry");
		queue.put("Nemo");
		queue.put("Andy");
		queue.put("John");
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
					String s = queue.take();
					System.out.println("取出"+s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
		queue.put("Hello");
		System.out.println("添加了Hello"); 
	}

}
