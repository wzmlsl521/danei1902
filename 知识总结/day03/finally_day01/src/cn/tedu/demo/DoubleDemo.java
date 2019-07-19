package cn.tedu.demo;

import java.math.BigDecimal;

public class DoubleDemo {
	public static void main(String[] args) {
		double d1 = 6.0,d2=5.9;
//		System.out.println(d1-d2);
		
		BigDecimal bigDecimal = new BigDecimal("6.0");
		BigDecimal bigDecimal2 = new BigDecimal("5.9");
		BigDecimal result = bigDecimal.subtract(bigDecimal2);
		System.out.println(result);
		
//		switch (3.2) {
//		case value:
//			
//			break;
//
//		default:
//			break;
//		}
		
		
	}
}
