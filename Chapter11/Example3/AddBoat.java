//  Chapter11 Example 3 - Add Boat GUI 

import java.awt.*; 			// Font, Color, Layout managers		 
import javax.swing.*; 		// GUI components		 
import java.awt.event.*; 	// ActionEvent, ActionListener, WindowAdapter

public class AddBoat extends JFrame implements ActionListener
{
	// GUI reference variables needing class scope
	JPanel boatPanel;
	CardLayout boatLayout;
	JTextField manufacturerText, boatLengthText, yearText, stateRegistrationText;
	JTextField numberOfSailsText, keelDepthText, numberOfEnginesText;
	JRadioButton sailboatRadioButton, powerboatRadioButton;
	JRadioButton noEngineRadioButton, inboardEngineRadioButton, outboardEngineRadioButton;
	JRadioButton gasolineFuelRadioButton, dieselFuelRadioButton;
	JButton addButton, clearButton, closeButton;
	 	  
	public static void main(String args[])
	{	AddBoat frame = new AddBoat(); }
	// constructor
	public AddBoat()
	{	// create the panels
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(5,1));
		JPanel upperPanel = new JPanel(new GridLayout(2,4));
		JPanel centerPanel = new JPanel(new FlowLayout());
		JPanel sailboatPanel = new JPanel(new FlowLayout()); 
		JPanel powerboatPanel = new JPanel(new FlowLayout());
		JPanel lowerPanel = new JPanel(new FlowLayout());

		// CardLayout permits the dynamic change of panel contents
		boatLayout = new CardLayout();		
		boatPanel = new JPanel();
		boatPanel.setLayout(boatLayout);

		// create logo
		JLabel logoLabel = new JLabel(" ",SwingConstants.CENTER);
		logoLabel.setForeground(Color.red);
		logoLabel.setFont(new Font("TimesRoman", Font.ITALIC,36));
		logoLabel.setText("Bradshaw Marina");
		c.add(logoLabel); // add logo to the Frame

		// build upper panel
		manufacturerText = new JTextField(15);		
		boatLengthText= new JTextField(4);
		yearText = new JTextField(6);
		stateRegistrationText = new JTextField(15);
		upperPanel.add(new JLabel("Manufacturer: ", SwingConstants.RIGHT));
		upperPanel.add(manufacturerText);
		upperPanel.add(new JLabel("Length: ", SwingConstants.RIGHT));
		upperPanel.add(boatLengthText);
		upperPanel.add(new JLabel("Year: ", SwingConstants.RIGHT));
		upperPanel.add(yearText);
		upperPanel.add(new JLabel("State Registration No: ", SwingConstants.RIGHT));
		upperPanel.add(stateRegistrationText);	
		c.add(upperPanel); // add panel to the Frame

		// build center panel
		// create radio buttons for type of boat - sailboat is default
		sailboatRadioButton = new JRadioButton("Sailboat", true);
		powerboatRadioButton = new JRadioButton("Powerboat", false);
		
		// create a ButtonGroup for boat type buttons
		ButtonGroup typeOfBoat = new ButtonGroup();
		typeOfBoat.add(sailboatRadioButton);
		typeOfBoat.add(powerboatRadioButton);

		// add radio buttons to centerPanel
		centerPanel.add(sailboatRadioButton);
		centerPanel.add(powerboatRadioButton);				 
		c.add(centerPanel); // add center panel to the Frame
				 
		// build sail boat panel
		JPanel leftSailboatPanel = new JPanel(new GridLayout(2,1));
		JPanel rightSailboatPanel = new JPanel(new FlowLayout());
		numberOfSailsText = new JTextField(4);	
		keelDepthText = new JTextField(4);	
		noEngineRadioButton = new JRadioButton("No Engine", false);
		inboardEngineRadioButton = new JRadioButton("Inboard Engine", true);
		outboardEngineRadioButton = new JRadioButton("Outboard Engine", false);
		ButtonGroup sailboatEngineGroup = new ButtonGroup();
		sailboatEngineGroup.add(noEngineRadioButton);
		sailboatEngineGroup.add(inboardEngineRadioButton);
		sailboatEngineGroup.add(outboardEngineRadioButton);
		leftSailboatPanel.add(new JLabel("Number of Sails: "));
		leftSailboatPanel.add(numberOfSailsText);	
		leftSailboatPanel.add(new JLabel("Keel Depth: "));
		leftSailboatPanel.add(keelDepthText);	
		rightSailboatPanel.add(noEngineRadioButton);	
		rightSailboatPanel.add(inboardEngineRadioButton);	
		rightSailboatPanel.add(outboardEngineRadioButton);
		sailboatPanel.add(leftSailboatPanel);
		sailboatPanel.add(rightSailboatPanel);	
		// create border for the panel	
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

