package com.example.primitives;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class StudyWrappers {

	public static void main(String[] args) {
		int i = 42; // 4-byte
		            // boxing
		Integer j = Integer.valueOf(42); // 12-byte + 4-byte (int) = 16-Byte
		    // auto-boxing
		j = 42 ;
		i++;
		j++; // j = Integer.valueOf(j.intValue() + 1);
		System.out.println(i);
		System.out.println(j);
		List<Integer> numbers = new ArrayList<>();
	}

}
