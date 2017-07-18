package magicTheGatheringLands;


/*
 * A Deck represents a collection of cards. They are either lands or not lands
 * The deck is an array of integers
 */
public class Deck {
	int[] cards; 
	int lands; //number of lands per deck
	
	/*
	 * Deck constructor taking parameter n, equal to desired number of lands
	 */
	public Deck(int n){
		this.lands = n;
		this.cards = new int[60];
		//creating n number of land cards
		for(int i=0; i<lands; i++){
			cards[i]=1;
		}
		//populating remaining deck slots with non-land cards
		for(int j=lands; j<60; j++){
			cards[j]=0;
		}
	}
	
	/*
	 * method that prints all cards in the deck in a user-friendly format
	 * mostly for testing purposes
	 */
	public void print(){
		for(int i=0; i<cards.length; i++){
			if(cards[i]==0){
				System.out.println("Non-land");
			}
			else{
				System.out.println("Land");
			}
		}
	}

	//HELPER METHOD swaps two cards at given indices
	public void swapCards(int i, int j) {
		int temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	    }
	
	//HELPER METHOD generates random integer
	public int randInt(int low, int high) {
		// Because Math.random can't return 1.0, and (int)
		// always rounds down, this method can't return high.
		int x = (int)(Math.random() * (high-low) + low);
		return x;
	}
	
	/*
     * Shuffles the cards in a deck.
     */
    public void shuffle() {
	for (int i=0; i<cards.length; i++) {
	    int j = randInt(i, cards.length-1);
	    swapCards(i, j);
		}
    }
	
    /*
     * Method that populates the hand with cards from the deck
     */
    public Hand deal(int n){
    	Hand play = new Hand(n);
    	for(int i=0; i<play.hand.length; i++){
    		play.hand[i]=cards[i];
    	}
    	return play;
    }
   /*
    * Method that generates n hands, with "lands" number of lands, and returns number of hands with optimal lands (4) 
    */
    public static int multiDealer(int n,int lands){
		Deck deck = new Deck(lands);
		Hand play = new Hand(13);
		int totalOptimal=0;
		for(int i=0; i<n; i++){
			deck.shuffle();
			play = deck.deal(13);
			if(play.sumHand()==4)totalOptimal++;
		}
		return totalOptimal;
	}
    
    
    /*
     * Method that tries multiDealer with different numbers of lands
     * returns an array of the results
     */
    public static int[] resultsArray(){
    	int [] results= new int[1000000];
    	for(int i=16; i<=19; i++){
    		int result = multiDealer(1000000,i);
    		results[i] = (result/10000);
    	}
    	return results;
    }
    
   /*
    * Method that finds the index of the highest element of an array
    * prints that element
    */
    
    public static void highest(int [] results){
    	int winner = 0;
    	for (int i=0; i<results.length; i++) {
    	    if (results[i] > results[winner]) {
    	    	winner = i;
    	    }
    	}
    	System.out.println("The best number of lands is: " + winner);
    	System.out.println("The chances of getting 4 lands in the first 5 turns is: " + results[winner] + " percent");
    }
    
    
}
