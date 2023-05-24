package com.example.primitives;

public class StudyChar {

	public static void main(String[] args) {
		char x = 'f'; // 2-byte, unsigned int, unicode
		x= 104;
		System.out.println(x);
        x = '\u20ba';
        System.out.println(x);
	}

}
