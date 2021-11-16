package Problema3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class Filme extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filme frame = new Filme();
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
	public Filme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Film");
		lblNewLabel.setBounds(62, 11, 34, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Actor");
		lblNewLabel_1.setBounds(62, 36, 34, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(130, 11, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(130, 36, 158, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("An lansare");
		lblNewLabel_2.setBounds(62, 64, 69, 14);
		contentPane.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Genuri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(37, 89, 335, 138);
		contentPane.add(panel);
		panel.setLayout(null);

		JCheckBox chckbxComedie = new JCheckBox("comedie");
		chckbxComedie.setBounds(17, 21, 97, 23);
		panel.add(chckbxComedie);

		JCheckBox chckbxDrama = new JCheckBox("drama");
		chckbxDrama.setBounds(138, 21, 97, 23);
		panel.add(chckbxDrama);

		JCheckBox chckbxRomantic = new JCheckBox("romantic");
		chckbxRomantic.setBounds(248, 21, 81, 23);
		panel.add(chckbxRomantic);

		JCheckBox chckbxIstoric = new JCheckBox("istoric");
		chckbxIstoric.setBounds(65, 47, 97, 23);
		panel.add(chckbxIstoric);

		JCheckBox chckbxActiune = new JCheckBox("actiune");
		chckbxActiune.setBounds(182, 47, 97, 23);
		panel.add(chckbxActiune);

		String[][] date = { { "Film1", "Actor1, Actor2", "2015", "comedie, actiune" }, };
		String[] coloane = { "Film", "Actori", "An lansare", "Genuri" };
		table = new JTable(date, coloane);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 238, 426, 102);
		contentPane.add(sp);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(181, 67, 56, 20);
		contentPane.add(spinner);
		spinner.setModel(new SpinnerNumberModel(2020, 2015, 2020, 1));
		setVisible(true);
	}
}
