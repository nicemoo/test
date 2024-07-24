package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.StyledEditorKit;

public class MyEditorKit extends StyledEditorKit {

	/**
	 * 
	 */
	private static final long serialVersionUID = -646280865444500007L;

	
	@Override
	public void read(InputStream in, Document doc, int pos) throws IOException, BadLocationException {
		// TODO Auto-generated method stub
		System.out.println("read(InputStream in, Document doc, int pos) "+pos);
		super.read(in, doc, pos);
	}
	
	@Override
	public void read(Reader in, Document doc, int pos) throws IOException, BadLocationException {
		System.out.println("read(Reader in, Document doc, int pos) "+pos);
		// TODO Auto-generated method stub
		super.read(in, doc, pos);
	}
	
	
	@Override
	public void write(OutputStream out, Document doc, int pos, int len) throws IOException, BadLocationException {
		// TODO Auto-generated method stub
		System.out.println("write(OutputStream out, Document doc, int pos, int len) "+pos+"/"+len);
		super.write(out, doc, pos, len);
	}
	
	
	@Override
	public void write(Writer out, Document doc, int pos, int len) throws IOException, BadLocationException {
		// TODO Auto-generated method stub
		System.out.println("Writer out, Document doc, int pos, int len "+pos+"/"+len);
		super.write(out, doc, pos, len);
	}
	
	
}
