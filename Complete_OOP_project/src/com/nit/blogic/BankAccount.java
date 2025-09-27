package com.nit.blogic;

import com.nit.exception.InsufficientFundsException;
import com.nit.exception.InvalidAmountException;

public class BankAccount{
	private double balance;
	
		public void deposit(double amt)
						throws InvalidAmountException{
		
				if(amt < 0){
					throw new InvalidAmountException(
										"Negative ammount is not allowed");
				}
			this.balance = this.balance+amt;
		}

		public void withdraw(double amt)
						throws InvalidAmountException,
									InsufficientFundsException{
										
				if(amt < 0){
					throw new InvalidAmountException(
										"Negative ammount is not allowed");
				}
			this.balance = this.balance-amt;
		}

		public void currentBalance(){
			System.out.println("Current balance: "+balance);
		}
}
