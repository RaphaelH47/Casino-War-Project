package latest;

class rounds {
	private int p_hand_value;
	private int d_hand_value;
	private int round_count = 1;
	
	public int getphValue() { return p_hand_value;}
	public void setphValue(int phv) { p_hand_value = phv; }
	public int getdhValue() { return d_hand_value;}
	public void setdhValue(int dhv) { d_hand_value = dhv; }
	public int getRound() { return round_count;}
	public void setRound(int rnd) { round_count = rnd; }
	
	public int draw_card(){
		double randNum = Math.random() * 52;
		int card_num = (int)randNum;
		return card_num;
	}
	
	public void startround(int c, int b, cards[] deck) {
		System.out.println("=========================================");
		System.out.println("Round " + getRound());
		System.out.println("Dealer's Cards: ");
		setdhValue(deck[draw_card()].print_card());
		System.out.println("");
		System.out.println("Player's Cards: ");
		setphValue(deck[draw_card()].print_card());
		setRound(getRound() + 1);
	}
}