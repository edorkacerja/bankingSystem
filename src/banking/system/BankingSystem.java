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
        edorsAccount.deposit(1);
        edorsAccount.withdraw(51);
        
        edor.display();
    }
    
}

class Account{
    private double balance;
    private String accountNumber;
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
                System.out.println("successfully withdrawn "+ amount + "\n No Transaction fees withheld.");
            }else{
                balance = tempBalance - nbg.getTransactionFees();
                System.out.println("successfully withdrawn "+ amount + ". \n "+ nbg.getTransactionFees() + "transaction fees withheld.");
                
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
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
}



class Costumer{
    private String name;
    Account account;
    
    Costumer(String costumerName, Account costumerAccount){
        name = costumerName;
        account = costumerAccount;
    }
    
    public void display(){
        System.out.println("Costumer Name:\t\t\t"+ name + "\n"
                + "Costumer Account Number:\t"+ account.getAccountNumber()+"\n"
                + "Costumer Account Balance:\t" + account.getBalance());
        
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
    private double INTEREST_RATE = 0.085;
    private Costumer[] costumersArray;
    
    
    public void calculateInterest(Costumer costumer){
        Account costumersAccount = costumer.getAccount();
        double balanceAfterInterest = costumersAccount.getBalance()*INTEREST_RATE;
        System.out.println("Costumer "+costumer.getName()+" will get a total balance of " + balanceAfterInterest + "after one year");
    }
    public double getInterestRate(){
        return INTEREST_RATE;
    }
    
    public int getTransactionFees(){
        return TRANSACTION_FEES;
    }
    
}