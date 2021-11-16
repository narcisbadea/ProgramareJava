package Problema1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldOperator1;
	private JTextField textFieldOperator2;
	private JLabel lblResult = new JLabel("",SwingConstants.CENTER);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Operand1");
		lblNewLabel.setBounds(29, 17, 74, 14);
		contentPane.add(lblNewLabel);

		JLabel lblOperand = new JLabel("Operand2");
		lblOperand.setBounds(29, 48, 74, 14);
		contentPane.add(lblOperand);

		textFieldOperator1 = new JTextField();
		textFieldOperator1.setBounds(145, 14, 86, 20);
		contentPane.add(textFieldOperator1);
		textFieldOperator1.setColumns(10);

		textFieldOperator2 = new JTextField();
		textFieldOperator2.setBounds(145, 45, 86, 20);
		contentPane.add(textFieldOperator2);
		textFieldOperator2.setColumns(10);

		JButton btnAdunare = new JButton("Adunare");
		btnAdunare.setBounds(29, 86, 89, 23);
		btnAdunare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int operator1 = 0, operator2 = 0;
				operator1 = Integer.parseInt(textFieldOperator1.getText());
				operator2 = Integer.parseInt(textFieldOperator2.getText());
				lblResult.setText(String.valueOf(operator1 + operator2));

			}
		});
		contentPane.add(btnAdunare);

		JButton btnScadere = new JButton("Scadere");
		btnScadere.setBounds(142, 86, 89, 23);
		btnScadere.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int operator1 = 0, operator2 = 0;
				operator1 = Integer.parseInt(textFieldOperator1.getText());
				operator2 = Integer.parseInt(textFieldOperator2.getText());
				lblResult.setText(String.valueOf(operator1 - operator2));

			}
		});
		contentPane.add(btnScadere);

		JButton btnImpartire = new JButton("Impartire");
		btnImpartire.setBounds(142, 114, 89, 23);
		btnImpartire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int operator1 = 0, operator2 = 0;
				operator1 = Integer.parseInt(textFieldOperator1.getText());
				operator2 = Integer.parseInt(textFieldOperator2.getText());
				lblResult.setText(String.valueOf(operator1 / operator2));

			}
		});
		contentPane.add(btnImpartire);

		JButton btnInmultire = new JButton("Inmultire");
		btnInmultire.setBounds(29, 114, 89, 23);
		btnInmultire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int operator1 = 0, operator2 = 0;
				operator1 = Integer.parseInt(textFieldOperator1.getText());
				operator2 = Integer.parseInt(textFieldOperator2.getText());
				lblResult.setText(String.valueOf(operator1 * operator2));

			}
		});
		contentPane.add(btnInmultire);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(29, 176, 202, 23);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldOperator1.setText("");
				textFieldOperator2.setText("");
				lblResult.setText("");

			}
		});
		contentPane.add(btnClear);

		lblResult.setBounds(29, 151, 202, 23);
		lblResult.setBackground(Color.WHITE);
		lblResult.setOpaque(true);
		contentPane.add(lblResult);
	}
}
