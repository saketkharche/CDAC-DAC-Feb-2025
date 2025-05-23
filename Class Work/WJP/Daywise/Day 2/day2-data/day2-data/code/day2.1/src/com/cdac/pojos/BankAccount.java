package com.cdac.pojos;

// id | name | type | bal
public class BankAccount {
	private int accountId;
	private String customerName;
	private String acType;
	private double balance;
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	//getters n setters 
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", customerName=" + customerName + ", acType=" + acType
				+ ", balance=" + balance + "]";
	}
	
}
