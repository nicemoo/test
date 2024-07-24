package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class ConnectionManager extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<String> list;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			try {
			    //UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
			    UIManager.setLookAndFeel( new FlatLightLaf() );
			} catch( Exception ex ) {
			    System.err.println( "Failed to initialize LaF" );
			}
			
			ConnectionManager dialog = new ConnectionManager();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConnectionManager() {
		setModal(true);
		setUndecorated(true);
		setType(Type.POPUP);
		setBounds(new Rectangle(100, 100, 640, 480));
		setAlwaysOnTop(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 10));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.add(panel, BorderLayout.EAST);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(17, 10, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 35, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 64, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, 94, 57, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 127, 57, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(0, 159, 57, 15);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(0, 195, 57, 15);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(0, 220, 57, 15);
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		lblNewLabel_1.setLabelFor(textField);
		textField.setBounds(86, 7, 202, 21);
		panel.add(textField);
		textField.setColumns(10);
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				list = new JList<>();
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				List<String> list_connection = new ArrayList<String>();
				list_connection.add("connection 1");
				list_connection.add("connection 2");
				list_connection.add("connection 3");
				list_connection.add("connection 4");
				list_connection.add("connection 5");
				list_connection.add("connection 6");
				list_connection.add("connection 7");
				list_connection.add("connection 8");
				list_connection.add("connection 9");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				list_connection.add("connection 0");
				DefaultListModel<String> lm = new DefaultListModel<String>();
				lm.addAll(list_connection);
				
				
				list.setModel(lm);
				scrollPane.setViewportView(list);
			}
			{
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				lblNewLabel.setLabelFor(list);
				scrollPane.setColumnHeaderView(lblNewLabel);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public String getConnection() {
		String result = "aaaaa";
		
		setVisible(true);
		
		
		return result;
	}
}
