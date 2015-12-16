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
import org.module.client.presentation.MyTable;
import org.module.client.presentation.ResultFrame;

public class City extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	ArrayList<String[]> listData ;
	String[] columnNames = {"城市名", "城市代码"};
	private MyTable myTable;
	private JButton add;
	private JButton delete;
	private JButton modify;
	private JButton refresh;
	
	private PriceAndCityManageController controller = new PriceAndCityManageController();

	
	public City() {
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
	private void delete(){
		
	}
	private void modify(){
		
	}
	private void refresh(){
		
	}
	
	private void init(){
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
		
		myTable = new MyTable(listData,columnNames);
		scrollPane.setViewportView(new JTable(myTable));
	}
	
	private void addListenrs(){
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
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
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
