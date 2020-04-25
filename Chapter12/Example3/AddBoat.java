// Chapter 12 illustrate Add Boat GUI 

import java.awt.*; 			// Font, Color, Layout managers		 
import javax.swing.*; 		// GUI components		 
import java.awt.event.*; 	// ActionEvent, ActionListener, WindowAdapter
import java.util.Vector; 

public class AddBoat extends JFrame implements ActionListener
{
	// GUI reference variables needing class scope
	CardLayout boatLayout;
	JPanel boatPanel, sailboatPanel, powerboatPanel, lowerPanel;
	JTextField manufacturerText, boatLengthText, yearText, stateRegistrationText;
	JTextField numberOfSailsText, keelDepthText, numberOfEnginesText;
	JRadioButton sailboatRadioButton, powerboatRadioButton;
	JRadioButton noEngineRadioButton, inboardEngineRadioButton, outboardEngineRadioButton;
	JRadioButton gasolineFuelRadioButton, dieselFuelRadioButton;
	JButton addButton, resetButton, closeButton;
 
	// other variables needing class scope
	Sailboat aSailboat; 	
	Powerboat aPowerboat; 	
	AddCustomer addCustomerWindow;
	Customer aCustomer;
	String manufacturer, stateRegistration, motorType, fuelType;
	int year, numberOfSails, numberOfEngines;
	double boatLength, keelDepth;
	 	  
