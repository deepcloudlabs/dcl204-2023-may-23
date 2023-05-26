package com.example.banking.application;

import com.example.banking.domain.AccountStatus;

public class StudyEnum {

	public static void main(String[] args) {
		for (AccountStatus as : AccountStatus.values()) {
			System.out.println("%s: %d, %d(bddk)".formatted(as.name(),as.ordinal(),as.getCode()));
		}

	}

}
