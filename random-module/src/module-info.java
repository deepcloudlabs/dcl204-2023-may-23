import com.example.random.service.RandomNumberService;
import com.example.random.service.business.CheapRandomNumberService;
import com.example.random.service.business.FastRandomNumberService;
import com.example.random.service.business.SecureRandomNumberService;

module com.example.random {
	exports com.example.random.service;
	provides RandomNumberService 
	with SecureRandomNumberService, FastRandomNumberService, CheapRandomNumberService;
}