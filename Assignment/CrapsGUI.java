import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * This class controls the Graphical User Interface and it's functions for the Craps Program.
 * 
 * @author s4910334 <b> Oliver Nock </b>
 *
 */

public class CrapsGUI {
	//Declare Necessary Objects
	Craps craps = new Craps();
	
	//Declare Necessary Variables
	private JFrame frame;
	private JPanel playerDetailsPanel, betPanel, diceRollPanel, resultPanel;
	private JLabel lblName, lblChipAmount, lblEnterChips, lblChipsAvailable, lblChipsBet, 
					lblDiceOne, lblDiceTwo, lblResultMessage, lblTotal;
	private JTextField txtName, txtChipAmount, txtBetAmount;
	private JButton btnOne, btnTwo, btnThree, btnFour, 
					btnFive, btnSix, btnSeven, btnEight,
					btnNine, btnZero, btnDone, btnExit, 
					btnSubmit, btnRoll, btnRollAgain, btnRestart;
	private ImageIcon diceFaceOne, diceFaceTwo, diceFaceThree, diceFaceFour, diceFaceFive, diceFaceSix;
	private int cursorPositionOne, cursorPositionTwo;
	
	/**
	 * This constructor method initiates the components and sets up the initial interface for the GUI.
	 */
	
	//Constructor Method
	public CrapsGUI(){
		createPanels();
		createFrame();
		createLabels();
		createTextBoxes();
		createImageIcons();
		createButtons();
		updatePlayerDetailsPanel();
		
		frame.add(playerDetailsPanel);
		frame.setVisible(true);
	}
	
	/**
	 * This method creates the frame to be used for the GUI.
	 */
	
	//Creates Frame
	public void createFrame(){
		frame = new JFrame("Craps");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setResizable(false);
	}
	
	/**
	 * This method creates the panel objects to be used for the GUI.
	 */
	
	//Create Panels
	public void createPanels(){
		playerDetailsPanel = new JPanel();
		betPanel = new JPanel();
		diceRollPanel = new JPanel();
		resultPanel = new JPanel();
	}
	
	/**
	 * This method creates all the Labels Components to be used for the Program's GUI.
	 */
	
	//Creates Labels
	public void createLabels(){
		lblName = new JLabel("Enter Your Name:");
		lblName.setBounds(110, 60, 100, 20);
		playerDetailsPanel.add(lblName);
		
		lblChipAmount = new JLabel("Enter your Amount of Chips");
		lblChipAmount.setBounds(230, 120, 200, 20);
		playerDetailsPanel.add(lblChipAmount);
		
		lblEnterChips = new JLabel("How Many Chips do You Want to Bet?");
		lblEnterChips.setBounds(200, 50, 240, 40);
		
		lblChipsBet = new JLabel();
		lblChipsBet.setBounds(250, 100, 100, 40);
		
		lblChipsAvailable = new JLabel();
		lblChipsAvailable.setBounds(255, 100, 150, 40);
		
		lblResultMessage = new JLabel();
		lblResultMessage.setBounds(250, 300, 300, 40);
		
		lblDiceOne = new JLabel();
		lblDiceOne.setBounds(50, 150, 200, 200);
		
		lblDiceTwo = new JLabel();
		lblDiceTwo.setBounds(150, 350, 200, 200);
		
		lblTotal = new JLabel();
		lblTotal.setBounds(280, 200, 100, 100);

	}
	
	/**
	 * This method creates all the Button Components to be used for the Program's GUI.
	 */
	
