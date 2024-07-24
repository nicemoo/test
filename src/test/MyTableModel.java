package test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> list_header = new ArrayList<String>();
	private List<List<Object>> data = new ArrayList<List<Object>>();
	
	public void setHeader(List<String> list_header) {
		this.list_header = list_header;
		fireTableStructureChanged();
	}
	
	public void addColumn(String column_name) {
		list_header.add(column_name);
		fireTableStructureChanged();
	}
	
	public void setData(List<List<Object>> data) {
		this.data = data;
		fireTableDataChanged();
	}
	
	public void addRow(List<Object> row) {
		this.data.add(row);
		fireTableDataChanged();
	}
	
	public void clear() {
		list_header.clear();
		data.clear();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		if(list_header == null) {
			return 0;
		}
		
		return list_header.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		if(list_header == null) {
			return null;
		}
		
		return list_header.get(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return Object.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(data == null) {
			return null;
		}
		return data.get(rowIndex).get(columnIndex);
	}



}
