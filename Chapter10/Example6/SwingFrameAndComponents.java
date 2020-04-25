// Chapter 10: Example 6
// illustrate Swing components 

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  

public class SwingFrameAndComponents extends JFrame implements ActionListener
{
	// Button & TextField reference variables need class scope
	JButton displayButton, clearButton, closeButton;
	JTextField messageTextField;

	public static void main(String args[])
	{
		// create instance of SwingFrameAndComponents
		SwingFrameAndComponents frameAndCompnents = new SwingFrameAndComponents(); 	
	}
	// constructor
	public SwingFrameAndComponents()
	{
		// create Button, Label and TextField instances
		displayButton = new JButton("Display");
		clearButton = new JButton("Clear");		
		closeButton = new JButton("Close"); 
		JLabel messageLabel = new JLabel("Message:");
		messageTextField = new JTextField(15);
		// create two Panels - default FlowLayout manager
		JPanel upperPanel = new JPanel();
		JPanel lowerPanel = new JPanel();
		// add label & textfield to upper panel
		upperPanel.add(messageLabel);
		upperPanel.add(messageTextField);
		// add buttons to lower panel
		lowerPanel.add(displayButton);
		lowerPanel.add(clearButton);
		lowerPanel.add(closeButton);
		// add panels to frame - frame default is BorderLayout
		Container c = this.getContentPane();
		c.add("North",upperPanel); 
		c.add("South",lowerPanel);
		// register frame as listener for button events
		displayButton.addActionListener(this);
		clearButton.addActionListener(this);		
		closeButton.addActionListener(this);	
		this.setSize(320,150);     
		this.setTitle("Swing Frame and Components");
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