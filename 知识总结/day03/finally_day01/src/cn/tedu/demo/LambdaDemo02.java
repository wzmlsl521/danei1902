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
		 * ʹ��foreachѭ����������
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
		 * ʹ��lambda���ʽ��������
		 * ()->{}
		 * ()�еı�����ָ�����õ���Ԫ�أ���Ϊֻ��һ��������()����ʡ��
		 */
//		list.forEach(str->System.out.println(str));
		
		
		/*
		 * ʹ��lambda��set���Ͻ��б���
		 */
//		Set<String> set = new HashSet<String>();
//		set.add("tom");
//		set.add("jerry");
//		set.add("jack");
//		set.add("rose");
//		
//		set.forEach(str->System.out.println(str));
		
		
		/*
		 * ��map���Ͻ��б���
		 */
		Map<String, String> map =  new HashMap<String, String>();
		map.put("����", "90");
		map.put("��ѧ", "100");
		map.put("Ӣ��", "120");
		map.put("����", "250");
		
		//ʹ��foreach����
//		for (Entry<String, String> entry : map.entrySet()) {
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
		
		/*
		 * ʹ��lambda����map����
		 * ()->{}
		 * ()����Ǳ�������ÿһ���ֵ��
		 */
		map.forEach((k,v)->System.out.println(k+":"+v));
	}

}





