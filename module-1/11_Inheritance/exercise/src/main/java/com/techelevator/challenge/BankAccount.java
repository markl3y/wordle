package com.techelevator.challenge;

import java.math.BigDecimal;

public class BankAccount {

    //INSTANCE VARIABLES

    private String accountHolderName;
    private String accountNumber;
    private BigDecimal balance = BigDecimal.valueOf(0.00);

    //CONSTRUCTORS

    //Init
    public BankAccount() {}

    // A new bank account requires an account holder name and account number. The balance defaults to a 0 dollar balance if not specified.
    public BankAccount(String accountHolderName, String accountNumber)	{
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.valueOf(0.00);
    }

   	//A new bank account requires an account holder name and account number. The balance is initialized to the dollar balance given.
    public BankAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //GETS

    //Returns the account holder name that the account belongs to.
    public String getAccountHolderName(){
        return accountHolderName;
    }

    //Returns the account number that the account belongs to.
    public String getAccountNumber(){
        return accountNumber;
    }

    //Returns the balance value of the bank account in dollars.
    public BigDecimal getBalance(){
        return balance;
    }

    //METHODS

    //Adds amountToDeposit to the current balance, and returns the new balance of the bank account.
    public BigDecimal deposit(BigDecimal amountToDeposit) {
        this.balance = balance.add(amountToDeposit);
        return balance;
    }

    //Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account.
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        this.balance = balance.add(amountToWithdraw);
        return balance;
    }
}
