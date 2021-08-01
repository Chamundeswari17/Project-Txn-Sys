package project;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import project.entity.Account;
import project.entity.Txn;
import project.repository.AccountRepository;
import project.repository.JdbcAccountRepository;
import project.repository.TxnRepository;
import project.repository.TxnRepositoryImpl;
import project.service.TxrService;
import project.service.TxrServiceImpl;

public class App {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount to transfer.");
		double amount =sc.nextDouble();
		System.out.println("Enter From Account Number");
		String fromAcc=sc.next();
     
		System.out.println("Enter To Account Number");
		String toAcc=sc.next();
		sc.close();
		AccountRepository accountRepository = new JdbcAccountRepository();
		TxrService txrService = new TxrServiceImpl(accountRepository);

		txrService.transfer(amount, fromAcc, toAcc);

	}

}

	
	

