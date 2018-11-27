package document;


public class Inproceedings extends Publication{

	private String booktitle;
	
	public Inproceedings(String t, String[] a, String y, String p, String b) {
		super(t, a, y, p);
		this.booktitle = b;
	}

	@Override
	public String toString() {
		String str = null;
		
		for(String a : super.authors) {
			str += a + ',';
		}
			
		str += " (" + super.year + "). ";
		str += super.titel + ". ";
		str += this.booktitle + ", ";
		str += "(" + super.pages + ")";
		
		return str;
	}

}
