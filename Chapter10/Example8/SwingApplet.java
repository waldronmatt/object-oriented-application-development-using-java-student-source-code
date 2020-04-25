// Chapter 10: Example 8
// illustrate Swing Applet

import java.awt.*;		 
import javax.swing.*;		 
import java.awt.event.*; 

public class SwingApplet extends JApplet implements ActionListener
{
	// The GUI reference variables need class scope
	JTextField messageTextField;
	JMenuItem displayMenu, clearMenu;
	  
	public void init()
	{
		// create menu bar, menus, & menu items
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		displayMenu = new JMenuItem("Display");
		clearMenu = new JMenuItem("Clear");
			
		fileMenu.setMnemonic('F'); 
		helpMenu.setMnemonic('H');
	
		this.setJMenuBar(menuBar);	// add bar to frame
		menuBar.add(fileMenu);  	// add menus to bar
		menuBar.add(helpMenu);
		fileMenu.add(displayMenu); // add menu items to menus
		fileMenu.add(clearMenu);
		
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
   }
	// actionPerformed is invoked when a menu item is clicked 
	public void actionPerformed(ActionEvent e)
	{	// see which menu item was clicked
		if(e.getSource() == displayMenu)
			displayMessage();
	  	if(e.getSource() == clearMenu)
     		clearMessage(); 
	}

	public void displayMessage()
		{ messageTextField.setText("Hello World"); }
	public void clearMessage()
		{ messageTextField.setText("           "); }	
}
