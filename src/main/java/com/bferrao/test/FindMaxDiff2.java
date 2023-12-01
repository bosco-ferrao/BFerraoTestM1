package com.bferrao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FindMaxDiff2 {

	private Integer maxDiff(Integer[] arr) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		return set.first() - set.last();
	}

	public static class Student {
		public String name;
		public Integer percentage;
		public Student(String name, Integer percentage) {
			super();
			this.name = name;
			this.percentage = percentage;
		}
	}

	public static class Employee {
		private static Integer incId = Integer.valueOf(1);
		public Integer id;
		public String name;

		public Employee(String name) {
			id = incId++;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}
		
		
	}

	public static void main(String[] args) {
		Integer[] arr = { 5, 10, -10, 25, -20 };

		System.out.println(new FindMaxDiff2().maxDiff(arr));

		// List of students
		// Which students are having more than 60% is Java

		List<Student> arr2 = new ArrayList<Student>();
		arr2.add(new Student("Name1", 70));
		arr2.add(new Student("Name2", 50));
		arr2.add(new Student("Name3", 71));

		Set<Employee> employees = arr2.stream().filter((student) -> student.percentage >= 60).map(student -> new Employee(student.name))
				.collect(Collectors.toSet());
		System.out.println(employees);

	}

}
