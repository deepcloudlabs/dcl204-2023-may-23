package com.example.model;

import java.util.List;

import com.example.util.RandomNumber;

public class LotteryModel {
	@RandomNumber(min = 1, max = 60, size = 6, distinct = true, sorted = true)
	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

}
