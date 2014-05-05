package com.basic;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author Allen
 * 
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return a == null ? b : a;
		}

		String l = a;
		String s = b;
		if (a.length() < b.length()) {
			l = b;
			s = a;
		}
		char[] sum = new char[l.length() + 1];
		int idx = l.length();

		boolean more = false;
		int i = s.length() - 1;
		int offset = l.length() - s.length();
		for (; i >= 0; i--) {
			char c1 = s.charAt(i);
			char c2 = l.charAt(i + offset);
			char r = '0';
			if (c1 == '0' && c2 == '0') {
				if (more) {
					r = '1';
				}
				more = false;
			} else if (c1 == '1' && c2 == '1') {
				if (more) {
					r = '1';
				}
				more = true;
			} else {
				if (!more) {
					r = '1';
				} else {
					more = true;
				}
			}
			sum[idx--] = r;
		}
		if (s.length() == l.length()) {
			if (more) {
				sum[idx--] = '1';
			}
		} else {
			for (i = l.length() - s.length() - 1; i >= 0; i--) {
				char c = l.charAt(i);
				char r = c;
				if (more) {
					if (c == '1') {
						r = '0';
						more = true;
					} else {
						r='1';
						more = false;
					}
				}
				sum[idx--] = r;
			}
			if (more) {
				sum[idx--] = '1';
			}
		}
		StringBuilder sb = new StringBuilder();
		for (i = idx + 1; i < sum.length; i++) {
			sb.append(sum[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		//System.out.println(new AddBinary().addBinary("100", "110010"));
		System.out.println(new AddBinary().addBinary("101111", "10"));
		
	}
}