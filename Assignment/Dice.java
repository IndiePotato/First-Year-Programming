import java.util.Random;

/**
 * 
 * This Class controls the Dice used for the Craps Program
 * 
 * @author s4910334 <b> Oliver Nock </b>
 *
 */

public class Dice {

	//Declare Variables
	private int faceValue;
	
	/**
	 * Constructor Method which sets the face value of the Dice to -1 upon instantiation.
	 */
	
	//Constructor Methods
	public Dice() {
		faceValue=-1;
	}
	
	//SET Methods
	
	/**
	 * Randomly sets the face value of the Dice.
	 */
	
	public void roll(){
		Random rand = new Random();
		faceValue = rand.nextInt(6)+1;
	}
	
	//GET MEthods
	
	/**
	 * Returns the Face Value of the Dice
	 * 
	 * @return <b>faceValue</b> Value of the Dice
	 */
	
	public int getFaceValue(){
		return faceValue;
	}
}
