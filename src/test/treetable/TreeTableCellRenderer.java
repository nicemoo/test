package test.treetable;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeModel;

public class TreeTableCellRenderer extends JTree implements TableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2097707957816172428L;
	
	protected int visibleRow;
	private JTable table;

	public TreeTableCellRenderer(TreeModel model) {
		setModel(model);
	}
	
	public void setTable(JTable table) {
		this.table = table;
		setRowHeight(table.getRowHeight());
	}

	public void setBounds(int x, int y, int w, int h) {
		System.out.println("setBounds : "+x+" "+y+" "+w+" "+h);
		
		super.setBounds(x, 0, w, table.getHeight());
//		super.setBounds(x, y, w, h);
	}

	public void paint(Graphics g) {
		System.out.println("paint rowcount : "+getRowCount());
//		System.out.println(visibleRow);
//		System.out.println(getRowHeight());
		System.out.println(-visibleRow * getRowHeight() -1);
		g.translate(1, -visibleRow * getRowHeight()-1);
		
		System.out.println("paint end");
		super.paint(g);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		System.out.println("row : "+row);
		visibleRow = row;
		return this;
	}
}
