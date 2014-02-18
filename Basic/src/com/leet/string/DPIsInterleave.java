package com.leet.string;

public class DPIsInterleave {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null && s2 == null) {
			return s3 == null || s3.length() == 0;
		} else if (s1 == null) {
			return s2.equals(s3);
		} else if (s2 == null) {
			return s1.equals(s3);
		} else if (s3 == null) {
			return false;
		}
		return check(s1, s2, s3);
	}

	private boolean check(String s1, String s2, String s3) {
		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2.length() == 0) {
			return s1.equals(s3);
		}
		if (s3.length() == 0) {
			return false;
		}

		char c1 = s1.charAt(s1.length() - 1);
		char c2 = s2.charAt(s2.length() - 1);
		char c3 = s3.charAt(s3.length() - 1);

		String subS3 = s3.substring(0, s3.length() - 1);
		if (c1 != c2) {
			if (c1 == c3) {
				return check(s1.substring(0, s1.length() - 1), s2, subS3);
			} else if (c2 == c3) {
				return check(s1, s2.substring(0, s2.length() - 1), subS3);
			} else {
				return false;
			}
		} else {
			return check(s1.substring(0, s1.length() - 1), s2, subS3)
					|| check(s1, s2.substring(0, s2.length() - 1), subS3);
		}
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";

		String s3 = "aadbbcbcac";
		s3 = "aadbbbaccc";
		System.out.println(new DPIsInterleave().isInterleave(s1, s2, s3));
	}
}