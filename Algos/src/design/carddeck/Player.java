package design.carddeck;

import java.util.Set;

/**
 * A player mainly calls actions of the Game class.
 * A specific Player type can be strategic, 
 * for example: he decides which card to pick and what game's actions to take depending on the current state of the game.
 * For example: A rummy player might call a different game's actions than a AssPlayer.
 * @author sinatarajan
 *
 */
public class Player {
	String id;
	Game game;

	public Player(String id, Game game){
		this.id = id;
		this.game = game;
	}

	public Set<Card> viewCards() {
		return game.getPlayerCards(this.id);
	}

	public void throwCard(Card card) {
		if(game.currentPlayer.equals(this)) {
			this.game.throwCardFromPlayer(id, card);
		}
		
	}
}
