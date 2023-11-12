package com.bferrao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestBosTestM1 {
	BosTestM1 bosTestM1 = new BosTestM1();
	
	@Test
	public void TestAddPositiveNumbers() {
		//given
		int a = 1;
		int b = 2;
		
		//when
		int sum = bosTestM1.add(a, b);
		
		//then
		assertEquals(3, sum);
	}
	
	@Test
	public void TestAddPositiveNumberNegativeNumber() {
		//given
		int a = 1;
		int b = -2;
		
		//when
		int sum = bosTestM1.add(a, b);
		
		//then
		assertEquals(-1, sum);
	}
	
	@Test
	public void TestAddNegativeNumbers() {
		//given
		int a = -1;
		int b = -2;
		
		//when
		int sum = bosTestM1.add(a, b);
		
		//then
		assertEquals(-3, sum);
	}

}