	//Creates Buttons
	public void createButtons(){
		btnRestart = new JButton("NEW GAME");
		btnRestart.setBounds(225, 400, 150, 40);
		btnRestart.addActionListener(new RestartHandler());
		
		btnExit = new JButton("EXIT");
		btnExit.setBounds(525, 10, 60, 40);
		playerDetailsPanel.add(btnExit);
		btnExit.addActionListener(new ExitHandler());
		
		btnOne = new JButton("1");
		btnOne.setBounds(50, 220, 50, 50);
		playerDetailsPanel.add(btnOne);
		btnOne.addActionListener(new KeyPadHandler("1"));
		
		btnTwo = new JButton("2");
		btnTwo.setBounds(105, 220, 50, 50);
		playerDetailsPanel.add(btnTwo);
		btnTwo.addActionListener(new KeyPadHandler("2"));
		
		btnThree = new JButton("3");
		btnThree.setBounds(160, 220, 50, 50);
		playerDetailsPanel.add(btnThree);
		btnThree.addActionListener(new KeyPadHandler("3"));
		
		btnFour = new JButton("4");
		btnFour.setBounds(50, 275, 50, 50);
		playerDetailsPanel.add(btnFour);
		btnFour.addActionListener(new KeyPadHandler("4"));
		
		btnFive = new JButton("5");
		btnFive.setBounds(105, 275, 50, 50);
		playerDetailsPanel.add(btnFive);
		btnFive.addActionListener(new KeyPadHandler("5"));
		
		btnSix = new JButton("6");
		btnSix.setBounds(160, 275, 50, 50);
		playerDetailsPanel.add(btnSix);
		btnSix.addActionListener(new KeyPadHandler("6"));
		
		btnSeven = new JButton("7");
		btnSeven.setBounds(50, 330, 50, 50);
		playerDetailsPanel.add(btnSeven);
		btnSeven.addActionListener(new KeyPadHandler("7"));
		
		btnEight = new JButton("8");
		btnEight.setBounds(105, 330, 50, 50);
		playerDetailsPanel.add(btnEight);
		btnEight.addActionListener(new KeyPadHandler("8"));
		
		btnNine = new JButton("9");
		btnNine.setBounds(160, 330, 50, 50);
		playerDetailsPanel.add(btnNine);
		btnNine.addActionListener(new KeyPadHandler("9"));
		
		btnZero = new JButton("0");
		btnZero.setBounds(105, 385, 50, 50);
		playerDetailsPanel.add(btnZero);
		btnZero.addActionListener(new KeyPadHandler("0"));
		
		btnDone = new JButton("DONE");
		btnDone.setBounds(400, 250, 70, 40);
		playerDetailsPanel.add(btnDone);
		btnDone.addActionListener(new DoneHandler());
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(400, 250, 100, 40);
		btnSubmit.addActionListener(new SubmitHandler());
		
		btnRoll = new JButton("ROLL");
		btnRoll.setBounds(200, 275, 200, 40);
		btnRoll.addActionListener(new RollHandler());
		
		btnRollAgain = new JButton("PLAY AGAIN");
		btnRollAgain.setBounds(225, 400, 150, 40);
		btnRollAgain.addActionListener(new ReRollHandler());
	}
	
	/**
	 * This method creates all the Textfield Components to be used for the Program's GUI.
	 */
	
	//Creates Text Boxes/Fields
	public void createTextBoxes(){
		txtName = new JTextField();
		txtName.setBounds(220, 50, 150, 40);
		
		txtChipAmount = new JTextField();
		txtChipAmount.setBounds(250, 150, 100, 40);
		
		txtBetAmount = new JTextField();
		txtBetAmount.setBounds(240, 250, 150, 40);
	}
	
	/**
	 * This method creates all the Image Icons to be used for the Program's GUI.
	 */
	
	//Creates Image Icons
	public void createImageIcons(){
		diceFaceOne = new ImageIcon("Dice1.jpg"); // http://2.bp.blogspot.com/-MDwUocciFLY/Tfz1y6TE0MI/AAAAAAAAAD8/gIcj4HsZFWY/s200/Dice1.jpg
		diceFaceTwo = new ImageIcon("Dice2.jpg"); // http://3.bp.blogspot.com/-ly5UXkR-lcg/Tfz1zgfO0GI/AAAAAAAAAEE/7Cx78huP0Kk/s200/Dice2.jpg
		diceFaceThree = new ImageIcon("Dice3.jpg"); // http://2.bp.blogspot.com/-zIzHdd_e3IM/Tfz1z_GQU7I/AAAAAAAAAEM/lxVTCfAe1Hw/s200/Dice3.jpg
		diceFaceFour = new ImageIcon("Dice4.jpg"); // http://4.bp.blogspot.com/-zn4MXkJ_C-g/Tfz10QuYhrI/AAAAAAAAAEU/HJZklt4M7Ys/s200/Dice4.jpg
		diceFaceFive = new ImageIcon("Dice5.jpg"); // http://4.bp.blogspot.com/-QHxGKMUT5MQ/Tfz104LKZ5I/AAAAAAAAAEc/2S9KnPfk24A/s200/Dice5.jpg
		diceFaceSix = new ImageIcon("Dice6.jpg"); // http://4.bp.blogspot.com/-PWtnEpdiasM/Tfz1765y0uI/AAAAAAAAAEk/Z6ebr0SJNhI/s200/Dice6.jpg
	}
	
