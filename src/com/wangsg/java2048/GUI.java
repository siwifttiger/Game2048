//GUI BorderLayout


package com.wangsg.java2048;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class GUI {

	//define
	private final int height = 394; // frame height
	private final int width = 328; // frame width
	private final int gameBoardSize = 296;
	private final int marginSize = 16;
	private final Color backgroundColor =  new Color(225, 225, 120);
	JFrame frame;
	Hashtable numberTies;
	Game game;
	GameBoard centerGB ;
	WinBoard winBoard;
	LoseBoard loseBoard;
	GameState gs;
	JPanel northPanel;
	JPanel westPanel;
	JPanel eastPanel;
	JPanel southPanel;
	JLabel gameLabel;
	JLabel scoreLabel;
	JLabel highScoreLabel;
	URL [] urlTiles;
	Font smallFeedbackFont  = new Font("SansSerif",0,20);
	Font largeFeedbackFont = new Font("SansSerif",0,40);
	
	class GameBoard extends JPanel{
		protected void paintComponent(Graphics g){
			g.setColor(new Color(20,20,20));
			g.fillRect(0,0,this.getWidth(),this.getHeight());
			int  [][] board = game.getGameBoard();
			game.printArray();
			
			for(int x = 1; x < 5; ++ x){
				for(int y = 1;y < 5; ++ y){
					int X = (8*x) + (64*(x-1));
					int Y = (8*y) + (64*(y-1));
					int thisNumber;
					if(board[y-1][x-1] == 0) thisNumber = 0;
					else  thisNumber = (int) (Math.log(board[y-1][x-1]) / Math.log(2));
					
					if(numberTies.containsKey(thisNumber)){
						ImageIcon thisTile = (ImageIcon)numberTies.get(thisNumber);
						thisTile.paintIcon(this, g, X, Y);
				}
				}
			}
		}
	}
	class WinBoard extends JPanel{
		protected void paintCompotnent(Graphics g){
			g.setColor(new Color(20, 20, 20));
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setFont(largeFeedbackFont);
			g.drawString("You Win!", 20,10);
			g.setFont(smallFeedbackFont);
			g.drawString("Press Enter to play again", 20, 30);
		}
	}
	
	class LoseBoard extends JPanel{
		protected void paintCompotnent(Graphics g){
			g.setColor(new Color(20, 20, 20));
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setFont(largeFeedbackFont);
			g.drawString("You Lose!", 20,10);
			g.setFont(smallFeedbackFont);
			g.drawString("Press Enter to try  again", 20, 30);
		}
	}
	
	class FrameKeyActionListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			GameState gs = game.getState();
			if(gs == GameState.CONTINUE){
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					System.out.println("Left Key pressed...");
					game.pushLeft();
					game.fillWithNewNum();
					game.checkState();
					centerGB.repaint();
			
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					System.out.println("Right Key pressed...");
					game.pushRight();
					game.fillWithNewNum();
					game.checkState();
					centerGB.repaint();
			
				}
				if(e.getKeyCode() == KeyEvent.VK_UP){
					System.out.println("Up Key pressed...");
					game.pushUp();
					game.fillWithNewNum();
					game.checkState();
					centerGB.repaint();
				
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
					System.out.println("Down Key pressed...");
					game.pushDown();
					game.fillWithNewNum();
					game.checkState();
					centerGB.repaint();
				}
			}
			else if(gs == GameState.LOSE){
				System.out.println("Lose...");
			}
		
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	//constructor
	public GUI(){
		frame = new JFrame("2048");
		game = new Game();
		loadNumberTiles();
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout());
		northPanel.setPreferredSize(new Dimension(width, 82));
		northPanel.setBackground(backgroundColor);
		
		gameLabel = new JLabel("2048",SwingConstants.CENTER);
		gameLabel.setFont(new Font("Serif",Font.BOLD, 20));
		
		scoreLabel = new JLabel("<html>Score:<br>524</html>",SwingConstants.CENTER);
		highScoreLabel = new JLabel("<html>High Score:<br>22600</html>",SwingConstants.CENTER);
		northPanel.add(gameLabel);
		northPanel.add(scoreLabel);
		northPanel.add(highScoreLabel);
		
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(marginSize, gameBoardSize));
		westPanel.setBackground(backgroundColor);;
		
		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(marginSize, gameBoardSize));
        eastPanel.setBackground(backgroundColor);	

		southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(width,marginSize));
        southPanel.setBackground(backgroundColor);	

        centerGB = new GameBoard();
        winBoard = new WinBoard();
        loseBoard = new LoseBoard();
        frame.getContentPane().add(northPanel, BorderLayout.NORTH);
        frame.getContentPane().add(westPanel, BorderLayout.WEST);
        frame.getContentPane().add(eastPanel, BorderLayout.EAST);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(centerGB, BorderLayout.CENTER);
       frame.getContentPane().setPreferredSize(new Dimension(width, height));
       frame.pack();
       frame.addKeyListener(new FrameKeyActionListener());
  
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
	}
	
	private void loadNumberTiles(){
		numberTies = new Hashtable();
		ClassLoader cldr = this.getClass().getClassLoader();
		urlTiles = new URL [12];
		for(int i = 0; i < 12; ++i){
			urlTiles[i] = cldr.getResource("image/tile"+(int)Math.pow(2,i)+"_64.png");
			System.out.println(urlTiles[i]);
				numberTies.put(i,new ImageIcon(urlTiles[i]));

		}
	}
	
}
