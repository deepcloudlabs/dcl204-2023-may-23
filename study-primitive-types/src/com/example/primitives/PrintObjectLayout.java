package com.example.primitives;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class PrintObjectLayout {
	// -XX:-UseCompressedOops
	public static void main(String[] args) {
		// 1M int[] -> 12 + 4 + 1M * 4 = 4M + 16B
		// 1M double[] -> 12 + 4 + 1M * 8 = 8M + 16B
		System.out.println(VM.current().details());
		System.out.println(ClassLayout.parseClass(int[].class).toPrintable());

	}

}
