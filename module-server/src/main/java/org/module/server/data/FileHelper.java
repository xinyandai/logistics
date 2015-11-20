package org.module.server.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileHelper {

	private File file;
	public FileHelper(File file) {

		this.file = file;
	}
	
	public ArrayList<String> read(){
		ArrayList<String> re =  new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String record = null;
			while ((record = br.readLine()) != null) {
				re.add(record);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return re;
	}

	public boolean rewrite(ArrayList<Object> os){
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fw);
			for (Object object : os) {
				br.write(object.toString()+"\n");
			}
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean add(Object object) {
		try {
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter br = new BufferedWriter(fw);
			
			
			br.write(object.toString()+"\n");
			
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}
