package test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Element;
import javax.swing.text.Highlighter;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.Dimension;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JMenuItem;
import javax.swing.JList;
import java.awt.ComponentOrientation;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JMenu;

public class TextPanel {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextPane txtpna;
	private JTextPane textRowHeader;
	
	int pos_x_press = 0; 
	int pos_y_press = 0;
	private JPopupMenu popupMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIManager.setLookAndFeel( new FlatLightLaf() );
					
					TextPanel window = new TextPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TextPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setDoubleBuffered(true);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
		txtpna = new JTextPane();
		scrollPane.setViewportView(txtpna);
		txtpna.setText("--주석\r\n\t\t\tSELECT --주석 ㅁㅁㅁ\r\n\t\t\t\tNTCOB_SEQ AS ntcobSeq --주석\r\n\t\t\t\t, NTCOB_TITLE AS ntcobTitle\r\n\t\t\t\t, NTCOB_CONT ntcobCont\r\n--주석\r\n\t\t\t\t, DISP_YN AS dispYn\r\n/* 주석 */\r\n\t\t\t\t, DEL_YN AS delYn\r\n\t\t\t\t, TOP_YN AS topYn\r\n\t\t\t\t, VIEW_CNT AS viewCnt\r\n\t\t\t\t, DISP_LVL_CD AS dispLvlCd\r\n\t\t\t\t, ATCH_FILE_ID AS atchFileId\r\n\t\t\t\t, TO_CHAR(REG_DATE, 'YYYY-MM-DD') AS regDate\r\n\t\t\t\t, FN_ADMIN_NM(REG_ID) AS regNm\r\n\t\t\t\t, REG_ID AS regId\r\n\t\t\t\t, MOD_DATE AS modDate\r\n\t\t\t\t, MOD_ID AS modId\r\n\t\t\tFROM\r\n\t\t\t\tTS_ADMIN_NOTICE /* sss */  aaaa  /* sss */\r\n\t\t\tWHERE\r\n\t\t\t\tNTCOB_SEQ = #{ntcobSeq}");

//		MyEditorKit mek = new MyEditorKit();
		//txtpna.setEditorKit(new MyEditorKit()); 
		
//		txtpna.setStyledDocument(mek.);
		txtpna.setFont(new Font("Monoplex KR", Font.PLAIN, 16));
		
		popupMenu = new JPopupMenu();
		addPopup(txtpna, popupMenu);
		
		mntmNewMenuItem = new JMenuItem("New menu item");
		popupMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("New menu item");
		popupMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("New menu item");
		popupMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("New menu item");
		popupMenu.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("New menu item");
		popupMenu.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("New menu itemaaaaaaa");
		popupMenu.add(mntmNewMenuItem_5);
		scrollPane.getViewport().revalidate();
		
		textRowHeader = new JTextPane();
		textRowHeader.setForeground(Color.GRAY);
		textRowHeader.setBackground(SystemColor.control);
		textRowHeader.setMargin(new Insets(3, 13, 3, 13));
		textRowHeader.setFocusable(false);
		textRowHeader.setEditable(false);
		textRowHeader.setFont(txtpna.getFont());
		scrollPane.setRowHeaderView(textRowHeader);
		
		//document.setCharacterAttributes(20, 10, attributes, false);

		
		
		txtpna.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						Vector<String> vec_test = new Vector<>();
						vec_test.add("aaaaaaaaa");
						vec_test.add("bbbbbbbb");
						vec_test.add("cccccc");
						vec_test.add("dddddddd");
						JComboBox<String> cb = new JComboBox<>(vec_test);
						
						
						JPanel panel = new JPanel();
						panel.setPreferredSize(new Dimension(400, 300));
						panel.setBorder(BorderFactory.createLineBorder(Color.GRAY) );
						panel.setBackground(Color.white);
						panel.addMouseListener(new MouseAdapter() {
							
						});
						
						Popup p = PopupFactory.getSharedInstance().getPopup(txtpna, panel, 200, 200);
						
						
						
						panel.addFocusListener(new FocusAdapter() {
							@Override
							public void focusLost(FocusEvent e) {
								// TODO Auto-generated method stub
								p.hide();
								super.focusLost(e);
							}
						});
						
						p.show();
						panel.grabFocus();
						
						
					}
				}
