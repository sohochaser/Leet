package com.leet.permutation;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 **/
public class RestoreIpAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		return genIp(s, 4);

	}

	private ArrayList<String> genIp(String head, int remain) {
		ArrayList<String> result = new ArrayList<String>();
		if (head == null || head.length() < remain
				|| head.length() > (remain * 3)) {
			return result;
		}
		if (remain <= 1) {
			int ip = Integer.parseInt(head);
			if (ip <= 255) {
				if (head.length() > 1) {
					if (!head.startsWith("0")) {
						result.add(head);
					}
				} else {
					result.add(head);
				}
			}
			return result;
		}

		int max = head.length() - remain + 1;
		if (max > 3) {
			max = 3;
		}
		if (head.startsWith("0")) {
			max = 1;
		}
		for (int i = max; i > 0; i--) {
			String ipStr = head.substring(0, i);
			if (i == (max)) {
				int ip = Integer.parseInt(ipStr);
				if (ip <= 255) {
					ArrayList<String> sub = (genIp(head.substring(i),
							(remain - 1)));
					for (String s : sub) {
						if (s != null) {
							result.add(head.substring(0, i) + "." + s);
						}
					}
				}
			} else {
				ArrayList<String> sub = (genIp(head.substring(i), (remain - 1)));
				for (String s : sub) {
					if (s != null) {
						result.add(ipStr + "." + s);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		String s = "010010";
//		System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
		String s1 = "255255255255";
		System.out.println(new RestoreIpAddresses().restoreIpAddresses(s1));
	}
}