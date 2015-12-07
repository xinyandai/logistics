package org.module.client.presentation.logisticsui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import org.module.client.vo.LogisticsVO;

public class MyList extends JList<Object>{

	
	private static final long serialVersionUID = -9013430164615811083L;
	
	public MyList(LogisticsVO vo){
		
		this.setModel(new MyModel(vo));
		this.setCellRenderer(new DefaultListCellRenderer(){

			private static final long serialVersionUID = -1465531171993177587L;
			@Override
			public Component getListCellRendererComponent(JList<?> list,
			        Object value,
			        int index,
			        boolean isSelected,
			        boolean cellHasFocus){
						
					if(value == null){
						return list;
					}
					JPanel panel = new JPanel ();
					JLabel lable1 = new JLabel(((String[]) value)[0]);
					JLabel lable2 = new JLabel(((String[]) value)[0]);
					panel.add(lable1);
					panel.add(lable2);
				return panel;
			}
		});
	}
	
	
}
