package com.example.banking.application;

import static com.example.banking.domain.Account.getCounter;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

@SuppressWarnings("static-access")
public class StudyStatic {
	
	public static void main(String[] args) {
		Account acc = null;
		System.out.println(getCounter());
		System.out.println(acc.getCounter());
		System.out.println(((Account)null).getCounter());
		//System.out.println(((Account)null).withdraw(1));
		new Account("tr1", 1_000);
		new CheckingAccount("tr1", 1_000,500);
		new Account("tr1", 1_000);
		new CheckingAccount("tr1", 1_000,500);
		new Account("tr1", 1_000);
		System.out.println(getCounter());
	}

}
