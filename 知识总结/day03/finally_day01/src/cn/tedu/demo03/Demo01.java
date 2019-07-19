package cn.tedu.demo03;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * 测试 LinkedList 算法
		 */
		LinkedList<String> list = new LinkedList<>();
		
		System.out.println(list);
		
		list.add("Tom");
		list.add("Jerry");
		
		System.out.println(list);
		
		list.add("Andy");
		list.add("Nemo");
		list.add("John");
		list.add("熊大");
		list.add("熊二");
		
		System.out.println(list);
		
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(4));
		
		list.add(4, "光头强");
		System.out.println(list.get(4)); 
		System.out.println(list.get(5)); 
		
		list.add(0, "范传奇");
		System.out.println(list.get(0)); 
		System.out.println(list.get(1)); 
		
		System.out.println(list.remove(0));
		System.out.println(list.get(0));
		
		System.out.println(list);
	}

}


