// Chapter 16 Example 1 - FindCustomer GUI
// Modified from Chapter 11 Example 

import java.awt.*; 				 
import javax.swing.*; 			 
import java.awt.event.*; 
import java.util.Vector; 

public class FindCustomer extends JFrame implements ActionListener
{
	// variables needing class scope
	Vector customers, customerNames; 
	JList customerList;
	JLabel customerAddressText, customerPhoneText;
	JButton findButton, closeButton;
	Customer aCustomer; 	
	  
	public static void main(String args[])
	{
		Customer.initialize();	// create database connection
		FindCustomer frame = new FindCustomer(); 
	}
	// constructor
	public FindCustomer()
	{	
		// Use GridLayout and 3 panels for the Frame instance
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3,1));
		JPanel centerPanel = new JPanel(new GridLayout(1,2));
		JPanel centerRightPanel = new JPanel(new GridLayout(2,1));
		JPanel lowerPanel = new JPanel(new FlowLayout());

		// create logo
		JLabel logoLabel = new JLabel(" ",SwingConstants.CENTER);
		logoLabel.setForeground(Color.red);
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC,36));
		logoLabel.setText("Bradshaw Marina");
		c.add(logoLabel); // add logo to the Frame

		// build JList
		customers = Customer.getAll();// get vector of all customers
		customerNames = new Vector(); // names used for JList
		for(int i = 0; i < customers.size(); i++)
		{ 	
			//get customer reference, its name, and add to Vector 
			aCustomer = (Customer) customers.get(i); 	
			String customerName = aCustomer.getName(); 
			customerNames.add(customerName);	
		}
		// create the list
		customerList = new JList(customerNames); 	
		// add scroll bars to the list
		JScrollPane scrollPaneCustomerList = new 
									JScrollPane(customerList);  

		// create labels for address & phone
		customerAddressText = new JLabel("          ");		
		customerPhoneText = new JLabel("          ");

		// add list and labels to the panels
		centerPanel.add(scrollPaneCustomerList);
		centerRightPanel.add(customerAddressText);		
		centerRightPanel.add(customerPhoneText);		
		centerPanel.add(centerRightPanel);		
		c.add(centerPanel); // add center panel to the Frame
		
		// create & add Buttons for bottom panel
		findButton = new JButton("Find"); 
		closeButton = new JButton("Close"); 
		lowerPanel.add(findButton);
		lowerPanel.add(closeButton);
		c.add(lowerPanel); 
		
		this.setSize(300,200);     
		this.setTitle("Find A Customer");
		this.setVisible(true);

		// register frame as listener for button events
		findButton.addActionListener(this);
		closeButton.addActionListener(this);		 
		
		// create anonymous inner class to for window closing event
		this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent event) 
  	 				{shutDown();}
			}	  
		 );
   }
   // actionPerformed is invoked when a Button is clicked 
   public void actionPerformed(ActionEvent e)
   {	// see which button was clicked and findCustomer or shutDown
		if(e.getSource() == findButton)
     		{findCustomer();} 
		if(e.getSource() == closeButton)
     	 	{shutDown();}
   }
	private void findCustomer()
	{
		// get index of list item selected
		int i = customerList.getSelectedIndex();
		// get corresponding customer reference
		aCustomer = (Customer) customers.get(i);
		// put customer info in labels
		customerAddressText.setText(aCustomer.getAddress());
		customerPhoneText.setText(aCustomer.getPhoneNo());
	}
 	private void shutDown()
	{ 
		Customer.terminate(); // release database resource
		System.exit(0); 
	}
}