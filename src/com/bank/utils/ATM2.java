package com.bank.utils;

import com.bank.beans.Account;
import com.bank.beans.Customer;

public class ATM2 extends Thread {
	private Customer customer;
	private Account toAccount;
	private String name ="" ;

	public ATM2(Customer customer, String name) {
		this.customer = customer;
		this.name = name;
	}

	public ATM2(Customer customer, Account toAccount, String name) {
		this.customer = customer;
		this.toAccount = toAccount;
		this.name = name;
	}

	@Override
	public void run() {
		Account acc = customer.getAccount();

		// SLEEP FOR SOME TIME
		try {
			acc.deposit(1000,name);
			  Thread.sleep(1000);
//			acc.transferToAccount(toAccount, 250, name);
//			  Thread.sleep(2000);
			acc.withdraw(500,name);
			  Thread.sleep(1000);
			acc.withdraw(500,name);
			  Thread.sleep(1000);
			acc.deposit(500,name);
			
			System.out.println("Final balance of "+customer.getName()+" = "+acc.getBalance());
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}
}
