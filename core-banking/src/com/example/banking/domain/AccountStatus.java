package com.example.banking.domain;

public enum AccountStatus {
	CLOSED(100), ACTIVE(200), BLOCKED(300);
	
	private final int code;

	private AccountStatus(final int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
}
