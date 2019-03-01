package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.InvalidMobileNumberException;

public interface AccountService {
	
	Account getAccountDetails(String mobileNo) throws InvalidMobileNumberException;
	double rechargeAccount(String mobileNo, double rechargeAmount) throws InvalidMobileNumberException;
}
