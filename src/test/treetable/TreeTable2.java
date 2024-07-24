package test.treetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import test.example.AbstractCellEditor;

public class TreeTable2 extends JTable {

    private static final long serialVersionUID = 1L;

    private TreeTableModel model;
    private DefaultMutableTreeNode node;
    
    private JTree tree = new JTree();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // UIManager.setLookAndFeel(new FlatLightLaf());
                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    f.setBounds(100, 100, 450, 400);
                    f.getContentPane().setLayout(new BorderLayout());

                    JScrollPane scrollPane_table = new JScrollPane();
                    f.getContentPane().add(scrollPane_table, BorderLayout.CENTER);

                    TreeTable2 table = new TreeTable2();
//					table.setRowHeight(200);
                    scrollPane_table.add(table);
                    scrollPane_table.setViewportView(table);

                    f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TreeTable2() {
        setCellSelectionEnabled(true);
        init();
    }

    public void init() {
        node = new DefaultMutableTreeNode(new TreeData("ROOT", "0"));
        DefaultMutableTreeNode node_1;
        node_1 = new DefaultMutableTreeNode(new TreeData("sub1", "1"));
        node_1.add(new DefaultMutableTreeNode(new TreeData("sub1-1", "2")));
        node.add(node_1);
        DefaultMutableTreeNode node_2;
        node_2 = new DefaultMutableTreeNode(new TreeData("sub2", "1"));
        node_2.add(new DefaultMutableTreeNode(new TreeData("sub2-111111111111111", "2")));
        node.add(node_2);

        model = new TreeTableModel(node);
        setModel(model);
        
        tree.setModel(new DefaultTreeModel(node));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.getClickCount() == 2) {
//					TreeTableNode ttn = node.getVisibleNode(getSelectedRow());
//					ttn.setOpen(!ttn.isOpen());
//					model.changeOpen(getSelectedRow());
//					revalidate();
                }
                super.mouseClicked(e);
            }

        });

//		setRowHeight(30);



//		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) getDefaultRenderer(Object.class);
//		Icon ii = UIManager.getIcon("Tree.closedIcon");
//		renderer.setIcon(ii);
        
        MyTableCellRenderer renderer = new MyTableCellRenderer();
        setDefaultRenderer(DefaultMutableTreeNode.class, renderer);

        MyTableCellEditor editor = new MyTableCellEditor();
        setDefaultEditor(DefaultMutableTreeNode.class, editor);

    }

    class MyTableCellEditor implements TableCellEditor {
        private static final long serialVersionUID = -1889933997649720041L;

        public MyTableCellEditor() {
            setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public Object getCellEditorValue() {
            // TODO Auto-generated method stub
//            System.out.println("getCellEditorValue : "+getNode());
            return null;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            // TODO Auto-generated method stub
            System.out.println("isCellEditable");
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            // TODO Auto-generated method stub
            System.out.println("shouldSelectCell");
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            // TODO Auto-generated method stub
            System.out.println("stopCellEditing");
            return true;
        }

        @Override
        public void cancelCellEditing() {
            // TODO Auto-generated method stub
            System.out.println("cancelCellEditing");
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
            // TODO Auto-generated method stub

        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            // TODO Auto-generated method stub

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            // TODO Auto-generated method stub
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            return tree;
        }

    }

    class MyTableCellRenderer implements TableCellRenderer {

        private static final long serialVersionUID = -8366489318298212512L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

            return tree;
        }

    }

    class TreeTableModel extends AbstractTableModel {
        /**
         * 
         */
        private static final long serialVersionUID = 1402872757399399773L;
        private DefaultMutableTreeNode node;

        public TreeTableModel(DefaultMutableTreeNode node) {
            this.node = node;
        }

//        public void setOpen(int rowIndex, boolean isOpen) {
//            list_data.get(rowIndex).setOpen(isOpen);
//            list_data = node.getVisibleNodeList();
//        }
//
//        public void changeOpen(int rowIndex) {
//            list_data.get(rowIndex).setOpen(!list_data.get(rowIndex).isOpen());
//            list_data = node.getVisibleNodeList();
//        }

        @Override
        public int getRowCount() {
//			System.out.println("getRowCount : "+list_data.size());
            return tree.getRowCount();
        }

        @Override
        public int getColumnCount() {
            // TODO Auto-generated method stub
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // TODO Auto-generated method stub

            // System.out.println("getValueAt : "+rowIndex+" / "+columnIndex);

//            if (columnIndex == 0) {
//                return tree.getModel().  list_data.get(rowIndex);
//            } else {
//                return list_data.get(rowIndex).getTreeData().getType();
//            }
            return null;
        }
        


        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return DefaultMutableTreeNode.class;
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            // TODO Auto-generated method stub
            if (columnIndex == 0) {
                return true;
            } else {
                return false;
            }
//			return super.isCellEditable(rowIndex, columnIndex);
        }
    }

}
