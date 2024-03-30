//Author: John Photis
//Purpose: This Java program follows the UML of the Transaction class.


package stacks;

import java.util.*;

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
