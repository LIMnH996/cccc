package document;

public abstract class Publication {
	
	protected String titel;
	protected String year;
	protected String pages;
	protected String[] authors;
	
	public Publication(String t, String[] a, String y, String p) {
		this.titel = t;
		this.authors = a;
		this.year = y;
		this.pages = p;
	}
	
}
