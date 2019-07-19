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
	
	//���ļ��������߳�
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
	//�������ѷ���
	private void writeFile() {
		try {
			String str = queue.take();
			out.println(str);
			out.flush();
			System.out.println("д��־��"+str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//������������
	public void println(String log) {
		boolean added = queue.offer(log);
		if(!added) {
			System.out.println("����ʧ�ܣ�"+log);
		}
	}
}
