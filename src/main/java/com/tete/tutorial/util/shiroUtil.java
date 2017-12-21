package com.tete.tutorial.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * shiro工具类
 * @author admin
 *
 */
public class shiroUtil {
	
	public static String MD5(String pwd,String salt){
		
		return new Md5Hash(pwd, salt).toHex();
	}
	/**
	 * 二进制串转换成int类型
	 * @param binaryStr 
	 * @return
	 */
	public static int binaryToInt(String binaryStr){
		return Integer.valueOf(binaryStr, 2);
	}
	/**
	 * 十进制串转换成二进制
	 * @param num 
	 * @return
	 */
	public static String IntToBinary(int num){
		String binaryString = Integer.toBinaryString(num);
		if(binaryString.length()<4){
			binaryString="000"+binaryString;
			binaryString = binaryString.substring(binaryString.length()-4, binaryString.length());
		}
		return binaryString;
	}
	/**
	 * 计算操作：(0000 从左往右依次为：增、删、改、查)<br>
	 * 即：0000(0)为没有任何权限；
	 * 1111(15)为满权限
	 * @param num 被计算数
	 * @param places 位置（从右往左 0-3）
	 * @return
	 */
	public static int countOperation(int num,int[] places){
		for (int i : places) {
			num = num ^ (1<<i);
		}
		return num;
	}
	
	public static void main(String[] args) {
//		System.out.println(MD5("123","admin"));
//		System.out.println(binaryToInt("1111"));
//		System.out.println(IntToBinary(6));
//		System.out.println(IntToBinary(countOperation(11,new int[]{0,1,3})));
		String aa="0010";
		char[] charArray = aa.toCharArray();
		System.out.println(charArray[0]=='1');
		
	}

}
