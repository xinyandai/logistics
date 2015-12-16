package org.module.client.presentation.managementui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PathGetter {
	private JFileChooser  chooser;
	public PathGetter(){
		this.chooser = new JFileChooser();
		int x,y,w,h;
		w = 400;
		h = 300;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		x = (int) (d.getWidth()/2 - w/2);
		y =   (int) (d.getHeight()/2 - h/2);
		this.chooser.setSize(w, h);
		this.chooser.setLocation(x, y);
		
		
		 FileNameExtensionFilter fileter = new FileNameExtensionFilter("xls�ļ�", "xls");
		 this.chooser.setFileFilter(fileter);
		 File file = new File("warehouse.xls");
		 this.chooser.setCurrentDirectory(new File("."));
		 this.chooser.setSelectedFile(file);
	//	 int result = this.chooser.showSaveDialog(null); 
	//	 System.out.println(this.chooser.getSelectedFile());
	}

	public File getPath(Component c){
		int re = this.chooser.showSaveDialog(c);
		if(re==JFileChooser.SAVE_DIALOG){
			return null;
		}
		return this.chooser.getSelectedFile();
	}
}
