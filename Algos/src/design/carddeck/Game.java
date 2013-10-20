package design.carddeck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * The Game class mainly maintains the state of the game.
 * It also provides actions for the players to call.
 * A specific type of game can have more specific actions.
 * For example: A rummy game can provide an action to pick cards from ground.
 * @author sinatarajan
 *
 */
public class Game {
	List<Card> cardsOnGround;
	List<Player> players;
	Map<String, Set<Card>> playerCards = new HashMap<String, Set<Card>>();

	Player currentPlayer;

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public Game(List<Card> cards) {
		this.cardsOnGround = cards;
	}	

	/**
		Assigns the list of cards to each of the players in the players list
	*/
	public void assignCardsToPlayers() {

	}

	protected Set<Card> getPlayerCards(String playerId) {
		return playerCards.get(playerId);
	}
	
	/**
		Throws a specific card from a player's set of cards and adds to the cardsOnGround list
	*/
	protected void throwCardFromPlayer(String playerId, Card card) {

	}


	/**
		Makes the next player to play the game. 
	*/
	protected void moveToNextPlayer() {

	}	
}

