package org.module.client.presentation;

import java.util.ArrayList;
import java.util.BitSet;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class MyTable extends AbstractTableModel {


	private static final long serialVersionUID = 1471177073613950851L;

	private ArrayList<String[]> list;
	
	
	public void setList(ArrayList<String[]> list) {
		this.list = list;
	}



	private String[] name;
	final private int checkBoxIndex;
	final private String checkBoxColumnName = "选择";
	private BitSet checkBitSet = new BitSet();
	
	public MyTable(ArrayList<String[]> list, String[] s) {
		
		this.list = list;
		//System.out.println(list.size());
		this.name = s;
		this.checkBoxIndex = s.length;
		this.addTableModelListener(new TableModelListener(){

			public void tableChanged(TableModelEvent e) {
				
				if (e.getType() != TableModelEvent.UPDATE//insert,delete
	                    || e.getLastRow() == Integer.MAX_VALUE//fireTableDataChanged
	                    || e.getLastRow() == TableModelEvent.HEADER_ROW){
					 checkBitSet.clear();
					 /*fireTableChanged(new TableModelEvent(
							 MyTable.this, 0, getRowCount() - 1,
		                        checkBoxIndex, TableModelEvent.UPDATE));*/
				}
			}
			
		});
	}

	public int getRowCount() {
		if(list!=null){
			return list.size();
		}
		return 0;
	}

	public int getColumnCount() {
		if(name!=null){
			return name.length+1;
		}
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if (columnIndex == checkBoxIndex)
            return checkBitSet.get(rowIndex);
        else if (columnIndex > checkBoxIndex)
            return this.list.get(rowIndex)[columnIndex-1];
        else
            return this.list.get(rowIndex)[columnIndex];
		
	}

	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == checkBoxIndex){
            checkBitSet.set(rowIndex, (Boolean) aValue);
            fireTableChanged(new TableModelEvent(this, rowIndex, rowIndex, columnIndex));
        } else if (columnIndex > checkBoxIndex){
        
        }else{
        	
        }
    }
	
	
	
	 
	public int[] getCheckedIndexes() {
		int[] indexes = new int[checkBitSet.cardinality()];
		System.out.println("idnex :"+indexes.length);
        int nextIndex = -1;
        for (int n = 0; n < checkBitSet.cardinality(); n++) {
            nextIndex = checkBitSet.nextSetBit(nextIndex + 1);
            indexes[n] = nextIndex;
        }
      
        return indexes; 
	}
	
	 @Override
	    public String getColumnName(int columnIndex) {
	        if (columnIndex == checkBoxIndex)
	            return checkBoxColumnName;
	        else if (columnIndex > checkBoxIndex)
	            return name[columnIndex - 1];
	        else
	            return name[columnIndex];
	    }

	    @Override
	    public Class<?> getColumnClass(int columnIndex) {
	        if (columnIndex == checkBoxIndex)
	            return Boolean.class;
	        else 
	        	return String.class;
	    }

	    
	    @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	    	if (columnIndex == checkBoxIndex){
	    		return true;
	    	}
	    	return false;
	    }
	    
	    
	
	

	
}
