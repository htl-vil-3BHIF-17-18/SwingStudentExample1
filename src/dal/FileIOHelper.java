package dal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;

import bll.Student;

public class FileIOHelper {
	public static void writeObjectsToFile(Path path, ArrayList<Student> students) throws IOException {

		boolean exists = false;
		exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
		if (exists) {
			Files.delete(path);
		}

		try (PrintWriter outputStream = new PrintWriter(new FileWriter(path.toString()))) {
			for (Student s : students) {
				outputStream.println( s.toCSVLine()); 
			}
		}
		

		
	}
	
	public static ArrayList<Student> readStudentsFrom( Path path ) throws FileNotFoundException, IOException {
		
		ArrayList<Student> students = new ArrayList<Student>();
		String 				line = ""; 
		boolean           exists = false; 
		Charset          charset = Charset.forName("ISO-8859-1");
		
		exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
		
		if (!exists) {
			throw new NoSuchFileException("Datei nicht vorhanden!"); 
		}
		
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    	line = reader.readLine();     
				while (line != null && !line.equals("")) {
					System.out.println(line);
					students.add(parseStudent(line));
					line = reader.readLine();
				}
		    
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return students;

	}
	
	
	private static Student parseStudent(String line) {
		Student student = null;
		String[] parts = null;
		parts = line.split(";");
		
		student = new Student(Integer.parseInt(parts[0]), parts[2], parts[1]);
		return student;

	}
}
