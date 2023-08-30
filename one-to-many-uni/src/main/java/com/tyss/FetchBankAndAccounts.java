package com.tyss;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchBankAndAccounts {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		
		Bank bank=em.find(Bank.class, 1);
		System.out.println("----------------BANK-------------------");
		System.out.println("bank id "+bank.getId());
		System.out.println("bank id "+bank.getName());
		System.out.println("bank id "+bank.getIfse());
		
		//by using Bank we are Fetching the Accounts
		List<Account> accounts=bank.getAccounts();
		System.out.println("----------------ACCOUNT----------------");
		for(Account account:accounts) {
			System.out.println("Account id "+account.getId());
			System.out.println("Account number "+account.getNumber());
			System.out.println("Account balance "+account.getBalance());
		}
		
	}
}
