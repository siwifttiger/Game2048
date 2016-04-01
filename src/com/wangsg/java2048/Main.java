package com.wangsg.java2048;

public class Main {

	public static void main(String[] args) {
		Game  game = new Game();
		for(int i = 0; i < 3; ++i){
			game.fillWithNewNum();
		}
		game.printArray();
		for(int i = 0; i < 5; ++ i){
			game.fillWithNewNum();
			System.out.println("New Array");
			game.printArray();
			game.pushUp();
			game.printArray();
		}
	}

}
