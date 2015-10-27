// CS2110:  Simple Calculator App (with GUI) - It is a simple accumulator.
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CalcGuiOK {

	private JFrame frame;
	private JTextField inputTextField;
	private JTextField memoryTextField;
	
	private CalcAppOK theApp;
	private JButton btnClear;
	private JLabel statusLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcGuiOK window = new CalcGuiOK();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcGuiOK() {
		theApp = new CalcAppOK(this);
		initialize();
		theApp.doAfterGuiCreated();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setBounds(21, 18, 61, 16);
		frame.getContentPane().add(lblInput);
		
		inputTextField = new JTextField();
		inputTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAdd();
			}
		});
		inputTextField.setBounds(81, 12, 134, 28);
		frame.getContentPane().add(inputTextField);
		inputTextField.setColumns(10);
		
		JLabel lblMemory = new JLabel("Memory:");
		lblMemory.setBounds(21, 59, 61, 16);
		frame.getContentPane().add(lblMemory);
		
		memoryTextField = new JTextField();
		memoryTextField.setText("0.0");
		memoryTextField.setEditable(false);
		memoryTextField.setBounds(91, 53, 134, 28);
		frame.getContentPane().add(memoryTextField);
		memoryTextField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAdd();
			}
		});
		btnAdd.setBounds(240, 13, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theApp.clearMemory();
				//memoryTextField.setText("0.0");
				memoryTextField.setText( "" + theApp.getMemory() );
				inputTextField.setText("");
				statusLabel.setText("");
				frame.repaint(); //Reset all text fields and labels
			}
		});
		btnClear.setBounds(237, 54, 117, 29);
		frame.getContentPane().add(btnClear);
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(21, 104, 333, 16);
		frame.getContentPane().add(statusLabel);
	}

	protected void handleAdd() {
		String inputStr = inputTextField.getText();
		double inputVal = 0;
		try {
			inputVal = Double.parseDouble(inputStr);
		}
		catch (Exception e) {
			statusLabel.setText("Bad input! You typed: " + inputStr);
			inputTextField.setText("");
			frame.repaint();
			return;
		}
		theApp.addToMemory(inputVal);
		double newMem = theApp.getMemory();
		memoryTextField.setText("" + newMem);
		inputTextField.setText("");
		statusLabel.setText("");
		frame.repaint();	
	}

	public void welcomeMsg() {
		statusLabel.setText("Welcome to the Simple Calculator!");
	}

}