package com.techelevator;

public class BankAccount {

    //INSTANCE VARIABLES

    private String accountHolderName;
    private String accountNumber;
    private int balance = 0;

    //CONSTRUCTORS

    //Init
    public BankAccount() {}

    // A new bank account requires an account holder name and account number. The balance defaults to a 0 dollar balance if not specified.
    public BankAccount(String accountHolderName, String accountNumber)	{
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

   	//A new bank account requires an account holder name and account number. The balance is initialized to the dollar balance given.
    public BankAccount(String accountHolderName, String accountNumber, int balance) {
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
    public int getBalance(){
        return balance;
    }

    //METHODS

    //Adds amountToDeposit to the current balance, and returns the new balance of the bank account.
    public int deposit(int amountToDeposit) {
        this.balance += amountToDeposit;
        return balance;
    }

    //Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account.
    public int withdraw(int amountToWithdraw) {
        this.balance -= amountToWithdraw;
        return balance;
    }
}
