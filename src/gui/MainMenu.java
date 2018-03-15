package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1868427937905501686L;
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
		this.menuNewStudent.setActionCommand("MainMenuNewStudent");
		this.menuLoadList = new JMenuItem("Schülerliste laden"); 
		this.menuLoadList.setActionCommand("MainMenuLoadList");
		this.menuSaveList = new JMenuItem("Schülerliste speichern"); 
		this.menuSaveList.setActionCommand("MainMenuSaveList");
		
		this.menuNewStudent.addActionListener(mf);
		this.menuLoadList.addActionListener(mf);
		this.menuSaveList.addActionListener(mf);
		
		this.menuStart.add(this.menuNewStudent); 
		this.menuStart.add(this.menuLoadList);
		this.menuStart.add(this.menuSaveList); 
		this.add(this.menuStart); 
	}
}
