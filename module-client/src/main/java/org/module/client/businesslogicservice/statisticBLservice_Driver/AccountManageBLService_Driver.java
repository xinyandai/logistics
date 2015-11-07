package org.module.client.businesslogicservice.statisticBLservice_Driver;

import org.module.client.businesslogicservice.statisticBLservice.AccountManageBLService;
import org.module.client.vo.AccountVO;


public class AccountManageBLService_Driver {
	public void drive(AccountManageBLService accountManageBLService){
//	AccountVO d=new AccountVO("id", "money");
		boolean add=accountManageBLService.add("id", 10);
		boolean delete=accountManageBLService.delete("id");
		boolean update=accountManageBLService.updata("id", 100);
		boolean income=accountManageBLService.income("id", 1000);
		boolean pay=accountManageBLService.pay("id", 10);
		if(add)
			System.out.println("add successfully!");
		if(delete)
			System.out.println("delete successfully!");
		if(update)
			System.out.println("update successfully!");
		if(income)
			System.out.println("income successfully!");
		if(pay)
			System.out.println("pay successfully!");
	}
}
