package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

@SuppressWarnings("unused")
public class StudyPolymorphism {

	public static void main(String[] args) {
		Account account; // (2)
		if (ThreadLocalRandom.current().nextBoolean())
			account = new Account("tr1", 10_000);
		else
			account = new CheckingAccount("tr2", 20_000, 1_000);
		System.out.println(account.getClass().getName());
		account.withdraw(1_000); // (3) polymorphic call
		System.out.println(account);
		Object o;
		o = 42;
		o = true;
		o = "jack";
		o = new int[6];
		o = new Account("tr1",100_000);
		
	}

}
