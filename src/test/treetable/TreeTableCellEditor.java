package test.treetable;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import test.example.AbstractCellEditor;

public class TreeTableCellEditor extends AbstractCellEditor implements TableCellEditor {
	private TreeTableCellRenderer treeRenderer;
	
	public TreeTableCellEditor(TreeTableCellRenderer treeRenderer) {
		this.treeRenderer = treeRenderer;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int r, int c) {
		return treeRenderer;
	}
}