package com.techelevator;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable{
    //name	String	X	X	The account holder name that the account belongs to.
    //address	String	X	X	The address of the customer.
    //phoneNumber	String	X	X	The phone number of the customer.
    //accounts	List<Accountable>	X*		The customer's list of Accountables.

    //INSTANCE VARS

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    //CONST
    public BankCustomer() {
    }

    //SETS

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //GETS

    public int getBalance() {
        int accountsBalance = 0;
        for (Accountable account : accounts) {
            accountsBalance += account.getBalance();
        }
        return accountsBalance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //getAccounts()	Accountable[]	Returns an array of the customer's accounts.
    public Accountable[] getAccounts(){
        Accountable[] accountArray = new Accountable[accounts.size()];
        int counter = 0;
        for (Accountable account : accounts) {
            accountArray[counter] = account;
            counter++;
        }
        return accountArray;
    }

    //METHODS

    //addAccount(Accountable newAccount)	void	Adds newAccount to the customer's list of accounts.
    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    //Customers whose combined account balances (credits minus debts) are at least $25,000
    //are considered VIP customers and receive special privileges.
    //Add a method called isVip to the BankCustomer class that returns true if the sum of
    //all accounts belonging to the customer is at least $25,000 and false otherwise.

    public boolean isVip() {
        return this.getBalance() >= 25000;
    }
}
