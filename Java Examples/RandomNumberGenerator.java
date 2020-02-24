/**
 * 
 * @author: Oliver Nock s4910334
 * Date Completed:
 * Upload 6 Task 2
 * 
 * This program generates a random number between 0 and 100. It then generates a random number 
 * between 0 and an assigned upper bound. Afterwards it generates a random number between a lower assigned boundary and 
 * an upper boundary. Finally, it generates an array of 10 random numbers which are all unique. The boundary is included
 * to increase the "likelyness" of duplicates so they can be solved.
 * 
 */

//Import Necessary Classes
import java.util.Arrays;
import java.util.Random;

public class RandomNumberGenerator {

	//Declare Global variables
	Random rand = new Random();

	public int randomNumber100() {
		return rand.nextInt(100);
	}

	public int randomNumberUpperBound(int upperBound) {
		return rand.nextInt(upperBound+1);
	}

	public int randomNumberBound(int lowerBound, int upperBound) {
		return rand.nextInt(upperBound-lowerBound) + lowerBound;
	}

	public int[] randomArray() {
		//Declare Variables
		int[] randomNumbers = new int[10];
		boolean repeat = false;
		
		for (int i = 0; i<10; i++) {
			do {
				//Create Random Number
				randomNumbers[i] = rand.nextInt(100);
				
				for (int j = 0; j<i; j++) {
					//Check Number against Previous Numbers
					if (randomNumbers[i] == randomNumbers[j]) {
						repeat = true;
						break;
					}
					else {
						repeat = false;
					}
				}
			} while (repeat);
		}

		return randomNumbers;
	}

	public static void main(String[] args) {
		RandomNumberGenerator generate = new RandomNumberGenerator();
		int upperNumber = 72;
		int upperBound = 86;
		int lowerBound = 34;

		//Get random Number Between 0 and 100
		System.out.println(generate.randomNumber100());

		//Get random Number Between 0 and an Assigned Value
		System.out.println(generate.randomNumberUpperBound(upperNumber));

		//Generate random Number Between an Assigned Lower Bound and an Assigned Upper Bound
		System.out.println(generate.randomNumberBound(lowerBound, upperBound));

		//Get Random Array of Unique Numbers
		System.out.println(Arrays.toString(generate.randomArray()));
	}

}