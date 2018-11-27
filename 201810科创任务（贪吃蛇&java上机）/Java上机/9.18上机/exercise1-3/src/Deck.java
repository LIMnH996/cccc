import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	Random random;

	public Deck() {
		this.cards = new ArrayList<Card>();
		this.random = new Random();

		// create all the cards
		this.generateDeck();
	}

	/*
	 * Generate all the cards for a deck the cards are stored in the member variable
	 * - cards
	 */
	private void generateDeck() {
		// TODO 3.1
		for (int i = 1; i <= 13; i++) {
			Card card1 = new Card(i, "Heart");
			Card card2 = new Card(i, "Spade");
			Card card3 = new Card(i, "Diamond");
			Card card4 = new Card(i, "Club");

			this.cards.add(card1);
			this.cards.add(card2);
			this.cards.add(card3);
			this.cards.add(card4);
		}
	}

	/*
	 * Return a random card, remove it from the deck
	 */
	public Card getRandomCard() {
		int index = this.random.nextInt(this.cards.size());
		return this.cards.remove(index);
	}

	/*
	 * Create a CardGroup by picking 3 cards randomly
	 */
	public CardGroup createRandomCardGroup() {
		// TODO 3.1
		Random rand = new Random();
		int r1 = rand.nextInt(52);
		Card t1 = this.cards.get(r1);
		int r2 = rand.nextInt(52);
		Card t2 = this.cards.get(r2);
		int r3 = rand.nextInt(52);
		Card t3 = this.cards.get(r3);
		CardGroup t_cg = new CardGroup(t1, t2, t3);
		return t_cg; // to be replaced
	}

	public static void main(String[] args) {
		Deck deck = new Deck();
		CardGroup cg1 = deck.createRandomCardGroup();
		CardGroup cg2 = deck.createRandomCardGroup();
		// CardGroup cg3 = deck.createRandomCardGroup();

		// TODO 3.4
		// print out the biggest CardGroup
		System.out.println(cg1.c1.getNumber() + "   " + cg1.c1.getSuit());
		System.out.println(cg1.c2.getNumber() + "   " + cg1.c2.getSuit());
		System.out.println(cg1.c3.getNumber() + "   " + cg1.c3.getSuit());
		System.out.println();
		System.out.println(cg2.c1.getNumber() + "   " + cg2.c1.getSuit());
		System.out.println(cg2.c2.getNumber() + "   " + cg2.c2.getSuit());
		System.out.println(cg2.c3.getNumber() + "   " + cg2.c3.getSuit());
		System.out.println();
		if (check(cg1) < check(cg2)) {
			System.out.println("cg1 is bigger");
		}

		if (check(cg1) > check(cg2)) {
			System.out.println("cg2 is bigger");
		}

		if (check(cg1) == check(cg2)) {
			if (cg1.sumOfNumbers() > cg2.sumOfNumbers())
				System.out.println("cg1 is bigger");
			else if (cg1.sumOfNumbers() < cg2.sumOfNumbers())
				System.out.println("cg2 is bigger");
			else
				System.out.println("cg1 equals cg2");
		}
	}

	public static int check(CardGroup t1) {
		int return_t = 0;
		if (t1.c1.getNumber() == t1.c2.getNumber() && t1.c2.getNumber() == t1.c3.getNumber())
			return_t = 1;
		else if (t1.c1.getNumber() == t1.c2.getNumber() || t1.c2.getNumber() == t1.c3.getNumber()
				|| t1.c1.getNumber() == t1.c3.getNumber())
			return_t = 2;
		else if (t1.c1.getSuit() == t1.c2.getSuit() && t1.c2.getSuit() == t1.c3.getSuit())
			return_t = 3;
		else if (t1.c1.getNumber() != t1.c2.getNumber() && t1.c2.getNumber() != t1.c3.getNumber()
				&& t1.c1.getNumber() != t1.c3.getNumber())
			return_t = 4;
		return return_t;
	}

}
