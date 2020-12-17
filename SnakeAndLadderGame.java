package SnakeAndLadder;

public class SnakeAndLadderGame {
	
	final static int winPoint = 100;
	private static int player;
	private static int player2;
	private static int player1;
	private static final int Snake = 2;
	private static final int Ladder = 1;
	private static final int NoPlay = 0;
	public static void main(String[] args)  {
		
	   while(player1!=winPoint || player2!=winPoint)
	   {
		   player1 = diceFunction(player);
		   System.out.println(player1);
		   if (player1 >= winPoint) {
			   System.out.println("Player1 is Winner");
		   	   break;
		   }
		   player2 =  diceFunction(player);
		   System.out.println("player2");
		   if (player2 >= winPoint) {
			   System.out.println("Player2 is Winner");
		   	   break;
		   } 
	   }
		
	}
	private static int diceFunction(int player) {
		boolean flag = true;
		while(flag) {
			int position = (int)(Math.random()*3);
			switch(position) {
			case NoPlay : break;
			case Ladder: int val1 = roller();
						if (player >= winPoint)
							return player;
						else {
							player += val1 ;
							System.out.println("Player gets LadderCount: "+player);
							if (player == winPoint) {
								flag = false;
								return player;
							}
						}
						break;
			case Snake: int val2 = roller();
						if (player >= winPoint)
							return player;
						else {
							player -= val2;
							if (player <= 0 || player <= -1)
								player = 0;
							System.out.println("Player gets SnakeCount: "+player);
							if (player == winPoint) {
								flag = false;
								return player;
							}
						}
						break;
			}
		}
		return player;		
	}
	private static int roller() {
		int diceRoll = (int)(Math.random()*6)+1;
		return diceRoll;
	}
}
