package com.example.random.service.business;

import java.security.SecureRandom;

import com.example.random.service.Quality;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@ServiceQuality(Quality.SECURE)
public class SecureRandomNumberService implements RandomNumberService {

	private SecureRandom random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.err.println("SecureRandomNumberService::generate");
		return random.nextInt(min, max);
	}

}
