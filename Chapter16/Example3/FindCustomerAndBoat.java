// FindCustomerAndBoat - Chapter 16 Example 3 
// illustrate GUI & association between Customer has Boat
// from Chapter 11 with modifications

import java.awt.*; 	
import javax.swing.*; 	
import java.awt.event.*; 	
import java.util.Vector; 

public class FindCustomerAndBoat extends JFrame 
						implements ActionListener
{
	// variables needing class scope
	Vector customers;
	Vector customerNames;
	JList customerList;
	JLabel customerAddressLabel, customerPhoneLabel, boatInfoLabel;
	JButton findButton, exitButton;
	Customer aCustomer; 

	// main method because there is no main menu GUI	
	public static void main(String args[])
	{
		Customer.initialize(); // establish database connection
		FindCustomerAndBoat frame = new FindCustomerAndBoat();
		frame.setSize(450,250);     
		frame.setTitle("Find Customer and Boat");
		frame.setVisible(true);	
	}
	
	// constructor
	public FindCustomerAndBoat()
	{	
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(4,1));
		JPanel centerPanel = new JPanel(new GridLayout(1,2));
		JPanel centerRightPanel = new JPanel(new GridLayout(2,1));
		JPanel lowerPanel = new JPanel();
	
		// create logo
		Font defaultFont = c.getFont(); // get font so can restore
		JLabel logoLabel = new JLabel(" ",SwingConstants.CENTER);
		logoLabel.setForeground(Color.red);
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC,36));
		logoLabel.setText("Bradshaw Marina");
		c.add(logoLabel); // add logo to the Frame

		// retrieve the Vector of customers
		customers = Customer.getAll();

		// store customer names in a vector
		customerNames = new Vector();
		for(int i = 0; i < customers.size(); i++)
			{ 	
				aCustomer = (Customer) customers.get(i); 
				String customerName = aCustomer.getName(); 
				customerNames.add(customerName);				 
			}
		// create a list containing customer names
		customerList = new JList(customerNames);
		// add scroll bars to the list
		JScrollPane scrollPaneCustomerList = 
							new JScrollPane(customerList);  
		centerPanel.add(scrollPaneCustomerList);
		// create Labels for address, phone & boat info
		customerAddressLabel = new JLabel();		
		customerPhoneLabel = new JLabel();
		boatInfoLabel = new JLabel();
		// add labels to panels and panels to the frame
		centerRightPanel.add(customerAddressLabel);
		centerRightPanel.add(customerPhoneLabel);		
		centerPanel.add(centerRightPanel);
		c.add(centerPanel); // add center panel to the Frame
		c.add(boatInfoLabel);

		// create Buttons for bottom panel
		findButton = new JButton("Find"); 
		exitButton = new JButton("Close"); 
		// add the buttons
		lowerPanel.add(findButton);
		lowerPanel.add(exitButton);
		c.add(lowerPanel); // add lower panel to the Frame		
		
		// register frame as listener for button events
		findButton.addActionListener(this);		
		exitButton.addActionListener(this);		 
		
		// create anonymous inner class for window closing event
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
		if(e.getSource() == findButton)
			{findCustomer();} 
		if(e.getSource() == exitButton)
			{shutDown();}
	}
	private void findCustomer()
	{
		// get list item index and customer reference
		int i = customerList.getSelectedIndex(); 
		aCustomer = (Customer) customers.get(i); 
		// get customer details
		customerAddressLabel.setText(aCustomer.getAddress());
		customerPhoneLabel.setText(aCustomer.getPhoneNo());
		// get boat details
		Boat aBoat = aCustomer.getBoat();
		String boatInfo = aBoat.tellAboutSelf();
		boatInfoLabel.setText(boatInfo);
	}
	public void shutDown()
	{ 
		Customer.terminate();
		System.exit(0);	
	}
}