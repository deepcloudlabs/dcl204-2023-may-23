package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String identity;
	private String fullname;
	private List<Account> accounts = new ArrayList<>();
}
