package cn.tedu.demo02;

import java.util.Arrays;
import java.util.Random;

public class Demo02 {

	public static void main(String[] args) {
		/**
		 * 将"非常大量"的一组数据中的前5名找到并排序
		 */
		int[] arr = new int[100];
		Random random = new Random();
		for(int j = 0; j<1000000000; j++) {
			int num = random.nextInt();
			int index=Arrays.binarySearch(arr, num);
			if(index==0||index==-1) continue;
			if(index<0) index = -(index+1);
			for(int i=1; i<index; i++) {
				arr[i-1]=arr[i];
			}
			arr[index-1]=num;
			//System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}
	

}






