package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

public class StudyTryCatch {

	public static void fun() throws E1, E2 {
		if (ThreadLocalRandom.current().nextBoolean())
			throw new E1();
		else
			throw new E2();
	}
	public static void main(String[] args) throws Exception {
		try {
			fun();
		} catch (E1 | E2 e) { // Java SE 7 : Multi-catch
			System.err.println(e.getClass().getSimpleName());
			throw e; // re-throw
		}
	}
	
}

@SuppressWarnings("serial")
class E1 extends Exception {
}

@SuppressWarnings("serial")
class E2 extends Exception {
}
