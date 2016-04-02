//GUI BorderLayout


package com.wangsg.java2048;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class GUI  extends JFrame{

	//define
	private final int height = 394; // frame height
	private final int width = 328; // frame width
	private final int gameBoardSize = 296;
	private final int marginSize = 16;
	private final Color backgroundColor =  new Color(225, 225, 120);
	
	GameBoard centerGB ;
	JPanel northPanel;
	JPanel westPanel;
	JPanel eastPanel;
	JPanel southPanel;
	JLabel gameLabel;
	JLabel scoreLabel;
	JLabel highScoreLabel;
	
	class GameBoard extends JPanel{
		protected void paintComponent(Graphics g){
			g.setColor(new Color(20,20,20));
			g.fillRect(0,0,this.getWidth(),this.getHeight());
		}
	}
	
	//constructor
	public GUI(){
		
		
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
        this.getContentPane().add(northPanel, BorderLayout.NORTH);
        this.getContentPane().add(westPanel, BorderLayout.WEST);
        this.getContentPane().add(eastPanel, BorderLayout.EAST);
        this.getContentPane().add(southPanel, BorderLayout.SOUTH);
        this.getContentPane().add(centerGB, BorderLayout.CENTER);
       this.getContentPane().setPreferredSize(new Dimension(width, height));
       this.pack();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
	}
	
	
	
}
