// Chapter 12 
// multiple window navigation AddCustomer GUI
 
import java.awt.*; 			// Font, Color, Layout managers		 
import javax.swing.*; 		// GUI components		 
import java.awt.event.*; 	// ActionEvent, ActionListener

public class AddCustomer extends JFrame implements ActionListener
{
	// variables needing class scope
	JTextField customerNameText, customerAddressText, customerPhoneText;
	JButton addButton, clearButton, closeButton;
	Customer aCustomer; 	
	MainMenu parentMenu;	
	
	// constructor
	public AddCustomer(MainMenu menu)
	{
		parentMenu = menu;	// set reference to main menu 

		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3,1));
		JPanel centerPanel = new JPanel(new GridLayout(3,2));
		JPanel lowerPanel = new JPanel(new FlowLayout());

		// create logo
		JLabel logoLabel = new JLabel(" ",SwingConstants.CENTER);
		logoLabel.setForeground(Color.red);
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC,36));
		logoLabel.setText("Bradshaw Marina");
		c.add(logoLabel); 	

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
		c.add(centerPanel); 
		// create & add Buttons to bottom panel
		addButton = new JButton("Add"); 
		clearButton = new JButton("Clear"); 
		closeButton = new JButton("Close"); 
		lowerPanel.add(addButton);
		lowerPanel.add(clearButton);
		lowerPanel.add(closeButton);
		c.add(lowerPanel); 		
		
		// register frame as listener for button events
		addButton.addActionListener(this);
		clearButton.addActionListener(this);		
		closeButton.addActionListener(this);		 

		this.setSize(300,200);     
		this.setTitle("Add A Customer");
		this.setVisible(true);

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
		if(e.getSource() == addButton)
     		{addCustomer();} 
	  	if(e.getSource() == clearButton)
     		{clearForm();} 
		if(e.getSource() == closeButton)
     	 	{shutDown();}
   }
	private void addCustomer()
	{
		String customerName = customerNameText.getText();	
		String customerAddress = customerAddressText.getText();		
		String customerPhone = customerPhoneText.getText();	
		
		if(customerName.length() == 0 || customerAddress.length() == 0 || customerPhone.length() == 0)
	   	JOptionPane.showMessageDialog(this, "Please Enter All Data ");
	   else   
			{
   			aCustomer = new Customer(customerName, customerAddress, customerPhone);
			   JOptionPane.showMessageDialog(this, "Customer Added");
				clearForm();
			}

	}
	private void clearForm()
	{
		customerNameText.setText("");	
		customerAddressText.setText("");		
		customerPhoneText.setText("");
		customerNameText.requestFocus();
	}
	
	// return to main menu
	public void shutDown()
	{
		parentMenu.setVisible(true);	
		this.dispose();
	}
}