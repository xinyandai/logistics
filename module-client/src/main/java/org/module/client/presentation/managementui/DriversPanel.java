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
import org.module.client.presentation.MyTable;

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
	String[] columnNames = {"编号", "姓名","生日","身份证号","手机","性别","驾驶证证期限"};
	private MyTable table;
	private JButton refresh;
	private JButton modify;
	private JButton delete;
	private JButton add;
	
	private void addListeners(){
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
	public DriversPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		add = new JButton("增");
		
		
		delete = new JButton("删");
		
		
		modify = new JButton("改");
		
		
		refresh = new JButton("同步");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
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
						.addComponent(refresh)
						.addComponent(modify)
						.addComponent(delete)
						.addComponent(add))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		listData = controller.toArray();
		table = new MyTable(listData,columnNames);
		scrollPane.setViewportView(new JTable(table));
		
		addListeners();
	}

}
