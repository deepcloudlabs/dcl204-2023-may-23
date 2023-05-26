package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer {
	private final String identity;
	private String fullname;
	private final List<Account> accounts = new ArrayList<>();

	public Customer(final String identity, final String fullname) {
		this.identity = identity;
		this.fullname = fullname;
	}

	final public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIdentity() {
		return identity;
	}

	public List<Account> getAccounts() {
		return List.copyOf(accounts);
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	// overloading vs overriding
	public Optional<Account> getAccount(int index) {
		if (index < 0 || index >= accounts.size())
			return Optional.empty();
		return Optional.of(this.accounts.get(index));
	}

	public Optional<Account> getAccount(String iban) {
		for (Account account : this.accounts) {
			if (account.getIban().equals(iban))
				return Optional.of(account);
		}
		return Optional.empty();
	}

	public Optional<Account> getFunctionalAccount(String iban) {
		// Stream API + FP + Filter/Map/Reduce
		return accounts.stream().parallel().filter(account -> account.getIban().equals(iban)).findFirst();
	}

	public int getNumberOfAccounts() {
		return this.accounts.size();
	}

	public Optional<Account> removeAccount(String iban) {
		final Optional<Account> account = getAccount(iban);
		if (account.isEmpty())
			return Optional.empty();
		return this.removeAccount(account.get());			
	}

	public Optional<Account> removeAccount(Account account) {
		if (this.accounts.remove(account))
			return Optional.of(account);
		return Optional.empty();
	}
}
