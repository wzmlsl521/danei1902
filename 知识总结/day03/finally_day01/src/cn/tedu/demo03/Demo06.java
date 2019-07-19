package cn.tedu.demo03;

import java.util.TreeSet;

public class Demo06 {

	public static void main(String[] args) {
		/**
		 * 测试Java中的红黑树
		 * TreeSet 内部实际上是只使用key存储数据的TreeMap
		 */
		TreeSet<Integer> tree = new TreeSet<>();
		tree.add(180);
		tree.add(90);
		tree.add(60);
		tree.add(40);
		System.out.println(tree);
	}

}
