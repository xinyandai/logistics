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

import org.module.client.businesslogic.managementbl.PriceAndCityManageController;
import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.MyTable;
import org.module.client.presentation.ResultFrame;

public class City extends JPanel {

	private static final long serialVersionUID = 1L;
	
	ArrayList<String[]> listData ;
	String[] columnNames = {"城市名", "城市代码"};
	private MyTable myTable;
	private JButton add;
	private JButton refresh;
	private FontFactory font;
	private PriceAndCityManageController controller = new PriceAndCityManageController();

	
	public City() {
		font = new FontFactory();
		this.listData = this.controller.toArray();
		init();
		addListenrs();
	}
	
	private void add(){
		final NewCityInputFrame cityInputFrame = new NewCityInputFrame();
		cityInputFrame.setVisible(true);
		cityInputFrame.getConfirm().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] ar = new String[3];
				ar[1] = cityInputFrame.getId();
				ar[0] = cityInputFrame.getCity();
				
				if(	controller.addCity(ar[0], ar[1]) ){
					cityInputFrame.dispose();
					
					listData.add(ar);
					new ResultFrame(true);
				}else{
					new ResultFrame(false);
				}
				myTable.fireTableDataChanged();
			}
		});
	}
	private void refresh(){
		
	}
	
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		
		add = new Button("add");
		refresh = new Button("refresh");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(339, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		myTable = new MyTable(listData,columnNames);
		JTable t = new JTable(myTable);
		t.setFont(font.getTableElementFont());
		t.getTableHeader().setFont(font.getTabelNameInput());
		scrollPane.setViewportView(t);
	}
	
	private void addListenrs(){
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
			}
		});
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		
	}
}
