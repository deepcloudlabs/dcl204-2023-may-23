package com.example.banking.application;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.example.banking.domain.Account;

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
		
	} // end of scope -> acc1
}
