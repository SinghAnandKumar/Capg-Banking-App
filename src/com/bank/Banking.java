package com.bank;

import java.util.TreeSet;

import com.bank.beans.Account;
import com.bank.beans.Customer;
import com.bank.utils.ATM1;
import com.bank.utils.ATM2;

public class Banking {

	static TreeSet<Customer> customers = new TreeSet<>();
	static TreeSet<Account> accounts = new TreeSet<>();

	public static void main(String[] args) {

		// Creating a new account for a customer
		Customer customer1 = new Customer(111, "Customer 1");
		customers.add(customer1);
		Account account1 = new Account(1234_5678, customer1);
		accounts.add(account1);
		account1.setCustomer(customer1);
		customer1.setAccount(account1);

		// Creating a new account for a customer
		Customer customer2 = new Customer(111, "Customer 2");
		customers.add(customer2);
		Account account2 = new Account(8765_4321, customer1);
		accounts.add(account2);
		account2.setCustomer(customer2);
		customer2.setAccount(account2);


		ATM1 action1 = new ATM1(customer1,account2,"ATM 1");
		action1.start();
		
		ATM2 action2 = new ATM2(customer2,account1,"ATM 2");
		action2.start();
		
		ATM2 action3 = new ATM2(customer1,account1,"ATM 2");
		action3.start();

		try {
			action1.join();
			action2.join();
			action3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
 * Runnable target = new Runnable(){ public void run(){ try {
 * account1.deposit(2000); } catch (InterruptedException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } } };
 * 
 * Runnable target2 = new Runnable(){ public void run(){ try {
 * account1.deposit(2000); } catch (InterruptedException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } } };
 * 
 * new Thread(target).start(); new Thread(target2).start(); }
 */
