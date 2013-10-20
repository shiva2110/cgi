package design.main;

import java.util.ArrayList;
import java.util.List;

import design.carddeck.Card;
import design.carddeck.CardNum;
import design.carddeck.CardType;
import design.carddeck.Player;
import design.carddeck.RummyGame;
import design.carddeck.RummyPlayer;

public class Main {
	
	public static void main(String[] args) {
		
		//buy cards
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(CardType.hearts, CardNum.five));
		cards.add(new Card(CardType.diamonds, CardNum.one));
		cards.add(new Card(CardType.claver, CardNum.jack));
		cards.add(new Card(CardType.spade, CardNum.king));
	
		//set up a game of rummy
		RummyGame game = new RummyGame(cards);
		
		
		//call and set up players
		RummyPlayer player1 = new RummyPlayer("vijay", game);
		RummyPlayer player2 = new RummyPlayer("siva", game);
		RummyPlayer player3 = new RummyPlayer("sv", game);
		RummyPlayer player4 = new RummyPlayer("kguru", game);		
		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		
		//add the players to the game
		game.setPlayers(players);
		
	}
}
