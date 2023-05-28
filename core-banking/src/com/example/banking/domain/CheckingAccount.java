package com.example.banking.domain;

import com.example.banking.domain.exception.InsufficientBalanceException;

// Account: superclass/base-class
// CheckingAccount: subclass/derived-class
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public double withdraw(double amount) throws InsufficientBalanceException {
		System.out.println("CheckingAccount::withdraw");
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException("Amount must be positive.");
		// business rule
		if (amount > (this.balance + this.overdraftAmount)) {
			double deficit = amount - this.balance - this.overdraftAmount;
			throw new InsufficientBalanceException("Your balance does not cover your expenses.", deficit);
		}
		this.balance = this.balance - amount;
		return this.balance;
	}

	@Override
	public String toString() {
		return "CheckingAccount [overdraftAmount=" + overdraftAmount + ", balance=" + balance + ", iban=" + getIban()
				+ "]";
	}

}
