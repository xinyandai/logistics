package org.module.server.main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.module.server.javaRMI.RmiServer;

public class Main {

    private SystemTray systemTray;  
    private TrayIcon trayIcon;  
    private RmiServer  rmi;
    
	public static void main(String[] args){
		try {
			new Main();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
    
	public Main() throws AWTException{
		rmi = new RmiServer();
		rmi.rebind();
		this.creatTray();
	}
	private void creatTray() throws AWTException{
		if (SystemTray.isSupported()) { 
			
            PopupMenu popupMenu = new PopupMenu();  
            MenuItem restart = new MenuItem("restart");  
            MenuItem exit = new MenuItem("exit");  
            popupMenu.add(restart);  
            popupMenu.add(exit);  
            exit.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    System.exit(0);  
                }  
            });  
            restart.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                	rmi.rebind();  
                }  
            });  
            Image image = Toolkit.getDefaultToolkit().getImage("pic"+File.separator+"tray.png");  
            trayIcon = new TrayIcon(image.getScaledInstance(20, 20, Image.SCALE_DEFAULT), "物流管理系统服务端", popupMenu);
			 systemTray = SystemTray.getSystemTray();  
	         systemTray.add(trayIcon);  
			
           
        }  
	}
}
