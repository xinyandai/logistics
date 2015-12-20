package org.module.client.businesslogic.managementbl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.table.TableModel;

public class ExcelExporter  {
    public ExcelExporter() { }
    public void exportTable(TableModel model, File file) throws IOException {
    	String charType = "UTF-8";
        FileOutputStream stream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(stream, charType);
        for(int i=0; i < model.getColumnCount()-1; i++) {
            writer.write(model.getColumnName(i) + "\t");
        }
        writer.write("\n");
        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount()-1; j++) {
                writer.write(model.getValueAt(i,j).toString()+"\t");
            }
            writer.write("\n");
        }
        writer.close();
    }
}
