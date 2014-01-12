package com.open;

public class Divide {
	private static long start = 0;
	private static long end = 0;

	public static void main(String[] args) {
		ps();
		System.out.println(f1(1.04f, 50000));
		pe();
		ps();
		System.out.println(f2(1.04f, 50000));
		pe();
	}

	private static void ps() {
		start = System.currentTimeMillis();
	}

	private static void pe() {
		end = System.currentTimeMillis();
		System.out.println("Take milliseconds: "+(end - start));
	}

	static double f1(float x, int n) {
		double s = 1;
		for (int i = 0; i < n; i++) {
			s = s * x;
		}
		return s;
	}

	static double f2(float x, int n) {
		if (n <= 1) {
			return x;
		} else {
			int m = n / 2;
			double s = f2(x, m);
			if (n % 2 == 0) {
				return s * s;
			} else {
				return s * s * x;
			}
		}
	}
}
