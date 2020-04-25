// Chapter 12 illustrate Add Customer & Boat GUI 

import java.awt.*; 			// Font, Color, Layout managers		 
import javax.swing.*; 		// GUI components		 
import java.awt.event.*; 	// ActionEvent, ActionListener, WindowAdapter
import java.util.Vector; 

public class AddCustomer extends JFrame implements ActionListener
{
	// variables needing class scope
	JTextField customerNameText, customerAddressText, customerPhoneText;
	JButton addBoatButton, resetButton, closeButton;
	Customer aCustomer; 	
	String customerName, customerAddress, customerPhone; 	  
	MainMenu mainMenu;
	
	// constructor
	public AddCustomer(MainMenu parentMenu)
	{
		mainMenu = parentMenu;
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3,1));
		JPanel centerPanel = new JPanel(new GridLayout(3,2));
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// create logo
		Font defaultFont = c.getFont(); // get font so can restore
		JLabel logoLabel = new JLabel(" ",SwingConstants.CENTER);
		logoLabel.setForeground(Color.red);
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC,36));
		logoLabel.setText("Bradshaw Marina");
		c.add(logoLabel); // add logo to the Frame

		// create TextFields for name, address & phone
		customerNameText = new JTextField();
		customerAddressText = new JTextField();		
		customerPhoneText = new JTextField();
		// add labels and TextFields to the panels
		centerPanel.add(new JLabel("Name: ", SwingConstants.RIGHT));
		centerPanel.add(customerNameText);
		centerPanel.add(new JLabel("Address: ", SwingConstants.RIGHT));
		centerPanel.add(customerAddressText);		
		centerPanel.add(new JLabel("Phone: ", SwingConstants.RIGHT));
		centerPanel.add(customerPhoneText);		
		c.add(centerPanel); // add center panel to the Frame
		// create Buttons for bottom panel
		addBoatButton= new JButton("Add Boat"); 
		resetButton = new JButton("Reset"); 
		closeButton = new JButton("Close"); 
		// add the buttons
		lowerPanel.add(addBoatButton);
		lowerPanel.add(resetButton);
		lowerPanel.add(closeButton);
		c.add(lowerPanel); // add lower panel to the Frame		
		
		// register frame as listener for button events
		addBoatButton.addActionListener(this);
		resetButton.addActionListener(this);		
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
   {
		// see which button was clicked
		if(e.getSource() == addBoatButton)
     		{addCustomer();} 
	  	if(e.getSource() == resetButton)
     		{clearForm();} 
		if(e.getSource() == closeButton)
     	 	{shutDown();}
   }
	private void addCustomer()
	{
		customerName = customerNameText.getText();	
		customerAddress = customerAddressText.getText();		
		customerPhone = customerPhoneText.getText();	
		if(customerName.length() == 0 || customerAddress.length() == 0 || customerPhone.length() == 0)
	   	JOptionPane.showMessageDialog(this, "Please Enter All Data ");
	   else   
			{
				aCustomer = new Customer(customerName, customerAddress, customerPhone);
				AddBoat addBoatWindow = new AddBoat(this, aCustomer);
 				addBoatWindow.setSize(550, 350);
				addBoatWindow.setTitle("Add a Boat for this Customer"); 
				addBoatWindow.setVisible(true);
				this.setVisible(false);
			}

	}
	public void clearForm()
	{
		customerNameText.setText("");	
		customerAddressText.setText("");		
		customerPhoneText.setText("");
		customerNameText.requestFocus();
	}
	
 	public void shutDown()
	{
		mainMenu.setVisible(true);
		this.dispose();
	}
}