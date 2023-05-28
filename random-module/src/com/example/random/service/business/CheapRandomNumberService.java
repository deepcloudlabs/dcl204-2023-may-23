package com.example.random.service.business;

import java.util.Random;

import com.example.random.service.Quality;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@ServiceQuality(Quality.CHEAP)
public class CheapRandomNumberService implements RandomNumberService {
	Random random = new Random();

	@Override
	public int generate(int min, int max) {
		System.err.println("CheapRandomNumberService::generate");
		return random.nextInt(min, max);
	}

}
