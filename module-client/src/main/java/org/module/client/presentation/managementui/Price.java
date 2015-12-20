package org.module.client.presentation.managementui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.module.client.businesslogic.managementbl.PriceAndCityManageController;
import org.module.client.vo.PriceAndCityVO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Price extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField distance;
	private JTextField carriage;

	String[] city ;
	private PriceAndCityManageController controller = new PriceAndCityManageController();
	private JComboBox cityA;
	private JComboBox cityB;
	private JButton determine;
	
	public Price() {
		this.city = this.controller.getAllCitiesArray();
		
		JLabel label = new JLabel("选择城市1");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("选择城市2");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		cityA = new JComboBox(city);

		cityB = new JComboBox(city);
		
		JLabel label_2 = new JLabel("输入距离");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("输入运费");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		distance = new JTextField();
		distance.setFont(new Font("楷体", Font.PLAIN, 18));
		distance.setColumns(10);
		
		carriage = new JTextField();
		carriage.setFont(new Font("楷体", Font.PLAIN, 18));
		carriage.setColumns(10);
		
		determine = new JButton("确定");
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(distance, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(carriage, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(label)
							.addGap(29)
							.addComponent(cityA, 0, 110, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(182)
							.addComponent(determine, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(label_1)
							.addGap(29)
							.addComponent(cityB, 0, 110, Short.MAX_VALUE)))
					.addGap(175))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(cityA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(cityB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(distance, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(carriage, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addComponent(determine, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		
		this.addListeners();

	}
	
	
	private void addListeners(){
		cityA.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				update();
			}
		});
		
		cityB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				update();
			}
		});
		
		determine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				save();
			}
		});
	}
	
	private void update(){
		PriceAndCityVO vo = this.controller.getDiretionAndPrice(
				cityA.getSelectedIndex(), cityB.getSelectedIndex());
		this.distance.setText(vo.getDistance());
		this.carriage.setText(vo.getPrice());
	}
	
	private void save(){
		this.controller.setDiretionAndPrice(cityA.getSelectedIndex(), cityB.getSelectedIndex(),
				distance.getText(), carriage.getText());
	}
}