	/**
	 * This method adds all the necessary components to the Player Details Panel.
	 */
	
	//Creates Player Details Panel
	public void updatePlayerDetailsPanel(){
		playerDetailsPanel.setLayout(null);
		playerDetailsPanel.add(btnOne);
		playerDetailsPanel.add(btnTwo);
		playerDetailsPanel.add(btnThree);
		playerDetailsPanel.add(btnFour);
		playerDetailsPanel.add(btnFive);
		playerDetailsPanel.add(btnSix);
		playerDetailsPanel.add(btnSeven);
		playerDetailsPanel.add(btnEight);
		playerDetailsPanel.add(btnNine);
		playerDetailsPanel.add(btnZero);
		playerDetailsPanel.add(txtName);
		playerDetailsPanel.add(txtChipAmount);
	}
	
	/**
	 * This method adds all the necessary components to the Bet Panel.
	 */
	
	//Creates Bet Panel
	public void updateBetPanel(){
		betPanel.setLayout(null);
		betPanel.add(btnExit);
		betPanel.add(btnSubmit);
		betPanel.add(btnZero);
		betPanel.add(btnOne);
		betPanel.add(btnTwo);
		betPanel.add(btnThree);
		betPanel.add(btnFour);
		betPanel.add(btnFive);
		betPanel.add(btnSix);
		betPanel.add(btnSeven);
		betPanel.add(btnEight);
		betPanel.add(btnNine);
		betPanel.add(lblEnterChips);
		
		txtBetAmount.setText("");
		lblChipsAvailable.setText("Chips Available: " + craps.getChipAmount());
		
		betPanel.add(lblChipsAvailable);
		betPanel.add(btnSubmit);
		betPanel.add(txtBetAmount);
	}
	
	/**
	 * This method adds all the necessary components to the Roll Panel.
	 */
	
	//Create Dice Roll Panel
	public void updateDiceRollPanel(){
		diceRollPanel.setLayout(null);
		
		lblChipsBet.setText("Chips Bet: " + craps.getBetAmount());
		
		btnExit.setBounds(250, 375, 100, 40);
		diceRollPanel.add(btnExit);
		diceRollPanel.add(btnRoll);
		diceRollPanel.add(lblChipsBet);
	}
	
	/**
	 * 
	 * This method adds all the necessary components to the Result Panel.
	 * 
	 * @param dice1 - The Facevalue of the First Dice
	 * @param dice2 - The Facevalue of the Second Dice
	 */

	//Create Score Screen Panel
	public void updateResultPanel(int dice1, int dice2){
		resultPanel.setLayout(null);
		
		//Get First Dice's Value
		if(dice1 == 1){
			lblDiceOne.setIcon(diceFaceOne);
		}
		else if(dice1 == 2){
			lblDiceOne.setIcon(diceFaceTwo);
			
		}
		else if(dice1 == 3){
			lblDiceOne.setIcon(diceFaceThree);
		}
		else if(dice1 == 4){
			lblDiceOne.setIcon(diceFaceFour);
		}
		else if(dice1 == 5){
			lblDiceOne.setIcon(diceFaceFive);
		}
		else if(dice1 == 6){
			lblDiceOne.setIcon(diceFaceSix);
		}
		
		//Get Second Dice's Value
		if(dice2 == 1){
			lblDiceTwo.setIcon(diceFaceOne);
		}
		else if(dice2 == 2){
			lblDiceTwo.setIcon(diceFaceTwo);
		}
		else if(dice2 == 3){
			lblDiceTwo.setIcon(diceFaceThree);
		}
		else if(dice2 == 4){
			lblDiceTwo.setIcon(diceFaceFour);
		}
		else if(dice2 == 5){
			lblDiceTwo.setIcon(diceFaceFive);
		}
		else if(dice2 == 6){
			lblDiceTwo.setIcon(diceFaceSix);
		}
		
		//Add Elements to Panel
		lblDiceOne.setBounds(175, 50, 100, 100);
		lblDiceTwo.setBounds(325, 50, 100, 100);
		btnExit.setBounds(250, 325, 100, 40);
		resultPanel.add(lblDiceOne);
		resultPanel.add(lblDiceTwo);
		resultPanel.add(lblTotal);
		resultPanel.add(lblResultMessage);
		if(craps.getChipAmount() <= 0){
			resultPanel.add(btnRestart);
			resultPanel.add(btnExit);
		}
		else {
			resultPanel.add(btnRollAgain);
		}
	}
	
