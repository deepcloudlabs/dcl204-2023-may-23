package com.example.lottery.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.Quality;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class LotteryApplication {
	private static ServiceLoader<RandomNumberService> services = 
			ServiceLoader.load(RandomNumberService.class);
	public static void main(String[] args) {
		var lotteryService = new StandardLotteryService();
		var randomNumberService = getRandomNumberService();
		randomNumberService.ifPresent( service -> {
			lotteryService.setRandomNumberService(service);
			lotteryService.draw(60, 6, 10).forEach(System.out::println);
		});		
	}

	private static Optional<RandomNumberService> getRandomNumberService() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(new File("src","application.properties")));
			String qualityString = props.getProperty("service.quality");
			var quality = Quality.valueOf(qualityString);
			for (var service : services) {
				var clazz = service.getClass();
				if (clazz.isAnnotationPresent(ServiceQuality.class)) {
					var serviceQuality = clazz.getAnnotation(ServiceQuality.class);
					if (serviceQuality.value() == quality)
						return Optional.of(service);
				}
			}
		} catch (IOException e) {
			System.err.println("Error has occured: "+e.getMessage());
		}		
		return Optional.empty();
	}

}
