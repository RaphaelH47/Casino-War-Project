package latest;

class cards {
	public cards(){
	}
	private String card_name;
	private String card_symbol;
	private int card_value;

	
	public cards(String cn, String cs, int cv) {
		card_name = cn;
		card_symbol = cs;
		card_value = cv;
	}
	
	public String getName() { return card_name; }
	public String getSymbol() { return card_symbol; }
	public int getValue() { return card_value; }
	
	
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