	/**
	 * 
	 * This method inserts the passed character into the BetAmount and ChipAmount text Fields.
	 * 
	 * @param character Character that is to be printed into the BetAmount and ChipAmount Text Fields.
	 */
	
	public void handleKeyPad(String character){
		try {
			cursorPositionOne = txtChipAmount.getCaretPosition();
			txtChipAmount.setText(txtChipAmount.getText().substring(0, cursorPositionOne)+character+txtChipAmount.getText().substring(cursorPositionOne));
			cursorPositionTwo = txtBetAmount.getCaretPosition();
			txtBetAmount.setText(txtBetAmount.getText().substring(0, cursorPositionTwo)+character+txtBetAmount.getText().substring(cursorPositionTwo));
			txtChipAmount.setCaretPosition(cursorPositionOne+1);
			txtBetAmount.setCaretPosition(cursorPositionTwo+1);
		}
		catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			//I understand it's bad practise to swallow the exception BUT! In this case I want it to do nothing.
			//I was going to create a Log File for it but ran out of time! (And it wasn't critical to the function of my program!
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
			//I understand it's bad practise to swallow the exception BUT! In this case I want it to do nothing.
			//I was going to create a Log File for it but ran out of time! (And it wasn't critical to the function of my program!
		}
	}
	
	/**
	 * 
	 * Inner Class which handles the <b> Restart Button  </b> 's actions when a Click-Event for the button occurs.
	 * <p> Attached Button Component resets the class variables and returns the user to the Player Details Panel. </p>
	 * 
	 * @author s4910334 <b> Oliver Nock </b> 
	 * 
	 */
	
	//Handles the "Restart" Button Click Event
	public class RestartHandler implements ActionListener{ //Let the User Start a New Game
		public void actionPerformed(ActionEvent event){
			//Wipe Variables
			craps.setBetAmount(0);
			craps.setChipAmount(0);
			craps.setTotal();
			craps.setUserName(null);
			txtName.setText(null);
			txtChipAmount.setText(null);
			txtBetAmount.setText(null);
			
			//Update GUI
			frame.remove(resultPanel);
			updatePlayerDetailsPanel();
			frame.add(playerDetailsPanel);
			frame.repaint();
			frame.revalidate();
		}
	}
	
	/**
	 * 
	 * Inner Class which handles the <b> Exit Button </b>.
	 * <p> Attached Button Component closes the program upon a click-event. </p>
	 * 
	 * @author s4910334 <b> Oliver Nock </b>
	 *
	 */
	
	//Handles the "Exit" Button Click Event
	public class ExitHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			int n = JOptionPane.showConfirmDialog(frame, "Are you Sure You Want to Exit?", "Exit?", JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}
	
	/**
	 * 
	 * Inner Class which handles the <b> Play Again Button </b>.
	 * <p> Attached Button Component sends user back to the Bet panel to Roll Again. </p>
	 * 
	 * @author s4910334 <b> Oliver Nock </b>
	 *
	 */
	
	//Handles the "Play Again" Button Click Event
	public class ReRollHandler implements ActionListener{ //Let the User Roll Again
		public void actionPerformed(ActionEvent event){
			//Update GUI
			frame.remove(resultPanel);
			updateBetPanel();
			frame.add(betPanel);
			frame.repaint();
			frame.revalidate();
		}
	}
	
	/**
	 * 
	 * Inner Class which handles the <b> Roll Button </b>.
	 * <p> Attached Button Component Rolls the Dice and sends user to Results Panel. </p>
	 * 
	 * @author s4910334 <b> Oliver Nock </b>
	 * 
	 */
	
	//Handles the "Roll" Button Click Event
	public class RollHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//Declare variables
			craps.rollDice();
			craps.setTotal();
			String outcome = String.valueOf(craps.calculateOutcome(craps.getTotal()));
			lblTotal.setText("Total: " + String.valueOf(((craps.getDiceOneValue()) + craps.getDiceTwoValue())));
			
			//Calculate Result Message
			if(outcome == "You Win"){
				lblResultMessage.setBounds(200, 275, 300, 40);
				lblResultMessage.setText("Well Done, " + craps.getUserName() + "! You win " + craps.getBetAmount() + " chips!");
				craps.setChipAmount(craps.getChipAmount() + craps.getBetAmount());
			}
			else if(outcome == "You Lose"){
				lblResultMessage.setBounds(200, 275, 300, 40);
				lblResultMessage.setText("Unlucky, " + craps.getUserName() + "! You lose " + craps.getBetAmount() + " chips!");
				craps.setChipAmount(craps.getChipAmount() - craps.getBetAmount());
			}
			else {
				lblResultMessage.setBounds(250, 275, 300, 40);
				lblResultMessage.setText("There's No Winner!");
			}
			
			//Update GUI
			frame.remove(diceRollPanel);
			updateResultPanel(craps.getDiceOneValue(), craps.getDiceTwoValue());
			frame.add(resultPanel);
			frame.repaint();
			frame.revalidate();
		}
	}
	
	/**
	 * 
	 * Inner Class which handles the <b> Submit Button </b>.
	 * <p> Attached Button Component checks the Bet Amount is Acceptable to be Used. </p>
	 * 
	 * @author s4910334 <b> Oliver Nock </b>
	 * 
	 */
	
	//Handles the "Submit" Button Click Event
	public class SubmitHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try {
				if(craps.checkBetAmount(Integer.parseInt(txtBetAmount.getText()), craps.getChipAmount())){
					
					//Collect Values from the Text-Fields on the Panel
					craps.setBetAmount(Integer.parseInt(txtBetAmount.getText()));
					
					//Update GUI
					frame.remove(betPanel);
					updateDiceRollPanel();
					frame.add(diceRollPanel);
					frame.repaint();
					frame.revalidate();
				}
				else{
					JOptionPane.showMessageDialog(frame, "Make sure the Bet Amount is between 100 and the Amount of Available Chips.");
				}
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(frame, "Make sure the Bet Amount is between 100 and the Amount of Available Chips.");
			}
		}
	}
	
	/**
	 * 
	 * Inner Class handles the <b> Done Button </b>.
	 * <p> Attached Button Component checks Initial Chip Amount and Bet Amount is Appropriate to be Used. </p>
	 * 
	 * @author s4910334 <b> Oliver Nock </b>
	 *
	 */
	
	//Handles the "DONE" Button Click Event
	public class DoneHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//Check the Values from the Interface
			try {
				if(craps.checkUserName(txtName.getText().trim()) && craps.checkChipAmount(Integer.parseInt(txtChipAmount.getText()))){
					//Collects Values held in the TextBoxes on the Panel
					craps.setUserName(String.valueOf(txtName.getText().trim()));
					craps.setChipAmount(Integer.parseInt(txtChipAmount.getText()));
					
					//Update GUI
					frame.remove(playerDetailsPanel);
					updateBetPanel();
					frame.add(betPanel);
					frame.repaint();
					frame.revalidate();
				}
				else{
						JOptionPane.showMessageDialog(frame, "Your Name must be between 1 and 20 Characters and the Chip Amount must be between 100 and 10,000!");
					}
				}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(frame, "Make sure Input is Numeric!");
			}
		}
	}
	
	/**
	 * 
	 * Inner Class which handles the <b> Key Pad </b>.
	 * 
	 * @author s4910334 <b> Oliver Nock </b>
	 *
	 */
	
	public class KeyPadHandler implements ActionListener{
		
		//Declare Appropriate Class Variables
		private String character;
		
		//Constructor Method
		public KeyPadHandler(String number){
			character = number;
		}
		
		//GeET Methods
		public String getCharacter(){
			return character;
		}
		
		public void actionPerformed(ActionEvent event){
			handleKeyPad(getCharacter());
		}
	}
	
	//Main Method
	public static void main(String[] args) {
		new CrapsGUI();
	}
}