		// create and add Buttons for bottom panel
		addButton = new JButton("Add"); 
		clearButton = new JButton("Clear"); 
		closeButton = new JButton("Close"); 
		lowerPanel.add(addButton);
		lowerPanel.add(clearButton);
		lowerPanel.add(closeButton);
		c.add(lowerPanel); // add lower panel to the Frame		

		this.setSize(550,350);     
		this.setTitle("Add A Boat");
		this.setVisible(true);

		// register frame as listener for events
		addButton.addActionListener(this);
		clearButton.addActionListener(this);		
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
     		addBoat(); 
	  	if(e.getSource() == clearButton)
     		clearForm(); 
		if(e.getSource() == closeButton)
     	 	shutDown();
		if(e.getSource() == sailboatRadioButton)
     	 	boatLayout.first(boatPanel); // show sailboat panel	
      if(e.getSource() == powerboatRadioButton)
     	 	boatLayout.last(boatPanel);	// show powerboat panel 		      
   }
  	   
	private void addBoat()
	{
		try
		{
			double boatLength = Double.parseDouble(boatLengthText.getText());
			int year = Integer.parseInt(yearText.getText());
			String manufacturer = manufacturerText.getText();
			String stateRegistration = stateRegistrationText.getText();

			if (manufacturer.length() == 0 || stateRegistration.length() == 0)
	  			JOptionPane.showMessageDialog(this, "Please Enter All Data ");
			else
				{
					if(sailboatRadioButton.isSelected())
						addSailboat(stateRegistration,boatLength,manufacturer,year);
					else
						addPowerboat(stateRegistration,boatLength,manufacturer,year);			
				}
		}
		catch(NumberFormatException e)
			{JOptionPane.showMessageDialog(this, "length and year must be numeric");}					
	}

	private void addSailboat(String aStateRegistration,double aBoatLength,String aManufacturer,int aYear)
	{
		String motorType = "";
		try
		{
			int numberOfSails = Integer.parseInt(numberOfSailsText.getText());	
			double keelDepth = Double.parseDouble(keelDepthText.getText());
			if(noEngineRadioButton.isSelected())
				motorType = "none";
			if(inboardEngineRadioButton.isSelected())
				motorType = "inboard";
			if(outboardEngineRadioButton.isSelected())
				motorType = "outboard";
			Sailboat aSailboat = new Sailboat(aStateRegistration, aBoatLength, aManufacturer, aYear, keelDepth, numberOfSails, motorType);			
			JOptionPane.showMessageDialog(this,"Sailboat added");
			clearForm();
		}
		catch(NumberFormatException e)
			{JOptionPane.showMessageDialog(this, "number of sails & keel depth must be numeric ");}
	}
	private void addPowerboat(String aStateRegistration,double aBoatLength,String aManufacturer,int aYear)
	{
		try
		{
			int numberOfEngines = Integer.parseInt(numberOfEnginesText.getText());	
			String fuelType = "";
			if(gasolineFuelRadioButton.isSelected())
				fuelType = "gasoline";
			if(dieselFuelRadioButton.isSelected())
				fuelType = "diesel";
			Powerboat aPowerboat = new Powerboat(aStateRegistration, aBoatLength, aManufacturer, aYear,numberOfEngines, fuelType);			
			JOptionPane.showMessageDialog(this,"Powerboat added");
			clearForm();
		}
		catch(NumberFormatException e)
			{JOptionPane.showMessageDialog(this, "number of engines must be numeric "); }
	
	}

	private void clearForm()
	{
		manufacturerText.setText("");	
		boatLengthText.setText("");		
		yearText.setText("");
		stateRegistrationText.setText("");
		numberOfSailsText.setText("");
		keelDepthText.setText("");
		sailboatRadioButton.doClick();
		inboardEngineRadioButton.doClick();
		manufacturerText.requestFocus();
	}
	
 	public void shutDown()
	{  System.exit(0);  }
}