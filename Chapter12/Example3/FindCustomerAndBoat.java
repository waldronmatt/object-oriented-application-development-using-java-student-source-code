// Chapter 12 - illustrate GUI & association - Customer has Boat

import java.awt.*; 			// Font, Color, Layout managers		 
import javax.swing.*; 		// GUI components		 
import java.awt.event.*; 	// ActionEvent, ActionListener, WindowAdapter
import java.util.Vector; 

public class FindCustomerAndBoat extends JFrame implements ActionListener
{
	// variables needing class scope
	Vector customers;
	Vector customerNames;
	JList customerList;
	JLabel customerAddressLabel, customerPhoneLabel, boatInfoLabel;
	JButton findButton, exitButton;
	Customer aCustomer; 
	MainMenu parentMenu;	
	  
	// constructor
	public FindCustomerAndBoat(MainMenu menu)
	{
		parentMenu = menu;	// set reference to main menu 
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(4,1));
		JPanel centerPanel = new JPanel(new GridLayout(1,2));
		JPanel centerRightPanel = new JPanel(new GridLayout(1,2));
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
				aCustomer = (Customer) customers.get(i); // get customer reference
				String customerName = aCustomer.getName(); // get the name
				customerNames.add(customerName);				 // add name to vector
			}

		// create a list containing customer names
		customerList = new JList(customerNames);
		// add scroll bars to the list
		JScrollPane scrollPaneCustomerList = new JScrollPane(customerList);  
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
		if(e.getSource() == findButton)
     		{findCustomer();} 
		if(e.getSource() == exitButton)
     	 	{shutDown();}
   }
	private void findCustomer()
	{
		int i = customerList.getSelectedIndex(); // get index of list item selected
		aCustomer = (Customer) customers.get(i); // get customer reference
		customerAddressLabel.setText(aCustomer.getAddress());
		customerPhoneLabel.setText(aCustomer.getPhoneNo());
		Boat aBoat = aCustomer.getBoat();
		String BoatInfo = aBoat.tellAboutSelf();
		boatInfoLabel.setText(BoatInfo);
	}
	
 	public void shutDown()
	{
		parentMenu.setVisible(true);	
		this.dispose();
	}
}