package com.bferrao.test;

import java.util.TreeSet;

class FindMaxDiff {
	public int solution(int[] A) {
		int[] copiedArray = new int[A.length];
		System.arraycopy(A, 0, copiedArray, 0, A.length);

		TreeSet<Integer> curSet = new TreeSet<Integer>();
		int i = 0;
		do {
			if (i == copiedArray.length - 1) {
				break;
			}
			int diff = copiedArray[i + 1] - copiedArray[i];
			if (diff >= 0) {
				curSet.add(diff);
			}
			i++;
		} while (i < copiedArray.length);
		System.out.println(curSet);

		return curSet.last();
	}

	public static void main(String[] args) {
		int[] A = { 4, 7, 1, 5, 3 };

		System.out.println(new FindMaxDiff().solution(A));

		int[] A2 = { 12, 12, 12, 15, 10 };

		System.out.println(new FindMaxDiff().solution(A2));

		int[] A3 = { 18, 26, 18, 24, 24, 20, 22 };

		System.out.println(new FindMaxDiff().solution(A3));
	}
}