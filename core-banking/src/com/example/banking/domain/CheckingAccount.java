package com.example.banking.domain;

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
	public boolean withdraw(double amount) {
		// validation
		if (amount <= 0.0)
			return false;
		// business rule
		if (amount > (this.balance+this.overdraftAmount))
			return false;
		this.balance = this.balance - amount;
		return true;
	}

	@Override
	public String toString() {
		return "CheckingAccount [overdraftAmount=" + overdraftAmount + ", balance=" + balance + ", iban="
				+ getIban() + "]";
	}

}
