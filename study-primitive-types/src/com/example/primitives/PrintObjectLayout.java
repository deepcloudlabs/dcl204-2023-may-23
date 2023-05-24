package com.example.primitives;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class PrintObjectLayout {
	// -XX:-UseCompressedOops
	public static void main(String[] args) {
		System.out.println(VM.current().details());
		System.out.println(ClassLayout.parseClass(A.class).toPrintable());

	}

}
