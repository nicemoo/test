package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class QueryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Connection _conn = null;
	private JTable query_table;
	private JTextPane query_text_panel;
	private MyTableModel table_model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					QueryPanel query_panel = new QueryPanel();
					frame.getContentPane().add(query_panel, BorderLayout.CENTER);
					
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							System.out.println("windowClosing");
							query_panel.closeConnection();
							super.windowClosing(e);
						}
						
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							System.out.println("windowClosed");
							super.windowClosed(e);
						}
					});
					
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public QueryPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent e) {
				// TODO Auto-generated method stub
				System.out.println("componentRemoved");
				super.componentRemoved(e);
			}
		});
		
		query_table = new JTable();
		table_model = new MyTableModel();
		query_table.setModel(table_model);
		scrollPane.setViewportView(query_table);
		
		query_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2) {
					Object o = table_model.getValueAt(query_table.getSelectedRow(), query_table.getSelectedColumn());
					System.out.println(o.getClass());
				}
				super.mouseClicked(e);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(0, 200));
		add(scrollPane_1, BorderLayout.SOUTH);
		
		query_text_panel = new JTextPane();
		query_text_panel.setText("SELECT * FROM T2_SD_CAR_CONTS_INFO");
		scrollPane_1.setViewportView(query_text_panel);
		
		try {
			//executeQuery();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	private void executeQuery() throws SQLException {
		
		table_model.clear();
		
		String query = query_text_panel.getText();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		
		if(stmt.execute(query)) {
			
			ResultSet rs = stmt.getResultSet();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for(int i=0; i<rsmd.getColumnCount(); i++) {
				table_model.addColumn(rsmd.getColumnName(i+1));
			}
			
			while(rs.next()) {
				
				List<Object> row = new ArrayList<>();
				for(int i=0; i<rsmd.getColumnCount(); i++) {
					row.add(rs.getObject(i+1));
				}
				//System.out.println(row);
				table_model.addRow(row);
			}
			
		}
		
	}
	
	public void closeConnection() {
		if(_conn != null) {
			try {
				_conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Connection getConnection() {
		if(_conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				_conn = DriverManager.getConnection(url,"test", "test");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return _conn;
	}

}
