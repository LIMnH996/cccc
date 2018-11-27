package document;

public class Article extends Publication{
	
	private String journal;
	private String volume;
	private String number;

	public Article(String t, String[] a, String y, String p, String j, String v, String n) {
		super(t, a, y, p);
		this.journal = j;
		this.volume = v;
		this.number = n;
	}
	
	@Override
	public String toString() {
		String str = null;
		
		for(String a : super.authors) {
			str += a + ',';
		}
			
		str += " (" + super.year + "). ";
		str += super.titel + ". ";

		str += "(" + super.pages + ")";
		
		return str;
	}
	
	
}
