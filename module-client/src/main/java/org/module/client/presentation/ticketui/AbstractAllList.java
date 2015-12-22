package org.module.client.presentation.ticketui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.Table;
import org.module.client.vo.AbstractVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class AbstractAllList extends JPanel {

	
	private static final long serialVersionUID = 3512270670954232575L;
	protected JButton add;
	protected JButton modify;
	protected JButton refresh;
	protected JXDatePicker endTime;
	protected JXDatePicker startTime;
	protected JLabel count;
	protected JScrollPane scrollPane;
	protected Table table;
	
	protected String[] typeArray ;
	protected ArrayList<? extends AbstractVO> listCell;
	
	protected  abstract void initData() ;
	protected  abstract void refresh();
	protected abstract  void modify() ;
	protected abstract void add(); 
	
	protected FontFactory font;
	public AbstractAllList() {
		this.font = new FontFactory();
		initData();
		init();
		addListeners();
		table =   new Table(this.listCell,this.typeArray);
		JTable t = new JTable(table);
		t.setFont(font.getTableElementFont());
		t.getTableHeader().setFont(font.getTabelNameInput());
		this.scrollPane.setViewportView(t);
	}
	protected void updateNums(){
		this.count.setText("合计："+this.listCell.size());
	}
	protected void init(){	
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		
		refresh = new Button("refresh");
		refresh.setFont(new Font("楷体", Font.PLAIN, 13));
		
		modify = new Button("modify");
		modify.setFont(new Font("楷体", Font.PLAIN, 13));
		
		add = new Button("add");
		add.setFont(new Font("楷体", Font.PLAIN, 13));
		
		startTime = new JXDatePicker();
		startTime.setDate(new Date());
		
		endTime = new JXDatePicker();
		endTime.setDate(new Date());
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(startTime, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(endTime, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(modify, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(startTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(endTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1, BorderLayout.SOUTH);
		
		count = new JLabel("合计：");
		count.setFont(new Font("楷体", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(381, Short.MAX_VALUE)
					.addComponent(count, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(count))
		);
		panel_1.setLayout(gl_panel_1);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

	}
	
	protected void addListeners() {
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
				updateNums();
			}
		});
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
				updateNums();
			}
		});
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
				updateNums();
			}
		});
		
		startTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				updateNums();
			}
		});
		
		endTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				updateNums();
			}
		});
	}
}
