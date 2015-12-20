package org.module.client.presentation.logisticsui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import org.module.client.presentation.FontFactory;
import org.module.client.vo.LogisticsVO;

public class MyList extends JList<Object>{

	
	private static final long serialVersionUID = -9013430164615811083L;
	private FontFactory font = new FontFactory();
	
	public MyList(LogisticsVO vo){
		
		this.setModel(new MyModel(vo));
		this.setFont(this.font.getTableElementFont());
		this.setOpaque(false);
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
					lable1.setFont(font.getTableElementFont());
					JLabel lable2 = new JLabel(((String[]) value)[1]);
					lable2.setFont(font.getTableElementFont());
					panel.add(lable1);
					panel.add(lable2);
				return panel;
			}
		});
	}
	
	
}
