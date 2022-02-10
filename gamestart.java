package latest;

import java.util.*; 

class gamestart {	
	public static void main(String args[]) throws java.io.IOException {
		
		//Initialize a 52 Card Deck holding card name, card symbol, and card value
		cards card_deck[] = new cards[52];
		card_deck[0] = new cards("Ace", "Spade", 14);
		card_deck[1] = new cards("Ace", "Heart", 14);
		card_deck[2] = new cards("Ace", "Clover", 14);
		card_deck[3] = new cards("Ace", "Diamond", 14);
		card_deck[4] = new cards("2", "Spade", 2);
		card_deck[5] = new cards("2", "Heart", 2);
		card_deck[6] = new cards("2", "Clover", 2);
		card_deck[7] = new cards("2", "Diamond", 2);
		card_deck[8] = new cards("3", "Spade", 3);
		card_deck[9] = new cards("3", "Heart", 3);
		card_deck[10] = new cards("3", "Clover", 3);
		card_deck[11] = new cards("3", "Diamond", 3);
		card_deck[12] = new cards("4", "Spade", 4);
		card_deck[13] = new cards("4", "Heart", 4);
		card_deck[14] = new cards("4", "Clover", 4);
		card_deck[15] = new cards("4", "Diamond", 4);
		card_deck[16] = new cards("5", "Spade", 5);
		card_deck[17] = new cards("5", "Heart", 5);
		card_deck[18] = new cards("5", "Clover", 5);
		card_deck[19] = new cards("5", "Diamond", 5);
		card_deck[20] = new cards("6", "Spade", 6);
		card_deck[21] = new cards("6", "Heart", 6);
		card_deck[22] = new cards("6", "Clover", 6);
		card_deck[23] = new cards("6", "Diamond", 6);
		card_deck[24] = new cards("7", "Spade", 7);
		card_deck[25] = new cards("7", "Heart", 7);
		card_deck[26] = new cards("7", "Clover", 7);
		card_deck[27] = new cards("7", "Diamond", 7);
		card_deck[28] = new cards("8", "Spade", 8);
		card_deck[29] = new cards("8", "Heart", 8);
		card_deck[30] = new cards("8", "Clover", 8);
		card_deck[31] = new cards("8", "Diamond", 8);
		card_deck[32] = new cards("9", "Spade", 9);
		card_deck[33] = new cards("9", "Heart", 9);
		card_deck[34] = new cards("9", "Clover", 9);
		card_deck[35] = new cards("9", "Diamond", 9);
		card_deck[36] = new cards("10", "Spade", 10);
		card_deck[37] = new cards("10", "Heart", 10);
		card_deck[38] = new cards("10", "Clover", 10);
		card_deck[39] = new cards("10", "Diamond", 10);
		card_deck[40] = new cards("Jack", "Spade", 11);
		card_deck[41] = new cards("Jack", "Heart", 11);
		card_deck[42] = new cards("Jack", "Clover", 11);
		card_deck[43] = new cards("Jack", "Diamond", 11);
		card_deck[44] = new cards("Queen", "Spade", 12);
		card_deck[45] = new cards("Queen", "Heart", 12);
		card_deck[46] = new cards("Queen", "Clover", 12);
		card_deck[47] = new cards("Queen", "Diamond", 12);
		card_deck[48] = new cards("King", "Spade", 13);
		card_deck[49] = new cards("King", "Heart", 13);
		card_deck[50] = new cards("King", "Clover", 13);
		card_deck[51] = new cards("King", "Diamond", 13);
		
		//Initializing new class objects
		rounds rd = new rounds();
		wagerBets wb = new wagerBets();
		
		//enables while loops until state is changed
		boolean menuLoop = true;
		boolean tie = false;
		boolean tieloop = true;
		boolean canWar = true;
		
		//char variables for switch case
		char tieSelect;
		char select;
		
		//Welcome Menu
		while(menuLoop == true){
		System.out.println("=========================================");
		System.out.println("Welcome to Casino Card Game War!");
		System.out.println("A. Start the game! ");
		System.out.println("B. How to Play? ");
		System.out.println("C. Exit the game ");
		System.out.print("Please enter your letter of choice: ");
		select = (char) System.in.read();
		
		//Menu Select
		switch(select) {
			case 'a':
			case 'A':
			while(true){
				//Disables menu looping now that the game has started
				menuLoop = false;
				//Goes to function to arrange bet amounts and coins
				wb.make_bet(wb.getCoins(), wb.getCBet());
				
				//Goes to function to show drawn cards
				rd.startround(wb.getCoins(), wb.getCBet(), card_deck);
				
				//Goes to function to display win, loss, or tie
				tie = rd.tie_checker(wb.handCompare(rd.getphValue(), rd.getdhValue()));
				 if (tie == true){
					while(tieloop == true){
						canWar = wb.war_Checker(wb.getCoins(), wb.getCBet());
						if (canWar == false)
							tieSelect = 's';
						else 
							tieSelect = (char) System.in.read();
						
					//switch case for Surrender or war
					switch(tieSelect){
						case 's':
						case 'S':
							tieloop = false;
							wb.tieSurrender(wb.getCoins(), wb.getCBet());
							break;
						case 'w':
						case 'W':
							tieloop = false;
							wb.gotoWar(wb.getCoins(), wb.getCBet());
							rd.tieround(wb.getCoins(), wb.getCBet(), card_deck);
							wb.warhandCompare(rd.getphValue(), rd.getdhValue());
							break;
						default:
							System.out.println("Wrong input. Please try again.");
							break;
					}
					}
				 }
			}
				
			case 'b': 
			case 'B': 
				//Option to display instructions on how to play
				System.out.println("Here's how to play!");
				System.out.println("");
				System.out.println("The player and dealer is dealt one card each. If the player's card is higher, he or she wins the wager they bet.");
				System.out.println("However, if the dealer's card is higher, the player loses their bet.");
				System.out.println("The cards are ranked numerically like this: 2-10= 2-10, Jack = 11, Queen = 12, King = 13, Ace = 14");
				System.out.println("A tie occurs when the dealer and the player each have cards of the same rank.");
				System.out.println("In a tie situation, the player has two options: ");
				System.out.println("  - The player can surrender, in which case the player loses half the bet.");
				System.out.println("  - The player can go to war, in which case the player must double his stake.");
				System.out.println("");
				System.out.println("If the player's card is ranked higher than the dealer's, then the player wins the amount of his original wager only. ");
				System.out.println("");
				break;
			case 'C':
			case 'c':
				//Option to exit the program/ game
				System.out.println("Closing the game...");
				System.exit(0);
			default:
				//Any other input option results in an error
				System.out.println("Wrong input. Please try again.");
				break;
			
		}
		}
	}
}