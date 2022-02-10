package latest;

import java.util.*;  
class wagerBets {
	//Private Members
	private int coins = 500;
	private int coin_bet = 0;
	
	//wagerBets Constructor
	public wagerBets() {
		coins = getCoins();
		coin_bet = getCBet();
	}
	
	//Compares the card values of player and dealer hand
	public boolean handCompare(int p, int d){
		if(p > d){
			System.out.println("You Win!");
 			int earnings = getCBet() * 2;
			System.out.println("You won " + earnings + " coins.");
			setCBet(0);
			setCoins(earnings + getCoins());
			return false;
		}
		
		else if (p < d){
			System.out.println("You lost!");
			int lost = getCBet();
			System.out.println("You lost your " + lost + " wagered coins.");
			setCBet(0);
			if (getCoins() == 0){
				System.out.println("You have run out of coins. Game over.");
				System.exit(0);
			}	
			return false;
		}
		else {
			System.out.println("It's a tie!");
			return true;
		}
	}
	
	public void warhandCompare(int p, int d){
		if(p > d){
			System.out.println("You Win!");
 			int earnings = getCBet();
			System.out.println("You won " + earnings + " coins.");
			setCBet(0);
			setCoins(earnings + getCoins());
		}
		
		else if (p < d){
			System.out.println("You lost!");
			int lost = getCBet();
			System.out.println("You lost your " + lost + " wagered coins.");
			setCBet(0);
			if (getCoins() == 0){
				System.out.println("You have run out of coins. Game over.");
				System.exit(0);
			}	
		}
		else {
			System.out.println("It's another tie!");
			int earnings = getCBet() * 2;
			System.out.println("You won " + earnings + " coins!");
			setCBet(0);
			setCoins(earnings + getCoins());
		}
	}
	
	//Manages bet and coin amount
	public void make_bet(int c, int b){
		int result;
	
		while (b == 0){
			Scanner sc = new Scanner(System.in);
			System.out.println("You currently have " + getCoins() + " coins.");
			System.out.print("Please make a wager for this round: ");
			int wager = Integer.parseInt(sc.next());
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
					result = getCoins() - wager;
					setCoins(result);
					System.out.println("You have decided to bet: " + getCBet() + " coins.");
					System.out.println("You currently have " + getCoins() + " coins.");
					System.out.println("");
					break;
			}
		}
	}
	public boolean war_Checker(int c, int b){
		System.out.println("=====================================");
		int tempCoins = c - b;
		if (tempCoins < 0){
			System.out.println("To go to war, you must double your wager.");
			System.out.println("You have " + c + " coins and need another " + b + " coins to wager.");  
			System.out.println("You do not have enough coins to go to war.");
			System.out.println("Auto-picking surrender...");
			int coinReturn = c + (b / 2);
			System.out.println("You get back: " + coinReturn + " coins.");
			return false;
		}
		else {
		System.out.println("If you choose to surrender, you will get back half of your wager.");
		System.out.println("You wagered: " + b + " coins.");
		int tempReturn = b / 2;
		System.out.println("You will get back: " + tempReturn + " coins.");
		System.out.println("If you choose to not surrender/ go to war, you must double your wager.");
		System.out.println("You currently have: " + c + " coins.");
		int tempBet = b * 2;
		System.out.println("If you choose to go to war, you will wager: " + tempBet + " coins.");
		System.out.println("You will have: " + tempCoins + " coins left.");
		System.out.print("Do you choose to surrender? (s) or go to war? (w) (s/w): ");
		return true;
		}
	}
	
	public void tieSurrender(int c, int b){
		int coinReturn = c + (b / 2);
		setCoins(coinReturn);
		setCBet(0);
	}
	
	public void gotoWar(int c, int b){
		int tempCoins = c - b;
		setCoins(tempCoins);
		setCBet(b * 2);
	}
	
	//Accessors and Mutators
	public int getCoins() { return coins; }
	public void setCoins(int c) { coins = c; }
	public int getCBet() { return coin_bet; }
	public void setCBet(int cb) { coin_bet = cb; }
}
