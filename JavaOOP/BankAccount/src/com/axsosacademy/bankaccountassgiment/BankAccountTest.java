package com.axsosacademy.bankaccountassgiment;

public class BankAccountTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount baraSalameh = new BankAccount();
		BankAccount khalilKhalil = new BankAccount();
		
		//should be random/ 0 / 0 / 2 / 0
		System.out.println(baraSalameh.getAccountNumber());
		System.out.println(baraSalameh.getCheckingBalance());
		System.out.println(baraSalameh.getSavingBalance());
		System.out.println(BankAccount.getAccounts());
		System.out.println(BankAccount.getTotalAmount());
		
		khalilKhalil.deposit("savingBalance", 10000);
		//should be random/ 0 / 0 / 10000 / 2 / 10000
		System.out.println(khalilKhalil.getAccountNumber());
		System.out.println(khalilKhalil.getCheckingBalance());
		System.out.println(khalilKhalil.getSavingBalance());
		System.out.println(BankAccount.getAccounts());
		System.out.println(BankAccount.getTotalAmount());
		
		//should be insufficient funds
		khalilKhalil.withdraw("savingBalance", 11000);
		
		
		khalilKhalil.withdraw("savingBalance", 5000);
		//should be 5000
		System.out.println(khalilKhalil.getSavingBalance());
		//should be 5000
		System.out.println(BankAccount.getTotalAmount());
	}


}
