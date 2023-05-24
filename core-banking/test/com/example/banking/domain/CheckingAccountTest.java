package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CheckingAccountTest {

	@DisplayName("Creating CheckingAccount Object Successfully")
	@ParameterizedTest
	@CsvFileSource(delimiter = ',', resources = "checking-accounts.csv")
	void createAccountObjectSuccessfully(String iban, double balance, double overdraftAmount) {
		CheckingAccount acc = new CheckingAccount(iban, balance, overdraftAmount);
		// verification
		assertAll(() -> assertEquals(iban, acc.getIban()), () -> assertEquals(balance, acc.getBalance()),
				() -> assertEquals(overdraftAmount, acc.getOverdraftAmount()));
	}

	@DisplayName("Withdraw with negative amount should fail")
	@Test
	void withdrawWithNegativeAmountShouldFail() {
		// 1. Fixture/Test Setup
		CheckingAccount acc = new CheckingAccount("tr1", 1_000, 500.0);
		// 2. Calling exercise method
		boolean result = acc.withdraw(-1.0);
		// 3. verification
		assertEquals(1_000.0, acc.getBalance());
		assertEquals(500.0, acc.getOverdraftAmount());
		assertFalse(result);
		// 4. tear-down
	}

	@DisplayName("Withdraw with amount over balance and overdraft amount should fail")
	@Test
	void withdrawWithAmountOverBalanceAndOverdraftShouldFail() {
		// 1. Fixture/Test Setup
		CheckingAccount acc = new CheckingAccount("tr1", 1_000, 500.0);
		// 2. Calling exercise method
		boolean result = acc.withdraw(1501.1);
		// 3. verification
		assertEquals(1_000.0, acc.getBalance());
		assertEquals(500.0, acc.getOverdraftAmount());
		assertFalse(result);
		// 4. tear-down
	}

	@DisplayName("Withdraw all balance successfully")
	@Test
	void withdrawAllBalanceShouldSucceed() {
		// 1. Fixture/Test Setup
		CheckingAccount acc = new CheckingAccount("tr1", 1_000, 500.0);
		// 2. Calling exercise method
		boolean result = acc.withdraw(1000.0);
		// 3. verification
		assertEquals(0.0, acc.getBalance());
		assertEquals(500.0, acc.getOverdraftAmount());
		assertTrue(result);
		// 4. tear-down
	}
	
	@DisplayName("Withdraw all possible amount successfully")
	@Test
	void withdrawAllPossibleAmountShouldSucceed() {
		// 1. Fixture/Test Setup
		CheckingAccount acc = new CheckingAccount("tr1", 1_000, 500.0);
		// 2. Calling exercise method
		boolean result = acc.withdraw(1500.0);
		// 3. verification
		assertEquals(-500.0, acc.getBalance());
		assertEquals(500.0, acc.getOverdraftAmount());
		assertTrue(result);
		// 4. tear-down
	}
	
	@DisplayName("toString() should contain iban and balance values")
	@Test
	void toStringShouldContainIbanAndBalanceAndOverdraftAmount() {
		// 1. Fixture/Test Setup
		CheckingAccount acc = new CheckingAccount("tr1", 1_000, 500.0);
		// 2. Calling exercise method
		String result = acc.toString();
		// 3. verification
		assertTrue(result.contains("CheckingAccount"));
		assertTrue(result.contains("iban="));
		assertTrue(result.contains("balance="));
		assertTrue(result.contains("overdraftAmount="));
		// 4. tear-down
	}
}
