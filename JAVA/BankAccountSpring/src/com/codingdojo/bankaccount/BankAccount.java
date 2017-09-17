package com.codingdojo.bankaccount;
import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {
	protected String accountNumber;
	protected Integer checkingBalance = 0;
	protected Integer savingsBalance = 0;
	protected static int numOfAccts = 0;
	protected static int totalMoney = 0;
	
	//instantiate class
	public BankAccount() {
		accountNumber = createAcctNum();
		numOfAccts ++;
	}
	
	//create a ten digit account number;
	protected String createAcctNum() {
		String acctNum = "";
		for (int i=0; i < 10; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0,10);
			acctNum += String.valueOf(randomNum);
		}
		System.out.println("New bank account number created. Your account number is:" + acctNum);
		return acctNum;
	}
	
	//Deposit money to checking
	public Integer depositChecking(Integer amount) {
		checkingBalance += amount;
		totalMoney += amount;
		System.out.println("You have deposited" + amount + "into your checking account");
		return checkingBalance;
	} 
	//Deposit money to savings
	public Integer depositSavings(Integer amount) {
		savingsBalance += amount;
		totalMoney += amount;
		System.out.println("You have deposited" + amount + "into your savings account");
		return savingsBalance;
	}
	
	//Create a method to withdraw money from one balance. 
	//Do not allow them to withdraw money if there are insufficient funds.	
	public void withdrawChecking(Integer amount) {
		if( checkingBalance >= amount) {
			checkingBalance -= amount;
			totalMoney += amount;
			System.out.println("You have withdrawn" + amount + "from your savings account");
		}
		System.out.println("You have insufficient funds to withdraw that amount. Your current balance is" + checkingBalance);
	}
			
	public void withdrawSavings(Integer amount) {
		if( savingsBalance >= amount) {
			savingsBalance -= amount;
			totalMoney -= amount;
			System.out.println("You have withdrawn" + amount + "from your savings account");
		}
		System.out.println("You have insufficient funds to withdraw that amount. Your current balance is" + checkingBalance);
	}
	
	//Get user's checking account balance
	public Integer getCheckingBal() {
		System.out.println(this.checkingBalance);
		return this.checkingBalance;
	}
	
	//Get user's savings account balance
	public Integer getSavingsBal() {
		System.out.println(this.savingsBalance);
		return this.savingsBalance;
	}

	//keep track of how many accounts have been created
	public static int numOfAccts() {
		System.out.println(numOfAccts);
		return numOfAccts;
	}
	
	//keep track of how much money is in each account
	public static int totalMoneyCount() {
		System.out.println(totalMoney);
		return totalMoney;
	}

}
