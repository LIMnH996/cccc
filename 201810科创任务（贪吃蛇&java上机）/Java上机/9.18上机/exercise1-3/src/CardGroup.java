
public class CardGroup {
	public Card c1;
	public Card c2;
	public Card c3;

	public CardGroup(Card c1, Card c2, Card c3) {
		// TODO 3.1
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}

	/*
	 * Return the number of cards with the same number
	 */
	public int numOfSameNumber() {
		// TODO 3.2
		int SameNumber = 1;
		if (c1.getNumber() == c2.getNumber() && c1.getNumber() == c3.getNumber() && c2.getNumber() == c3.getNumber())
			SameNumber = 3;
		if (c1.getNumber() == c2.getNumber() || c1.getNumber() == c3.getNumber() || c2.getNumber() == c3.getNumber())
			SameNumber = 2;
		return SameNumber; // to be Sreplaced
	}

	/*
	 * Return the sum of all 3 numbers.
	 */
	public int sumOfNumbers() {
		// TODO 3.3
		return c1.getNumber() + c2.getNumber() + c3.getNumber(); // to be replaced
	}

	/*
	 * Compare if it is bigger than CardGroup c
	 * 
	 * @param c another CardGroup
	 * 
	 * @return 1: bigger than c; 0: the same; -1: smaller than c.
	 */
	public int compare(CardGroup c) {
		// TODO 3.4

		return 0; // to be replaced
	}

}
