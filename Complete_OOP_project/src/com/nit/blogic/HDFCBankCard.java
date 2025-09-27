package com.nit.blogic;

import com.nit.exception.InsufficientFundsException;
import com.nit.exception.InvalidAmountException;

public class HDFCBankCard implements ATMCard{
	
	private BankAccount acc1 = new BankAccount();
	
	@Override
	public void deposit(double amt)
						throws InvalidAmountException{
		acc1.deposit(amt);
	}
	
	@Override
	public void withdraw(double amt)
						throws InvalidAmountException,
								InsufficientFundsException{
		acc1.withdraw(amt);
	}
	
	@Override
	public void currentBalance(){
		acc1.currentBalance();
	}
}