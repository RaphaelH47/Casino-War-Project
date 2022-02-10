package latest;

class rounds {
	//Private Members
	private int p_hand_value;
	private int d_hand_value;
	private int round_count = 1;
	
	//Accessors and Mutators
	public int getphValue() { return p_hand_value;}
	public void setphValue(int phv) { p_hand_value = phv; }
	public int getdhValue() { return d_hand_value;}
	public void setdhValue(int dhv) { d_hand_value = dhv; }
	public int getRound() { return round_count;}
	public void setRound(int rnd) { round_count = rnd; }
	
	//A RNG for picking a card from the card deck array
	public int draw_card(){
		int card_num = (int)(Math.random() * 52);
		return card_num;
	}
	
	//checks in case hand compare is a tie
	public boolean tie_checker(boolean check){
		if (check == false)
			return false;
		else
			return true;
	}

		
	//Prints out the drawn cards for each round
	public void startround(int c, int b, cards[] deck) {
		System.out.println("=========================================");
		System.out.println("Round " + getRound());
		setRound(getRound() + 1);
		System.out.println("Dealer's Cards: ");
		setdhValue(deck[draw_card()].print_card());
		System.out.println("");
		System.out.println("Player's Cards: ");
		setphValue(deck[draw_card()].print_card());
	}
	
	//Prints out the drawn cards for a war tie round
	public void tieround(int c, int b, cards[] deck){
		System.out.println("=========================================");
		System.out.println("War Round");
		System.out.println("Dealer's Cards: ");
		setdhValue(deck[draw_card()].print_card());
		System.out.println("");
		System.out.println("Player's Cards: ");
		setphValue(deck[draw_card()].print_card());
	}
}