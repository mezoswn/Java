package com.axsosacademy.bankaccountassgiment;

public class BankAccountTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount bankAccount1 = new BankAccount();
		BankAccount bankAccount2 = new BankAccount();
		
		//should be random/ 0 / 0 / 2 / 0
		System.out.println(bankAccount1.getAccountNumber());
		System.out.println(bankAccount1.getCheckingBalance());
		System.out.println(bankAccount1.getSavingBalance());
//		System.out.println(BankAccount.getAccounts()); when it is private
		System.out.println(BankAccount.accounts); //because public
		System.out.println(BankAccount.getTotalAmount());
		
		bankAccount2.deposit("savingBalance", 10000);
		//should be random/ 0 / 0 / 10000 / 2 / 10000
		System.out.println(bankAccount2.getAccountNumber());
		System.out.println(bankAccount2.getCheckingBalance());
		System.out.println(bankAccount2.getSavingBalance());
//		System.out.println(BankAccount.getAccounts());
		System.out.println(BankAccount.accounts);
		System.out.println(BankAccount.getTotalAmount());
		
		//should be insufficient funds
		bankAccount2.withdraw("savingBalance", 11000);
		
		
		bankAccount2.withdraw("savingBalance", 5000);
		//should be 5000
		System.out.println(bankAccount2.getSavingBalance());
		//should be 5000
		System.out.println(BankAccount.getTotalAmount());
		
	}


}
