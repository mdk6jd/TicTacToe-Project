import java.awt.*;
import javax.swing.*;

// Extend JPanel to override its paintComponent() method: 

class NewPanel extends JPanel {

  // Set background in constructor: 
  public NewPanel () 
  {
    this.setBackground (Color.cyan); // Setting the background color
  }
  

  // Override paintComponent().
  // To override means we have to inherit from JPanel
  // This is why NewPanel extends JPanel

  public void paintComponent (Graphics g)
  {
    // Always call super.paintComponent (g): 
    super.paintComponent(g);

    // drawString(), drawRect(), drawOval(), etc are 'Graphics' methods 

    // Draw a...
    
    // Square: 
    g.drawRect (50,50,50,50);
    g.drawString ("Square", 55, 115);

    // Circle: 
    g.drawOval (200,50,50,50);
    g.drawString ("Circle", 209, 115);

    // Rounded rectangle: 
    g.drawRoundRect (350,50,75,50,20,20);
    g.drawString ("Rectangle", 359, 115);

    // Draw a line across the middle: 
    g.drawLine (0,150,500,150);

    // Now draw some filled shapes: 

    // Square: 
    g.fillRect (50,200,50,50);
    g.drawString ("Square", 55, 265);

    // Circle: 
    g.fillOval (200,200,50,50);
    g.drawString ("Circle", 209, 265);

    // Rounded rectangle: 
    g.fillRoundRect (350,200,75,50,20,20);
    g.drawString ("Rectangle", 359, 265);    
    
    
  }

}