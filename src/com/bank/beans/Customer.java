package com.bank.beans;

import java.util.TreeSet;

public class Customer implements Comparable{
	private int custId;
	private String firstName = "NA";
	private String lastName = "NA";
	private String name = "";
	private String address1 = "";
	private long pin = 000000;
	private String mobileNo = "0123456789";
	private TreeSet<Account> accounts = null;
	private Account account = null;

	public Customer() {
		accounts = new TreeSet<>();
	}

	public Customer(int custId, String name) {
		this.custId = custId;
		this.name = name;
		accounts = new TreeSet<>();
	}

	public Customer(int custId, String firstName, String lastName) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = firstName + lastName;
		accounts = new TreeSet<>();
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TreeSet<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(TreeSet<Account> accounts) {
		this.accounts = accounts;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getCustId() {
		return custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String fName, String lName) {
		this.name = fName + lName;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		return this.custId - ((Customer)o).custId;
	}

}
