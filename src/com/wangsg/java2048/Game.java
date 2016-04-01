//The Game class, for game logic

package com.wangsg.java2048;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private int [][] gameBoard;
	private Random r = new Random();
	//constructor
	public Game(){
		gameBoard = new int[4][4];
	}
	
	//just print the array
	public void printArray(){
		for(int[] x:gameBoard){
			System.out.format("%6d%6d%6d%6d\n",x[0],x[1],x[2],x[3]);
		}
	}
	
	//random produce some numbers to fill the empty spaces
	public void fillWithNewNum(){
		ArrayList<Integer> emptySpacesX = new ArrayList<Integer>();
		ArrayList<Integer> emptySpacesY = new ArrayList<Integer>();
		
		for(int x = 0; x < 4; ++x){
			for(int y = 0; y < 4; ++y){
				emptySpacesX.add(x);
				emptySpacesY.add(y);
			}
		}
		
		int choice = r.nextInt(emptySpacesX.size());  // value 0-3 choose the coordinate
		int numberChooser = r.nextInt(10); // value 0-9   as a choose standard
		int newNum = 1;
		if(numberChooser == 0)
			newNum = 2;
		int  X = emptySpacesX.get(choice);  //coordinate X
		int  Y = emptySpacesY.get(choice); //coordinate Y
		gameBoard[X][Y] = newNum;
		
	}
	
	//move up
	public void pushUP(){
		
	}
	//move down
	public void pushDown(){
		
	}
	//move right
	public void pushRight(){
		
	}
	//move left
	public void pushLeft(){
		
	}


}
