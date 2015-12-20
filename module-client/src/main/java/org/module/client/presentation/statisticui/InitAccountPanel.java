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

public class InitAccountPanel extends JPanel {

	
	private static final long serialVersionUID = -6453835256452886591L;
	private InitAccountBLService controller = new InitAccountController();
	private JComboBox comboBox;
	private String[] choices = {"账户","车辆","员工","机构"};
	private JButton button;
	private JTable table;
	private Table model;
    private ArrayList<? extends AbstractVO> listCell;
	
	
	final private String[][] nameArrays = {
			 {"ID",	"余额"	},
			{"车辆代号","车牌号","服役时间"},
			{"姓名","年龄","类型","ID"},
			{"名称","类别","地址","ID"	},
			
	};
	private String[] names = this.nameArrays[0];
	
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
		this.names = this.nameArrays[this.comboBox.getSelectedIndex()];
		model.setList(listCell);
		model.setName(names);
		
	//	model.fireTableDataChanged();
		model.fireTableStructureChanged();
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
	
	public InitAccountPanel() {
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
	    this.model = new Table(this.listCell,this.names);
	    
		table = new JTable(model);
		scrollPane.setViewportView(table);
		this.addListenrs();

	}
}