	// constructor
	public AddBoat(AddCustomer returnToWindow, Customer newCustomer)
	{
		addCustomerWindow = returnToWindow;
		aCustomer = newCustomer;
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(5,1));
		JPanel topPanel = new JPanel(new GridLayout(2,4));
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		boatLayout = new CardLayout();		
		boatPanel = new JPanel();
		boatPanel.setLayout(boatLayout);
		sailboatPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
		powerboatPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// create logo
		Font defaultFont = c.getFont(); // get font so can restore
		JLabel logoLabel = new JLabel(" ",SwingConstants.CENTER);
		logoLabel.setForeground(Color.red);
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC,36));
		logoLabel.setText("Bradshaw Marina");
		c.add(logoLabel); // add logo to the Frame

		// build top panel
		manufacturerText = new JTextField(15);		
		boatLengthText= new JTextField(4);
		yearText = new JTextField(6);
		stateRegistrationText = new JTextField(15);
		topPanel.add(new JLabel("Manufacturer: ", SwingConstants.RIGHT));
		topPanel.add(manufacturerText);
		topPanel.add(new JLabel("Length: ", SwingConstants.RIGHT));
		topPanel.add(boatLengthText);
		topPanel.add(new JLabel("Year: ", SwingConstants.RIGHT));
		topPanel.add(yearText);
		topPanel.add(new JLabel("State Registration No: ", SwingConstants.RIGHT));
		topPanel.add(stateRegistrationText);	
		c.add(topPanel); // add top panel to the Frame

		// build center panel
		sailboatRadioButton = new JRadioButton("Sailboat", true);
		powerboatRadioButton = new JRadioButton("Powerboat", false);
		ButtonGroup typeOfBoat = new ButtonGroup();
		typeOfBoat.add(sailboatRadioButton);
		typeOfBoat.add(powerboatRadioButton);
		centerPanel.add(sailboatRadioButton);
		centerPanel.add(powerboatRadioButton);				 
		c.add(centerPanel); // add center panel to the Frame
				 
		// build sail boat panel
		numberOfSailsText = new JTextField(4);	
		keelDepthText = new JTextField(4);	
		noEngineRadioButton = new JRadioButton("No Engine", false);
		inboardEngineRadioButton = new JRadioButton("Inboard Engine", true);
		outboardEngineRadioButton = new JRadioButton("Outboard Engine", false);
		ButtonGroup sailBoatEngineGroup = new ButtonGroup();
		sailBoatEngineGroup.add(noEngineRadioButton);
		sailBoatEngineGroup.add(inboardEngineRadioButton);
		sailBoatEngineGroup.add(outboardEngineRadioButton);
		JPanel leftSailboatPanel = new JPanel(new GridLayout(2,1));
		JPanel rightSailboatPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		leftSailboatPanel.add(new JLabel("Number of Sails: "));
		leftSailboatPanel.add(numberOfSailsText);	
		leftSailboatPanel.add(new JLabel("Keel Depth: "));
		leftSailboatPanel.add(keelDepthText);	
		rightSailboatPanel.add(noEngineRadioButton);	
		rightSailboatPanel.add(inboardEngineRadioButton);	
		rightSailboatPanel.add(outboardEngineRadioButton);
		sailboatPanel.add(leftSailboatPanel);
		sailboatPanel.add(rightSailboatPanel);		
		sailboatPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		boatPanel.add(sailboatPanel, "sailboat");

		// build power boat panel
		numberOfEnginesText = new JTextField(4);	
		gasolineFuelRadioButton = new JRadioButton("Gasoline Fuel", true);
		dieselFuelRadioButton = new JRadioButton("Diesel Fuel", false);
		ButtonGroup powerboatFuelGroup = new ButtonGroup();
		powerboatFuelGroup.add(gasolineFuelRadioButton);
		powerboatFuelGroup.add(dieselFuelRadioButton );
		powerboatPanel.add(new JLabel("Number of Engines: "));
		powerboatPanel.add(numberOfEnginesText);	
		powerboatPanel.add(gasolineFuelRadioButton);	
		powerboatPanel.add(dieselFuelRadioButton);	
		powerboatPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		boatPanel.add(powerboatPanel, "powerboat");
		c.add(boatPanel); 	

		// create Buttons for bottom panel
		addButton = new JButton("Add Customer & Boat"); 
		resetButton = new JButton("Reset"); 
		closeButton = new JButton("Close"); 
		// add the buttons
		lowerPanel.add(addButton);
		lowerPanel.add(resetButton);
		lowerPanel.add(closeButton);
		c.add(lowerPanel); // add lower panel to the Frame		

		// register frame as listener for events
		addButton.addActionListener(this);
		resetButton.addActionListener(this);		
		closeButton.addActionListener(this);		 
		sailboatRadioButton.addActionListener(this);	
		powerboatRadioButton.addActionListener(this);			
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
     		addBoatAndCustomer(); 
	  	if(e.getSource() == resetButton)
     		clearForm(); 
		if(e.getSource() == closeButton)
     	 	shutDown();
		if(e.getSource() == sailboatRadioButton)
     	 	boatLayout.first(boatPanel); // show the other boat panel	
      if(e.getSource() == powerboatRadioButton)
     	 	boatLayout.last(boatPanel);	// show the other boat panel 		      
   }
  	   
	private void addBoatAndCustomer()
	{
		try
		{
			boatLength = Double.parseDouble(boatLengthText.getText());
			year = Integer.parseInt(yearText.getText());
			if(sailboatRadioButton.isSelected())
				{
					numberOfSails = Integer.parseInt(numberOfSailsText.getText());	
					keelDepth = Double.parseDouble(keelDepthText.getText());
				}
			else
				numberOfEngines = Integer.parseInt(numberOfEnginesText.getText());	

			manufacturer = manufacturerText.getText();
			stateRegistration = stateRegistrationText.getText();

			if (manufacturer.length() == 0 || stateRegistration.length() == 0)
	  			JOptionPane.showMessageDialog(this, "Please Enter All Data ");
			else
				{
					if(sailboatRadioButton.isSelected())
						addSailboat();
					else
						addPowerboat();		
					
					JOptionPane.showMessageDialog(this, "Customer and Boat added");
					addCustomerWindow.clearForm(); // clear customer form
					clearForm();						 // clear Boat form	
					
				}
		}
		catch(NumberFormatException e)
		{	if(sailboatRadioButton.isSelected())	
					JOptionPane.showMessageDialog(this, "length, year & number of sails must be numeric ");
			else
					JOptionPane.showMessageDialog(this, "length, year & number of engines must be numeric ");					
			}
	}
	private void addSailboat()
	{
		String motorType = "";
		if(noEngineRadioButton.isSelected())
			motorType = "none";
		if(inboardEngineRadioButton.isSelected())
			motorType = "inboard";
		if(outboardEngineRadioButton.isSelected())
			motorType = "outboard";
		aSailboat = new Sailboat(stateRegistration, boatLength, manufacturer, year, 
						numberOfSails, keelDepth, motorType);			
		aSailboat.assignBoatToCustomer(aCustomer);
	}
	private void addPowerboat()
	{
		String motorType = "";
		if(gasolineFuelRadioButton.isSelected())
			fuelType = "gasoline";
		if(dieselFuelRadioButton.isSelected())
			fuelType = "diesel";
		aPowerboat = new Powerboat(stateRegistration, boatLength, manufacturer, year,
						 numberOfEngines, fuelType);			
		aPowerboat.assignBoatToCustomer(aCustomer);
	}

	private void clearForm()
	{
		manufacturerText.setText("");	
		boatLengthText.setText("");		
		yearText.setText("");
		stateRegistrationText.setText("");
		numberOfSailsText.setText("");
		keelDepthText.setText("");
		numberOfEnginesText.setText("");
		sailboatRadioButton.doClick();
		inboardEngineRadioButton.doClick();
		manufacturerText.requestFocus();
	}
	
 	public void shutDown()
	{
		addCustomerWindow.setVisible(true);
		this.dispose();
	}
}