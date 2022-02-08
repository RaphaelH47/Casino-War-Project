import java.util.*;  
import java.util.Scanner;

public class wagerBets {
	private int coins = 500;
	private int coin_bet = 0;
	
	public wagerBets() {
		coins = getCoins();
		coin_bet = getCBet();
	}
	
	public void make_bet(int c, int b){
		int result;
		while (b == 0){
			Scanner sc = new Scanner(System.in);
			System.out.println("You currently have " + c + " coins.");
			System.out.print("Please make a wager for this round: ");
			int wager = Integer.parseInt(sc.nextLine());
			if (wager > c || wager < 0){
				System.out.println("Incorrect wager amount. Please try again.");
				System.out.println("");
			}
			else if (wager == 0){
				System.out.println("No wager was made. Please try again.");
				System.out.println("");
			}
			else{
					setCBet(wager);
					result = c - wager;
					setCoins(result);
					System.out.println("You have decided to bet: " + b + " coins.");
					System.out.println("You currently have " + c + " coins.");
					System.out.println("");
					break;
			}
		}
	}
	
	public int getCoins() { return coins; }
	public void setCoins(int c) { coins = c; }
	public int getCBet() { return coin_bet; }
	public void setCBet(int cb) { coin_bet = cb; }
}
public class gamestart {
	public static void main(String args[]) throws java.io.IOException {
		wagerBets wb = new wagerBets();
		System.out.println("Welcome to Casino Card Game War!");
		System.out.println("A. Start the game! ");
		System.out.println("B. How to Play? ");
		System.out.println("C. Exit the game ");
		System.out.print("Please enter your number of choice: ");
		char select = (char) System.in.read();
		
		
		switch(select) {
			case 'a':
				wb.make_bet(wb.getCoins(), wb.getCBet());
				break;
			case 'A':
				wb.make_bet(wb.getCoins(), wb.getCBet());
				break;
			case 'b': 
				System.out.println("Here's how to play!");
				System.out.println("");
				System.out.println("The cards are ranked in the same way that cards in poker games are ranked, with aces being the highest cards.");
				System.out.println("One card each is dealt to a dealer and to a player. If the player's card is higher, he or she wins the wager they bet. However, if the dealer's card is higher, the player loses their bet.");
				System.out.println("A tie occurs when the dealer and the player each have cards of the same rank. In a tie situation, the player has two options: ");
				System.out.println("- The player can surrender, in which case the player loses half the bet.");
				System.out.println("- The player can go to war, in which case the player must double his stake.");
				System.out.println("");
				System.out.println("If the player's card is ranked higher than the dealer's, then the player wins the amount of his original wager only. ");
				break;
			case 'B': 
				System.out.println("Here's how to play!");
				System.out.println("");
				System.out.println("The cards are ranked in the same way that cards in poker games are ranked, with aces being the highest cards.");
				System.out.println("One card each is dealt to a dealer and to a player. If the player's card is higher, he or she wins the wager they bet. However, if the dealer's card is higher, the player loses their bet.");
				System.out.println("A tie occurs when the dealer and the player each have cards of the same rank. In a tie situation, the player has two options: ");
				System.out.println("- The player can surrender, in which case the player loses half the bet.");
				System.out.println("- The player can go to war, in which case the player must double his stake.");
				System.out.println("");
				System.out.println("If the player's card is ranked higher than the dealer's, then the player wins the amount of his original wager only. ");
				break;
			case 'C':
				System.out.println("Closing the game...");
				System.exit(0);
			case 'c':
				System.out.println("Closing the game...");
				System.exit(0);
			default:
				System.out.println("Wrong input. Please restart and try again.");
		}
	}
}