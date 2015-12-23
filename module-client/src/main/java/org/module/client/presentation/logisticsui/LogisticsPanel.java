package org.module.client.presentation.logisticsui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

import org.module.client.businesslogic.logisticsbl.LogisticsController;
import org.module.client.businesslogicservice.logisticsBLservice.LogisticsBLService;
import org.module.client.presentation.FontFactory;
import org.module.client.presentation.Numeric;
import org.module.client.presentation.ResultFrame;
import org.module.client.vo.LogisticsVO;

public class LogisticsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField ID;
	private JList list;
	private JScrollPane scrollPane;
	private LogisticsBLService controller = new LogisticsController();
	private FontFactory font = new FontFactory();
	
	public LogisticsPanel() {
		this.setOpaque(false);
		setBorder(new CompoundBorder());
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblInputId = new JLabel("输入订单号");
		lblInputId.setFont(font.getTableElementFont());
		panel.add(lblInputId);
		
		ID = new JTextField();
		ID.setFont(font.getInputFont());
		panel.add(ID);
		ID.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.setFont(font.getTableElementFont());
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search();
			}
		});
		panel.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		add(scrollPane, BorderLayout.CENTER);
		
		

	}

	protected void search() {
		
		if(!Numeric.isNumeric(this.ID.getText()) || this.ID.getText().length() != 10){
			new ResultFrame(false);
			return;
		}
		
		LogisticsVO vo = this.controller.showState(this.ID.getText());
		
		if(vo == null){
			new ResultFrame(false);
			return;
		}
		list = new MyList(vo);
		scrollPane.setViewportView(list);
	}
	
}
	


