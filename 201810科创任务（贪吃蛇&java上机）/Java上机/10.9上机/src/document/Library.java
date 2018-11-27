package document;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Library {
	
	private ArrayList<Publication> publications;
	private ArrayList<Author> authors;
	
	public Library() {
		
	}
	
	public void addAuthor(Author auth) {
		this.authors.add(auth);
	}
	
	public void addPublication(Publication pub) {
		this.publications.add(pub);
	}
	
	public static void main(String[] args) {
		Library library = new Library();
		char[] text = new char[1];
		String classification = "";
		try {
			FileReader in = new FileReader("library.bib");
			in.read(text);
			while(true) {
				classification = "";
				do{
					in.read(text);
					System.out.print(text);
					classification += text[0];
				}
				while(text[0] != '\n');
				classification = classification.substring(0, 6);
				if(classification.equals("inproc")) {
					library.publications.add(readInpro(in));
				}
				else if(classification.equals("articl")) {
					library.publications.add(readArti(in));
				}
				else {
					readToNext(in);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		System.out.print(text);
		//System.out.print(true);
		
	}
	
	public static Inproceedings readInpro(FileReader in) throws IOException {
		char[] text = new char[1];
		String[] string = new String[6];
		for(int i=0; i<6; i++) {
			do{
			in.read(text);
			System.out.print(text);
			string[i] += text[0];
			}
			while(text[0] != '\n');	
		}
		do{
			in.read(text);
			}
		while(text[0] != '@');	
		int index1,index2;
		for(String s:string) {
			if(!s.isEmpty()) {
				index1 = s.indexOf('{');
				index2 = s.indexOf('}');
				s = s.substring(index1, index2);
			}
		}
		String[] authors = string[2].split(" and ");
		return new Inproceedings(string[1], authors, string[5], string[4], string[3]);
	}

	public static Article readArti(FileReader in) throws IOException {
		char[] text = new char[1];
		String[] string = new String[8];
		for(int i=0; i<8; i++) {
			do{
			in.read(text);
			System.out.print(text);
			string[i] += text[0];
			}
			while(text[0] != '\n');	
		}
		do{
			in.read(text);
			}
		while(text[0] != '@');	
		int index1,index2;
		for(String s:string) {
			if(!s.isEmpty()) {
				index1 = s.indexOf('{');
				index2 = s.indexOf('}');
				System.out.println(s);
				s = s.substring(index1, index2);
			}
		}
		String[] authors = string[2].split(" and ");
		return new Article(string[1], authors, string[7], string[6], string[3], string[4], string[5]);
	}
	
	public static void readToNext(FileReader in) throws IOException{
		char[] text = new char[1];
		do{
			in.read(text);
			}
		while(text[0] != '@');	
	}
}
