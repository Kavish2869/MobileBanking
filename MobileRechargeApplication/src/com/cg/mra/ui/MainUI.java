package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.InvalidMobileNumberException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		AccountService service = new AccountServiceImpl();
		
		int choice=0;
		  String mobileNumber="";
		  String accountType = null, customerName = null;
		  double accountBalance = 0;
		while(true) {  	  
		      System.out.println("1.Account Balance Enquiry");
			  System.out.println("2.Recharge Account");
		   	  System.out.println("3.Exit");
		  	    choice=sc.nextInt();
		try  {    
			Account account=new Account();
				if(choice==1) {
				 System.out.println("Enter mobile Number of customer");
				 mobileNumber=sc.next();
			   	account=service.getAccountDetails(mobileNumber);
				System.out.println("Your Current Balance IS Rs  "+account.getAccountBalance());
				choice=sc.nextInt();
				}				 
			 }
				catch(InvalidMobileNumberException e) {
				System.out.println("Phone Number doesn't exist!"); 
						 }
		try {
				 if(choice==2) {
					String mobileno="";
					 System.out.println("Enter mobile Number of customer");
					 mobileno=sc.next();
					 System.out.println( " Enter Recharge amount");
					  double rechargeAmount=sc.nextDouble();
					  double updateBalance=service.rechargeAccount(mobileno, rechargeAmount);
					  System.out.println("Updated Balance ="+updateBalance);
					  Account  account = new Account(accountType, customerName, accountBalance);
				System.out.println("Details : " + service.getAccountDetails(mobileno));
				choice=sc.nextInt();
				 }
			  }
				catch(InvalidMobileNumberException e) {
				System.out.println("Phone Number doesn't exist!"); 
						 }
				if(choice==3){
					System.exit(0);
					System.out.println("Ending Program Execution");			  			  
				}
			}
	}
}
