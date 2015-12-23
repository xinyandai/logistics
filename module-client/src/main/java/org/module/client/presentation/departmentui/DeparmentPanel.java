package org.module.client.presentation.departmentui;

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

import org.module.client.businesslogic.deparmentbl.DepartmentManageController;
import org.module.client.businesslogicservice.departmentBLservice.DepartmentManageBLService;
import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.MyTable;
import org.module.client.presentation.ResultFrame;
import org.module.common.dataservice.MyList;

public class DeparmentPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private DepartmentManageBLService controller = new DepartmentManageController(); 
	
	String[] columnNames = {"名字","类别","地址", "编号"};
	ArrayList<String[]> listData;
	
	
	private final MyTable myTable;
    private FontFactory font ;
	private int mainKey = 3;
	private JButton add;
	private JButton delete;
	private JButton modify;
	private JButton refresh;
	
	public DeparmentPanel() {
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
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(refresh))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(modify, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(delete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		listData = this.controller.toArrayList();
		myTable = new MyTable(this.listData,this.columnNames);
		JTable tableView = new JTable(myTable);
		tableView.setFont(font.getTableElementFont());
		tableView.getTableHeader().setFont(font.getTabelNameInput());
		scrollPane.setViewportView(tableView);
		
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
		
		
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			} 
		});
		
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
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
			new ResultFrame(true,DeparmentPanel.this);
			myTable.fireTableDataChanged();		
		}else{
			new ResultFrame(false,DeparmentPanel.this);
		}
	}
	
	
	private void add(){
		final NewDepartmentInputFrame departmentInputFramenew  = 
				new	NewDepartmentInputFrame();
			departmentInputFramenew.setVisible(true);
			JButton button = departmentInputFramenew.getButton();
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String[] ar = new String[4];
					ar[0] = departmentInputFramenew.getName();
					ar[1] = departmentInputFramenew.getCategory();
					ar[2] = departmentInputFramenew.getLcoationOfInput();
					ar[3] = departmentInputFramenew.getID();
				
					boolean  re = controller.add(
							ar[0], 
							ar[1],
							ar[2],
							ar[3]
                            );
					if(re){
						departmentInputFramenew.dispose();
						new ResultFrame(true,DeparmentPanel.this);
						listData.add(ar);
						myTable.fireTableDataChanged();	
					}else{
						new ResultFrame(false,DeparmentPanel.this);
					}
					
				}
			});
	}
	
	private void refresh(){
		this.listData = this.controller.toArrayList();
		this.myTable.setList(listData);
		this.myTable.fireTableDataChanged();
	}


	private void modify(){
		
        int[] indexes = myTable.getCheckedIndexes();
		myTable.fireTableDataChanged();
	
		if(indexes.length==1){
			final int index = indexes[0];
			final String[] temp = new String[4];
			final String[] ar = listData.get( index );
			final NewDepartmentInputFrame departmentInputFramenew  = 
					new	NewDepartmentInputFrame(ar[0],ar[1],ar[2],ar[3]);
				departmentInputFramenew.setVisible(true);
			
			JButton button = departmentInputFramenew.getButton();
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					temp[0] = departmentInputFramenew.getName();
					temp[1] = departmentInputFramenew.getCategory();
					temp[2] = departmentInputFramenew.getLcoationOfInput();
					temp[3] = departmentInputFramenew.getID();
				
 					boolean re = controller.update(temp[0], temp[1],temp[2],temp[3]);
					if(re){
						ar[0] = departmentInputFramenew.getName();
						ar[1] = departmentInputFramenew.getCategory();
						ar[2] = departmentInputFramenew.getLcoationOfInput();
						ar[3] = departmentInputFramenew.getID();
						
						departmentInputFramenew.dispose();
						new ResultFrame(true,DeparmentPanel.this);
						myTable.fireTableDataChanged();
					}else{
						new ResultFrame(false,DeparmentPanel.this);
					}
 					
				}
			});
		}else{
			
		}
	}
}
