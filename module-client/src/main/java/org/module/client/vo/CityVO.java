package org.module.client.vo;

public class CityVO {

	private String name;
	private String id;
	
	
	private String split=":%:%:";
	
	
	@Override
	public String toString(){
		return this.name+this.split+this.id;
	}
	public CityVO(String str){
		super();
		String[] strs=str.split(this.split);
		this.name=strs[0];
		this.id=strs[1];
	}
	public CityVO(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum() {
		// TODO Auto-generated method stub
		return 2;
	}
	public String[] toArray() {
		String[] array = {name ,id};
		return array;
	}
	public String getMainKey() {
		// TODO Auto-generated method stub
		return id;
	}
		
}
