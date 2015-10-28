package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import po.PO;
import dataservice.MyList;

public class DataHelper{

	private String name;
	public DataHelper(String name) {
		super();
		this.name = name;
	}

	
	public boolean write(ArrayList<PO> r){

		File file = new File("file"+File.separator+name+".txt");
		try {
			FileWriter fW = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fW);
			for (PO e : r) {
				br.write(e.toString()+"\n");
			}
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public MyList<PO> allUsers() {
		MyList<PO> re = new MyList<PO>();
		File file = new File("file"+File.separator+name+".txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String record = null;
			while ((record = br.readLine()) != null) {
				re.add( PO.getInstance(record));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return re;
	}

	public boolean add(PO e) {
		
		ArrayList<PO> re = this.allUsers();
		re.add(e);
		this.write(re);
		return true;
	}

	public PO find(String id) {
		ArrayList<PO> re = this.allUsers();
		for (PO e : re) {
			if(e.getID().equals(id)) return e;
		}
		return null;
	}

	public boolean delete(PO e) {
		
			ArrayList<PO> re = this.allUsers();
			re.remove(e);
			this.write(re);
		    return true;
		
		
		
	}

	public boolean update(PO e) {
		ArrayList<PO> re = this.allUsers();
		for (PO po : re) {
			if(e.getID().equals(po.getID())){
				re.remove(po);
				re.add(e);
				break;
			}
		}
        this.write(re);
        return true;
	}
    
	

}
