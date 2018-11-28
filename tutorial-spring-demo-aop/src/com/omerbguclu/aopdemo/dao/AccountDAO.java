package com.omerbguclu.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.omerbguclu.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n"
						+ "*****************************************************************************************************************");
	}
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH ACCOUNT PARAMETER\n"
						+ "*****************************************************************************************************************");
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH ACCOUNT TWO PARAMETER\n"
						+ "*****************************************************************************************************************");
	}
	
	public void updateAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: UPDATING AN ACCOUNT\n"
				+ "*****************************************************************************************************************");
	}
}
