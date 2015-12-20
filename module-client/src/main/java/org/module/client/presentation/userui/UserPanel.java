package org.module.client.presentation.userui;

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

import org.module.client.businesslogic.userbl.UserManageController;
import org.module.client.businesslogicservice.userBLservice.UserManageBLService;
import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.ResultFrame;
import org.module.client.presentation.Table;
import org.module.client.vo.UserVO;

public class UserPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	ArrayList<UserVO> listData ;
	String[] columnNames = {"id","名字", "密码","工作类别","所属部门","权限"};
	
	private Table table;
	private JButton add;
	private JButton delete;
	private JButton modify;
	private JButton update;
	
	private FontFactory fontFactory = new FontFactory() ;
	
	private UserManageBLService controller  = new UserManageController();
	
	private void addListeners(){
		
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final NewUserInputFrame frame = new NewUserInputFrame();
				frame.setVisible(true);
				frame.getComfirm().addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent e) {
						controller.add(new UserVO(frame.getId(),frame.getNameOfUser(),frame.getPassword(),
								frame.getTypeOfUser(),frame.getDeparment(),frame.getRight()));
						table.fireTableDataChanged();
						frame.dispose();
					}
				});
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] indexes = table.getCheckedIndexes();
				if(indexes.length==0){
					return;
				}
				if(controller.delete(indexes)){
					new ResultFrame(true);
					table.fireTableDataChanged();
				}else{
					new ResultFrame(false);
				}
				
			}
		});
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] indexes = table.getCheckedIndexes();
				if(indexes.length!=1){return;}
				final NewUserInputFrame frame = new NewUserInputFrame(listData.get(indexes[0]));
				frame.setVisible(true);
				frame.getComfirm().addMouseListener(new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent e) {
						if(controller.update(new UserVO(frame.getId(),frame.getNameOfUser(),frame.getPassword(),
								frame.getTypeOfUser(),frame.getDeparment(),frame.getRight()))){
							new ResultFrame(true);
							table.fireTableDataChanged();
						frame.dispose();
						}else{
							new ResultFrame(false);
						}
						
					}
				});
			}
		});
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listData = controller.getAll();
				table.setList(listData);
				table.fireTableDataChanged();
			}
		});
	}
	
	public UserPanel() {
		this.listData = controller.getAll();
		init();
		this.addListeners();
	}
				
	private void init(){
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add = new Button("add");
		delete = new Button("delete");
		modify = new Button("modify");
		update = new Button("refresh");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(214, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(update, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(add, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
				.addComponent(delete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
				.addComponent(modify, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
				.addComponent(update, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		table = new Table(this.listData,this.columnNames);
		JTable t = new JTable(table);
		t.setFont(fontFactory.getTableElementFont());
		t.getTableHeader().setFont(fontFactory.getTabelNameInput());
		
		
		scrollPane.setViewportView(t);
		t.setOpaque(false);
		this.setOpaque(false);
		scrollPane.setOpaque(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

}
