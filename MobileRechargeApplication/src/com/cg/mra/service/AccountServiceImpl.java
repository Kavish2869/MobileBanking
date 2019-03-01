package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exceptions.InvalidMobileNumberException;

public class AccountServiceImpl implements AccountService{
	
	AccountDao accountDao = new AccountDaoImpl();
	Account account;
	@Override
	public Account getAccountDetails(String mobileNo) throws InvalidMobileNumberException {
		
	if(mobileNo.length()!=10) 	
		throw new InvalidMobileNumberException("Phone Number doesn't exist!");	
	return accountDao.getAccountDetails(mobileNo);
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws InvalidMobileNumberException {
		account = accountDao.getAccountDetails(mobileNo);
		if(account ==null)
		throw new InvalidMobileNumberException("Phone Number doesn't exist!");
		else
		return accountDao.rechargeAccount(mobileNo, rechargeAmount);
	}

	
	
}
