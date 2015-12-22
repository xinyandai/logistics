package org.module.client.presentation;

import java.util.ArrayList;
import java.util.BitSet;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.module.client.vo.AbstractVO;

public class Table extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6531466986196769453L;
	private ArrayList<? extends AbstractVO> list;
	private String[] name;
	private int checkBoxIndex;
	final private String checkBoxColumnName = "选择";
	private BitSet checkBitSet = new BitSet();
	
	
	
	public Table(ArrayList<? extends AbstractVO> list, String[] s) {
		
		this.list = list;
		this.name = s;
		this.checkBoxIndex = s==null? 0 : s.length;
		
		this.addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e) {
				if (e.getType() != TableModelEvent.UPDATE//insert,delete
	                    || e.getLastRow() == Integer.MAX_VALUE//fireTableDataChanged
	                    || e.getLastRow() == TableModelEvent.HEADER_ROW){
					 checkBitSet.clear();
					/* fireTableChanged(new TableModelEvent(
							 Table.this, 0, getRowCount() - 1,
		                        checkBoxIndex, TableModelEvent.UPDATE));*/
				}
			}
			
		});
	}

	public void setName(String[] name) {
		this.name = name;
		this.checkBoxIndex = name==null? 0 : name.length;
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
            return this.list.get(rowIndex).get(columnIndex-1);
        else
            return this.list.get(rowIndex).get(columnIndex);
		
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
        int nextIndex = -1;
        for (int n = 0; n < checkBitSet.cardinality(); n++) {
            nextIndex = checkBitSet.nextSetBit(nextIndex + 1);
            indexes[n] = nextIndex;
        }
      
        return indexes; 
	}
	
	 @Override
	    public String getColumnName(int columnIndex) {
		 try{
			 if (columnIndex == checkBoxIndex)
		            return checkBoxColumnName;
		        else if (columnIndex > checkBoxIndex)
		            return name[columnIndex - 1];
		        else{
		        	return name[columnIndex];
		        }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return "empty";
	       
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
	    
	    
	    public void setList(ArrayList<? extends AbstractVO> list) {
			this.list = list;
		}
}
