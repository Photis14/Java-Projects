//Author: John Photis
//Purpose: This Java program is the Test for the Account class.



package stacks;

import java.util.*;

import stacks.Account.Checking;
import stacks.Account.Saving;	


public class AccountTest {

	public static void main(String[] args) {
		Account accounts[] = { new Checking("1122", 1000, "George", 500, 1.5), new Saving("2233", 5000, "Billy", 2.5) };
		
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("Withdraw/Deposit: ");
			char type = input.next().charAt(0);
			System.out.print("Checking or Saving: ");
			String accountType = input.next();
			System.out.print("The amount: ");
			double amount = input.nextDouble();

			if (accountType.equalsIgnoreCase("Saving")) {
				if (type == 'W' || type == 'w') {
					((Saving) accounts[1]).withdraw(amount);
				} else if (type == 'D' || type == 'd') {
					((Saving) accounts[1]).deposit(amount);
					accounts[1].addTransactions('D', "Saving", amount, "");
				}
			} else if (accountType.equalsIgnoreCase("Checking")) {
				if (type == 'W' || type == 'w') {
					((Checking) accounts[0]).withdraw(amount);

				} else if (type == 'D' || type == 'd') {
					((Checking) accounts[0]).deposit(amount);
					accounts[0].addTransactions('D', "Checking", amount, "");
				}
			}

			System.out.print("\nDo you want to continue? ");
			String choice = input.next();
			if (choice.equalsIgnoreCase("no")) {
				break;
			}
		}

		System.out.println();
		for (int i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i].getTransactions());
		}

	}
}

