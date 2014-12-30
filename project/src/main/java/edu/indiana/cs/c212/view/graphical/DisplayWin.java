package edu.indiana.cs.c212.view.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.indiana.cs.c212.gameMechanics.GameRunner;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

@SuppressWarnings("serial")
public class DisplayWin extends JPanel implements Observer {
	
	private JLabel label;

	
	public DisplayWin(PlayerColor player, GameRunner game){
		super();
		
		int width = 150;
		int height = 50;
		Dimension hello = new Dimension(width,height);
		setPreferredSize(hello);
		
		
		
		
		
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}

}
