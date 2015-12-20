package org.module.client.presentation;

import java.awt.Font;
import java.io.InputStream;

public class FontFactory {

	/**
	 *@param fontFileName外部字体名
	 * @param fontSize字体大小
	 * @return
	 */
	 private Font loadFont(String fontFilePath, float fontSize)  
	    {
	        try
	        {
	        	InputStream stream = this.getClass().getClassLoader().getResourceAsStream("font/"+fontFilePath);
	        //    File file = new File("font"+File.separator+fontFilePath);
	        //    FileInputStream fontFileStream = new FileInputStream(file);
	            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, stream);
	            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
	          //  fontFileStream.close();
	            stream.close();
	            return dynamicFontPt;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return new java.awt.Font("楷体", Font.PLAIN, 14);
	        }
	 }
	 
	 /**
	  * 
	  * @return 表格内容
	  */
	 public Font getTableElementFont(){
		 return this.loadFont("element.ttf", 15);
	 }
     /**
      * 
      * @return 输入信息格式
      */
	 public Font getInputFont(){
		 return this.loadFont("input.ttf", 15);
	 }
	 /**
	  * 
	  * @return 表格标题栏
	  */
	 public Font getTabelNameInput(){
		 return this.loadFont("name.ttf", 15);
	 }
	 /**
	  * @return 标题，状态提示
	  */
	 public Font getStateFont(){
		 return this.loadFont("title.ttf", 15);
	 }
	 /**
	  * 切换窗口标题栏
	  * @return
	  */
	 public Font getTabbeFont(){
		 return this.loadFont("title.ttf", 15);
	 }
}
