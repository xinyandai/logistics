package org.module.client.presentation;

import java.util.BitSet;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
/**
 * 将一个TableMode封装成新的AbstractTableModel，在其中添加一列，用以标识是否被选中
 * @author trytocatch@163.com
 * @date 2013-4-30
 */
public class CheckBoxTableModelProxy extends AbstractTableModel {
    private static final long serialVersionUID = 4419095637613592975L;
   
    protected TableModel tableModel;
    protected String checkBoxColumnName;
    protected BitSet checkBitSet;
    protected int checkBoxIndex;

    public CheckBoxTableModelProxy(TableModel model,
            String checkBoxColumnName) {
        this(model, checkBoxColumnName, 0);
    }

    public CheckBoxTableModelProxy(TableModel model,
            String checkBoxColumnName, int checkBoxIndex) {
        if (model == null)
            throw new IllegalArgumentException("model can't be null");
        if (checkBoxIndex > model.getColumnCount())
            throw new IllegalArgumentException(
                    "checkBoxIndex can't be greater than colunm size");
        this.tableModel = model;
        this.checkBoxColumnName = checkBoxColumnName;
        this.checkBoxIndex = checkBoxIndex < 0 ? 0 : checkBoxIndex;
        checkBitSet = new BitSet();
        model.addTableModelListener(new EventRedirector());
    }

  
    public int getRowCount() {
    	
        return tableModel.getRowCount();
    }

   
    public int getColumnCount() {
        return tableModel.getColumnCount() + 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == checkBoxIndex)
            return checkBoxColumnName;
        else if (columnIndex > checkBoxIndex)
            return tableModel.getColumnName(columnIndex - 1);
        else
            return tableModel.getColumnName(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == checkBoxIndex)
            return Boolean.class;
        else if (columnIndex > checkBoxIndex)
            return tableModel.getColumnClass(columnIndex - 1);
        else
            return tableModel.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == checkBoxIndex)
            return true;
        else if (columnIndex > checkBoxIndex)
            return tableModel.isCellEditable(rowIndex, columnIndex - 1);
        else
            return tableModel.isCellEditable(rowIndex, columnIndex);
    }

  
    public Object getValueAt(int rowIndex, int columnIndex) {
    	
        if (columnIndex == checkBoxIndex)
            return checkBitSet.get(rowIndex);
        else if (columnIndex > checkBoxIndex)
            return tableModel.getValueAt(rowIndex, columnIndex - 1);
        else
            return tableModel.getValueAt(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == checkBoxIndex){
            checkBitSet.set(rowIndex, (Boolean) aValue);
            fireTableChanged(new TableModelEvent(this, rowIndex, rowIndex, columnIndex));
        } else if (columnIndex > checkBoxIndex)
            tableModel.setValueAt(aValue, rowIndex, columnIndex - 1);
        else
            tableModel.setValueAt(aValue, rowIndex, columnIndex);

    }

    public int[] getCheckedIndexes() {
        int[] indexes = new int[checkBitSet.cardinality()];
        int nextIndex = -1;
        for (int n = 0; n < indexes.length; n++) {
            nextIndex = checkBitSet.nextSetBit(nextIndex + 1);
            indexes[n] = nextIndex;
        }
        return indexes;
    }

    private class EventRedirector implements TableModelListener {
        
        public void tableChanged(TableModelEvent e) {
            int Column = e.getColumn();
            if (Column >= checkBoxIndex)
                Column++;
            fireTableChanged(new TableModelEvent(CheckBoxTableModelProxy.this,
                    e.getFirstRow(), e.getLastRow(), Column, e.getType()));
            if (e.getType() != TableModelEvent.UPDATE//insert,delete
                    || e.getLastRow() == Integer.MAX_VALUE//fireTableDataChanged
                    || e.getLastRow() == TableModelEvent.HEADER_ROW) {//fireTableStructureChanged
                checkBitSet.clear();
                fireTableChanged(new TableModelEvent(
                        CheckBoxTableModelProxy.this, 0, getRowCount() - 1,
                        checkBoxIndex, TableModelEvent.UPDATE));
            }
        }
    }
}
