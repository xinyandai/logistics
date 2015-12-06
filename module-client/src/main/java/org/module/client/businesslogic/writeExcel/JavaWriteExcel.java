package org.module.client.businesslogic.writeExcel;

import java.io.*;
import jxl.*;
public class JavaWriteExcel{
	public static void writeExcel(OutputStream os,excelDate date) throws Exception {
		
		jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(os);
		jxl.write.WritableSheet ws = wwb.createSheet("TestSheet1", 0);
		int i=date.getI();
		int j=date.getJ();
		jxl.write.Label labelC ;
		for(int x=0;x<i;x++){
			for(int z=0;z<j;z++){
				labelC=new jxl.write.Label(z, x, date.getString(z, x));
				ws.addCell(labelC);
			}
		}
		
		
		//写入excel工作表
		wwb.write();
		//关闭excel工作簿对象
		wwb.close();
	}

	public static void main(String[] args)throws Exception{
		File f=new File("kkk.xls");
		excelDate date=new excelDate();
		f.createNewFile();
		writeExcel(new FileOutputStream(f),date);
	}
}
