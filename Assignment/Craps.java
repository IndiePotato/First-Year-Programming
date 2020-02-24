/**
 * 
 * Runs the Game Logic behind the Craps Game. Interfaces with CrapsGUI.
 * <p> Craps is a game played with dice. The resulting total of the dice, when rolled, decides whether the player wins or loses. </p>
 * <p> This implementation includes betting with chips. </p> 
 * @author s4910334 <b> Oliver Nock </b>
 *
 */
public class Craps {
	//Declare Appropriate Class Variables
	private int betAmount, chipAmount, total;
	private String userName = null;
	
	//Initialise Dice Variables
	private Dice dice1 = new Dice(), dice2 = new Dice();
	
	//Constructor Class
	public Craps() {
	}
	
	//SET Methods
	
	/**
	 * 
	 * Sets the Bet Amount with the Parameter Passed.
	 * 
	 * @param betCount The Amount of Chips being Bet
	 * 
	 */
	
	public void setBetAmount(int betCount){
		betAmount = betCount;
	}
	
	/**
	 * 
	 * Sets the User's Chip Amount with the Parameter Passed.
	 * 
	 * @param chipCount The Amount of Chips Currently Held by the User
	 * 
	 */
	
	public void setChipAmount(int chipCount){
		chipAmount = chipCount;
	}
	
	/**
	 * 
	 * Sets the Name of the User with the Parameter Passed.
	 * 
	 * @param name The Name of the User
	 * 
	 */
	
	public void setUserName(String name){
		userName = name;
	}
	
	/**
	 * Sets the faceValue of the Die.
	 */
	
	public void rollDice(){
		dice1.roll();
		dice2.roll();
	}
	
	/**
	 * Sets the Total to the Combined Facevalues of the two Dice.
	 */
	
	public void setTotal(){
		total = dice1.getFaceValue() + dice2.getFaceValue();
	}
	
	//GET Methods
	
	/**
	 * 
	 * Returns the Facevalue of the First Dice.
	 * 
	 * @return <b>FaceValue</b> of the First Dice
	 */
	
	public int getDiceOneValue(){
		return dice1.getFaceValue();
	}
	
	/**
	 * 
	 * Returns the Facevalue of the Second Dice.
	 * 
	 * @return <b>FaceValue</b> of the Second Dice
	 */
	
	public int getDiceTwoValue(){
		return dice2.getFaceValue();
	}
	
	/**
	 * 
	 * Returns the Total of the Combined Facevalues of both Dice.
	 * 
	 * @return <b>total</b> Total of the Combined Facevalues of both Dice
	 */
	
	public int getTotal(){
		return total;
	}
	
	/**
	 * 
	 * Returns The Amount of Chips of which the User wishes to Bet.
	 * 
	 * @return <b>betAmount</b> Amount of Chips of which the User wishes to Bet
	 */
	
	public int getBetAmount(){
		return betAmount;
	}
	
	/**
	 * 
	 * Returns the Amount of Chips belonging to the User.
	 * 
	 * @return <b>chipAmount</b> Amount of Chips belonging to the User
	 */
	
	public int getChipAmount(){
		return chipAmount;
	}
	
	/**
	 * 
	 * Returns the Name of the User.
	 * 
	 * @return <b>userName</b> Name of the User
	 */
	public String getUserName(){
		return userName;
	}
	
	/**
	 * 
	 * Checks whether the User Name passed is acceptable to be stored by the program.
	 * 
	 * @param userName Name of the User
	 * @return <b>passed</b> Whether the Name is Acceptable to be used by the Program
	 */
	
	//Check the UserName is Appropriate
	public boolean checkUserName(String userName){
		boolean passed = false;
		if(!userName.equalsIgnoreCase(null) && userName.length() >= 1 & userName.length() <=20){
			passed = true;
		}
		else{
			passed = false;
		}
		return passed;
	}

	/**
	 * 
	 * Checks that the Chip Amount is Between 100 and 10,000.
	 * 
	 * @param chipAmount Amount of Chips
	 * @return <b>passed</b> Whether the Amount of Chips is Appropriate or Not
	 */
	
	//Check that the Initial Chip Amount is Appropriate
	public boolean checkChipAmount(int chipAmount){
		boolean passed = false;
		if(chipAmount >= 100 && chipAmount <= 10000){
			passed = true;
		}
		else{
			passed = false;
		}
		return passed;
	}
	
	/**
	 * 
	 * Checks the Bet Amount is between 1 and the Available Chip Amount.
	 * 
	 * @param betAmount Amount of Chips the User wishes to Bet
	 * @param chipAmount Amount of Chips the User actually Has
	 * 
	 * @return <b>passed</b> Whether the Bet Amount is Appropriate or Not
	 */
	
	//Check the Bet Amount is Possible
	public boolean checkBetAmount(int betAmount, int chipAmount){
		boolean passed = false;
		if(betAmount <= chipAmount && betAmount > 0){
			passed = true;
		}
		else{
			passed = false;
		}
		return passed;
	}
	
	/**
	 * 
	 * Calculates the Result of the Round
	 * 
	 * @param total Total of the Combined Facevalues of the Dice
	 * @return <b>outcome</b> Outcome of the Round
	 */
	
	//Calculate the Outcome
	public String calculateOutcome(int total) {
		//Declare Variables
		String outcome = "";

		//Calculate whether to Win or Lose or No Winner
		if (total == 2 || total == 3 || total == 12) {
			//Display Losing Message
			outcome = "You Lose";
		}
		else if (total == 7 || total == 11) {
			//Display Winning Message
			outcome = "You Win";
		}
		else {
			//Display No Winning Message
			outcome = "No Winner";
		}

		return outcome;
	}
	
}
