package com.techelevator;

public class CreditCardAccount implements Accountable {

    //INSTANCE VARS

    private String accountHolder;
    private String accountNumber;
    private int debt = 0;

    //CONST

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    //GETS

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return -1 * debt;
    }

    public int getDebt() {
        return debt;
    }

    //METHODS

    //pay(int amountToPay)	int	Removes amountToPay from the amount owed and returns the new total amount owed.
    public int pay(int amountToPay) {
        debt -= amountToPay;
        return debt;
    }

    //charge(int amountToCharge)	int	Adds amountToCharge to the amount owed, and returns the new total amount owed.
    public int charge(int amountToCharge) {
        debt += amountToCharge;
        return debt;
    }

}
