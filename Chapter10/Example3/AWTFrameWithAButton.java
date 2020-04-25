// Chapter 10: Example 3
// illustrate event handling using an anonymous inner class

import java.awt.*;
import java.awt.event.*;
public class AWTFrameWithAButton extends Frame implements ActionListener
{
	public static void main(String args[])
	{	// create instance of Frame 
		AWTFrameWithAButton frameWithButton = new AWTFrameWithAButton(); 
	}
	
	// constructor
	public AWTFrameWithAButton() 	
	{	// create instance of Button
		Button closeButton = new Button("Close"); 
		// set FlowLayout as the layout manager
		this.setLayout(new FlowLayout());
		// place Button on Frame instance
      this.add(closeButton);
      // establish size, create title & make it visible 
		this.setSize(300,150);     
		this.setTitle("AWT Frame With A Button");
		this.setVisible(true);
		// register frame as listener for button event
		closeButton.addActionListener(this);
   
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

   // actionPerformed is invoked when closeButton is clicked 
   public void actionPerformed(ActionEvent e)
		{ shutDown(); }
     
	public void shutDown()
	{
      this.dispose();
      System.exit(0);  // terminate
	}
}
