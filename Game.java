import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Game extends JFrame {

	// ArrayList Declaration
	ArrayList<Integer> player1 = new ArrayList<Integer>();
	ArrayList<Integer> player2 = new ArrayList<Integer>();
	JPanel panel = new JPanel();
	JPanel lowerPanel = new JPanel();
	JPanel middlePanel = new JPanel();
	
	JLabel lblMessage = new JLabel("Lets start playing!");
	JLabel lblGameInfo = new JLabel("Game Information");
	
	//Game components
	
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	
	
	ImageIcon blue = new ImageIcon("src/blue.png");
	ImageIcon red = new ImageIcon("src/Red.png");
	ImageIcon two = new ImageIcon("src/2.png");
	ImageIcon three = new ImageIcon("src/3.png");
	ImageIcon four = new ImageIcon("src/4.png");
	ImageIcon five = new ImageIcon("src/5.png");
	ImageIcon six = new ImageIcon("src/6.png");
	ImageIcon seven = new ImageIcon("src/7.png");
	ImageIcon eight = new ImageIcon("src/8.png");
	ImageIcon nine = new ImageIcon("src/9.png");
	ImageIcon ten = new ImageIcon("src/10.png");
	ImageIcon jack = new ImageIcon("src/jack.png");
	ImageIcon ace = new ImageIcon("src/ace.png");
	ImageIcon king = new ImageIcon("src/king.png");
	ImageIcon queen = new ImageIcon("src/queen.png");

	JLabel lblImage = new JLabel(blue);
	JLabel label = new JLabel(red);
	
	String user;

	int cont = 1;
	JButton btnExit = new JButton("Exit");
	JButton btnContinue = new JButton("Continue ");

	public Game() {
		
		
		setResizable(false);
		setSize(600, 700);
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(lowerPanel, BorderLayout.SOUTH);
		
		JLabel lblWarGame = new JLabel("War Game");
		lblWarGame.setFont(new Font("Arial", Font.ITALIC, 13));
		panel.add(lblWarGame);
		
		lowerPanel.add(lblGameInfo);
		

		getContentPane().add(middlePanel, BorderLayout.CENTER);
		SpringLayout sl_middlePanel = new SpringLayout();
		sl_middlePanel.putConstraint(SpringLayout.NORTH, label, 2, SpringLayout.SOUTH, lblMessage);
		sl_middlePanel.putConstraint(SpringLayout.NORTH, lblImage, 2, SpringLayout.SOUTH, lblMessage);
		sl_middlePanel.putConstraint(SpringLayout.NORTH, lblMessage, 21, SpringLayout.NORTH, middlePanel);
		sl_middlePanel.putConstraint(SpringLayout.WEST, lblMessage, 68, SpringLayout.WEST, middlePanel);
		sl_middlePanel.putConstraint(SpringLayout.SOUTH, lblMessage, -528, SpringLayout.SOUTH, middlePanel);
		sl_middlePanel.putConstraint(SpringLayout.EAST, lblMessage, -56, SpringLayout.EAST, middlePanel);
		middlePanel.setLayout(sl_middlePanel);
		

		lblMessage.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		middlePanel.add(lblMessage);
		
		JButton btnContinue = new JButton("Continue ");
		sl_middlePanel.putConstraint(SpringLayout.EAST, btnContinue, -257, SpringLayout.EAST, middlePanel);
		middlePanel.add(btnContinue);
		
		 btnContinue.addActionListener(new ActionListener() {
		     @Override
		        public void actionPerformed(ActionEvent e) {
		    	 			btnContinue.setVisible(false);
		    	 			btnExit.setVisible(false);
		    	 			makeDeck();
		                    lblMessage.setText("You have " + player1.size() + " cards. Computer has " + player2.size() + " cards.");
		          t.start();
		        }
		    });
		
		
		
		JButton btnExit = new JButton("Exit");
		sl_middlePanel.putConstraint(SpringLayout.NORTH, btnExit, 548, SpringLayout.NORTH, middlePanel);
		sl_middlePanel.putConstraint(SpringLayout.SOUTH, btnContinue, -6, SpringLayout.NORTH, btnExit);
		sl_middlePanel.putConstraint(SpringLayout.EAST, btnExit, -271, SpringLayout.EAST, middlePanel);
		middlePanel.add(btnExit);
		
		
		 btnExit.addActionListener(new ActionListener() {
		     @Override
		        public void actionPerformed(ActionEvent e) {
		    	 System.exit(0);
		        }
		    });
		
		
		
		sl_middlePanel.putConstraint(SpringLayout.WEST, lblImage, 0, SpringLayout.WEST, lblMessage);
		sl_middlePanel.putConstraint(SpringLayout.EAST, lblImage, -303, SpringLayout.EAST, middlePanel);
		middlePanel.add(lblImage);
		sl_middlePanel.putConstraint(SpringLayout.WEST, label, 24, SpringLayout.EAST, lblImage);
		sl_middlePanel.putConstraint(SpringLayout.EAST, label, -56, SpringLayout.EAST, middlePanel);
		middlePanel.add(label);
		
		JLabel lblPlayer = new JLabel("Player 1");
		sl_middlePanel.putConstraint(SpringLayout.NORTH, lblPlayer, 480, SpringLayout.NORTH, middlePanel);
		sl_middlePanel.putConstraint(SpringLayout.SOUTH, lblImage, -14, SpringLayout.NORTH, lblPlayer);
		sl_middlePanel.putConstraint(SpringLayout.WEST, lblPlayer, 155, SpringLayout.WEST, middlePanel);
		middlePanel.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		sl_middlePanel.putConstraint(SpringLayout.SOUTH, label, -14, SpringLayout.NORTH, lblPlayer_1);
		sl_middlePanel.putConstraint(SpringLayout.SOUTH, lblPlayer_1, 0, SpringLayout.SOUTH, lblPlayer);
		sl_middlePanel.putConstraint(SpringLayout.EAST, lblPlayer_1, -148, SpringLayout.EAST, middlePanel);
		middlePanel.add(lblPlayer_1);
		setVisible(true);
	}
	

	// method that creates the decks for the two players
	public void makeDeck() {
		// loop that creates 26 cards for player 1
		for (int counter1 = 0; counter1 < 2; counter1++) {
			for (int counter = 0; counter < 13; counter++) {
				player1.add(counter);
			}
		}
		// loop that creates 26 cards for player 2
		for (int counter1 = 0; counter1 < 2; counter1++) {
			for (int counter = 0; counter < 13; counter++) {
				player2.add(counter);
			}
		}

		// shuffles cards for both players
		Collections.shuffle(player1);
		Collections.shuffle(player2);
		
	}
	
	public String checkCard (int card) {
		
		String name = "";
		if (card == 1)
			name = "Ace";
		else if (card == 11)
			name = "jack";
		else if (card == 12)
			name = "queen";
		else if (card == 13)
			name = "king";
		else 
			name = String.valueOf(card);	
			
	return name;
	}
	
public void showCard (int blue, int red) {
		
	if (blue == 1)
		lblImage.setIcon(ace);
	else if (blue == 2)
		lblImage.setIcon(two);
	else if (blue == 3)
		lblImage.setIcon(three);
	else if (blue == 4)
		lblImage.setIcon(four);	
	else if (blue == 5)
		lblImage.setIcon(five);
	else if (blue == 6)
		lblImage.setIcon(six);
	else if (blue == 7)
		lblImage.setIcon(seven);
	else if (blue == 8)
		lblImage.setIcon(eight);
	else if (blue == 9)
		lblImage.setIcon(nine);
	else if (blue == 10)
		lblImage.setIcon(ten);
	else if (blue == 11)
		lblImage.setIcon(jack);
	else if (blue == 12)
		lblImage.setIcon(queen);
	else if (blue == 13)
		lblImage.setIcon(king);
	
	if (red == 1)
		label.setIcon(ace);
	else if (red == 2)
		label.setIcon(two);
	else if (red == 3)
		label.setIcon(three);
	else if (red  == 4)
		label.setIcon(four);	
	else if (red  == 5)
		label.setIcon(five);
	else if (red == 6)
		label.setIcon(six);
	else if (red == 7)
		label.setIcon(seven);
	else if (red == 8)
		label.setIcon(eight);
	else if (red == 9)
		label.setIcon(nine);
	else if (red == 10)
		label.setIcon(ten);
	else if (red == 11)
		label.setIcon(jack);
	else if (red == 12)
		label.setIcon(queen);
	else if (red == 13)
		label.setIcon(king);
	}
	
	Thread t = new Thread(new Runnable() {

		@Override
		public void run() {
			     
			      //runs game as long as player enters continue and each player still has cards left
			      while (cont == 1 && player1.size() != 0 && player2.size() != 0)
			      {
			    	  lblGameInfo.setText("<HTML>You have " + player1.size() + " cards. Computer has " + player2.size() + " cards.</HTML>");
			        Collections.shuffle(player1);
			        Collections.shuffle(player2);
			        
			        //first card of the list array is parsed to an int
			        int play1 = (Integer) player1.get(0);
			        int play2 = (Integer) player2.get(0);
			        
			        //compares first cards of both players
			        //displays cards of both players and adds both cards to player 1
			        if (play1 > play2)
			        {
			          
			        	lblMessage.setText("<HTML>Player 1 picked " + checkCard((player1.get(0) + 1)) + " and player 2 picked " + checkCard((player2.get(0)+1)) + ", player 1 wins</HTML>");
			        	showCard((player1.get(0) + 1), (player2.get(0)+1));
			        	//adds cards to winner
			          player1.add(player1.get(0));
			          player1.add(player2.get(0));
			          //removes first cards of both players
			          player1.remove(0);
			          player2.remove(0);
			          
			        }
			        //displays cards of both players and adds both cards to player 2
			        else if (play1 < play2)
			        {
			          
			        	lblMessage.setText("<HTML>Player 1 picked " + checkCard((player1.get(0)+ 1)) + " and player 2 picked " + checkCard((player2.get(0)+ 1)) + ", player 2 wins</HTML>");
			        	showCard((player1.get(0) + 1), (player2.get(0)+1));
			        	//adds cards to winner
			          player2.add(player1.get(0));
			          player2.add(player2.get(0));
			          //removes first cards of both players
			          player1.remove(0);
			          player2.remove(0);
			        }
			        
			        //runs if both players pull the same card
			        else if (play1 == play2)
			        {
			          //runs if any of the players has less than 3 cards left
			          if (player1.size() < 4)
			          {
			        	  lblMessage.setText("<HTML>Tie!  Since Player 1 has less than four cards, Player 2 wins this game of War</HTML>");
			            cont = 2;
			          }
			          else if (player2.size() < 4)
			          {
			        	  lblMessage.setText("<HTML>Tie! Since Player 2 has less than four cards, Player 1 wins this game of War</HTML>");
			            cont = 2;
			          }
			          else
			          {
			            //displays cards
			        	  lblMessage.setText("<HTML>Player 1 picked " + checkCard((player1.get(0)+ 1)) + " and player 2 picked " + checkCard((player2.get(0)+ 1)) +"<HTML>");
			        	  showCard((player1.get(0) + 1), (player2.get(0)+1));
			        	  lblMessage.setText("Tie!");
			            
			            //2D array that stores the next three cards of each player
			            int [][]tieCards = new int [2][3];
			            
			            //double for loop that stores next three cards of each player
			            for (int row = 0; row < 2; row++)
			            {
			              for (int col = 0; col < 3; col++)
			              {
			                if (row == 0)
			                {
			                  tieCards[row][col] = player1.get(col+1);
			                }
			                else if (row == 1)
			                {
			                  tieCards[row][col] = player2.get(col+1);
			                }
			              }
			            }
			            
			            //displays the 3 cards that each player picked
			            lblMessage.setText("<HTML>Player 1 picked up another 3 cards: " + checkCard((player1.get(1)+ 1)) + " " + checkCard((player1.get(2)+ 1)) + " " + checkCard((player1.get(3)+ 1)) + "</HTML>" );
			            lblMessage.setText("<HTML>Player 2 picked up another 3 cards: " + checkCard((player2.get(1)+ 1)) + " " + checkCard((player2.get(2)+ 1)) + " " + checkCard((player2.get(3)+ 1)) + "</HTML>");
			            
			            //adds up the 3 cards that each player picked
			            play1 = tieCards[0][0] + tieCards[0][1] + tieCards[0][2];
			            play2 = tieCards[1][0] + tieCards[1][1] + tieCards[1][2];
			            
			            //runs if the total of player 1's three cards is more than player 2
			            if (play1 > play2)
			            {
			            	lblMessage.setText("Player 1 wins");
			              //for loop that adds the 8 cards that player 1 won
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player1.add(player1.get(counter));
			                player1.add(player2.get(counter));
			              }
			              //removes the first 4 cards of each player
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player1.remove(0);
			                player2.remove(0);
			              }
			              
			            }
			            //runs if the total of player 2's three cards is more than player 1
			            else if (play1 < play2)
			            {
			            	lblMessage.setText("Player 2 wins");
			              //for loop that adds the 8 cards that player 1 won
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player2.add(player1.get(counter));
			                player2.add(player2.get(counter));
			              }
			              //removes the first 4 cards of each player
			              for (int counter = 0; counter < 4; counter++)
			              {
			                player1.remove(0);
			                player2.remove(0);
			              }
			            }
			            // runs if the total of both players are equal
			            else if (play1 == play2)
			            {
			              
			            	lblMessage.setText("It's a tie still");
			            }
			          }
			        }

			        int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
			            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        if (response == JOptionPane.NO_OPTION) {
			          cont = 2;
			        } else if (response == JOptionPane.YES_OPTION) {
			          cont = 1;
			        } else if (response == JOptionPane.CLOSED_OPTION) {
			          cont = 2;
			        }
			        
			      }
			      
			      //runs if the player 1 has no cards left
			      if (player1.size() == 0)
			      {
			    	  lblMessage.setText("Player 2 wins this game of War");
			      }
			      //runs if player 2 has no cards left
			      else if (player2.size() == 0)
			      {
			        lblMessage.setText("Player 1 wins this game of War");
			      }
			      // ends game
			      else if (cont == 2)
			      {
			    	  lblMessage.setText("Player chose to quit the game, press exit to exit the game.");
			      }
			   
			 
		} });
    	  

	public static void main(String args[]) {
		
	new Game();
	}
}

