package com.nit.exception;

public class InvalidAmountException extends Exception{
	
	public InvalidAmountException(){
		super();
	}
	
	public InvalidAmountException(String errMsg){
		super(errMsg);
	}
}