package cn.tedu.demo03;

import java.util.LinkedList;

public class Demo02 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Nemo");
		list.add("John");
		list.add("�ܴ�"); 
		list.add("�ܶ�");
		System.out.println(list);
	}

}
