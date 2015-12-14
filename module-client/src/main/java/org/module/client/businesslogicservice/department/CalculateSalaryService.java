package org.module.client.businesslogicservice.department;

import org.module.client.vo.StuffVO;

public interface CalculateSalaryService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public double calculateSalary(StuffVO vo);
}
