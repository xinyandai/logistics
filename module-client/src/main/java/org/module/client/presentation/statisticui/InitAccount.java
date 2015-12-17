package org.module.client.presentation.statisticui;

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

import org.module.client.businesslogic.statisticbl.InitAccountController;
import org.module.client.businesslogicservice.statisticBLservice.InitAccountBLService;
import org.module.client.presentation.ResultFrame;
import org.module.client.presentation.Table;
import org.module.client.vo.AbstractVO;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitAccount extends JPanel {

	
	private static final long serialVersionUID = -6453835256452886591L;
	private InitAccountBLService controller = new InitAccountController();
	private JComboBox comboBox;
	private String[] choices = {"账户","车辆","员工","机构"};
	private JButton button;
	private JTable table;
	private Table model;
    private ArrayList<? extends AbstractVO> listCell;
	
	private void refresh(){
		if(this.comboBox.getSelectedIndex()==0){
			this.listCell = this.controller.getInitAccount();
		}else if(this.comboBox.getSelectedIndex()==1){
			this.listCell = this.controller.getInitCar();
		}else if(this.comboBox.getSelectedIndex()==2){
			this.listCell = this.controller.getInitStuff();
		}else if(this.comboBox.getSelectedIndex()==3){
			this.listCell = this.controller.getInitDepartment();
		}
		model.setList(listCell);
		if(this.listCell.size()==0){
	    	this.model.setList(this.listCell);
	    	this.model.setName(new String[]{"空"});
	    }else{
	    	this.model.setList(this.listCell);
	    	this.model.setName(this.listCell.get(0).names());
	    }
		model.fireTableDataChanged();
	}
	
	private void addListenrs(){
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				refresh();
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(controller.init()){
					new ResultFrame(true);
				}else{
					new ResultFrame(false);
				}
			}
		});
	}
	
	public InitAccount() {
		this.setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		
		button = new JButton("建账");
		button.setToolTipText("以当前信息建账");
		
		comboBox = new JComboBox(this.choices);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
					.addComponent(button))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
	    this.listCell = this.controller.getInitAccount();
	    if(this.listCell.size()==0){
	    	this.model = new Table(this.listCell, new String[]{"空"});
	    }else{
	    	this.model = new Table(this.listCell,this.listCell.get(0).names());
	    }
		table = new JTable(model);
		scrollPane.setViewportView(table);
		this.addListenrs();

	}
}
