package com.bferrao.test;

import java.util.Arrays;

/**
 * Find the smallest missing element in an array
 * 
 * @author Bosco.F
 *
 */
class SmallestMissingElementInArray {
	public int solution(int[] A) {
		int[] copiedArray = new int[A.length];
		System.arraycopy(A, 0, copiedArray, 0, A.length);
		Arrays.sort(copiedArray);

		int ismall = copiedArray[0];
		int ismallest = ismall;
		int imax = copiedArray[copiedArray.length - 1];
		int j = 0;
		boolean flag = true;
		for (int i = ismall; i <= imax; i++) {
			if (j < copiedArray.length && copiedArray[j] != i) {
				ismallest = i;
				flag = false;
			}
			j++;
		}
		if (flag) {
			ismallest = imax+1;
		}
		if (ismallest < 0) {
			ismallest = 1;
		}

		return ismallest;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };

		System.out.println(new SmallestMissingElementInArray().solution(A));
		
		int[] A2 = { -1, -3 };

		System.out.println(new SmallestMissingElementInArray().solution(A2));
	}
}