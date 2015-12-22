package org.module.client.presentation.managementui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.module.client.businesslogic.managementbl.TicketAndOrderManageController;
import org.module.client.businesslogicservice.managementBLservice.TicketAndOrderManageBLService;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.ResultFrame;
import org.module.client.presentation.Table;
import org.module.client.vo.AbstractVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TicketManagePanel extends JPanel {

	
	private static final long serialVersionUID = 1L;

	private TicketAndOrderManageBLService controller = new TicketAndOrderManageController();
	private String[] typeArray = {"空"};
	private JScrollPane scrollPane;
	private Table table;
	private ArrayList<? extends AbstractVO> listCell;
	private JButton pass;
	private JButton unpass;
	private JButton refresh;
	private JComboBox type;
	private FontFactory font;
	public TicketManagePanel() {
		this.font = new FontFactory();
		this.typeArray = this.controller.getTypes();
		init();
		this.listCell = this.controller.getAll(typeArray[0]);
		if(!this.listCell.isEmpty()){
			table = new Table(this.listCell,this.listCell.get(0).names());
			JTable t = new JTable(this.table);
			t.setFont(font.getTableElementFont());
			t.getTableHeader().setFont(font.getTabelNameInput());
			scrollPane.setViewportView(t);
		}
		addListeners();
	}
	
	protected void pass() {
		if (this.controller.pass(this.table.getCheckedIndexes(), this.type.getSelectedItem().toString())){
			new ResultFrame(true);
		}else{
			new ResultFrame(false);
		}
		this.table.fireTableDataChanged();
	}
	protected void unpass() {
		if(
				this.controller.unpass(this.table.getCheckedIndexes(), 
						this.type.getSelectedItem().toString())){
			new ResultFrame(true);
		}else{
			new ResultFrame(false);
		}
		this.table.fireTableDataChanged();
	}
	protected void refresh() {	
		this.listCell = this.controller.getAll(this.type.getSelectedItem().toString());
		if(!this.listCell.isEmpty()){
			//table = new Table(this.listCell,this.listCell.get(0).names());
			table.setName(this.listCell.get(0).names());
			table.setList(listCell);
		}else{
			String[] name = {"空"};
			//table = new Table(this.listCell,name);
			table.setName(name);
			table.setList(listCell);
		}
		table.fireTableStructureChanged();
		//JTable t = new JTable(this.table);
		//scrollPane.setViewportView(t);
	}
	
	
	private void init(){
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		
		pass = new JButton("审批通过");
		unpass = new JButton("审批不通过");
		refresh = new JButton("刷新");
		pass.setFont(font.getStateFont());
		unpass.setFont(font.getStateFont());
		refresh.setFont(font.getStateFont());
		
		type = new JComboBox(this.typeArray);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(type, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addComponent(pass)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(unpass)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(refresh)
						.addComponent(unpass)
						.addComponent(pass)
						.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
	
	}

	private void addListeners() {
		
		pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pass();
			}
		});
		unpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				unpass();
			}
		});
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		type.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				refresh();
			}
		});
	}
}
