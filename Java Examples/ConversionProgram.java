/**
 * @author Oliver Nock s4910334
 * Date Completed: 
 * Upload 6 Task 1
 * 
 * This program allows the user to input 10 sums of money in GBP and shows then shows the conversion rate of the user's choice depending
 * on whether they've chosen the Euro, the Dollars, the Yen, or the Rupee etc.
 */

//Import Necessary Classes
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConversionProgram {
	
	//Declare Global Variables
	Scanner scan = new Scanner(System.in);
	DecimalFormat formatter = new DecimalFormat("###,###,##0.00");

	public double getValue() {
		//Declare Variables
		double moneyValue = 0;
		boolean repeat = false;

		//Request user to Enter Amount in GDP
		do {
			try {
				System.out.print("Enter amount in GDP: ");
				moneyValue = scan.nextDouble();
			}
			catch (InputMismatchException ex) {
				System.err.println("Wrong Data Type Entered. Expecting a Decimal Number.");
				repeat = true;
			}
			catch (NoSuchElementException ex) {
				scan.next();
			}

			return moneyValue;
		} while(repeat);

	}

	public double[] convertToEuros(double[] poundValues) {
		//Create Euro Array
		double[] euroAmount = new double[10];
		
		//Calculate Amount in Euros
		for (int i = 0; i < poundValues.length; i++) {
			euroAmount[i] = poundValues[i]*1.19;
			
			//Print Conversion Sum
			System.out.println("GBP " + formatter.format(poundValues[i]) + " - " + formatter.format(euroAmount[i]) + " EURO");
		}
		return euroAmount;
	}
	
	public double[] convertToDollars(double[] poundValues) {
		//Create Dollar Array
		double[] dollarAmount= new double[10];
		
		//Calculate Amount in Dollars
		for (int i = 0; i < poundValues.length; i++) {
			dollarAmount[i] = poundValues[i]*1.26;
			
			//Print Conversion Sum
			System.out.println("GBP " + formatter.format(poundValues[i]) + " - " + formatter.format(dollarAmount[i]) + " USD");
		}
		
		return dollarAmount;
	}
	
	public double[] convertToYen(double[] poundValues) {
		//Create Yen Array
		double[] yenAmount= new double[10];
		
		//Calculate Amount in Yen
		for (int i = 0; i < poundValues.length; i++) {
			yenAmount[i] = poundValues[i]*144.53;
			
			//Print Conversion Sum
			System.out.println("GBP " + formatter.format(poundValues[i]) + " - " + formatter.format(yenAmount[i]) + " YEN");
		}
		
		return yenAmount;
	}
	
	public double[] convertToRupee(double[] poundValues) {
		//Create Rupee Array
		double[] rupeeAmount= new double[10];
		
		//Calculate Amount in Rupee
		for (int i = 0; i < poundValues.length; i++) {
			rupeeAmount[i] = poundValues[i]*84.98;
			
			//Print Conversion Sum
			System.out.println("GBP " + formatter.format(poundValues[i]) + " - " + formatter.format(rupeeAmount[i]) + " INR");
		}
		
		return rupeeAmount;
	}
	
	public void displayMenu() {
		//Declare Variables
		double[] moneyValues = new double[10];
		int userChoice;
		Scanner scan = new Scanner(System.in);
		boolean repeat = true;
		
		//Display Menu and get User Choice
		do {
			try {
				System.out.println("MENU");
				System.out.println("");
				System.out.println("1. Enter GBP Values");
				System.out.println("2. Convert to (EUR)Euros");
				System.out.println("3. Convert to (USD)Dollars");
				System.out.println("4. Convert to (JPY)Yen");
				System.out.println("5. Convert to (INR)Rupees");
				System.out.println("6. Exit");
				System.out.println("");
				System.out.print("Choose an Option: ");
				userChoice = scan.nextInt();
				if (userChoice == 1) {
					//Get Array of Pound Values
					for(int i = 0; i<moneyValues.length; i++) {
						moneyValues[i] = getValue();
						//Arrays.toString(moneyValues);
					}
					System.out.println();
				}	
				else if (userChoice == 2) {
					//Convert to Euros
					convertToEuros(moneyValues);
				}
				else if (userChoice == 3) {
					//Convert to Dollars
					convertToDollars(moneyValues);
				}
				else if (userChoice == 4) {
					//Convert to Yen
					convertToYen(moneyValues);
				}
				else if (userChoice == 5) {
					//Convert to Rupees
					convertToRupee(moneyValues);
				}	
				else if (userChoice == 6){
					//Exit the Program
					repeat = false;
				}
				else{
					repeat = true;
				}
			}
			//Catch an Input Mismatch Exception
			catch (InputMismatchException ex){
				System.err.println("Wrong Data Type Entered. Expecting an Integer Value.");
				scan.next();
			}
		} while (repeat);
		scan.close();
	}

	public static void main(String[] args) {
		//Declare Variables
		ConversionProgram meth = new ConversionProgram();

		//Display the Menu
		meth.displayMenu();


	}

}
