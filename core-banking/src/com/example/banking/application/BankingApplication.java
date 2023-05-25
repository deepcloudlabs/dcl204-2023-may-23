package com.example.banking.application;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.Customer;

public class BankingApplication {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Text + Data + Stack + Heap
		//             Heap Object
		Properties props = new Properties();
		props.load(new FileInputStream(new File("src","application.properties")));
		double initialBalance = Double.parseDouble(props.getProperty("initial.balance"));
		// acc1: i) reference variable ii) local/temporary/stack/automatic variable
		Account acc1 = new Account("tr1", initialBalance);
		// acc1: Reference/Stack/Local variable
		
		acc1.deposit(0.2);
		System.out.println("Balance: %8.24f".formatted(acc1.getBalance()));
        System.out.println(acc1.toString()); 
        
        Customer jack = new Customer("11111111110", "jack bauer");
        Account tr1 = new Account("tr1", 100_000);
		jack.addAccount(tr1);
        CheckingAccount tr2 = new CheckingAccount("tr2", 200_000,5_000);
		jack.addAccount(tr2);
        jack.addAccount(new Account("tr3", 300_000));
        // Functional Programming: i) Higher-Order Function (HoF) 
        //                        ii) Pure Function: Lambda Expression
        jack.getAccount("tr3").ifPresent( account -> account.withdraw(50_000) );
		
        Optional<Account> account = jack.getAccount("tr3");
        if (account.isPresent()) {
        	Account acc = account.get();
        	acc.withdraw(50_000);
        }
        System.out.println("Number of accounts: %d".formatted(jack.getNumberOfAccounts()));
        jack.removeAccount(tr1);
        System.out.println("Number of accounts: %d".formatted(jack.getNumberOfAccounts()));        
        jack.removeAccount(tr2);
        System.out.println("Number of accounts: %d".formatted(jack.getNumberOfAccounts()));        
	} // end of scope -> acc1
}
