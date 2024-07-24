package test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class Main {

	public static void main(String[] args) {
		FlatLightLaf.setup();
		
		JFrame w = new JFrame();
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		w.setLayout(new FlowLayout());
		
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		
		w.setVisible(true);
		
		
		JButton btn1 = new JButton("test1");
		//btn1.setSize(200, 20);
		
		JButton btn2 = new JButton("test2");
		//btn2.setSize(200, 20);
		
		w.add(btn1);
		w.add(btn2);
		
		w.revalidate();
	}

}
