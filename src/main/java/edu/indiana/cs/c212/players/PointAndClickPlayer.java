package edu.indiana.cs.c212.players;

import java.awt.AWTEvent;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.util.List;
import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.OverwriteMove;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

/**
 * @author <janson>
 * @author <galexeev>
 * 
 **/

public class PointAndClickPlayer extends AbstractPlayer implements
		AWTEventListener {

	private String playerName;
	private Point click;

	public PointAndClickPlayer(PlayerColor c) {
		super(c);
	}

	@Override
	public Move getMove(Board board, List<Move> legalMoves) {
		Toolkit.getDefaultToolkit().addAWTEventListener(this, 0);

		while (click == null) {

			try {
				Thread.sleep(3);

			} catch (InterruptedException error) {

				//error.printStackTrace();
			}
		}
		
		int x = click.x, y = click.y;
		
		Move move = new Move(x, y);
		
		if(legalMoves.contains(move)){
			
			Toolkit.getDefaultToolkit().removeAWTEventListener(this);
			click = null;
			
			return move;
		} else {
			
			Toolkit.getDefaultToolkit().removeAWTEventListener(this);
			click = null;
			
			OverwriteMove overwrite = new OverwriteMove(x,y);
			return overwrite;
		}
		
		
	}

	@Override
	public String getName() {
		playerName = "Point and Click";
		return playerName;
	}

	@Override
	public void eventDispatched(AWTEvent event) {
		// TODO Auto-generated method stub
		click = (Point) event.getSource();

	}

}
