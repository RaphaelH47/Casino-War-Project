package latest;

class cards {
	//Default Constructor
	public cards(){}
	
	//Private Members
	private String card_name;
	private String card_symbol;
	private int card_value;

	//Constructor for the card array
	public cards(String cn, String cs, int cv) {
		card_name = cn;
		card_symbol = cs;
		card_value = cv;
	}
	
	//Accessors
	public String getName() { return card_name; }
	public String getSymbol() { return card_symbol; }
	public int getValue() { return card_value; }
	
	//Prints out the cards from a specific array address that is passed to it
	public int print_card(){
		System.out.print("Card name: ");
		System.out.println(getName());
		System.out.print("Card symbol: ");
		System.out.println(getSymbol());
		System.out.println("");
		int value = getValue();
		return value;
	}
}