package com.leet.string;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] arr = new int[256];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = -1;
		}

		int start = 0;
		int len = 0;
		int max = Integer.MIN_VALUE;
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (arr[c] == -1) {
				len++;
			} else {
				if (len > max) {
					max = len;
				}
				len = len - (arr[c] - start);
//				System.out.println(s.charAt(arr[c]) + "\tarr[c]\t" + arr[c]
//						+ "\tstart\t" + start + "\tlen\t" + len);
				
				for (int j = start; j < arr[c]; j++) {
					char cc = s.charAt(j);
					arr[cc] = -1;
				}
				start = (arr[c] + 1);
			}
			arr[c] = i;
		}
		if (i == s.length()) {
			int lastlen = s.length() - start;
			if (lastlen > max) {
				max = lastlen;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		// s = "wlrbbmqbhcdarzowkky";
		System.out.println("result: "
				+ new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
	}
}