package com.wangsg.java2048;

public class Main {

	public static void main(String[] args) {
		Game  game = new Game();
		for(int i = 0; i < 3; ++i){
			game.fillWithNewNum();
		}
		game.printArray();
		for(int i = 0; i < 5; ++ i){
			game.pushUp();
			game.printArray();
			game.fillWithNewNum();
			System.out.println("New Array");
			game.printArray();
			game.pushDown();
			game.printArray();
			game.fillWithNewNum();
			System.out.println("New Array");
			game.printArray();
			game.pushLeft();
			game.printArray();
			game.fillWithNewNum();
			System.out.println("New Array");
			game.printArray();
			game.pushRight();
			game.printArray();
			game.fillWithNewNum();
			System.out.println("New Array");
			game.printArray();
		}
	}

}
