package com.nit.blogic;

import com.nit.exception.InsufficientFundsException;
import com.nit.exception.InvalidAmountException;

public interface ATMCard{
	public abstract void deposit(double amount)
						throws InvalidAmountException;
						
	public abstract void withdraw(double amount)
						throws InsufficientFundsException,
									InvalidAmountException;
						
	public abstract void currentBalance();
	
}