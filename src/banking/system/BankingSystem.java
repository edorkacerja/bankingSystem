/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.system;

public class BankingSystem {
    public static void main(String[] args) {
        
        Costumer edor = new Costumer("edor kacerja", new Account(150));
        Account edorsAccount = edor.getAccount();
        System.out.println(edorsAccount.getBalance());
    }
    
}

class Account{
    private double balance;
    private int accountNumber;
    private boolean firstWithdrawal = true;
    Bank nbg;
    
    Account(){
        balance = 100;
    }
    
    Account(double balanceAmount){
        if(balanceAmount >= 100){
            balance = balanceAmount;
        }else{
            System.out.println("You cannot have a balance lower than 100, so your balance will be 100");
            balance = 100;
        }
    }
    public void withdraw(double amount){
        double tempBalance = balance;
        tempBalance = tempBalance - amount;
        if (tempBalance >= 100){
            
            if(firstWithdrawal){
                balance = tempBalance;    
            }else{
                balance = tempBalance - nbg.getTransactionFees();
            }
            firstWithdrawal = false;
            
        }else{
            System.err.println("Insufficient funds to withdraw "+ amount);
        }
        
        
    };
    public void deposit(double amount ){
        if(amount>0){
            balance += amount;
        }else{
            System.err.println("Sorry but you cannot enter a negative amount to deposit, if you do the math, that would be stupid for your own good rigt?");
        }
        
    };
    public double getBalance(){
        return balance;
    };
    
    
}

class Costumer{
    private String name;
    Account account;
    
    Costumer(String costumerName, Account costumerAccount){
        name = costumerName;
        account = costumerAccount;
    }
    
    public String getName(){
        return name;
    };
    
    public Account getAccount(){
        return account;
    }
    
    
}

class Bank{
    private int TRANSACTION_FEES = 10;
    Costumer costumer;
    
    public void calculateInterest(){
        
    }
    
    public int getTransactionFees(){
        return TRANSACTION_FEES;
    }
    
}