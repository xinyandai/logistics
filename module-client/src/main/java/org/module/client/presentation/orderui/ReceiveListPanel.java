package org.module.client.presentation.orderui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXDatePicker;


import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXDatePicker;


public class ReceiveListPanel extends JPanel {
	public ReceiveListPanel() {
		super();
		setLayout(null);
		initPanel();
	}

	public void initPanel() {
		// TODO 自动生成的方法存根
		removeAll();
		//消息提示框
		final JLabel jdjll = new JLabel();
		jdjll.setHorizontalAlignment(SwingConstants.CENTER);
		jdjll.setBounds(30, 20, 70, 35);
		jdjll.setFont(new Font("楷体", Font.PLAIN, 18));
		
		final JLabel jp4jl1 = new JLabel("订单号");
		jp4jl1.setBounds(5, 22, 100, 35);
		jp4jl1.setFont(new Font("楷体", Font.PLAIN, 16));
		// 设置标签上文字的对齐方式
		jp4jl1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jp4jl1);
		
		final JTextField jp4jf1 = new JTextField();
		jp4jf1.setBounds(105, 25, 100, 30);
		jp4jf1.setFont(new Font("楷体", Font.PLAIN, 16));
		add(jp4jf1);
		
		
		final JLabel jp4jl4 = new JLabel("收件人");
		jp4jl4.setBounds(5, 72, 100, 35);
		jp4jl4.setFont(new Font("楷体", Font.PLAIN, 16));
		jp4jl4.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jp4jl4);
		
		final JTextField jp4jf4 = new JTextField();
		jp4jf4.setBounds(105, 75, 100, 30);
		jp4jf4.setFont(new Font("楷体", Font.PLAIN, 16));
		add(jp4jf4);
			
		
		final JLabel jp4jl7 = new JLabel("收件日期");
		jp4jl7.setBounds(5, 122, 100, 35);
		jp4jl7.setFont(new Font("楷体", Font.PLAIN, 16));
		jp4jl7.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jp4jl7);
		
		final JXDatePicker timePicker1 = new JXDatePicker();
		timePicker1.setFont(new Font("楷体", Font.PLAIN, 18));
		timePicker1.getEditor().setText("YY-MM-DD");
		timePicker1.setBounds(105, 125, 100, 30);
		add(timePicker1);
		
		
		final JButton jp4jb1 = new JButton("确定");
		jp4jb1.setBounds(170, 185, 80, 32);
		jp4jb1.setFont(new Font("楷体", Font.PLAIN, 18));
		add(jp4jb1);
		
		/*final JButton jp4jb2 = new JButton("取消");
		jp4jb2.setBounds(310, 273, 80, 32);
		jp4jb2.setFont(new Font("楷体", Font.PLAIN, 18));
		add(jp4jb2);*/
		
		
		
		
		
		

		
		
	}

}
