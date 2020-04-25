// Chapter 10: Example 7
// illustrate Swing menus

import java.awt.*;		 
import javax.swing.*;		 
import java.awt.event.*; 

public class SwingFrameWithMenus extends JFrame implements ActionListener
{
	// The GUI reference variables need class scope
	JTextField messageTextField;
	JMenuItem displayMenu, clearMenu, closeMenu;
	  
	public static void main(String args[])
	{
		// create instance of Frame
		SwingFrameWithMenus frame = new SwingFrameWithMenus(); 
	}
	// constructor
	public SwingFrameWithMenus()
	{
		// create menu bar, menus, & menu items
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		displayMenu = new JMenuItem("Display");
		clearMenu = new JMenuItem("Clear");
		closeMenu = new JMenuItem("Close");
		
		fileMenu.setMnemonic('F'); 
		helpMenu.setMnemonic('H');
	
		this.setJMenuBar(menuBar);	// add bar to frame
		menuBar.add(fileMenu);  	// add menus to bar
		menuBar.add(helpMenu);
		fileMenu.add(displayMenu); // add menu items to menus
		fileMenu.add(clearMenu);
		fileMenu.add(closeMenu);
	
		// create instances of Label and TextField
		JLabel messageLabel = new JLabel("Message:");
		messageTextField = new JTextField(15);
		// add label & textfield to upper panel
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(messageLabel);
		c.add(messageTextField);
		// register frame as listener for menu events
		displayMenu.addActionListener(this);
		clearMenu.addActionListener(this);
		closeMenu.addActionListener(this);
		this.setSize(320,150);     
		this.setTitle("Swing Frame with Menus");
		this.setVisible(true);
		 
		// register frame as listener for window event
		// create anonymous inner class to handle window closing event
		this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent event) 
					{shutDown();}
			}	  
		);
   }
	// actionPerformed is invoked when a menu item is clicked 
	public void actionPerformed(ActionEvent e)
	{	// see which menu item was clicked
		if(e.getSource() == displayMenu)
			displayMessage();
	  	if(e.getSource() == clearMenu)
     		clearMessage(); 
	  	if(e.getSource() == closeMenu)
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
