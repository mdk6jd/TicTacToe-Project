import java.awt.Color;

import javax.swing.*;

public class Test {

	public static void main(String[] args) {
		JFrame f = new JFrame();// creating instance of JFrame
		//JPanel panel1 = new JPanel();
		
		// creating instance of JButton
		JButton a1 = new JButton("click");
		// x axis, y axis, width, height
		a1.setBounds(100, 100, 100, 100);
		JButton a2 = new JButton("click");
		a2.setBounds(200, 100, 100, 100);
		JButton a3 = new JButton("click");
		a3.setBounds(300, 100, 100, 100);
		JButton b1 = new JButton("click");
		b1.setBounds(100, 200, 100, 100);
		JButton b2 = new JButton("click");
		b2.setBounds(200, 200, 100, 100);
		JButton b3 = new JButton("click");
		b3.setBounds(300, 200, 100, 100);
		JButton c1 = new JButton("click");
		c1.setBounds(100, 300, 100, 100);
		JButton c2 = new JButton("click");
		c2.setBounds(200, 300, 100, 100);
		JButton c3 = new JButton("click");
		c3.setBounds(300, 300, 100, 100);
		
		// adding button in JFrame
		f.add(a1);
		f.add(a2);
		f.add(a3);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(c1);
		f.add(c2);
		f.add(c3);

		f.setSize(500, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
		
	}
}