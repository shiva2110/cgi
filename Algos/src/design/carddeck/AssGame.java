package design.carddeck;

import java.util.List;

public class AssGame extends Game{

	Card lastThrownCard;
	public AssGame(List<Card> cards) {
		super(cards);
	}
	
	@Override
	public void throwCardFromPlayer(String playerId, Card card) {
		this.lastThrownCard = card;
		super.throwCardFromPlayer(playerId, card);
	}
	
	public Card showLastThrownCard() {
		return this.lastThrownCard;
	}

}
