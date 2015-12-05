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

public class OfficeLoadListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5708449962639760332L;
	protected final int lengthOfID = 9;
	protected JTextField location;
	protected JTextField officeID;
	protected JTextField carID;
	protected JTextField monitor;
	protected JTextField TrucksNumber;
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
	/**
	 * Create the panel.
	 */
	public OfficeLoadListPanel() {

		init();
		
	}
	private void init(){
		labelOfDepartment = new JLabel("营业厅编号");
		labelOfDepartment.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("车辆代号");
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("监装员");
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("汽运编号");
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("装车时间");
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("押运员");
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_5 = new JLabel("目的地");
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		
		city = new JComboBox(array);
		
		location = new JTextField();
		location.setFont(new Font("楷体", Font.PLAIN, 15));
		location.setColumns(10);
		
		officeID = new JTextField();
		officeID.setColumns(10);
		
		carID = new JTextField();
		carID.setColumns(10);
		
		monitor = new JTextField();
		monitor.setColumns(10);
		
		TrucksNumber = new JTextField();
		TrucksNumber.setColumns(10);
		
		timerPicker = new JXDatePicker();
	//	timerPicker.setColumns(10);
		
		escort = new JTextField();
		escort.setColumns(10);
		
		price = new JTextField();
		price.setEditable(false);
		price.setText("￥ 88");
		price.setColumns(10);
		
		JLabel label_6 = new JLabel("运费");
		label_6.setFont(new Font("楷体", Font.PLAIN, 16));
		
		button = new JButton("确定");
		
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(203))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(labelOfDepartment)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(officeID, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(TrucksNumber, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(price, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(carID, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addGap(49)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(timerPicker, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(monitor, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addGap(49)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(escort, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(city, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(location, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(TrucksNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelOfDepartment)
							.addComponent(officeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(carID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(timerPicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(monitor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(escort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(location, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_5))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6)
						.addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button)
					.addGap(24))
		);
		
		state = new JLabel("");
		state.setFont(new Font("楷体", Font.PLAIN, 16));
		panel.add(state);
		
		JLabel label_7 = new JLabel("在下方填入本次装车所有托运单号");
		scrollPane.setColumnHeaderView(label_7);
		label_7.setFont(new Font("楷体", Font.PLAIN, 16));
		
		textPane = new JTextPane();
		
		scrollPane.setViewportView(textPane);
		
		
		setLayout(groupLayout);

		addListeners();
	}
	
	private void addListeners() {
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String[] shippingId = shippingId();
				if(shippingId==null) return ;
				controller.creat(
						timerPicker.getDate().getTime()+"", 
						officeID.getText(), 
						TrucksNumber.getText(), 
						city.getSelectedItem().toString(),
						location.getText(), 
						carID.getText(), 
						monitor.getText(),
						escort.getText(), 
						shippingId, 
						price.getText()
						
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

