// Chapter 12 
// Multiple window navigation - GUI Menu for AddCustomer & FindCustomer 

import java.awt.*; 			// Font, Color, Layout managers		 
import javax.swing.*; 		// GUI components		 
import java.awt.event.*; 	// ActionEvent, ActionListener, WindowAdapter

public class MainMenu extends JFrame implements ActionListener
{
	// variables needing class scope
	JButton findCustomerButton, addCustomerButton, closeButton;

	public static void main(String args[])
	{	MainMenu frame = new MainMenu(); }
		
	// constructor
	public MainMenu()
	{
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(2,1));
		JPanel lowerPanel = new JPanel(); // default FlowLayout 

		// create logo
		Font defaultFont = c.getFont(); // get font so can restore
		JLabel logoLabel = new JLabel(" ",SwingConstants.CENTER);
		logoLabel.setForeground(Color.red);
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC,36));
		logoLabel.setText("Bradshaw Marina");
		c.add(logoLabel); // add logo to the Frame

		// create Buttons for bottom panel
		findCustomerButton = new JButton("Find a Customer"); 
		addCustomerButton = new JButton("Add a Customer"); 
		closeButton = new JButton("Close"); 
		// add the buttons
		lowerPanel.add(findCustomerButton);
		lowerPanel.add(addCustomerButton);
		lowerPanel.add(closeButton);
		c.add(lowerPanel); // add lower panel to the Frame		
		
		// register frame as listener for button events
		findCustomerButton.addActionListener(this);
		addCustomerButton.addActionListener(this);		
		closeButton.addActionListener(this);		 

		this.setSize(300,200);     
		this.setTitle("Main Menu");
		this.setVisible(true);

		Customer.initialize(); // initialize the pseudo-dbms	

		// create anonymous inner class to handle window closing event
		this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent event) 
  	 				{shutDown();}
			}	  
		 );
   }
   // actionPerformed is invoked when a Button is clicked 
   public void actionPerformed(ActionEvent e)
   {
		// see which button was clicked
		if(e.getSource() == findCustomerButton)
     		{findCustomer();} 
	  	if(e.getSource() == addCustomerButton)
     		{addCustomer();} 
		if(e.getSource() == closeButton)
     	 	{shutDown();}
   }
	private void findCustomer()
	{
		FindCustomer findCustomerFrame = new FindCustomer(this);
		findCustomerFrame.setSize(300,200);     
		findCustomerFrame.setTitle("Find A Customer");
		findCustomerFrame.setVisible(true);
		this.setVisible(false);	
	}
	private void addCustomer()
	{
		AddCustomer addCustomerFrame = new AddCustomer(this);
		addCustomerFrame.setSize(300,200);     
		addCustomerFrame.setTitle("Add A Customer");
		addCustomerFrame.setVisible(true);
		this.setVisible(false);	
	}
 	public void shutDown()
		{  System.exit(0);  }
}