//				if(e.getKeyCode() == KeyEvent.VK_TAB) {
//					e.setKeyCode(KeyEvent.VK_SPACE);
//				}
				
				super.keyPressed(e);
			}
		});
		
		int spaceCount = 4;
		DefaultStyledDocument doc = (DefaultStyledDocument) txtpna.getStyledDocument();
		doc.setDocumentFilter(new ChangeTabToSpacesFilter(spaceCount));
		doc.addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateText();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		
		updateText();
	}
	
	private void updateText() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StyledDocument doc = txtpna.getStyledDocument();
					setLineNumber(doc);
					setSyntaxColor(doc);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void setLineNumber(StyledDocument doc) {
		Element paragraph = doc.getDefaultRootElement();
        int lineCount = paragraph.getElementCount();
        System.out.println("lineCount : "+lineCount);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lineCount; i++) {
        	if(i != 0) {
        		sb.append(System.lineSeparator());
        	}
        	sb.append(i+1);
        }
        
        textRowHeader.setText(sb.toString());
	}
	
	private void setSyntaxColor(StyledDocument doc) throws BadLocationException {
		MutableAttributeSet mas_default = new SimpleAttributeSet();
	
		String txt = txtpna.getText(0, doc.getLength());
		doc.setCharacterAttributes(0, doc.getLength(), mas_default, true);
		
		int idx_start = 0;
		
		//범위주석 부터 시작
		setAreaCommentAttribute(txt, idx_start, doc);
	}
	
	
	//범위주석
	private void setAreaCommentAttribute(String txt, int idx_start, StyledDocument doc) {
		

		MutableAttributeSet mas_comment = new SimpleAttributeSet();
		StyleConstants.setForeground(mas_comment, new Color(0,168,3));
		
		String[] words = txt.split("/\\*");
		
		System.out.println("---------------------------------------------------");
		System.out.println("words.length : "+words.length);
		
		for(int i=0; i<words.length; i++) {
			if(i != 0) {
//				System.out.println(words[i]+" idx_start:"+idx_start);
				//doc.setCharacterAttributes(idx_start-1, comment_start[i].length()+2, mas_comment, false);
				
				int idx_comment_end = words[i].indexOf("*/");
				//System.out.println("idx_comment_end : "+idx_comment_end);
				if(idx_comment_end == -1) {
					idx_comment_end = words[i].length();
				}else {
					idx_comment_end += 2;
					
					//범위주석이 아닌부분
					String no_area_comment = words[i].substring(idx_comment_end);
					//System.out.println(">>>"+no_area_comment);
					setLineCommentAttribute(no_area_comment, idx_start + idx_comment_end, doc);
				}
				
				idx_comment_end += 2;
				
				//System.out.println("idx_comment_end : "+idx_comment_end);
				
				doc.setCharacterAttributes(idx_start-2, idx_comment_end, mas_comment, true);
			}else {
				String no_area_comment = words[i];
				//System.out.println(">>>"+no_area_comment);
				
				setLineCommentAttribute(no_area_comment, idx_start, doc);
			}
			
			idx_start += words[i].length()+2;
		}
	}

	
	//라인주석
	private void setLineCommentAttribute(String txt, int idx_start, StyledDocument doc) {
		
		MutableAttributeSet mas = new SimpleAttributeSet();
		StyleConstants.setForeground(mas, new Color(0,168,3));
		
//		System.out.println("setLineCommentAttribute  --------------------------------------");
//		System.out.println("txt : "+txt);
		
		int idx_line_comment_start = 0;
		int idx_line_comment_end = 0;
		while((idx_line_comment_start = txt.indexOf("--", idx_line_comment_end)) > -1) {
			
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//			System.out.println("txt : "+txt);
//			System.out.println("idx_start : "+idx_start);
//			System.out.println("idx_line_comment_end : "+idx_line_comment_end);
//			System.out.println("idx_line_comment_start : "+idx_line_comment_start);
			
			String no_comment = txt.substring(idx_line_comment_end, idx_line_comment_start);
			setStringAttribute(no_comment, idx_start+idx_line_comment_end, doc);
			
			idx_line_comment_end = txt.indexOf("\n", idx_line_comment_start);
			if(idx_line_comment_end == -1) {
				idx_line_comment_end = txt.length();
			}
//			System.out.println("idx_line_comment_end : "+idx_line_comment_end);
			doc.setCharacterAttributes(idx_start+idx_line_comment_start, idx_line_comment_end - idx_line_comment_start, mas, true);
		}
		
		String no_comment = txt.substring(idx_line_comment_end);
		setStringAttribute(no_comment, idx_start+idx_line_comment_end, doc);
	}

	//문자열
	private void setStringAttribute(String txt, int idx_start, StyledDocument doc) {
		
		MutableAttributeSet mas_str = new SimpleAttributeSet();
		StyleConstants.setForeground(mas_str, new Color(194,121,81));
		
		String[] words = txt.split("\'");
		
		for(int i=0; i<words.length; i++) {
			if(i%2 == 1) {
				doc.setCharacterAttributes(idx_start-1, words[i].length()+2, mas_str, false);
			}else {
				setWordAttribute(words[i], idx_start, doc);
			}
			
			idx_start += words[i].length()+1;
		}
	}
	
	//문법단어
	private void setWordAttribute(String txt, int idx_start, StyledDocument doc) {
		List<String> list_system_word = new ArrayList<>();
		list_system_word.add("select");
		list_system_word.add("from");
		list_system_word.add("where");
		
		MutableAttributeSet mas = new SimpleAttributeSet();
		StyleConstants.setForeground(mas, Color.blue);
		StyleConstants.setBold(mas, true);
		
		String[] words = txt.split("\s|\\(|\\)|\\{|\\}|\n|\t");
//		System.out.println("=================================================================================");
		for(String word:words) {
//			System.out.println(word+" idx_start:"+idx_start);
			
			if(list_system_word.contains(word.toLowerCase())) {
//				System.out.println(word+" idx_start:"+idx_start+" length:"+word.length());
				doc.setCharacterAttributes(idx_start, word.length(), mas, true);
			}
			
			idx_start += word.length()+1;
		}
	}
	
	
	//탭을 공백으로 변환하는 필터
    private static class ChangeTabToSpacesFilter extends DocumentFilter {
        private String spaces = "";
        
        public ChangeTabToSpacesFilter(int spaceCount) {
            for (int i = 0; i < spaceCount; i++) {
                spaces += " ";
            }
        }

//        @Override
//        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
//                throws BadLocationException {
//        	System.out.println("@@ insertString ");
//            string = string.replace("\t", spaces);
//            super.insertString(fb, offset, string, attr);
//        }
        
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            text = text.replace("\t", spaces);
            super.replace(fb, offset, length, text, attrs);
        }
        
    }

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
