package com.bank.beans;

public class Account implements Comparable{

	private long accountNo = 0000_0000;
	private double balance = 0;
	public int custId;
	public Customer customer = null;

	public Account(long accountNo, Customer customer) {
		this.accountNo = accountNo;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	synchronized public void deposit(double amount, String branch) {
		// READ BALANCE
		double balance = this.balance;

		// MODIFY BALANCE
		try {
			System.out.println("\n\n"+branch+" : "+customer.getName() + " " + " is try to deposit Rs. = "+amount);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			balance = balance + amount;
			System.out.println(branch+" : "+customer.getName() + " " + " deposited. \n***  New Balance in "+accountNo+" = " + balance);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// UPDATE BALANCE
		this.balance = balance;

	}

	synchronized public void withdraw(double amount, String branch) {
		try {

			if (balance >= amount) {
				System.out.println("\n\n"+branch+" : "+customer.getName() + " " + "is try to withdraw Rs. "+amount);
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance = balance - amount;
				System.out.println(branch+" : "+customer.getName() + " " + "is complete the withdraw.\n*** New Balance in "+this.accountNo+" = "+balance);
			} else {
				System.out.println(branch+" : "+customer.getName() + " " + "doesn't have enough money for withdraw ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void transferToAccount(Account toAccount, int amount,String branch){
		
		if(toAccount != null){
			System.out.println("\n######\n Before transfer:- \nBalance in "+this.accountNo+" = "+this.balance+"  ||  Balance in "+toAccount.getAccountNo()+" = "+toAccount.balance);
			this.withdraw(amount, branch);
			toAccount.deposit(amount, branch);
			System.out.println("After transfer:- \nBalance in "+this.accountNo+" = "+this.balance+"  ||  Balance in "+toAccount.getAccountNo()+" = "+toAccount.balance+"\n########");
		}else{
			System.out.println("Invalid account no. ");
		}
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public int compareTo(Object o) {
		return this.custId - ((Account)o).custId;
	}

}
