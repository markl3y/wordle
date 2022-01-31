package com.techelevator.challenge;

import java.math.BigDecimal;

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
    public SavingsAccount(String accountHolderName, String accountNumber, BigDecimal balance) {
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
    public BigDecimal getBalance() {
        return super.getBalance();
    }

    //METHODS

    //Adds amountToDeposit to the current balance, and returns the new balance of the bank account.
    public BigDecimal deposit(BigDecimal amountToDeposit) {
        super.deposit(amountToDeposit);
        return super.getBalance();
    }


    //OVERRIDES

    //Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account.
    //If the remaining balance is less than $150.00 after a withdrawal is made, an additional $2.00 service charge is withdrawn from the account.
    //If a withdrawal is requested that would result in a negative balance (including the service charge), the withdrawal fails and balance remains the same. No fees are incurred.
    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        super.withdraw(amountToWithdraw);
        if (super.getBalance().compareTo(BigDecimal.valueOf(100.00)) < 0 && super.getBalance().compareTo(BigDecimal.valueOf(2.00)) >= 0) {
            super.withdraw(BigDecimal.valueOf(2.00));
        } else if (super.getBalance().compareTo(BigDecimal.valueOf(2.00)) < 0) {
            super.deposit(amountToWithdraw);
        }
        return super.getBalance();
    }
}

