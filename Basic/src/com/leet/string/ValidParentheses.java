package com.leet.string;

import java.util.Stack;

/**
 * <ol>
 * <li>Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. *
 * <li>The brackets must close in the correct order, "()" and "()[]{}" are all
 * valid but "(]" and "([)]" are not.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		if (s == null || s.length() == 0) {
			return true;
		}
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {///!!!!!
				stack.push(c);
				continue;
			}

			char peek = stack.peek();
			switch (c) {
			case ')':
				if (peek == '(') {
					stack.pop();
				}
				break;
			case '}':
				if (peek == '{') {
					stack.pop();
				}
				break;
			case ']':
				if (peek == '[') {
					stack.pop();
				}
				break;
			default:
				stack.push(c);
				break;
			}
		}
		if (stack.size() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(new ValidParentheses().isValid(s));
	}
}