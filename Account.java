package com.lti.p2;

import org.springframework.stereotype.Component;

@Component("acct")
public class Account{
	double balance;
	public Account() {
		System.out.println("Default constructor");
	}
	public Account(double balance){
		System.out.println("Parameterised constructor");
		this.balance=balance;
	}
	
	public double deposit(double amount) throws AmountException{
		
			if(amount<0) {
				throw new AmountException("Invalid amount Exception");
			}
			else {
				System.out.println("Balance: Rs."+balance);
				this.balance=this.balance+amount;
				System.out.println("Money deposited: Rs."+amount);	
			}
		return this.balance;
		
	}
	
	public double withdraw(double amount) throws BalanceException, AmountException {
		
		if(amount<0 ) {
			throw new AmountException("Invalid amount Exception");
		}
		else {
		
			if(this.balance<0 || this.balance-amount<0) {
				throw new BalanceException("Invalid Balance Exception");
				}
			else {
				System.out.println("Balance: Rs."+balance);
				this.balance=this.balance-amount;
			System.out.println("Withdrawn money: Rs."+amount);
			}
		}
		return this.balance;
	}
	
}
class AmountException extends Exception {
	public AmountException(String message) {
		super(message);
	}
}
class BalanceException extends Exception {
	public BalanceException(String message) {
		super(message);
	}
}
