package com.omerbguclu.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.omerbguclu.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
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

	public String getName() {
		System.out.println(getClass() + ":in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ":in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ":in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ":in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
