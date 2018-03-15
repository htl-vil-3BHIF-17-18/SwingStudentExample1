package gui;


import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar{

	JMenu menuStart = null; 
	JMenuItem menuNewStudent = null; 
	JMenuItem menuLoadList = null; 
	JMenuItem menuSaveList = null; 
	MainFrame mf = null; 
	/*neu*/
	public MainMenu( MainFrame mf ){
		this.mf = mf; 
		this.initializeControls(); 
	}
	private void initializeControls(){
		this.menuStart = new JMenu("Start"); 
		this.menuNewStudent = new JMenuItem("Neuen Schüler anlegen");
		
		this.menuLoadList = new JMenuItem("Schülerliste laden"); 
		this.menuSaveList = new JMenuItem("Schülerliste speichern"); 
		
		this.menuNewStudent.addActionListener(mf);
		this.menuLoadList.addActionListener(mf);
		this.menuSaveList.addActionListener(mf);
		
		this.menuStart.add(this.menuNewStudent); 
		this.menuStart.add(this.menuLoadList);
		this.menuStart.add(this.menuSaveList); 
		this.add(this.menuStart); 
	}
}
