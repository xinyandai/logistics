package org.module.common.dataservice;

public class MySearch {

	/**
	 * 
	 * @param tobematch  查找字符
	 * @param key 关键字
	 * @return 相似度
	 */
	public double similarity(String tobematch,String key){
		double re = 0;
		
		for (int i = 0; i < key.length(); i++) {
			
			double weight = 1.0; 
			for(int j = 0; j<tobematch.length(); j++){
				if(key.charAt(i)==tobematch.charAt(j)){
					weight = weight/2;
					re += weight;
				}
			}
		}
		System.out.println(re);
		System.out.println(key.length());
		return re/key.length();
	}
	
}
