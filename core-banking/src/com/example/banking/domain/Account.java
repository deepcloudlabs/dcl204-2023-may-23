package com.example.banking.domain;
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
// Members: i) Attribute/State/Data/Property
	private String iban;
	protected double balance; // Invariance: balance >= 0
	private AccountStatus status = AccountStatus.ACTIVE; 
//         ii) Method/Behavior/Function
	// constructor -> initializing object state
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
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
	public boolean deposit(double amount) {
		// validation
		if (amount <= 0.0)
			return false;
        this.balance = this.balance + amount;
        return true;
	}

	public boolean withdraw(double amount) {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0.0)
			return false;
		// business rule
		if (amount > this.balance)
			return false;
		this.balance = this.balance - amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
	
}