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

public class TreeTable extends JTable {

    private static final long serialVersionUID = 1L;

    private TreeTableModel model;
    private TreeTableNode node;

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

                    TreeTable table = new TreeTable();
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
    public TreeTable() {
        setCellSelectionEnabled(true);
        init();

//		UIDefaults ui = UIManager.getLookAndFeelDefaults();
//		
//		Set<Entry<Object, Object>> es = ui.entrySet();
//		for(Entry<Object, Object> entry : es) {
//			String s = entry.getKey().toString();
//			if(s.startsWith("Tree.")) {
//				System.out.println(entry.getKey()+":"+entry.getValue());
//			}
//		}

//		Enumeration<Object> eum = ui.elements();
//		while(eum.hasMoreElements()) {
//			Object o = eum.nextElement();
//			System.out.println(o.getClass() + " / "+o);
//			
//		}
    }

    public void init() {
        node = new TreeTableNode(new TreeData("ROOT", "0"));
        TreeTableNode node_1;
        node_1 = new TreeTableNode(new TreeData("sub1", "1"));
        node_1.add(new TreeTableNode(new TreeData("sub1-1", "2")));
        node.add(node_1);
        TreeTableNode node_2;
        node_2 = new TreeTableNode(new TreeData("sub2", "1"));
        node_2.add(new TreeTableNode(new TreeData("sub2-111111111111111", "2")));
        node.add(node_2);

        model = new TreeTableModel(node);
        

        setModel(model);
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
        renderer.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println(e);
                super.focusGained(e);
            }
        });
        setDefaultRenderer(TreeTableNode.class, renderer);

        MyTableCellEditor editor = new MyTableCellEditor();
        setDefaultEditor(TreeTableNode.class, editor);

    }

    class MyTableCellEditor extends TreeCell implements TableCellEditor {
        private static final long serialVersionUID = -1889933997649720041L;

        public MyTableCellEditor() {
            setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public Object getCellEditorValue() {
            // TODO Auto-generated method stub
            System.out.println("getCellEditorValue : "+getNode());
            return getNode();
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
            TreeTableNode node = (TreeTableNode) value;
            System.out.println("getTableCellEditorComponent : " + node.isOpen());
            setNode(node);
            table.revalidate();
            return this;
        }

    }

    class TreeCell extends JPanel {
        private static final long serialVersionUID = -5525230350025464058L;

        public static final Icon icon_closed = UIManager.getIcon("Tree.closedIcon");
        public static final Icon icon_open = UIManager.getIcon("Tree.openIcon");
        public static final Icon icon_leaf = UIManager.getIcon("Tree.leafIcon");
        public static final Icon icon_collapsed = UIManager.getIcon("Tree.collapsedIcon");
        public static final Icon icon_expanded = UIManager.getIcon("Tree.expandedIcon");

        private JLabel lbl_icon;
        private JLabel lbl_text;

        private TreeTableNode node;

        public TreeCell() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout());
            setBackground(Color.white);

            lbl_icon = new JLabel();
            add(lbl_icon, BorderLayout.WEST);
            lbl_icon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(e);
                    toggleOpen();
//					super.mouseClicked(e);
                }
            });

            lbl_text = new JLabel();
            add(lbl_text, BorderLayout.CENTER);
        }

        public TreeTableNode getNode() {
            return node;
        }

        public void toggleOpen() {
            
            System.out.println("toggleOpen : "+node.isOpen());
            node.setOpen(!node.isOpen());

            if (node.isOpen()) {
                lbl_icon.setIcon(icon_expanded);
            } else {
                lbl_icon.setIcon(icon_collapsed);
            }
        }

        public void setNode(TreeTableNode node) {
            this.node = node;

            if (node.isOpen()) {
                lbl_icon.setIcon(icon_expanded);
            } else {
                lbl_icon.setIcon(icon_collapsed);
            }

            if (node.isLeaf()) {
                lbl_text.setIcon(icon_leaf);
            } else {
                lbl_text.setIcon(icon_closed);
            }

            lbl_text.setText(node.getTreeData().getName());
        }
    }

    class MyTableCellRenderer extends TreeCell implements TableCellRenderer {

        private static final long serialVersionUID = -8366489318298212512L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            TreeTableNode node = (TreeTableNode) value;
            System.out.println("getTableCellRendererComponent : "+ node.getTreeData().getName()+ ", " + node.isOpen());
            setNode(node);
            table.revalidate();

            return this;
        }

    }

    class TreeTableModel extends AbstractTableModel {
        /**
         * 
         */
        private static final long serialVersionUID = 1402872757399399773L;
        private TreeTableNode node;
        private List<TreeTableNode> list_data;

        public TreeTableModel(TreeTableNode node) {
            this.node = node;
            list_data = node.getVisibleNodeList();
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
            list_data = node.getVisibleNodeList();
            return list_data.size();
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

            if (columnIndex == 0) {
                return list_data.get(rowIndex);
            } else {
                return list_data.get(rowIndex).getTreeData().getType();
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return TreeTableNode.class;
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

    class TreeTableNode implements TreeNode {
        private List<TreeTableNode> children = new ArrayList<>();
        private boolean isOpen = false;
        private TreeData treeData;

        public TreeTableNode(TreeData treeData) {
            this.treeData = treeData;
        }

        public TreeData getTreeData() {
            return treeData;
        }

        public void setTreeData(TreeData treeData) {
            this.treeData = treeData;
        }

        public boolean isOpen() {
            return isOpen;
        }

        public void setOpen(boolean isOpen) {
            this.isOpen = isOpen;
        }

        public void add(TreeTableNode node) {
            children.add(node);
        }

        public TreeTableNode getChildNode(int childIndex) {
            return children.get(childIndex);
        }

        public List<TreeTableNode> getVisibleNodeList() {
            List<TreeTableNode> list = new ArrayList<TreeTable.TreeTableNode>();

            list.add(this);
            if (isOpen()) {
                for (TreeTableNode child : children) {
                    list.addAll(child.getVisibleNodeList());
                }
            }

            return list;
        }

//		public TreeTableNode getVisibleNode(int index) {
//			System.out.println("getVisibleNode : "+index);
//			
//			if(index  == 0) {
//				return this;
//			}else {
//				if(isOpen()) {
//					//현재노드
//					int visible_child_count = 1;
//					
//					for(TreeTableNode child : children) {
//						//child별 오픈 노드개수
//						visible_child_count += getVisibleChildCount(child);
//						System.out.println("visible_child_count : "+visible_child_count);
//						
//						if(visible_child_count > index) {
//							return getVisibleNode(visible_child_count - index);
//						}
//					}
//				}
//			}
//			
//			return null;
//		}
//		
//		public int getVisibleNodeCount() {
//			return getVisibleChildCount(this);
//		}
//		
//		public int getVisibleChildCount(TreeTableNode node) {
//			System.out.println("getVisibleChildCount : "+ node.getTreeData());
//			int result = 1;
//			if(node.isOpen()) {
//				for(int i=0; i<node.getChildCount(); i++) {
//					System.out.println("getVisibleChildCount - child : "+ node.getChildNode(i).getTreeData());
//					result += getVisibleChildCount(node.getChildNode(i));
//				}
//			}
//
//			return result;
//		}

        @Override
        public TreeNode getChildAt(int childIndex) {
            return children.get(childIndex);
        }

        @Override
        public int getChildCount() {
            return children.size();
        }

        @Override
        public TreeNode getParent() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getIndex(TreeNode node) {
            return children.indexOf(node);
        }

        @Override
        public boolean getAllowsChildren() {
            return true;
        }

        @Override
        public boolean isLeaf() {
            if (children.size() == 0) {
                return true;
            }
            return false;
        }

        @Override
        public Enumeration<? extends TreeNode> children() {
            return Collections.enumeration(children);
        }
    }
}
