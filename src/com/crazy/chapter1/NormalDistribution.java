package com.crazy.chapter1;

import java.util.Scanner;

public class NormalDistribution {

	public static double calc(double u) {
		double y = Math.abs(u);
		double y2 = y * y;
		double z = Math.exp(-0.5 * y2) * 0.398942280401432678;
		double p = 0;
		int k = 28;
		double s = -1;
		double fj = k;

		if (y > 3) {
			// 当y>3时
			for (int i = 1; i <= k; i++) {
				p = fj / (y + p);
				fj = fj - 1.0;
			}
			p = z / (y + p);
		} else {
			// 当y<3时
			for (int i = 1; i <= k; i++) {
				p = fj * y2 / (2.0 * fj + 1.0 + s * p);
				s = -s;
				fj = fj - 1.0;
			}
			p = 0.5 - z * y / (1 - p);
		}
		if (u > 0)
			p = 1.0 - p;
		return p;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		while(scanner.hasNext()){
			x = scanner.nextInt();
			System.out.println("x=" + x + ",  y= " + calc(x));
		}
		scanner.close();
	}
}
