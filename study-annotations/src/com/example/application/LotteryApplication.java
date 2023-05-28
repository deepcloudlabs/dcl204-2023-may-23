package com.example.application;

import com.example.model.LotteryModel;
import com.example.service.RandomNumberGenerator;

public class LotteryApplication {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		var rng = new RandomNumberGenerator();
		var lotteryModel = new LotteryModel();
		rng.generate(lotteryModel);
		System.out.println(lotteryModel.getNumbers());
	}

}
