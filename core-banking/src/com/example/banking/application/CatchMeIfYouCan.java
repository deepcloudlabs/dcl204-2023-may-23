package com.example.banking.application;

@SuppressWarnings("finally")
public class CatchMeIfYouCan {

	public static int fun() {
		try {
			throw new IllegalArgumentException("oopps");
			//return 42;
		} catch (Exception e) {
			return 108;
		} finally {
			return 75;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(fun());
	}

}
