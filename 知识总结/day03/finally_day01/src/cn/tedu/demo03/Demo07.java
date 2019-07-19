package cn.tedu.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo07 {
	
	static List<String> list;
	
	public static void main(String[] args) {
		list = new CopyOnWriteArrayList<>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Nemo");
		list.add("Wang");
		list.add("Lee");
		Thread t1 = new Thread() {
			public void run() {
				for (String s : list) {
					System.out.println(s);
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				try {
					sleep(200);
					list.add(2,"光头强");
					System.out.println("插入数据"); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t2.start();
	}

}








