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
	 * Generate all the cards for a deck
	 * the cards are stored in the member variable - cards
	 */
	private void generateDeck() {
		// TODO 3.1
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
		return null; // to be replaced
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		CardGroup cg1 = deck.createRandomCardGroup();
		CardGroup cg2 = deck.createRandomCardGroup();
		CardGroup cg3 = deck.createRandomCardGroup();
		
		// TODO 3.4
		// print out the biggest CardGroup
	}
}
