// Chapter 12 
// multiple window navigation FindCustomer GUI 

import java.awt.*; 			// Font, Color, Layout managers		 
import javax.swing.*; 		// GUI components		 
import java.awt.event.*; 	// ActionEvent, ActionListener, WindowAdapter
import java.util.Vector;   // Vector

public class FindCustomer extends JFrame implements ActionListener
{
	// variables needing class scope
	Vector customers, customerNames; 
	JList customerList;
	JTextField customerAddressText, customerPhoneText;
	JButton findButton, updateButton, closeButton;
	Customer aCustomer;
	MainMenu parentMenu; 	
	 	
	// constructor
	public FindCustomer(MainMenu menu)
	{
		parentMenu = menu;	// set reference to main menu 

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
		// retrieve vector of customers
		customerNames = new Vector();
		customers = Customer.getAll(); 
		for(int i = 0; i < customers.size(); i++)
			{ 	
				aCustomer = (Customer) customers.get(i); 		// get customer reference
				String customerName = aCustomer.getName(); 	// get the name
				customerNames.add(customerName);				 	// add  to vector
			}

		customerList = new JList(customerNames); // create the list
		// add scroll bars to the list
		JScrollPane scrollPaneCustomerList = new JScrollPane(customerList);  

		// create TextFields for address & phone
		customerAddressText = new JTextField("          ");		
		customerPhoneText = new JTextField("          ");
		// add list and TextFields to the panels
		centerPanel.add(scrollPaneCustomerList);
		centerRightPanel.add(customerAddressText);		
		centerRightPanel.add(customerPhoneText);		
		centerPanel.add(centerRightPanel);		
		c.add(centerPanel); // add center panel to the Frame
		
		// create & add Buttons for bottom panel
		findButton = new JButton("Find"); 
		updateButton = new JButton("Update"); 
		closeButton = new JButton("Close"); 
		lowerPanel.add(findButton);
		lowerPanel.add(updateButton);
		lowerPanel.add(closeButton);
		c.add(lowerPanel); 
		
		this.setSize(300,200);     
		this.setTitle("Find A Customer");
		this.setVisible(true);

		// register frame as listener for button events
		findButton.addActionListener(this);
		updateButton.addActionListener(this);		
		closeButton.addActionListener(this);		 
		
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
   {	// see which button was clicked
		if(e.getSource() == findButton)
     		{findCustomer();} 
	  	if(e.getSource() == updateButton)
     		{updateCustomer();} 
		if(e.getSource() == closeButton)
     	 	{shutDown();}
   }
	private void findCustomer()
	{
		int i = customerList.getSelectedIndex(); // get index of list item selected
		aCustomer = (Customer) customers.get(i); // get customer reference
		customerAddressText.setText(aCustomer.getAddress());
		customerPhoneText.setText(aCustomer.getPhoneNo());
	}
	private void updateCustomer()
	{
		int i = customerList.getSelectedIndex(); // get index of list item selected
		aCustomer = (Customer) customers.get(i); // get customer reference
		aCustomer.setAddress(customerAddressText.getText());		
		aCustomer.setPhoneNo(customerPhoneText.getText());			
	}
	
 	// return to main menu
	public void shutDown()
	{
		parentMenu.setVisible(true);	
		this.dispose();
	}
}