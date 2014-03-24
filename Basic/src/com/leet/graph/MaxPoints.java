package com.leet.graph;

import java.util.HashMap;
import java.util.Map;

import com.leet.Point;

public class MaxPoints {
	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		}
		if (points.length <= 2) {
			return points.length;
		}
		int max = 0;
		int[] vArr = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			vArr[i] = 1;
		}
		int dup = 0;
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		for (int i = 0; i < points.length; i++) {
			map.clear();
			dup = 0;
			Point x1 = points[i];
			for (int j = i + 1; j < points.length; j++) {
				Point x2 = points[j];
				if (x1.x == x2.x) {
					if (x1.y != x2.y) {
						vArr[i] = vArr[i] + 1;
						if (vArr[i] > max) {
							max = vArr[i];
						}
					} else {
						dup++;
					}
				} else {
					double t = 0;
					if (x2.y != x1.y) {
						t = (x2.y - x1.y) / (double) (x2.x - x1.x);
					}

					Integer nb = map.get(t);
					if (nb == null) {
						nb = 1;
					}
					nb = nb + 1;
					map.put(t, nb);
					if (nb > max) {
						max = nb;
					}
				}
			}
			max = max + dup;
		}
		return max;
	}

	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(-1, -1);
		Point p3 = new Point(2, 2);

		Point[] parr = new Point[] { p1, p2, p3 };

		System.out.println(new MaxPoints().maxPoints(parr));

		p1 = new Point(0, 0);
		p2 = new Point(1, 1);
		p3 = new Point(0, 0);
		parr = new Point[] { p1, p2, p3 };
		System.out.println(new MaxPoints().maxPoints(parr));

		p1 = new Point(2, 3);
		p2 = new Point(3, 3);
		p3 = new Point(-5, 3);
		parr = new Point[] { p1, p2, p3 };
		System.out.println(new MaxPoints().maxPoints(parr));
	}
}