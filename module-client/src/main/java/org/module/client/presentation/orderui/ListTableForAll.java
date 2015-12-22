package org.module.client.presentation.orderui;

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

import org.module.client.presentation.Button;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.Table;
import org.module.client.vo.AbstractVO;

public abstract class ListTableForAll extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1496144533263177050L;
	protected JButton add;
	protected String[] typeArray ;
	protected ArrayList<? extends AbstractVO> listCell;
	protected JButton modify;
	protected JButton refresh;
	protected Table table;
	protected JScrollPane scrollPane;
	protected FontFactory font;
	
	public ListTableForAll() {
		font = new FontFactory();
		initData();
		init();
		addListeners();
		table =   new Table(this.listCell,this.typeArray);
		JTable t = new JTable(table);
		t.setOpaque(false);
		t.setFont(font.getTableElementFont());
		t.getTableHeader().setFont(font.getTabelNameInput());
		this.scrollPane.setViewportView(t);
		this.refresh();
	}

	

	protected  abstract void initData() ;
	protected  abstract void refresh();
	protected abstract  void modify() ;
	protected abstract void add(); 

	protected void init(){
		setLayout(new BorderLayout(0, 0));
		this.setOpaque(false);
		this.setBorder(null);
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setOpaque(false);
		refresh = new Button("refresh");
		refresh.setToolTipText("刷新");
		modify = new Button("modify");
		modify.setToolTipText("对已提交单据进行修改");
		add = new Button("add");
		add.setToolTipText("新建新单据进行提交");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(230, Short.MAX_VALUE)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(modify, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(4))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(modify, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(refresh, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
		);
		panel.setLayout(gl_panel);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

	}
	
	protected void addListeners() {
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
			}
		});
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
			}
		});
	}
}
