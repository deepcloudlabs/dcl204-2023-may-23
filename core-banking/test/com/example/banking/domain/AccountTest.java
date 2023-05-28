package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.example.banking.domain.exception.InsufficientBalanceException;

// CUT: Class Under Test -> Account
class AccountTest {
 
	@DisplayName("Creating Account Object Successfully")
	@ParameterizedTest
	@CsvFileSource(delimiter = ',', resources = "accounts.csv")
	void createAccountObjectSuccessfully(String iban,double balance) {
		Account acc = new Account(iban, balance);
		// verification
		assertAll(
		  () ->  assertEquals(iban, acc.getIban()),
		  () -> assertEquals(balance, acc.getBalance())
		);
	}
	
	@DisplayName("Deposit positive amount successfully")
	@Test
	void depositWithPositiveAmountSuccessfully() {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Calling exercise method
		var balance = acc.deposit(1.0);
		// 3. verification
		assertEquals(1_001.0, balance);
		// 4. tear-down
	}
	
	
	@DisplayName("Deposit negative amount should fail")
	@Test
	void depositWithNegativeAmountFails() {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Calling exercise method
		// 3. verification
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> acc.deposit(-1.0)),
				() -> assertEquals(1_000, acc.getBalance())
		);
		// 4. tear-down
	}
	
	
	@DisplayName("Withdraw with negative amount should fail")
	@Test
	void withdrawWithNegativeAmountShouldFail() {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Calling exercise method
		// 3. verification
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-1.0)),
				() -> assertEquals(1_000, acc.getBalance())
		);
		// 4. tear-down
	}
	
	
	@DisplayName("Withdraw with amount over balance should fail")
	@Test
	void withdrawWithAmountOverBalanceShouldFail() {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000.0);
		// 2. Calling exercise method
		// 3. verification
		assertAll(
				() -> assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(1001.0)),
				() -> assertEquals(1_000, acc.getBalance())
		);
		// 4. tear-down
	}
	
	@DisplayName("Withdraw all balance successfully")
	@Test
	void withdrawAllBalanceShouldSucceed() throws Throwable {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000);
		// 2. Calling exercise method
		var balance = acc.withdraw(1000.0);
		// 3. verification
		assertEquals(0.0, balance);
		// 4. tear-down
	}
	
	@DisplayName("toString() should contain iban and balance values")
	@Test
	void toStringShouldContainIbanAndBalance() {
		// 1. Fixture/Test Setup
		Account acc = new Account("tr1", 1_000.0);
		// 2. Calling exercise method
		String result = acc.toString();
		// 3. verification
		assertTrue(result.contains("Account"));
		assertTrue(result.contains("iban="));
		assertTrue(result.contains("balance="));
		// 4. tear-down
	}	


}
