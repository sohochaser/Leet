package com.iv.tree;

public class BinaryTree {

	int data; // ���ڵ�����
	BinaryTree left; // ������
	BinaryTree right; // ������

	public BinaryTree(int data) // ʵ������������
	{
		this.data = data;
		left = null;
		right = null;
	}

	public void insert(BinaryTree root, int data) { // ��������в����ӽڵ�
		if (data > root.data) // ����������ڵ㶼�ȸ��ڵ�С
		{
			if (root.right == null) {
				root.right = new BinaryTree(data);
			} else {
				this.insert(root.right, data);
			}
		} else { // ���������ҽڵ㶼�ȸ��ڵ��
			if (root.left == null) {
				root.left = new BinaryTree(data);
			} else {
				this.insert(root.left, data);
			}
		}
	}
}
