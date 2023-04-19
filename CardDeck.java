package remember;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	
	List<Integer> cards;
	
	public CardDeck() {
		cards = new ArrayList<>();
//		cards.add(1);
//		cards.add(15);
//		cards.add(31);
//		cards.add(49);
//		cards.add(52);
		for(int i=0;i<52;i++) {
			cards.add(i+1);
		}
	}
	
	public void print() {
		for(int i=0;i<cards.size();i++) {
			int c=cards.get(i);
			System.out.print(c+" ");
		}
		System.out.println();
	}
	
	public int getSize() {
		return cards.size();
	}
	
	public int getCodeAt(int x) {
		return cards.get(x);
	}
	
	private static String code2label(int code) {
		String first = null,second;
		switch(code/13){
			case 0:
			first="S";
			break;
			
			case 1:
			first="H";
			break;
			
			case 2:
			first="D";
			break;
			
			case 3:
			first="C";
			break;
			
		}
		switch(code%13){
		case 1:
			second="A";
			break;

		case 10:
			second="T";
			break;

		case 11:
			second="J";
			break;

		case 12:
			second="Q";
			break;

		case 0:
			second="K";
			break;

		default:
			Integer rank=code%13;
			second=rank.toString();
		}
		return first+second;//intをStringにする方法
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	public int takeCard() {
		cards.remove(0);
		return 0;
	}
	
	public static void main(String args[]) {
		CardDeck deck = new CardDeck();
		System.out.println(deck.getCodeAt(3));
		System.out.println(deck.getSize());
		int c1=deck.getCodeAt(0);System.out.println(code2label(c1));
		int c2=deck.getCodeAt(2);System.out.println(code2label(c2));
		//deck.print();
		deck.shuffle();
		deck.takeCard();
		deck.print();
	}
}
