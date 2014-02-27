package com.leet.list.merge;

/**
 * 堆结点
 * 
 * @since jdk1.5及其以上
 * @author 毛正吉
 * @version 1.0
 * @date 2010.05.24
 * 
 */
public class Node {
	private int iData; // 结点数据是整型

	public Node(int key) {
		iData = key;
	}

	/**
	 * setKey
	 * 
	 * @param id
	 */
	public void setKey(int id) {
		iData = id;
	}

	/**
	 * getKey
	 * 
	 * @return
	 */
	public int getKey() {
		return iData;
	}
}