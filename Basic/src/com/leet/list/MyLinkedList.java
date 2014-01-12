package com.leet.list;

public class MyLinkedList {
	private LinkListNode<Integer> root = new LinkListNode<Integer>(null, null);
	private int length;
	private int point;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList(10045, 232);
		
		System.out.println(list.isHasRound());
		System.out.println("the point cut obj is " + list.getCutPoint());
	}

	/**
	 * 初始化一个环链表
	 */
	private MyLinkedList(int length, int point) {
		root = new LinkListNode<Integer>(1,null);
		LinkListNode<Integer> b =  new LinkListNode<Integer>(2,root);
		root.next(b);
//		this.length = length;
//		this.point = point;
//		LinkListNode<Integer> current = this.root;
//		for (int i = 1; i <= this.length - 1; i++) {
//			current = current.next(new LinkListNode<Integer>(new Integer(i),
//					null));
//		}
//		if (this.point < 0) {
//			current.next(null);
//		} else {
//			LinkListNode<Integer> pointObj = this.root;
//			for (int i = 0; i < point; i++) {
//				pointObj = pointObj.next();
//			}
//			current.next(pointObj);
//		}
	}

	public Integer getCutPoint() {
		LinkListNode<Integer> seekPoint = this.getSeekPoint();
		System.out.println(seekPoint.data());
		LinkListNode<Integer> a = this.root;
		while (true) {
			a = a.next();
			seekPoint = seekPoint.next();
			if (a == seekPoint) {
				return a.data();
			}
			// System.out.println(a.data() +"," + seekPoint.data());
		}
	}

	private LinkListNode<Integer> getSeekPoint() {
		LinkListNode<Integer> a = this.root;
		LinkListNode<Integer> b = this.root;
		a = a.next();
		b = b.next().next();
		while (true) {
			a = a.next();
			b = b.next();
			if (b == null) {
				return null;
			}
			if (a == b && b != null) {
				return b;
			}
			b = b.next();
			if (b == null) {
				return null;
			}
			if (a == b && b != null) {
				return b;
			}
		}
	}

	public boolean isHasRound() {
		return this.getSeekPoint() != null;
	}
}

class LinkListNode<T> {
	private LinkListNode<T> next = null;
	private T data;

	public LinkListNode(T data, LinkListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public LinkListNode<T> next() {
		return next;
	}

	public LinkListNode<T> next(LinkListNode<T> next) {
		this.next = next;
		return next;
	}

	public T data() {
		return this.data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}