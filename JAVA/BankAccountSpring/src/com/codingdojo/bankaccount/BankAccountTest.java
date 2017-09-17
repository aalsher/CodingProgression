package com.codingdojo.bankaccount;

public class BankAccountTest extends BankAccount {

	public static void main(String[] args) {
		BankAccount aminasAcct = new BankAccount();
		aminasAcct.depositChecking(7000);
		aminasAcct.depositSavings(14000);
		aminasAcct.withdrawChecking(50);
		aminasAcct.withdrawSavings(14500);
		aminasAcct.getCheckingBal();
		aminasAcct.getSavingsBal();
		BankAccount.numOfAccts();
		BankAccount.totalMoneyCount();
	}
}
