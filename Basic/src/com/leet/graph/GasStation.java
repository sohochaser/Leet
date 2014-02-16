package com.leet.graph;

/**
 * <ol>
 * <li>There are N gas stations along a circular route, where the amount of gas
 * at station i is gas[i].
 * 
 * <li>You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * <li>Return the starting gas station's index if you can travel around the
 * circuit once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique
 * </ol>
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length <= 1) {
			if (gas.length == 0) {
				return -1;
			}
			if (gas[0] < cost[0]) {
				return -1;
			} else {
				return 0;
			}
		}
		int total = 0;
		int[] need = new int[gas.length];
		for (int i = 0; i < gas.length; i++) {
			need[i] = gas[i] - cost[i];
			total += need[i];
		}

		if (total < 0) {
			return -1;
		}

		int max = Integer.MIN_VALUE;
		int idx = 0;
		int sum = 0;
		for (int i = 0; i < need.length; i++) {
			sum += need[i];
			if ((total - sum) > max) {
				max =( total - sum);
				idx = i;
			}
		}
		return idx+1;
	}

	public static void main(String[] args) {
		int[] gas = new int[] { 1, 2 };
		int[] cost = new int[] { 2, 1 };
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));// 1

		gas = new int[] { 2, 4 };
		cost = new int[] { 3, 4 };
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));// -1

		gas = new int[] { 1, 2, 3, 4, 5 };
		cost = new int[] { 3, 4, 5, 1, 2 };
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));// 3

		gas = new int[] { 2, 3, 1 };
		cost = new int[] { 3, 1, 2 };
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));// 1

	}
}