//Author: John Photis
//Purpose: This Java program follows the UML of the Account class.


package stacks;

import java.util.*;

public class Account {
	public String id;
	public String holder_name;
	public double balance;
	public double annualRate;
	public ArrayList<Transaction> transactions;

	public Account() {
		transactions = new ArrayList<Transaction>();
	}

	public Account(String id, double balance, String holder_name, double rate) {
		this.id = id;
		this.holder_name = holder_name;
		this.balance = balance;
		transactions = new ArrayList<Transaction>();
		this.annualRate = rate;
	}

	public String getID() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public String getHolder() {
		return holder_name;
	}

	public void withdraw(double amount) {
		if (balance - amount >= 0) {
			this.balance -= amount;
		}
	}

	public void deposit(double amount) {
		if (amount >= 0) {

			this.balance += amount;
		}
	}

	public String getTransactions() {
		String string = "";
		for (int i = 0; i < transactions.size(); i++) {

			if (transactions.get(i).getAccountType().equalsIgnoreCase("Saving")) {
				string += "Saving Account Summary\n";
			} else if (transactions.get(i).getAccountType().equalsIgnoreCase("Checking")) {
				string += "Checking Account Summary\n";
			}

			string += this.toString();
			string += transactions.get(i) + "\n";
		}
		return string;
	}

	public void addTransactions(char type, String accountType, double amount, String memo) {
		Transaction t = new Transaction(type, accountType, amount, memo);
		transactions.add(t);
	}

	public String toString() {
		String string = "";
		string += "Holder: " + holder_name + "\n";
		string += "Current Balance: " + balance + "\n";
		return string;
	}
	
//-------------------------------------------------------------------------------------------

	public class Transaction {
		public Date date;
		public char type;
		public String accountType;
		public double amount;
		public String memo;

		public Transaction(char type, String accountType, double amount, String memo) {
			this.date = new Date();
			this.type = type;
			this.accountType = accountType;
			this.amount = amount;
			this.memo = memo;
		}

		public Date getDate() {
			return date;
		}

		public char getType() {
			return type;
		}

		public void setType(char type) {
			this.type = type;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getMemo() {
			return memo;
		}

		public void setMemo(String memo) {
			this.memo = memo;
		}

		public String toString() {
			String string = "";

			string += "Transactions:\n";
			string += date;
			if (type == 'D' || type == 'd') {
				string += " Deposit ";
			} else if (type == 'W' || type == 'w') {
				string += " Withdraw ";
			}
			string += amount + "\n";

			return string;
		}

	}
	
	
//-------------------------------------------------------------------------------------------	
	
	

	static class Checking extends Account {
		public double overdraft_limit;

		public Checking() {
		}

		public Checking(String id, double balance, String holder_name, double overdraft_limit, double rate) {
			super(id, balance, holder_name, rate);
			this.overdraft_limit = overdraft_limit;

		}

		public void withdraw(double amt) {

			if (amt <= (getBalance() + overdraft_limit)) {
				if (amt <= getBalance()) {
					super.withdraw(amt);
					super.addTransactions('W', "Checking", amt, "");
				} else {
					super.withdraw(amt);

				}
			}
		}
	}

	
	
//-------------------------------------------------------------------------------------------
	
	
	
	static class Saving extends Account {
		public Saving() {
		}

		public Saving(String id, double balance, String holder_name, double rate) {
			super(id, balance, holder_name, rate);

		}

		public void withdraw(double amt) {
			if (amt <= getBalance()) {
				super.withdraw(amt);
				super.addTransactions('W', "Saving", amt, "");
			}
		}
	}
}
