package com.leet.list.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最小堆应用测试
 * 
 * @since jdk1.5及其以上
 * @author 毛正吉
 * @version 1.0
 * @date 2010.05.24
 * 
 */
public class MinHeapApp {

	/**
	 * @param args
	 * @throws IOException
	 * @throws MinHeapException
	 */
	public static void main(String[] args) throws IOException, MinHeapException {
		int value, value2;
		MinHeap hp = new MinHeap(31);
		boolean success;

		hp.insert(53);
		hp.insert(17);
		hp.insert(78);
		hp.insert(9);
		hp.insert(45);
		hp.insert(65);
		hp.insert(87);
		hp.insert(23);

		while (true) {
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, remove: ");
			int choice = getChar();

			switch (choice) {
			case 's':
				hp.displayHeap();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				success = hp.insert(value);
				if (!success) {
					System.out.println("Can't insert; heap is full");
				}
				break;
			case 'r':
				if (!hp.isEmpty()) {
					hp.removeMin();
				} else {
					System.out.println("Can't remove; heap is empty");
				}
				break;
			default:
				System.out.println("Invalid entry\n");
			}
		}

	}

	/**
	 * 获得控制台输入流
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String getString() throws IOException {
		return new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	/**
	 * 获得控制台输入字符
	 * 
	 * @return
	 * @throws IOException
	 */
	public static char getChar() throws IOException {
		return getString().charAt(0);
	}

	/**
	 * 获得控制台输入整型
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static int getInt() throws NumberFormatException, IOException {
		return Integer.parseInt(getString());
	}

}