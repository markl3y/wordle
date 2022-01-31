package com.techelevator;

public class CheckingAccount extends BankAccount {

    //CONSTRUCTORS

    //Init from parent.
    public CheckingAccount() {
        super();
    }

    //Call parent constructor.
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //GETS

    //Returns the account holder name that the account belongs to.
    public String getAccountHolderName() {
        return super.getAccountHolderName();
    }

    //Returns the account number that the account belongs to.
    public String getAccountNumber(){
        return super.getAccountNumber();
    }

    //Returns the balance value of the bank account in dollars.
    public int getBalance(){
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
    //A request to overdraw a checking account by $100.00 or more (before overdraft fee) fails and the balance remains the same.
    //For example, if the current balance is -$89.00, and the amount to withdraw is $10.00, the resulting balance is -$99.00. The withdrawal is permitted since the new balance is greater than -$100.00.
    //The $10.00 overdraft fee is then charged against the account, resulting in a final balance of -$109.00.
    //A withdrawal of $11.00 in the same situation fails because the new balance would be -$100.00 which is equal to, not greater than, the lower limit of -$100.00.
    @Override
    public int withdraw(int amountToWithdraw) {
        super.withdraw(amountToWithdraw);
        if (super.getBalance() < 0 && super.getBalance() > -100) {
            super.withdraw(10);
        } else if (super.getBalance() < -100) {
            super.deposit(amountToWithdraw);
        }
        return super.getBalance();
    }






}
