package latest;

import java.util.*;  
class wagerBets {
	private int coins = 500;
	private int coin_bet = 0;
	
	public wagerBets() {
		coins = getCoins();
		coin_bet = getCBet();
	}
	
	public void handCompare(int p, int d){
		if(p > d){
			System.out.println("You Win!");
 			int earnings = getCBet() * 2;
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
		else 
			System.out.println("It's a tie!");
	}
	
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
	
	public int getCoins() { return coins; }
	public void setCoins(int c) { coins = c; }
	public int getCBet() { return coin_bet; }
	public void setCBet(int cb) { coin_bet = cb; }
}
