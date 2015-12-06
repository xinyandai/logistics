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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setLayout(null);
		
		JLabel label = new JLabel("选择城市1");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(55, 39, 81, 21);
		add(label);
		
		JLabel label_1 = new JLabel("选择城市2");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		label_1.setBounds(55, 82, 81, 21);
		add(label_1);
		
		cityA = new JComboBox(city);
		cityA.setBounds(165, 41, 61, 21);
		add(cityA);

		cityB = new JComboBox(city);
		cityB.setBounds(165, 82, 61, 21);
		add(cityB);
		
		JLabel label_2 = new JLabel("输入距离");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		label_2.setBounds(55, 124, 81, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("输入运费");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		label_3.setBounds(55, 159, 81, 21);
		add(label_3);
		
		distance = new JTextField();
		distance.setFont(new Font("楷体", Font.PLAIN, 18));
		distance.setBounds(165, 126, 66, 21);
		add(distance);
		distance.setColumns(10);
		
		carriage = new JTextField();
		carriage.setFont(new Font("楷体", Font.PLAIN, 18));
		carriage.setColumns(10);
		carriage.setBounds(165, 161, 66, 21);
		add(carriage);
		
		determine = new JButton("确定");
		determine.setFont(new Font("楷体", Font.PLAIN, 18));
		determine.setBounds(182, 226, 93, 23);
		add(determine);
		
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
