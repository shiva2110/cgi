package design.carddeck;

public class Card {
	CardType type;
	CardNum num;
	public Card(CardType type, CardNum num) {
		this.type = type;
		this.num = num;
	}

	@Override
	public int hashCode() {
		return this.type.toString().hashCode() + this.num.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof Card)) {

			if(obj == this) {
				return true;
			}

			Card card = (Card)obj;
			if(card.type.equals(this.type) && card.num.equals(this.num)){
				return true;
			} 
		}

		return true;
	}
}