// Import the GUI libraries
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PiratesStep1 {
	/**
	 * MAIN METHOD
	 * This main method starts the GUI and runs the createMainWindow() method.
	 * This method should not be changed.
	 */
	public static void main (String [] args) {
		javax.swing.SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				createMainWindow ();
			}
		});
	}


	/**
	 * STATIC VARIABLES AND CONSTANTS
	 * Declare the objects and variables that you want to access across
	 * multiple methods.
	 */



	/**
	 * CREATE MAIN WINDOW
	 * This method is called by the main method to set up the main GUI window.
	 */
	private static void createMainWindow () {
		// Create and set up the window.
		JFrame frame = new JFrame ("Pirates");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setResizable (false);
		
		

		// The panel that will hold the components in the frame.
		JPanel contentPane = new JPanel ();
		contentPane.setPreferredSize(new Dimension(950, 400));
		contentPane.setLayout(new BorderLayout());
		
		
		

		//create the right action panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		contentPane.add(rightPanel, BorderLayout.EAST);
		
		

		// Add score labels
		JLabel scoreTitleLabel = new JLabel("Score");
		scoreTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(scoreTitleLabel);

		// score
		JLabel scoreNumberLabel = new JLabel ("0");
		scoreNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(scoreNumberLabel);

		//Actions label
		JLabel actionTitleLabel = new JLabel ("Actions");
		actionTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(actionTitleLabel);

		//New game button
		JButton newGameButton = new JButton ("New Game");
		newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(newGameButton);

		//Music off button
		JButton musicButton = new JButton ("Music Off");
		musicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(musicButton);

		// Quit button
		JButton quitButton = new JButton ("Quit");
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(quitButton);
		
		
		
		//Add the map
		JLayeredPane gamePanel= new JLayeredPane();
		contentPane.add(gamePanel);
		
		JLabel mapImage = new JLabel(new ImageIcon("resources/world-map-animals.jpg"));
		mapImage.setSize(775, 400);
		gamePanel.add(mapImage);
		
		
		// add pirate ship
		JLabel shipImage = (createScaledImage("resources/pirate-ship.png", 40, 40));
		shipImage.setSize(40, 40);
		gamePanel.add(shipImage, Integer.valueOf(100));
		
		
		//put ship at random location
		Random randomGenerator = new Random();
		int pirateX = randomGenerator.nextInt(735);
		int pirateY =randomGenerator.nextInt(360);
		shipImage.setLocation(pirateX, pirateY);

		// Add the panel to the frame
		frame.setContentPane(contentPane);

		//size the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	/**
	 * HELPER METHODS
	 * Methods that you create to manage repetitive tasks.
	 */

	/** Creates an image label scaled to the given size. */
	private static JLabel createScaledImage (String filename, int width, int height) {
		Image originalImage = new ImageIcon(filename).getImage();
		Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new JLabel(new ImageIcon(scaledImage));
	}


	/**
	 * EVENT LISTENERS
	 * Subclasses that handle events (button clicks, mouse clicks and moves,
	 * key presses, timer expirations)
	 */

}