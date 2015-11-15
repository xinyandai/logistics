package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.AccountService;
import org.module.client.vo.AccountVO;

public class Account implements AccountService {

	public Account() {
		// TODO Auto-generated constructor stub
	}

	
	public boolean add(AccountVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(ArrayList<String> a) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(AccountVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	

	public boolean pay(String id, double b) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean income(String id, double b) {
		// TODO Auto-generated method stub
		return false;
	}


	public ArrayList<AccountVO> showAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<AccountVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
