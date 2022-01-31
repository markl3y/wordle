package com.techelevator;

public class SavingsAccount extends BankAccount {
//CONSTRUCTORS

    //Init from parent.
    public SavingsAccount() {
        super();
    }

    //Call parent constructor.
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    //Call parent constructor.
    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //GETS

    //Returns the account holder name that the account belongs to.
    public String getAccountHolderName() {
        return super.getAccountHolderName();
    }

    //Returns the account number that the account belongs to.
    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    //Returns the balance value of the bank account in dollars.
    public int getBalance() {
        return super.getBalance();
    }

    //METHODS

    //Adds amountToDeposit to the current balance, and returns the new balance of the bank account.
    public int deposit(int amountToDeposit) {
        super.deposit(amountToDeposit);
        return super.getBalance();
    }


    //OVERRIDES

    //Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account.
    //If the remaining balance is less than $150.00 after a withdrawal is made, an additional $2.00 service charge is withdrawn from the account.
    //If a withdrawal is requested that would result in a negative balance (including the service charge), the withdrawal fails and balance remains the same. No fees are incurred.
    @Override
    public int withdraw(int amountToWithdraw) {
        super.withdraw(amountToWithdraw);
        if (super.getBalance() < 150 && super.getBalance() >= 2) {
            super.withdraw(2);
        } else if (super.getBalance() < 2) {
            super.deposit(amountToWithdraw);
        }
        return super.getBalance();
    }
}
