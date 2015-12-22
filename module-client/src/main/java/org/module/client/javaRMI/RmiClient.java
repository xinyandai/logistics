package org.module.client.javaRMI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class RmiClient {

	
	
	@SuppressWarnings("unchecked")
	public  <T> T get(Class<T> cla){
		String url="rmi://"+this.read()+"/"+cla.getName();
		T service;   
		 try {
			service = (T)Naming.lookup(url);
			return service;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch ( RemoteException  e) {
			e.printStackTrace();
		} catch ( NotBoundException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public String read(){
		String re = "127.0.0.1";
		try {
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream("config"+File.separator+"config.txt"),"UTF-8");
			BufferedReader br = new BufferedReader(reader);
			re = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return re;
	}
}
