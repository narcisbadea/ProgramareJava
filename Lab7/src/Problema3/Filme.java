package Problema3;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Filme extends JFrame {

	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 463, 423);
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

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Film");
		model.addColumn("Actori");
		model.addColumn("An lansare");
		model.addColumn("Genuri");
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 271, 426, 102);
		contentPane.add(sp);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(181, 67, 56, 20);
		contentPane.add(spinner);
		spinner.setModel(new SpinnerNumberModel(2020, 2015, 2020, 1));

		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numeFilm = textField.getText(), numeActori = textField_1.getText(),
						anLansare = spinner.getValue().toString();
				String genuri = "";
				if (chckbxComedie.isSelected()) {
					genuri += chckbxComedie.getText() + " ";
				}
				if (chckbxDrama.isSelected()) {
					genuri += chckbxDrama.getText() + " ";
				}
				if (chckbxRomantic.isSelected()) {
					genuri += chckbxRomantic.getText() + " ";
				}
				if (chckbxIstoric.isSelected()) {
					genuri += chckbxIstoric.getText() + " ";
				}
				if (chckbxActiune.isSelected()) {
					genuri += chckbxActiune.getText() + " ";
				}
				model.addRow(new Object[] { numeFilm, numeActori, anLansare, genuri });
				

			}
		});
		btnNewButton.setBounds(37, 238, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sterge");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeRow(table.getSelectedRow());
			}
		});
		btnNewButton_1.setBounds(283, 237, 89, 23);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}
}
