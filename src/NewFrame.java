import javax.swing.JFrame;

class NewFrame extends JFrame {

  public NewFrame ()
  {
    // Set the title and other parameters. 
    this.setTitle ("Some Geometric Figures");
    this.setResizable (true);
    this.setSize (500, 350); // Can adjust the size of the frame here

    // Create and add the panel. 
    NewPanel panel = new NewPanel ();
    this.getContentPane().add (panel); 	// The content of the frame is the panel (NewPanel)
    									// with all the shapes that have been drawn

    // Show the frame. 
    this.setVisible (true);
  }
  
}