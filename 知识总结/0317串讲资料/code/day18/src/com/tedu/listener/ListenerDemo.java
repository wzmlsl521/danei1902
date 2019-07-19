package com.tedu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
/**
 * 创建一个窗口, 窗口中添加一个按钮
 * 当点击按钮时, 会在控制台输出"Hello btn"
 */
public class ListenerDemo {
	public static void main(String[] args) {
		//1.创建一个窗口
		JFrame frame = new JFrame();
		//2.设置窗口的大小
		frame.setSize(250, 200);
		//3.设置窗口的位置
		frame.setLocation(350, 250);
		//4.创建一个按钮, 并添加到窗口中
		JButton btn = new JButton("按钮");
		/*
		 * 需求: 当按钮被点击时, 在控制台打印"hello btn~~!!"
		 * 事件源: 按钮
		 * 事件: 按钮被点击
		 * 监听器: 当把监听器注册到事件源开始, 监听器会一直
		 * 	监听着事件源(按钮), 直到按钮被点击事件发生, 就会
		 *  激活监听器, 执行监听器中对应的方法, 从事实现特定功能
		 */
		//>>创建一个监听器(行为监听器)
		ActionListener listener = new ActionListener() {
			//处理事件的方法(事件处理器)
			public void actionPerformed(ActionEvent e) {
				String dateStr = new Date(e.getWhen()).toLocaleString();
				System.out.println(dateStr);
				System.out.println("hello btn~!!");
			}
		};

		//>>将监听器注册到按钮上(此后监听器会一直监听按钮的状态)
		btn.addActionListener(listener);
		//5.将按钮添加到窗口中
		frame.add(btn);
		//6.设置窗口为显示状态
		frame.setVisible(true);
		System.out.println("执行完成...");
	}
}




