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

import org.module.client.businesslogic.deparmentbl.StuffManageController;
import org.module.client.businesslogicservice.departmentBLservice.StuffManageBLService;
import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.ResultFrame;
import org.module.client.presentation.Table;
import org.module.client.vo.StuffVO;


public class StuffPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	
	ArrayList<StuffVO> listData ;
	private StuffManageBLService controller = new StuffManageController();
	String[] columnNames = {"名字", "年龄","工作类别","员工号","薪水"};
	private Table table;
	private JButton add;
	private JButton delete;
	private JButton modify;
	private JButton refresh;
	private FontFactory font;
	
	public StuffPanel() {
		font = new FontFactory();
		this.listData = this.controller.showAll();
		init();
		addListeners();
	}
	
	private void addListeners(){
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final NewStuffInputFrame frame = new NewStuffInputFrame();
				frame.setVisible(true);
				frame.getComfirm().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(controller.add(
								frame.getNameOfStuff(), frame.getAge(),
								frame.getTypeOfStuff(), frame.getId())){
							frame.dispose();
							new ResultFrame(true);
						}else{
							new ResultFrame(true);
						}
					    
					    table.fireTableDataChanged();
					}
				});
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] ins = table.getCheckedIndexes();
				if(ins.length==0){
					return;
				}
				if (controller.delete(ins)){
					table.fireTableDataChanged();
					new ResultFrame(true);
				}else{
					new ResultFrame(false);
				}
				
			}
		});
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] ins = table.getCheckedIndexes();
				if(ins.length!=1) return ;
				StuffVO stuffVO = listData.get(ins[0]);
				final NewStuffInputFrame frame = new NewStuffInputFrame(stuffVO);
				frame.setVisible(true);
				frame.getComfirm().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(
								controller.update(
										frame.getNameOfStuff(), frame.getAge(), 
										frame.getTypeOfStuff(), frame.getId())){
							 frame.dispose();
							    table.fireTableDataChanged();
							new ResultFrame(true);
						}else{
							new ResultFrame(false);
						}
					   
					}
				});
			}
		});
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listData = controller.showAll();
				table.setList(listData);
				table.fireTableDataChanged();
			}
		});
	}
	
	private void init(){
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		
		add = new Button("add");
		delete = new Button("delete");
		modify = new Button("modify");
		refresh = new Button("refresh");

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
		scrollPane.setOpaque(false);
		add(scrollPane, BorderLayout.CENTER);
		
		table = new Table(this.listData,this.columnNames);
		JTable t = new JTable(table);
		t.setFont(font.getTableElementFont());
		t.getTableHeader().setFont(font.getTabelNameInput());
		scrollPane.setViewportView(t);
	}

}
