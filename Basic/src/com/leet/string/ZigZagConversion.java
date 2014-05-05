package com.leet.string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows <= 1) {
			return s;
		}
		List<StringBuilder> sbs = new ArrayList<StringBuilder>();
		for (int i = 0; i < nRows; i++) {
			sbs.add(new StringBuilder());
		}
		int k = 2 * nRows - 2;
		int current = 0;
		int i = 0;
		while (current < s.length()) {

			for (i = 0; i < nRows; i++) {
				if (current >= s.length()) {
					break;
				}
				sbs.get(i % nRows).append(s.charAt(current++));
			}

			for (; i < k; i++) {
				if (current >= s.length()) {
					break;
				}
				sbs.get(nRows - i % nRows - 2).append(s.charAt(current++));
			}
		}
		StringBuilder result = sbs.get(0);

		for (i = 1; i < nRows; i++) {
			result.append(sbs.get(i));

		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out
				.println(new ZigZagConversion()
						.convert(
								"twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd",
								4));
	}
}