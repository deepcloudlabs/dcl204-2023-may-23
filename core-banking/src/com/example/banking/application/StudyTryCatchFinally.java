package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

public class StudyTryCatchFinally {

	public static int fun() throws E1, E2 {
		if (ThreadLocalRandom.current().nextBoolean())
			throw new E1();
		if (ThreadLocalRandom.current().nextBoolean())
			throw new E2();
		return 42;
	}
	public static void main(String[] args) throws Exception {
		
		try {
			var result = fun();
			System.out.println(result);
		} catch (E1 | E2 e) { // Java SE 7 : Multi-catch
			System.err.println(e.getClass().getSimpleName());
			throw e; // re-throw
		} finally {
			System.err.println("Finally, we have arrived here!");
		}
	}
	
}

