package test.treetable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeTest frame = new TreeTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TreeTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("ROOT") {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4531067096400324621L;

				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode(new TreeData("sub1","1"));
						node_1.add(new DefaultMutableTreeNode(new TreeData("sub1-1","2")));
					add(node_1);
					DefaultMutableTreeNode node_2;
					node_2 = new DefaultMutableTreeNode(new TreeData("sub2","1"));
						node_2.add(new DefaultMutableTreeNode(new TreeData("sub2-1","2")));
					add(node_2);

				}
			}
		));
		scrollPane.setViewportView(tree);
	}
	


}
