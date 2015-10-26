package data.userdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import po.UserPO;
import dataservice.userdataservice.UserDataService;


public class UserDataImpl implements UserDataService {

	private String spt = ":%:%:";
	
	public UserPO toPO(String s){
		return new UserPO(s.split(spt));
	}
	public boolean write(ArrayList<UserPO> r){

		File file = new File("file"+File.separator+"user.txt");
		try {
			FileWriter fW = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fW);
			for (UserPO userPO : r) {
				br.write(userPO.toString()+"\n");
			}
			br.flush();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public ArrayList<UserPO> allUsers() {
		ArrayList<UserPO> re = new ArrayList<UserPO>();
		File file = new File("file"+File.separator+"user.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String record = null;
			while ((record = br.readLine()) != null) {
				re.add(this.toPO(record));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean add(UserPO user) {
		
		ArrayList<UserPO> re = this.allUsers();
		re.add(user);
		this.write(re);
		return false;
	}

	@Override
	public UserPO find(String id) {
		ArrayList<UserPO> re = this.allUsers();
		for (UserPO userPO : re) {
			if(userPO.getId().equals(id)) return userPO;
		}
		return null;
	}

	@Override
	public boolean delete(UserPO user) {
		try{
			ArrayList<UserPO> re = this.allUsers();
			re.remove(user);
			this.write(re);
			return true;
		}catch(Exception e){
			return false;
		}
		
		
		
	}

	@Override
	public boolean update(UserPO old) {
		try{
			ArrayList<UserPO> re = this.allUsers();
			for (UserPO userPO : re) {
				if(old.getId().equals(userPO.getId())){
					re.remove(userPO);
					break;
				}
			}
			this.write(re);
			return true;
		}catch(Exception e){
			return false;
		}
	
	}
    
	

	
}
