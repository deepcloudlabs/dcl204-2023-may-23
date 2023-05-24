package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

// CUT: Class Under Test -> Account
class AccountTest {

	@DisplayName("Creating Account Object Successfully")
	@ParameterizedTest
	@CsvFileSource(delimiter = ',', resources = "accounts.csv")
	void createAccountObjectSuccessfully(String iban,double balance) {
		Account acc = new Account(iban, balance);
		// verification
		assertEquals(iban, acc.getIban());
		assertEquals(balance, acc.getBalance());
	}
	
	@DisplayName("Deposit positive amount successfully")
	@Test
	void depositWithPositiveAmountSuccessfully() {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Calling exercise method
		boolean result = acc.deposit(1.0);
		// 3. verification
		assertEquals(1_001.0, acc.getBalance());
		assertTrue(result);
		// 4. tear-down
	}
	
	
	@DisplayName("Deposit negative amount fails")
	@Test
	void depositWithNegativeAmountFails() {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Calling exercise method
		boolean result = acc.deposit(-1.0);
		// 3. verification
		assertEquals(1_000.0, acc.getBalance());
		assertFalse(result);
		// 4. tear-down
	}
	
	


}
