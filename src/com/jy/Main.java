package com.jy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 获取输入
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入底数base:");
		double base = scanner.nextDouble();
		System.out.print("请输入指数exponent:");
		int exponent = scanner.nextInt();

		// 输出结果
		System.out.println(base + "的" + exponent + "次方:" + power(base, exponent));

		// 释放资源
		scanner.close();
	}

	/**
	 * 幂指数运算
	 * 
	 * @param base
	 *            底数
	 * @param exponent
	 *            指数
	 * @return 幂指数的结果
	 */
	private static double power(double base, int exponent) {
		if (base == 0.0) { // 底数为0的情况
			if (exponent < 0) {
				throw new RuntimeException("Invalid Input!");
			} else {
				return 0.0;
			}
		}

		// 获取指数的绝对值
		int absExponent = exponent;
		if (exponent < 0)
			absExponent = -exponent;

		double result = powerWithUnsignedExponent2(base, absExponent);
		if (exponent < 0)
			result = 1.0 / result;
		return result;
	}

	/**
	 * 指数为无符号整数的幂指数运算
	 * 
	 * @param base
	 *            底数
	 * @param absexponent
	 *            无符号指数
	 * @return 幂指数的结果
	 */
	private static double powerWithUnsignedExponent1(double base, int absexponent) {
		double result = 1.0;
		for (int i = 1; i <= absexponent; i++)
			result *= base;
		return result;
	}

	/**
	 * 使用递归的方式 指数为无符号整数的幂指数运算
	 * 
	 * @param base
	 *            底数
	 * @param absexponent
	 *            无符号指数
	 * @return 幂指数的结果
	 */
	private static double powerWithUnsignedExponent2(double base, int absexponent) {
		if (absexponent == 0)
			return 1.0;
		if (absexponent == 1)
			return base;
		// 指数右移1位后，递归
		double result = powerWithUnsignedExponent2(base, absexponent >> 1);
		result *= result;
		if ((absexponent & 0x1) == 1) // 是否为奇数
			result *= base;
		return result;

	}

}
