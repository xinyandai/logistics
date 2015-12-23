package org.module.server.main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.module.server.javaRMI.RmiServer;
/**
 * 启动类
 * 注册RMI
 * 创建系统托盘
 * @author yan
 *
 */
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
	/**
	 * 系统托盘的显示
	 * @throws AWTException
	 */
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
            InputStream s = this.getClass().getClassLoader().getResourceAsStream("pic"+"/"+"tray.png");
            Image image ;
			try {
				image = ImageIO.read(s);
				 trayIcon = new TrayIcon(image.getScaledInstance(20, 20, Image.SCALE_DEFAULT), "物流管理系统服务端", popupMenu);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
           
			 systemTray = SystemTray.getSystemTray();  
	         systemTray.add(trayIcon);  
			
           
        }  
	}
}
