package com.cg.mra.dao;

import com.cg.mra.beans.Account;

public interface AccountDao {
	
	Account getAccountDetails(String mobileNo);
	double rechargeAccount(String mobileNo, double rechargeAmount);
	
}
