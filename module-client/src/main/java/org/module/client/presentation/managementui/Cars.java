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

import org.module.client.businesslogic.managementbl.CarsManageController;
import org.module.client.businesslogicservice.managementBLservice.CarsManageBLService;
import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.MyTable;
import org.module.client.presentation.ResultFrame;
import org.module.common.dataservice.MyList;

public class Cars extends JPanel {

	
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 车辆代号（城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字）、
	 * 车牌号（苏A 00000）、服役时间、车辆图片）
	 */
	
	CarsManageBLService controller = new CarsManageController();
	
	ArrayList<String[]> listData ;
	String[] columnNames = {"车辆代号", "车牌号","服役时间"};
	
	private int mainKey = 0;
	
	private MyTable myTable;
	private JButton add;
	private JButton delete;
	private JButton modify;
	private JButton refresh;
	private FontFactory font;
	
	public Cars() {
		
		font = new FontFactory();
		
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
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refresh)
					.addGap(2))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(modify, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(delete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		listData = controller.getAllToArray();
		myTable = new MyTable(listData,columnNames);
		JTable t = new JTable(myTable);
		t.setFont(font.getTableElementFont());
		t.getTableHeader().setFont(font.getTabelNameInput());
		scrollPane.setViewportView(t);
		
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
	
	private void add(){
		final NewCarsInputFrame carInputFramenew = new NewCarsInputFrame();
		carInputFramenew.setVisible(true);
		carInputFramenew.getConfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] ar = new String[3];
				ar[0] = carInputFramenew.getId();
				ar[1] = carInputFramenew.getLicense();
				ar[2] = carInputFramenew.getTime();
				if(
				    controller.add(ar[0], ar[1], ar[2])){
					carInputFramenew.dispose();
				    listData.add(ar);
				    new ResultFrame(true);
				}else{
					new ResultFrame(false);
				}
				
				myTable.fireTableDataChanged();
			}
		});
	}
	private void delete(){

		int[] indexes = myTable.getCheckedIndexes();
		if(indexes.length==0){
			return;
		}
		MyList<String> ids = new MyList<String>();
		for (int i =  indexes.length-1; i>=0; i--) {
			ids.add(listData.get(indexes[i])[this.mainKey]);
		}
		if(controller.delete(ids)){

			for (int i =  indexes.length-1; i>=0; i--) {
				listData.remove(indexes[i]);
			}
			new ResultFrame(true);
			myTable.fireTableDataChanged();		
		}else{
			this.refresh();
			new ResultFrame(false);
		}
	}
	private void modify(){

		int[] indexes = myTable.getCheckedIndexes();
		myTable.fireTableDataChanged();
	
		if(indexes.length==1){
			final int index = indexes[0];
			final String[] origindata = listData.get( index );
			final NewCarsInputFrame carInputFramenew  = 
					new	NewCarsInputFrame(origindata[0],origindata[1],origindata[2]);
				carInputFramenew.setVisible(true);
			
			JButton button = carInputFramenew.getConfirm();
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String[] ar = new String[3];
					ar[0] = carInputFramenew.getId();
					ar[1] = carInputFramenew.getLicense();
					ar[2] = carInputFramenew.getTime();
				
					if(	controller.modify(ar[0], ar[1],ar[2]) ){
						carInputFramenew.dispose();
						origindata[0] = carInputFramenew.getId();
						origindata[1] = carInputFramenew.getLicense();
						origindata[2] = carInputFramenew.getTime();
						new ResultFrame(true);
					}else{
						new ResultFrame(false);
					}
					myTable.fireTableDataChanged();
				}
			});
		}else{
			
		}
	}
	private void refresh(){
		this.listData = this.controller.getAllToArray();
		this.myTable.setList(listData);
		this.myTable.fireTableDataChanged();
	}
	
}
