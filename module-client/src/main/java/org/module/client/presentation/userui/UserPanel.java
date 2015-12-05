package org.module.client.presentation.userui;

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

import org.module.client.businesslogic.userbl.UserManageController;
import org.module.client.businesslogicservice.userBLservice.UserManageBLService;
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
				controller.delete(indexes);
				table.fireTableDataChanged();
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
						controller.update(new UserVO(frame.getId(),frame.getNameOfUser(),frame.getPassword(),
								frame.getTypeOfUser(),frame.getDeparment(),frame.getRight()));
						table.fireTableDataChanged();
						frame.dispose();
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
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		add = new JButton("增");
		delete = new JButton("删");
		modify = new JButton("改");
		update = new JButton("同步");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(190, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(update))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(update)
					.addComponent(modify)
					.addComponent(delete)
					.addComponent(add))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		table = new Table(this.listData,this.columnNames);
		scrollPane.setViewportView(new JTable(table));
	}

}
