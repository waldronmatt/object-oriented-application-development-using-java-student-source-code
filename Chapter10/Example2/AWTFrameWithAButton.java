// Chapter 10: Example 2
// illustrate event handling using an adapter class

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
   
		// create instance of WindowCloser 
		WindowCloser eventHandler = new WindowCloser(this);

		// register WindowCloser as listener for frame event
		this.addWindowListener(eventHandler);
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

// WindowCloser is a subclass of WindowAdapter
class WindowCloser extends WindowAdapter
{
	AWTFrameWithAButton frameToClose;
	// constructor populates reference to frame instance
	public WindowCloser(AWTFrameWithAButton frame)
	{ frameToClose = frame;}

	// windowClosing is invoked when window closed
	// this method overrides windowClosing in WindowAdapter
	public void windowClosing(WindowEvent event) 
	{ frameToClose.shutDown();	}
}

