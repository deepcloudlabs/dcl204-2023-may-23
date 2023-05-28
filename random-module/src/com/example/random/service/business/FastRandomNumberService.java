package com.example.random.service.business;

import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.Quality;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@ServiceQuality(Quality.FAST)
public class FastRandomNumberService implements RandomNumberService {

	@Override
	public int generate(int min, int max) {
		System.err.println("FastRandomNumberService::generate");
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
