package com.leet.string;

public class ReverseWords {
	public String reverseWords(String s) {
		if (s == null || s.length() < 1) {
			return s;
		}
		String sub = s.trim();
		
		StringBuilder sb = new StringBuilder();
		int end = sub.length();
		for (int i = sub.length() - 1; i >= 0;) {
			if (sub.charAt(i) == ' ') {
				sb.append(sub.substring(i + 1, end)).append(' ');
				end = i;
				i--;
				while (i >= 0 && sub.charAt(i) == ' ') {
					end = i;
					i--;
				}

			} else {
				i--;
			}
		}
		if (end > 0) {
			sb.append(sub.substring(0, end));
		}else if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "   a   b ";
		System.out.println(new ReverseWords().reverseWords(str));
		str = "a";
		System.out.println(new ReverseWords().reverseWords(str));
	}
}