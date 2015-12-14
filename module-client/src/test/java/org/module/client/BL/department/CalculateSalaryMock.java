package org.module.client.BL.department;

import org.module.client.businesslogicservice.department.CalculateSalaryService;
import org.module.client.vo.StuffVO;

public class CalculateSalaryMock implements CalculateSalaryService{
	public double calculateSalary(String id,String time) {
	    if(id.equals("140010001"))
	    	return 500;
		return 0;
	}

	public double calculateSalary(StuffVO vo) {
		// TODO Auto-generated method stub
		return 500;
	}

}
