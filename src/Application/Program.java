package Application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import Model.entities.Account;
import Model.entities.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		
		
		try {

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		sc.nextLine();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account acc = new Account (number, holder, balance, withdrawLimit);
				
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		acc.withdraw(amount);
		System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));	
		
		}
		
		catch (InputMismatchException e) {
			System.out.println("Incorrect data - Closing application");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
		}		
	}