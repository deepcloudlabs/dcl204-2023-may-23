package com.example.primitives;

import java.math.BigInteger;

@SuppressWarnings("unused")
public class IntegralTypes {
	public static void main(String[] args) {
		long arr[] = { 1, 2, 3, 4 }; // 100M -> 800M
		byte barr[] = {}; // 100M -> 100M
		// byte: 1-Byte, [-128..127]
		byte b = 127;
		b++; // b = (byte)(b + 1)
		System.out.println("b=%d".formatted(b));
		b = -128;
		if (b == Byte.MIN_VALUE) {
			short ss = b;
			ss--;
			System.out.println("ss=%d".formatted(ss));
		}
		// short: 2-byte, [-32768..32767]
		short s = Short.MAX_VALUE;
		s++;
		System.out.println("s=%d".formatted(s));
		s = Short.MIN_VALUE;
		s--;
		System.out.println("s=%d".formatted(s));
		// int: 4-byte, [-2147483648..2147483647]
		int i = Integer.MAX_VALUE;
		i++;
		System.out.println("i=%d".formatted(i));
		i = Integer.MIN_VALUE;
		i--;
		System.out.println("i=%d".formatted(i));
		// long: 8-byte, [-9223372036854775808..9223372036854775807]
		long l = Long.MAX_VALUE;
		l++;
		System.out.println("l=%d".formatted(l));
		l = Long.MIN_VALUE;
		l--;
		System.out.println("l=%d".formatted(l));
		// BigInteger: Immutability
		BigInteger veryLongInteger = BigInteger.valueOf(Long.MAX_VALUE);
		System.out.println(veryLongInteger);
		veryLongInteger = veryLongInteger.add(BigInteger.ONE);
		System.out.println(veryLongInteger);
		String name = "jack";
		String upperCaseName = name.toUpperCase();
		System.out.println(name);
		System.out.println(upperCaseName);
		byte u = 3, v = 5;
		int w = u + v;
		System.out.println("w=%d".formatted(w));
		// JLS
		l = Integer.MAX_VALUE + 1L;
		System.out.println("l=%d".formatted(l));
	}
}
