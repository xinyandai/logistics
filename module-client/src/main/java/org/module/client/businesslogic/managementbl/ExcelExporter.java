package org.module.client.businesslogic.managementbl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.TableModel;

public class ExcelExporter  {
    public ExcelExporter() { }
    public void exportTable(TableModel model, File file) throws IOException {
        FileWriter out = new FileWriter(file);
        
        for(int i=0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");
        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i,j).toString()+"\t");
            }
            out.write("\n");
        }
        out.close();
    }
}
