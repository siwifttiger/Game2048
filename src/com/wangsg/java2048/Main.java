package com.wangsg.java2048;

public class Main {

	public static void main(String[] args) {
		Game  game = new Game();
		for(int i = 0; i < 11; ++i){
			game.fillWithNewNum();
			game.printArray();
			System.out.println();
		}
	}

}
