// Chapter 10: Example 4
// illustrate multiple AWT components
 
import java.awt.*;		 
import java.awt.event.*;  

public class AWTFrameAndComponents extends Frame implements ActionListener
{
	// Button & TextField reference variables need class scope
	Button displayButton, clearButton, closeButton;
	TextField messageTextField;

	public static void main(String args[])
	{	// create instance of AWTFrameAndComponents
		AWTFrameAndComponents frameAndCompnents = new AWTFrameAndComponents(); 	
	}

	// constructor
	public AWTFrameAndComponents()
	{	// create Button, Label and TextField instances
		displayButton = new Button("Display");
		clearButton = new Button("Clear");		
		closeButton = new Button("Close"); 
		Label messageLabel = new Label("Message:");
		messageTextField = new TextField(15);
		// create two Panels - default FlowLayout manager
		Panel upperPanel = new Panel();
		Panel lowerPanel = new Panel();
		// add label & textfield to upper panel
		upperPanel.add(messageLabel);
		upperPanel.add(messageTextField);
		// add buttons to lower panel
		lowerPanel.add(displayButton);
		lowerPanel.add(clearButton);
		lowerPanel.add(closeButton);
		// add panels to frame - frame default is BorderLayout
		this.add("North",upperPanel); 
		this.add("South",lowerPanel);
		// register frame as event listener with all buttons
		displayButton.addActionListener(this);
		clearButton.addActionListener(this);		
		closeButton.addActionListener(this);	
		this.setSize(320,150);     
		this.setTitle("AWT Frame and Components");
		this.setVisible(true);

		// create anonymous inner class to handle window closing event
		// register the inner class as a listener with the frame
		this.addWindowListener
		(  // begin inner class definition
			new WindowAdapter() // superclass of inner class is WindowAdapter
			{ 
				public void windowClosing(WindowEvent event) 
  	 				{shutDown();} // invoke shutDown in outer class
			}// end of inner class definition	  
		 ); // end of argument sent to addWindowListener method	 
	}

	// actionPerformed is invoked when a Button is clicked 
	public void actionPerformed(ActionEvent e)
	{	// see which button was clicked
		if(e.getSource() == displayButton)
			displayMessage();
		if(e.getSource() == clearButton)
			clearMessage(); 
		if(e.getSource() == closeButton)
			shutDown();     
	}
	public void displayMessage()
		{ messageTextField.setText("Hello World"); }
	public void clearMessage()
		{ messageTextField.setText("           "); }	
	public void shutDown()
		{
			this.dispose();
			System.exit(0);  // terminate
		}
}