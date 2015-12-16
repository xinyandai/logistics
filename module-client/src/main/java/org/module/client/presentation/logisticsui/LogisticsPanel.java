package org.module.client.presentation.logisticsui;

import java.awt.BorderLayout;
import java.awt.Font;
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
import org.module.client.presentation.Numeric;
import org.module.client.presentation.ResultFrame;
import org.module.client.vo.LogisticsVO;

public class LogisticsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField ID;
	private JList list;
	private JScrollPane scrollPane;
	private LogisticsBLService controller = new LogisticsController();
	/**
	 * Create the panel.
	 */
	public LogisticsPanel() {
		setBorder(new CompoundBorder());
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblInputId = new JLabel("输入订单号");
		lblInputId.setFont(new Font("楷体", Font.PLAIN, 15));
		panel.add(lblInputId);
		
		ID = new JTextField();
		ID.setFont(new Font("楷体", Font.PLAIN, 13));
		panel.add(ID);
		ID.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				search();
			}
		});
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setToolTipText("搜索");
		panel.add(label);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		

	}

	protected void search() {
		
		/*if(!Numeric.isWholeNumber(this.ID.getText()) || this.ID.getText().length() != 9){
			return;
		}*/
		
		LogisticsVO vo = this.controller.showState(this.ID.getText());
		
		if(vo == null){
			new ResultFrame(false);
			return;
		}
		list = new MyList(vo);
		scrollPane.setViewportView(list);
	}
	
}
	


