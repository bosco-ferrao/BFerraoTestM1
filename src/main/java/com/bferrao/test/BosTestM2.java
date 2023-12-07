package com.bferrao.test;

public class BosTestM2 {

	public static String newList(String[] students) {
		// Insert your code here
		String ans = "";
		int count = 0;
		for (int ci = 0; ci < students.length; ci++) {
			String student = students[ci];
			if (student == null || student.isEmpty() || student == "") {
				ans += ";";
				continue;
			}
			String[] arr = student.split(" ");
			int sum = 0;
			for (int i = 2; i < arr.length; i++) {
				sum += Integer.valueOf(arr[i]);
			}
			int avg = sum / (arr.length - 2);
			if (count == 0) {
				ans = arr[0] + " " + arr[1] + "-" + avg;
			} else {
				ans += ";" + arr[0] + " " + arr[1] + "-" + avg;
			}

			count++;
		}
		ans += ";";

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(newList(new String[] { "Madeline Choi 5 5 6", "Ethan Wyatt 8 9 10", }));

	}

}
