package com.example.banking.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.example.banking.domain.exception.InsufficientBalanceException;

// Eclipse:

// Alt+Shift+S: Generate Source Code
// Ctrl+Shift+F: Format Source Code
// IntelliJ IDEA:
// Alt+Insert: Generate Source Code
// Ctrl+Alt+L: FormatLa Source Code

// Encapsulation + Information Hiding Principle
// Types: i) Primitive Types (byte, short, int, long, float, double, boolean, char)
//       ii) Class -> Type
// DDD (Domain-Driven Design) 
public class Account extends Object {
	private static int counter;
	static {
		var props = new Properties();
		try {
			props.load(new FileInputStream(new File("src","application.properties")));
			counter = Integer.parseInt(props.getProperty("initial.counter"));
		} catch (IOException e) {
			System.err.println("Error has occured while opening the file: %s".formatted(e.getMessage()));
		}
	}
	public static int getCounter() {
		return counter ;
	}
// Members: i) Attribute/State/Data/Property
	private String iban;
	protected double balance; // Invariance: balance >= 0
	private AccountStatus status = AccountStatus.ACTIVE; 
//         ii) Method/Behavior/Function
	// constructor -> initializing object state
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
		counter++;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}



	// getter
	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public double deposit(double amount)  {
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException("Amount must be positive.");
        this.balance = this.balance + amount;
        return this.balance;
	}

	public double withdraw(double amount) throws InsufficientBalanceException {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException("Amount must be positive.");
		// business rule
		if (amount > this.balance) {
			double deficit = amount - this.balance;
			throw new InsufficientBalanceException("Your balance does not cover your expenses.", deficit);
		}
		this.balance = this.balance - amount;
		return this.balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
	
}