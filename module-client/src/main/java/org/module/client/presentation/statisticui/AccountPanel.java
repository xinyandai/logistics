package org.module.client.presentation.statisticui;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.module.client.businesslogic.statisticbl.AccountManageController;
import org.module.client.businesslogicservice.statisticBLservice.AccountManageBLService;
import org.module.client.presentation.Button;
import org.module.client.presentation.ResultFrame;
import org.module.client.presentation.Table;
import org.module.client.vo.AccountVO;

public class AccountPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	ArrayList<AccountVO> listData ;
	String[] columnNames = {"账号", "余额"};
	private Table table;
	private JTextField input;
	private JButton search;
	private JButton add;
	private JButton delete;
	private JButton update;
	
	private AccountManageBLService controller = new AccountManageController();
	
	protected void search() {
		this.listData = controller.fuzzySearch(this.input.getText());
		this.table.setList(listData);
		this.table.fireTableDataChanged();
	}

	protected void update() {
		this.listData = controller.showAll();
		this.table.setList(listData);
		this.table.fireTableDataChanged();
	}

	protected void delete() {
		int[] indexes = this.table.getCheckedIndexes();
		if(this.controller.delete(indexes)){
			new ResultFrame(true);
		}else{
			new ResultFrame(false);
		}
		this.table.fireTableDataChanged();
	}

	protected void add() {
		final NewAccountInputFrame frame = new NewAccountInputFrame();
		frame.setVisible(true);
		frame.getComfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(controller.add(frame.getId(), frame.getMoney())){
					frame.dispose();
					new ResultFrame(true);
				}else{
					new ResultFrame(false);
				}
				
				table.fireTableDataChanged();
			}
		});
	}

	public AccountPanel() {
		this.listData = this.controller.showAll();
		init();
		this.addListener();
	}
	
	
	
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		
		add = new Button("add");
		delete = new Button("delete");
		update = new Button("refresh");
		
		input = new JTextField();
		input.setColumns(10);
		
		search = new JButton("搜索");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(input, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(search))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(271, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(update, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(update, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(delete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(search)))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new Table(this.listData,columnNames);
		scrollPane.setViewportView(new JTable(table));
	}
	
	
	
	private void addListener(){
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
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
			}
		});
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search();
			}
		});
	}
}
