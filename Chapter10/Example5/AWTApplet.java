// Chapter 10: Example 5
// illustrate AWT Applet

import java.awt.*;		 
import java.awt.event.*;  
import java.applet.*;

public class AWTApplet extends Applet implements ActionListener
{
	// Button & TextField reference variables need class scope
	Button displayButton, clearButton, closeButton;
	TextField messageTextField;

	// constructor
	public void init()
	{
		// create Button, Label and TextField instances
		displayButton = new Button("Display");
		clearButton = new Button("Clear");		
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
		// add panels to frame - frame default is BorderLayout
		this.add("North",upperPanel); 
		this.add("South",lowerPanel);
		// register frame as listener for button events
		displayButton.addActionListener(this);
		clearButton.addActionListener(this);		
	}

	// actionPerformed is invoked when a Button is clicked 
	public void actionPerformed(ActionEvent e)
	{	// see which button was clicked
		if(e.getSource() == displayButton)
			displayMessage();
		if(e.getSource() == clearButton)
			clearMessage(); 
	}
	public void displayMessage()
		{ messageTextField.setText("Hello World"); }
	public void clearMessage()
		{ messageTextField.setText("           "); }	
}