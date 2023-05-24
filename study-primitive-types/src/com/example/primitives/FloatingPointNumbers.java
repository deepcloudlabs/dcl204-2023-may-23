package com.example.primitives;

import java.math.BigDecimal;

public class FloatingPointNumbers {

	public static void main(String[] args) {
		// float: 4-byte
		float f = 3.141516F;
		// double: 8-byte
		double g = 3.141516;
		f = 1_000_000_000;
		System.out.println("f=%16.16f".formatted(f));
		f = f + 50;
		System.out.println("f=%16.16f".formatted(f));
		g = 4.35;
		g = g * 100;
		System.out.println("g=%16.16f".formatted(g));
		double x = 0/0.;
		System.out.println("x=%f".formatted(x));
		x++;
		System.out.println("x=%f".formatted(x));
		if (Double.isNaN(x))
			System.out.println("x is NOT NaN");
		else
			System.out.println("x is NaN");
		System.out.println("x==x: "+(x==x));
		// BigDecimal: immutable
		BigDecimal money = BigDecimal.valueOf(2.0);
		money = money.subtract(BigDecimal.valueOf(1.1));
		System.out.println(money);
	}

}
