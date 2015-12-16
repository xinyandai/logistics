package org.module.client.presentation.statisticui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.module.client.businesslogic.statisticbl.SalaryController;
import org.module.client.businesslogicservice.statisticBLservice.SalarySettingBLService;
import org.module.client.vo.salary.AccountantSalaryVO;
import org.module.client.vo.salary.CourierSalaryVO;
import org.module.client.vo.salary.DriverSalaryVO;
import org.module.client.vo.salary.OfficeClerkSalaryVO;
import org.module.client.vo.salary.TranCenterClerkSalaryVO;
import org.module.client.vo.salary.WarehouseManagerSalaryVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalaryPanel extends JPanel {

	
	private static final long serialVersionUID = 3571853914813487730L;
	private JTextField baseOfOfficeClerk;
	private JTextField baseOfCourier;
	private JTextField bonusOfReceipt;
	private JTextField baseOfDriver;
	private JTextField bonusInCity;
	private JTextField bonusOutCity;
	private JTextField baseOfTranCenterClerk;
	private JTextField baseOfAccount;

	
	SalarySettingBLService controller = new SalaryController();
	private JTextField baseOfWarehouse;
	private JButton button;
	
	protected void save() {
		boolean re = true;
  		re = re && this.controller.setAccountSalary(this.getAccountantSalaryVO())
  				&&
		this.controller.setCourierSalary(this.getCourierSalaryVO())
		&&
		this.controller.setDriverSalary(this.getDriverSalaryVO())
		&&
		this.controller.setOfficeClerkSalary(this.getOfficeClerkSalaryVO())
		&&
		this.controller.setTranCenterClerkSalary(this.getTranCenterClerkSalaryVO())
		&&
		this.controller.setWarehouseSalary(this.getWarehouseManagerSalaryVO());
		
	}
	
	private void initData(){
		AccountantSalaryVO accountantSalaryVO = this.controller.getAccountantSalaryVO();
		this.baseOfAccount.setText(accountantSalaryVO.getBase()+"");
		
		CourierSalaryVO courierSalaryVO = this.controller.getCourierSalaryVO();
		this.baseOfCourier.setText(courierSalaryVO.getBase()+"");
		this.bonusOfReceipt.setText(courierSalaryVO.getBonusEveryDelivered()+"");
		
		DriverSalaryVO driverSalaryVO = this.controller.getDriverSalaryVO();
		this.baseOfDriver.setText(driverSalaryVO.getBase()+"");
		this.bonusInCity.setText(driverSalaryVO.getBonusEveryIncityDriving()+"");
		this.bonusOutCity.setText(driverSalaryVO.getBonusEveryKilometersOutcityDriving()+"");
		
		OfficeClerkSalaryVO officeClerkSalaryVO = this.controller.getOfficeClerkSalaryVO();
		this.baseOfOfficeClerk.setText(officeClerkSalaryVO.getBase()+"");
		
		TranCenterClerkSalaryVO tranCenterClerkSalaryVO = this.controller.getTranCenterClerkSalaryVO();
		this.baseOfTranCenterClerk.setText(tranCenterClerkSalaryVO.getBase()+"");
		
		WarehouseManagerSalaryVO warehouseManagerSalaryVO = this.controller.getWarehouseManagerSalaryVO();
		this.baseOfWarehouse.setText(warehouseManagerSalaryVO.getBase()+"");
	}
	
	private WarehouseManagerSalaryVO getWarehouseManagerSalaryVO(){
		return new WarehouseManagerSalaryVO(
				Double.parseDouble( this.baseOfWarehouse.getText() ),
				0,
				0
				);
	}
	
	private TranCenterClerkSalaryVO getTranCenterClerkSalaryVO(){
		return new TranCenterClerkSalaryVO(
				Double.parseDouble(this.baseOfTranCenterClerk.getText()),
				0,
				0
				);
	}
	
	private OfficeClerkSalaryVO getOfficeClerkSalaryVO(){
		return new OfficeClerkSalaryVO(
				Double.parseDouble(this.baseOfOfficeClerk.getText()),
				0,
				0
				);
	}
	
	private DriverSalaryVO getDriverSalaryVO(){
		return new DriverSalaryVO(
				Double.parseDouble(this.baseOfDriver.getText()),
				Double.parseDouble(this.bonusInCity.getText()),
				Double.parseDouble(this.bonusOutCity.getText())
				);
	}
	
	private CourierSalaryVO getCourierSalaryVO(){
		return new CourierSalaryVO(Double.parseDouble(this.baseOfCourier.getText()),
				Double.parseDouble(this.bonusOfReceipt.getText()),
				Double.parseDouble(this.bonusOfReceipt.getText())
				);
	}
	private AccountantSalaryVO getAccountantSalaryVO(){
		return new AccountantSalaryVO(Double.parseDouble(this.baseOfAccount.getText()),0);
	}
	
	public SalaryPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("营业厅业务员");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		label.setBounds(10, 10, 105, 15);
		add(label);
		
		JLabel label_1 = new JLabel("基本工资");
		label_1.setBounds(33, 35, 54, 15);
		add(label_1);
		
		baseOfOfficeClerk = new JTextField();
		baseOfOfficeClerk.setBounds(102, 35, 66, 21);
		add(baseOfOfficeClerk);
		baseOfOfficeClerk.setColumns(10);
		
		JLabel label_2 = new JLabel("快递员");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(10, 60, 105, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("基本工资");
		label_3.setBounds(33, 85, 54, 15);
		add(label_3);
		
		baseOfCourier = new JTextField();
		baseOfCourier.setColumns(10);
		baseOfCourier.setBounds(102, 85, 66, 21);
		add(baseOfCourier);
		
		JLabel label_4 = new JLabel("收款提成");
		label_4.setBounds(204, 85, 54, 15);
		add(label_4);
		
		bonusOfReceipt = new JTextField();
		bonusOfReceipt.setColumns(10);
		bonusOfReceipt.setBounds(267, 82, 66, 21);
		add(bonusOfReceipt);
		
		JLabel label_5 = new JLabel("司机");
		label_5.setFont(new Font("楷体", Font.PLAIN, 15));
		label_5.setBounds(10, 116, 105, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("基本工资");
		label_6.setBounds(33, 141, 54, 15);
		add(label_6);
		
		baseOfDriver = new JTextField();
		baseOfDriver.setColumns(10);
		baseOfDriver.setBounds(102, 141, 66, 21);
		add(baseOfDriver);
		
		JLabel label_7 = new JLabel("市内提成");
		label_7.setToolTipText("司机每室内运货一次 的提成");
		label_7.setBounds(33, 175, 54, 15);
		add(label_7);
		
		bonusInCity = new JTextField();
		bonusInCity.setColumns(10);
		bonusInCity.setBounds(102, 172, 66, 21);
		add(bonusInCity);
		
		JLabel label_8 = new JLabel("跨市提成");
		label_8.setToolTipText("司机跨市运输提成，单位是 人民币/千千米");
		label_8.setBounds(204, 175, 54, 15);
		add(label_8);
		
		bonusOutCity = new JTextField();
		bonusOutCity.setColumns(10);
		bonusOutCity.setBounds(267, 172, 66, 21);
		add(bonusOutCity);
		
		JLabel label_9 = new JLabel("中转中心业务员");
		label_9.setFont(new Font("楷体", Font.PLAIN, 15));
		label_9.setBounds(10, 213, 105, 15);
		add(label_9);
		
		JLabel label_10 = new JLabel("基本工资");
		label_10.setBounds(33, 238, 54, 15);
		add(label_10);
		
		baseOfTranCenterClerk = new JTextField();
		baseOfTranCenterClerk.setColumns(10);
		baseOfTranCenterClerk.setBounds(102, 238, 66, 21);
		add(baseOfTranCenterClerk);
		
		JLabel label_11 = new JLabel("财务人员");
		label_11.setFont(new Font("楷体", Font.PLAIN, 15));
		label_11.setBounds(10, 281, 105, 15);
		add(label_11);
		
		JLabel label_12 = new JLabel("基本工资");
		label_12.setBounds(33, 301, 54, 15);
		add(label_12);
		
		baseOfAccount = new JTextField();
		baseOfAccount.setColumns(10);
		baseOfAccount.setBounds(102, 298, 66, 21);
		add(baseOfAccount);
		
		button = new JButton("保存");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save();
			}
		});
		button.setBounds(167, 398, 93, 23);
		add(button);
		
		JLabel label_13 = new JLabel("财务人员");
		label_13.setFont(new Font("楷体", Font.PLAIN, 15));
		label_13.setBounds(10, 336, 105, 15);
		add(label_13);
		
		JLabel label_14 = new JLabel("基本工资");
		label_14.setBounds(33, 361, 54, 15);
		add(label_14);
		
		baseOfWarehouse = new JTextField();
		baseOfWarehouse.setColumns(10);
		baseOfWarehouse.setBounds(102, 361, 66, 21);
		add(baseOfWarehouse);

		this.initData();
	}

	
}
