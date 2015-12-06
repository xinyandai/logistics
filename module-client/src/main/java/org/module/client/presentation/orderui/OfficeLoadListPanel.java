package org.module.client.presentation.orderui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.swingx.JXDatePicker;
import org.module.client.businesslogic.orderbl.OfficeLoadingController;
import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;
import org.module.common.po.State;

public class OfficeLoadListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5708449962639760332L;
	protected final int lengthOfID = 9;
	protected JTextField officeID;
	protected JTextField monitor;
	protected JXDatePicker timerPicker;
	protected JTextField escort;
	protected JTextField price;

	protected OfficeLoadingBLService controller = new OfficeLoadingController();
	protected JButton button;
	protected JComboBox city;
	protected JScrollPane scrollPane;
	protected JTextPane textPane;
	
	
	protected JLabel state;
	protected String[] array = {"南京","上海","北京"};
	protected JLabel labelOfDepartment;
	protected JTextField carID;
	protected JTextField TrucksNumber;
	protected JComboBox location;
	/**
	 * Create the panel.
	 */
	public OfficeLoadListPanel() {

		init();
		
	}
	private void init(){
		labelOfDepartment = new JLabel("营业厅编号");
		labelOfDepartment.setBounds(34, 29, 80, 19);
		labelOfDepartment.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("车辆代号");
		label.setBounds(34, 58, 77, 19);
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("监装员");
		label_1.setBounds(34, 89, 77, 19);
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("汽运编号");
		label_2.setBounds(254, 29, 71, 19);
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("装车时间");
		label_3.setBounds(255, 58, 71, 19);
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("押运员");
		label_4.setBounds(255, 89, 71, 19);
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_5 = new JLabel("目的地");
		label_5.setBounds(34, 118, 77, 19);
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		
		city = new JComboBox(array);
		city.setBounds(124, 119, 53, 21);
		
		officeID = new JTextField();
		officeID.setBounds(124, 29, 84, 21);
		officeID.setColumns(10);
		
		monitor = new JTextField();
		monitor.setBounds(124, 89, 84, 21);
		monitor.setColumns(10);
		
		timerPicker = new JXDatePicker();
		timerPicker.setBounds(336, 58, 84, 23);
		
		escort = new JTextField();
		escort.setBounds(336, 89, 84, 21);
		escort.setColumns(10);
		
		price = new JTextField();
		price.setBounds(124, 150, 84, 21);
		price.setEditable(false);
		price.setText("￥ 88");
		price.setColumns(10);
		
		JLabel label_6 = new JLabel("运费");
		label_6.setBounds(34, 150, 71, 19);
		label_6.setFont(new Font("楷体", Font.PLAIN, 16));
		
		button = new JButton("确定");
		button.setBounds(205, 385, 69, 29);
		
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 181, 433, 194);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 467, 23);
		
		JLabel label_8 = new JLabel("目的地");
		label_8.setBounds(255, 119, 77, 19);
		label_8.setFont(new Font("楷体", Font.PLAIN, 16));
		
		state = new JLabel("");
		state.setFont(new Font("楷体", Font.PLAIN, 16));
		panel.add(state);
		
		JLabel label_7 = new JLabel("在下方填入本次装车所有托运单号");
		scrollPane.setColumnHeaderView(label_7);
		label_7.setFont(new Font("楷体", Font.PLAIN, 16));
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		setLayout(null);
		add(label_8);
		add(button);
		add(scrollPane);
		add(labelOfDepartment);
		add(officeID);
		add(label_2);
		add(label_6);
		add(price);
		add(label_5);
		add(label_1);
		add(label);
		add(label_3);
		add(timerPicker);
		add(monitor);
		add(label_4);
		add(escort);
		add(city);
		add(panel);
		
		carID = new JTextField();
		carID.setColumns(10);
		carID.setBounds(124, 60, 84, 21);
		add(carID);
		
		TrucksNumber = new JTextField();
		TrucksNumber.setColumns(10);
		TrucksNumber.setBounds(335, 29, 84, 21);
		add(TrucksNumber);
		
		location = new JComboBox(new Object[]{});
		location.setBounds(336, 119, 53, 21);
		add(location);
		addListeners();
	}
	
	private void addListeners() {
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String[] shippingId = shippingId();
				if(shippingId==null) return ;
				controller.creat( 
						new OfficeLoadingListVO(
						timerPicker.getDate().getTime()+"", 
						officeID.getText(), 
						TrucksNumber.getText(), 
						city.getSelectedItem().toString(),
						location.getSelectedItem().toString(),
						carID.getText(), 
						monitor.getText(),
						escort.getText(), 
						shippingId, 
						price.getText(),
						State.SUBMITTED
						)
						);
				
				
			}
		});
		
	}
	
	protected String[] shippingId(){
			String[] shippingId = null;
			
			String   text = textPane.getText();
			while(text.charAt(text.length()-1)=='\r'  || text.charAt(text.length()-1)==' '
					||text.charAt(text.length()-1)=='\n' ){
				text = text.substring(0, text.length()-1);
			}
			shippingId = text.split("\r",0);
			
			
			for (String string : shippingId) {
				System.out.println("-2:"+string);
				string = string.replace("\r", "");
				System.out.println("-1:"+string);
				string = string.replace("\n", "");
				System.out.println("0:"+string);
				if(string.length()!=lengthOfID){
					System.out.println("1:"+string);
					System.out.println("2:"+string.length());
					state.setText("托运单号请以空格或回车隔开");
					return null;
				}else{
					System.out.println("3:"+string);
					System.out.println("4:"+string.length());
				}
				
			}
		    state.setText("格式正确");
		    return shippingId;
	}
}

