// Chapter 10: Figure 10-3
// illustrate Frame with a button

import java.awt.*;
import java.awt.event.*;

public class AWTFrameWithAButton extends Frame implements ActionListener, WindowListener
{
	public static void main(String args[])
	{	// create instance of Frame 
		AWTFrameWithAButton frameWithButton = new AWTFrameWithAButton(); 
	}
	
	// constructor
	public AWTFrameWithAButton() 	
	{	// create instance of Button
		Button closeButton = new Button("Close"); 
		// BorderLayout is the default layout manager
		// place Button on Frame instance
      this.add(closeButton);
      // establish size, create title & make it visible 
		this.setSize(300,150);     
		this.setTitle("AWT Frame With A Button");
		this.setVisible(true);
		// register frame as listener for button event
		closeButton.addActionListener(this);
		// register frame as listener for frame event
		this.addWindowListener(this);

	}
   // actionPerformed is invoked when closeButton is clicked 
   public void actionPerformed(ActionEvent e)
		{ shutDown(); }
   
   //  The following 7 methods are required because we implemented WindowListener
	// windowClosing invoked when window closed
	public void windowClosing(WindowEvent event) 
		{ shutDown(); }
	
	public void windowClosed(WindowEvent event){}
	public void windowDeiconified(WindowEvent event){}
  	public void windowIconified(WindowEvent event){}
   public void windowActivated(WindowEvent event){}
  	public void windowDeactivated(WindowEvent event){}
  	public void windowOpened(WindowEvent event){}

	// terminate
  	public void shutDown()
	{
      this.dispose();
      System.exit(0);  	
   }
}
