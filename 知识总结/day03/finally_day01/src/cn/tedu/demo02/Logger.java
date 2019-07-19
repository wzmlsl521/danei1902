package cn.tedu.demo02;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger {
	
	private LinkedBlockingQueue<String> queue;
	private PrintWriter out;
	
	public Logger() {
		queue = new LinkedBlockingQueue<String>(10000);
	}
	
	//打开文件，启动线程
	public void open() {
		try {
			out = new PrintWriter("log.txt");
			Thread t = new Thread() {
				@Override
				public void run() {
					while(true) {
						writeFile();
					}
				}
			};
			t.setDaemon(true); 
			t.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void close() {
		out.close();
	}
	//数据消费方法
	private void writeFile() {
		try {
			String str = queue.take();
			out.println(str);
			out.flush();
			System.out.println("写日志："+str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//数据生产方法
	public void println(String log) {
		boolean added = queue.offer(log);
		if(!added) {
			System.out.println("插入失败！"+log);
		}
	}
}
