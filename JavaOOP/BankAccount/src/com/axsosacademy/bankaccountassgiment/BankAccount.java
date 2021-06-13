package com.axsosacademy.bankaccountassgiment;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
	private static int accounts = 0;
	private static double totalAmount = 0;
	
	//Constructor
	public BankAccount() {
		BankAccount.accounts += 1;
		BankAccount.totalAmount += savingBalance+checkingBalance;
		this.checkingBalance = 0;
		this.savingBalance = 0;
		this.accountNumber = generateAccountNumber();
	}
	
	//Getters
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	public double getSavingBalance() {
		return this.savingBalance;
	}
	public static int getAccounts() {
		return BankAccount.accounts;
	}
	public static double getTotalAmount() {
		return BankAccount.totalAmount;
	}
	
	public void deposit(String accountName , int depositAmount) {
		if(accountName == "checkingBalance")
			this.checkingBalance += depositAmount;
		if(accountName == "savingBalance")
			this.savingBalance += depositAmount;
		BankAccount.totalAmount += depositAmount;
	}
	
	public void withdraw(String accountName , int withdrawAmount) {
		if(accountName == "checkingBalance")
			if(withdrawAmount > this.checkingBalance)
				System.out.println("insufficient funds");
			else {
				this.checkingBalance -= withdrawAmount;
				BankAccount.totalAmount -= withdrawAmount;
			}
		if(accountName == "savingBalance")
			if(withdrawAmount > this.savingBalance)
				System.out.println("insufficient funds");
			else {
				this.savingBalance -= withdrawAmount;
				BankAccount.totalAmount -= withdrawAmount;
			}
	}
	public void getTotalBalance() {
		System.out.println("Total balance : "+BankAccount.totalAmount);
	}
	private String generateAccountNumber() {
		Random r = new Random();
		String accountNum = new String();
		for (int i = 0 ; i < 10 ; i++) {
			accountNum += r.nextInt(9);
		}
		return accountNum;
	}
}
