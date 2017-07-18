package magicTheGatheringLands;

/*
 * hand object simulates the first n draws of a game
 * The number of turns is equal to n-7
 */

public class Hand{
	int[] hand;
	int draws;
	
	public Hand(int n){
		this.draws=n;
		this.hand= new int[draws];
		
	}
	/*
	 * method that prints a hand
	 */
	public void printHand(){
		for(int i=0; i<hand.length; i++){
			if(hand[i]==0){
				System.out.println("Non-land");
			}
			else{
				System.out.println("Land");
			}
		}
	}
	
	//HELPER METHOD
	public int sumHand(){
		int sum=0;
		for(int i=0; i<hand.length; i++){
			sum = sum + hand[i];
		}
		return sum;
	}
	
	
}
