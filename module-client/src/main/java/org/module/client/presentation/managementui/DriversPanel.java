package org.module.client.presentation.managementui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.module.client.businesslogic.managementbl.DriversManageController;
import org.module.client.businesslogicservice.managementBLservice.DriversManageBLService;
import org.module.client.presentation.Button;
import org.module.client.presentation.MyTable;
import org.module.client.presentation.ResultFrame;
import org.module.common.dataservice.MyList;

public class DriversPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	/**
	 * 司机编号（城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字、
	 * 姓名、
	 * 出生日期、
	 * 身份证号、
	 * 手机 、
	 * 性别、
	 * 行驶证期限
	 */
	
	private DriversManageBLService controller = new DriversManageController();
	ArrayList<String[]> listData ;
	String[] columnNames = {"编号", "姓名","生日","身份证号","手机","性别","驾驶证期限"};
	private MyTable myTable;
	private JButton refresh;
	private JButton modify;
	private JButton delete;
	private JButton add;
	private final int mainKey = 0;
	
	private void add(){
		final NewDriverInputFrame driversInputFrame  = 
				new	NewDriverInputFrame();
			driversInputFrame.setVisible(true);
			JButton button = driversInputFrame.getConfirm();
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String[] ar = {
							driversInputFrame.getId(),
							driversInputFrame.getDrivername(),
							driversInputFrame.getBirthday(),
							driversInputFrame.getIdCard(),
							driversInputFrame.getPhone(),
							driversInputFrame.getGender(),
							driversInputFrame.getDate()
					};
					listData.add(ar);
					controller.add(ar[0],ar[1],ar[2],ar[3],ar[4],ar[5],ar[6]);
					driversInputFrame.dispose();
					myTable.fireTableDataChanged();
					
				}
			});
	}
	private void delete(){
		int[] indexes = myTable.getCheckedIndexes();
		MyList<String> ids = new MyList<String>();
		for (int i =  indexes.length-1; i>=0; i--) {
			ids.add(listData.get(indexes[i])[mainKey]);
		}
		if(
			controller.delete(ids)
		  ){
			
			for (int i =  indexes.length-1; i>=0; i--) {
				listData.remove(indexes[i]);
			}
			myTable.fireTableDataChanged();		
		}
	}
	private void modify(){
		
		 
		    int[] indexes = myTable.getCheckedIndexes();
			if(indexes.length==1){
				final int index = indexes[0];
				final String[] originData = listData.get( index );
				final NewDriverInputFrame driversInputFrame  = 
						new	NewDriverInputFrame(originData[0],originData[1],originData[2],
								originData[3],originData[4],originData[5],originData[6]);
					driversInputFrame.setVisible(true);
				
					JButton button = driversInputFrame.getConfirm();
					button.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							String[] ar = new String[7];
							ar[0] = driversInputFrame.getId();
							ar[1] = driversInputFrame.getDrivername();
							ar[2] = driversInputFrame.getBirthday();
							ar[3] = driversInputFrame.getIdCard();
							ar[4] = driversInputFrame.getPhone();
							ar[5] = driversInputFrame.getGender();
							ar[6] = driversInputFrame.getDate();
						    if(controller.modify(ar[0],ar[1],ar[2],ar[3],ar[4],ar[5],ar[6])){
						    	originData[0] = driversInputFrame.getId();
						    	originData[1] = driversInputFrame.getDrivername();
						    	originData[2] = driversInputFrame.getBirthday();
						    	originData[3] = driversInputFrame.getIdCard();
						    	originData[4] = driversInputFrame.getPhone();
						    	originData[5] = driversInputFrame.getGender();
						    	originData[6] = driversInputFrame.getDate();
						    	new ResultFrame(true);
								myTable.fireTableDataChanged();
								driversInputFrame.dispose();
						    }else{
						    	new ResultFrame(false);
						    }
							
						}
					});
				}else{
					
				}
		
	}
	private void refresh(){
		this.listData = this.controller.toArray();
		this.myTable.setList(listData);
		this.myTable.fireTableDataChanged();
	}
	
	
	
	public DriversPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		
		add = new Button("add");
		delete = new Button("delete");
		refresh = new Button("refresh");
		modify = new Button("modify");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refresh))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(modify, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(delete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		listData = controller.toArray();
		myTable = new MyTable(listData,columnNames);
		scrollPane.setViewportView(new JTable(myTable));
		
		addListeners();
	}
	
	
	
	private void addListeners(){
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   delete();
			}
		});
		
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
			}
		});
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
	}
}
