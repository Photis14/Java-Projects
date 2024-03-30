//Author: John Photis
//Due Date: November 1st, 2021
//Purpose: This Java program follows the UML of the Account class.
//Credits: I completed this program independently using class notes and the textbook.


package hw6;

import java.util.*;

public class Account {
	private String id;
    private double balance;
    private double annualInterestRate;
    private MyDate dateCreated;


    public Account(){
        id = null;
        balance = 0.0;
        annualInterestRate = 0.0;
       // dateCreated = null;
    }

    
    public Account(String id, double balance, double rate, MyDate date){
        this.id= id;
        this.balance = balance;
        this.annualInterestRate = rate*100;
        dateCreated = date;
    }


    public String getID(){
        return id;
    }

    public double getBalance(){
        return balance;
    }


    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public MyDate getDate(){
        return dateCreated;
    }

    public void setAnnualInterestRate(double rate){
        this.annualInterestRate = rate;
    }

    
    public double getMonthlyInterestRate(){
        return (annualInterestRate/12)/100;
    }

    public double getMonthlyInterest(){
        return (balance * getMonthlyInterestRate())/100;
    }

    public void withdraw(double amount){
        if(amount <= balance)
            balance -= amount;
        else
        {
            System.out.println("Low balance cannot withdraw $" + amount);
        }
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void transfer(Account other, double amount){
        if(amount<= balance){
            balance -= amount;
            other.deposit(amount);
        }else{
            System.out.println("Low balance cannot transfer $" + amount);
        }
    }


    public String toString(){
        String answer;
        
        answer =  id + " " + annualInterestRate + "% " + balance;
       // answer = "ID: " + id + "Annual Interest Rate: " + annualInterestRate + "Curent Balance: " + balance;
        return answer;
    }
        
    
    
    
    
    //--------------------------------------------------------------------------------------------------------------------
    
    
    
    
    
    
    public static void main(String args[]){
            MyDate date = new MyDate(2021, 03, 12);
            Account account1 = new Account("1122", 2000, 0.045, new MyDate(2020, 10, 17));
            Account account2 = new Account("2233", 1000, 0.045, new MyDate(2020, 10, 17));

            System.out.println("ID    Balance     AnnualInterestRate          MonthlyInterestRate         Date");

            System.out.println(account1.getID() + "  " + account1.getBalance() + "     " + account1.getAnnualInterestRate() + 
            		"%                        " + account1.getMonthlyInterestRate()*100 +
            "%                      " + account1.getDate().toString());
                

            System.out.println( account2.getID() + "  " + account2.getBalance() +
            		"      " + account2.getAnnualInterestRate()+ "%                        " + 
            		account2.getMonthlyInterestRate()*100 + "%                      "+ account2.getDate().toString());


            System.out.println("\nMonth   ID        Balance             MonthlyInterest");
            for(int i=1; i<=5; i++){
                int withdraw = (int)(Math.random()*2000);
                if(account1.getBalance() < withdraw)
                {   
                    System.out.println("Low Balance to withdraw $" + withdraw + " in month " + i);
                    break;
                }
                
                account1.deposit((int)(Math.random() * 5000));
                
                System.out.println("" + i + "      " + account1.getID() +"       " + account1.getBalance() + "             " + account1.getMonthlyInterest());
            }

            if(account1.getBalance() >= 2000){
                account1.transfer(account2, 2000);
            }
            System.out.println();
            System.out.println("ID           Balance");
            System.out.println(account1.getID() + "         " + account1.getBalance());
            System.out.println(account2.getID() + "         " + account2.getBalance());
        }
    }
