// CS2110:  Simple Calculator App (no GUI)
// This class is a simple accumulator -- you can add a value
// which is stored into memory.  You can clear memory.
// This class does not have a GUI -- you can run this from main() in this class.
// But a GUI class can be linked to this to give a GUI interface to this app.
// Note that we could use JUnit to test this class (without going through the GUI).

import java.util.Scanner;

public class CalcAppOK {
	private double memory;
	private CalcGuiOK theGui;

	public CalcAppOK() {
		this(null); // call other constructor
	}
	
	public CalcAppOK(CalcGuiOK g) {
		this.theGui = g;
		memory = 0.0;
		// we'd like to ask the GUI to do something at the start, but the Swing objects are not yet defined!
		// theGui.welcomeMsg();
	}
	
	// a method for the GUI object to call after the GUI has been created
	public void doAfterGuiCreated() {
		if (theGui != null) {
			theGui.welcomeMsg();		
		}
	}

	
	public void addToMemory(double inputVal) {
		memory = memory + inputVal;
	}
	
	public void clearMemory() {
		memory = 0.0;
	}
	
	public double getMemory() {
		return memory;
	}
	public void setMemory(double memory) {
		this.memory = memory;
	}

	public static void main ( String[] args ) {
		Scanner stdin = new Scanner(System.in);
		CalcAppOK theApp = new CalcAppOK();
		System.out.println("Welcome to the calculator!  Commands are add, clear or exit");
		System.out.print("Enter command [add, clear or exit]: ");
		while ( stdin.hasNext() ) {
			String input = stdin.next();
			if ( input.equalsIgnoreCase("add")) {
				System.out.print("Enter amount: ");
				theApp.addToMemory( Double.parseDouble(stdin.next()));
				System.out.println("Memory contains: " + theApp.getMemory() );
			}
			else if (input.equalsIgnoreCase("clear")) {
				theApp.clearMemory();
				System.out.println("Memory Clear!");
				System.out.println("Memory contains: " + theApp.getMemory() );
			}
			else if ( input.equalsIgnoreCase("exit") ) {
				System.out.println("Exiting!");
				System.exit(0);
			}
			System.out.print("Enter command [Commands are add, clear or exit]: ");
		}
	}
}