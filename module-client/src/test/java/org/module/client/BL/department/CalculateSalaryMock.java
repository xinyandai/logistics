package org.module.client.BL.department;

import org.module.client.businesslogicservice.department.CalculateSalaryService;

public class CalculateSalaryMock implements CalculateSalaryService{
	public double calculateById(String id,String time) {
	    if(id.equals("140010001"))
	    	return 500;
		return 0;
	}

}
