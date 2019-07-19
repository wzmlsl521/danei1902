package cn.tedu.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LambdaDemo02 {
	public static void main(String[] args) {
		/*
		 * 使用foreach循环遍历集合
		 */
//		List<String> list = new ArrayList<String>();
//		list.add("tom");
//		list.add("jerry");
//		list.add("jack");
//		list.add("rose");
//		for (String str : list) {
//			System.out.println(str);
//		}
		/*
		 * 使用lambda表达式遍历集合
		 * ()->{}
		 * ()中的遍历是指遍历得到的元素，因为只有一个参数，()可以省略
		 */
//		list.forEach(str->System.out.println(str));
		
		
		/*
		 * 使用lambda对set集合进行遍历
		 */
//		Set<String> set = new HashSet<String>();
//		set.add("tom");
//		set.add("jerry");
//		set.add("jack");
//		set.add("rose");
//		
//		set.forEach(str->System.out.println(str));
		
		
		/*
		 * 对map集合进行遍历
		 */
		Map<String, String> map =  new HashMap<String, String>();
		map.put("语文", "90");
		map.put("数学", "100");
		map.put("英语", "120");
		map.put("理综", "250");
		
		//使用foreach遍历
//		for (Entry<String, String> entry : map.entrySet()) {
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
		
		/*
		 * 使用lambda遍历map集合
		 * ()->{}
		 * ()存的是遍历到的每一组键值对
		 */
		map.forEach((k,v)->System.out.println(k+":"+v));
	}

}





