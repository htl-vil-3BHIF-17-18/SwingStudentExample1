package gui;
import bll.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentList extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1076207264250065297L;
	private JList<Student> listStudents = null; 
    private Component parent = null; 
	private JScrollPane scrollpane = null; 
	private DefaultListModel<Student> dml; // new DefaultListModel<Student>(); 
	
	public StudentList(Component parent ){
		this.parent = parent; 
		this.initializeControls(); 
	}
	private void initializeControls(){
		
		this.setLayout( new GridBagLayout()); 
		this.listStudents = new JList<Student>();
		this.scrollpane = new JScrollPane(this.listStudents); 
		dml = new DefaultListModel<Student>(); 
	//	GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new BorderLayout());
	
		this.listStudents.setFont( this.getFont());
		this.listStudents.setBackground( Color.WHITE);
		this.listStudents.addMouseListener(this);
	
		this.listStudents.setModel(dml);
		this.add(this.scrollpane,BorderLayout.CENTER); 
		this.setVisible(true);
		
	}
	public ArrayList<Student> getStudents(){
		ArrayList<Student> list = new ArrayList<Student>(); 
		for( int i = 0; i<dml.getSize(); i++)
			list.add(dml.getElementAt(i)); 
		return list; 
	}
	public void FillList(ArrayList<Student> students)
	{
		dml.removeAllElements();
		for( Student s : students){
			
			dml.addElement(s);
		}
	}
	public void addNewStudent(Student s){
		dml.addElement(s);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if( e.getClickCount() == 2)
		{
			if( this.listStudents.getSelectedValue()!= null){
				StudentDialog dlg = new StudentDialog( (MainFrame)parent, false, this.listStudents.getSelectedValue()); 
			}
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
