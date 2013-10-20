package design.carddeck;

public class RummyPlayer extends Player{
	
	public RummyPlayer(String id, RummyGame game) {
		super(id, game);		
	}

	/**
	 * Picks a card from ground, checks if it is a good one to keep, if not throws it back.
	 */
	public void pickACard() {
		if(game.currentPlayer.equals(this)) {
			((RummyGame)this.game).pickCardFromGround(id);
		}

	}

}