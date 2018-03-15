package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import bll.Student;
import dal.FileIOHelper;

public class MainFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2836194594444036813L;
	private MainMenu menu = null;
	private StudentList list = null;

	public MainFrame(String title) {
		super(title);
		this.initializeControls();
		this.setMinimumSize(new Dimension(600, 400));
		this.setPreferredSize(new Dimension(600, 400));
		this.pack();
		this.setVisible(true);
	}

	private void initializeControls() {
		this.menu = new MainMenu(this);
		this.list = new StudentList(this);
		this.setLayout(new BorderLayout());
		this.add(this.list, BorderLayout.CENTER);
		this.setJMenuBar(this.menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("MainMenuNewStudent")) {
			StudentDialog dlg = new StudentDialog(this, true, null);
			if (dlg.getStudent() != null) {
				this.list.addNewStudent(dlg.getStudent());
			}

		} else if (e.getActionCommand().equals("MainMenuLoadList")) {
			JFileChooser dlg = new JFileChooser();
			String filename = "";

			if (dlg.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				dlg.setCurrentDirectory(new File(System.getProperty("user.dir")));
				filename = dlg.getSelectedFile().getPath();
				try {
					ArrayList<Student> stds = FileIOHelper.readStudentsFrom(Paths.get(filename));
					this.list.FillList(stds);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getActionCommand().equals("MainMenuSaveList")) {
			JFileChooser dlg = new JFileChooser();
			String filename = "";

			if (dlg.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				dlg.setCurrentDirectory(new File(System.getProperty("user.dir")));
				filename = dlg.getSelectedFile().getPath();
				try {
					FileIOHelper.writeObjectsToFile(Paths.get(filename), this.list.getStudents());

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

}
