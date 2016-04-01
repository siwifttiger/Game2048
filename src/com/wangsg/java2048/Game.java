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
		System.out.println();
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
		int X,Y;
		int newNum = 2;
		do{
			int choice = r.nextInt(emptySpacesX.size());  // value 0-3 choose the coordinate
	//int numberChooser = r.nextInt(10); // value 0-9   as a choose standard
		
		//if(numberChooser == 0)
			//newNum = 4;
		  X = emptySpacesX.get(choice);  //coordinate X
		  Y = emptySpacesY.get(choice); //coordinate Y
		  
		}while(gameBoard[X][Y] != 0);
		gameBoard[X][Y] = newNum;
	}
	
	//move up
	public void pushUp(){
		System.out.println("Pushing up...");
		for(int y = 0; y < 4; ++y){
			for(int x = 1; x < 4; ++x){
				if(gameBoard[x][y] != 0){  //ignore 0
					int value = gameBoard[x][y];
					int tempX = x -1;
					//ignore 0
					while((tempX >= 0) && gameBoard[tempX][y] == 0){
						tempX--;
					}
					//if the top is 0, swap
					if(tempX == -1){
						gameBoard[0][y] = value;
						gameBoard[x][y] = 0;
					}
					
					else if(gameBoard[tempX][y] != value){
						if(gameBoard[tempX+1][y] != 0 && gameBoard[tempX][y] != 0){
							gameBoard[tempX+1][y] = value;
						}
						else {
							gameBoard[tempX+1][y] = value;
							gameBoard[x][y] = 0;
						}
					}
					
					else{
						gameBoard[tempX][y] *= 2;
						gameBoard[x][y] = 0;
					}
				}
			}
		}
	}
	//move down
	public void pushDown(){
		//just like pushing up
		System.out.println("Pushing down...");
		for(int y = 0; y < 4; y++){
			for(int x = 2; x >= 0;  x--){
				if(gameBoard[x][y] != 0){
					int value = gameBoard[x][y];
					int tempX = x + 1;
					while(tempX <= 3 && gameBoard[tempX][y] == 0){
						tempX++;
					}
					if(tempX == 4){
						gameBoard[3][y] = value;
						gameBoard[x][y] = 0;
					}
					else if(gameBoard[tempX][y] != value){
						if(gameBoard[tempX-1][y] != 0 && gameBoard[tempX][y] != 0){
							gameBoard[tempX-1][y] = value;
						}
						else{
							gameBoard[tempX-1][y] = value;
							gameBoard[x][y] = 0;
						}
					}
					else{
						gameBoard[tempX][y] *= 2;
						gameBoard[x][y] = 0;
					}
				}
			}
		}
	}
	//move right
	public void pushRight(){
		
	}
	//move left
	public void pushLeft(){
		
	}


}
