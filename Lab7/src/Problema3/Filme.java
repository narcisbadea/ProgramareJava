package Problema3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txtFilm;
	private JTextField txtActori;
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
		setBounds(100, 100, 463, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Film");
		lblNewLabel.setBounds(54, 21, 23, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Actor");
		lblNewLabel_1.setBounds(54, 46, 45, 14);
		contentPane.add(lblNewLabel_1);

		txtFilm = new JTextField();
		txtFilm.setBounds(147, 21, 242, 20);
		contentPane.add(txtFilm);
		txtFilm.setColumns(10);

		txtActori = new JTextField();
		txtActori.setBounds(147, 43, 242, 20);
		contentPane.add(txtActori);
		txtActori.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("An lansare");
		lblNewLabel_2.setBounds(54, 68, 56, 14);
		contentPane.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Genuri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(54, 93, 335, 77);
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
		sp.setBounds(10, 208, 426, 102);
		contentPane.add(sp);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(240, 65, 56, 20);
		contentPane.add(spinner);
		spinner.setModel(new SpinnerNumberModel(2020, 2015, 2020, 1));

		JButton btnAdaugare = new JButton("Adauga");
		btnAdaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtFilm.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Numele filmului lipseste!");
				} else {
					if (txtActori.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Numele actorilor lipsesc!");
					} else {
						String numeFilm = txtFilm.getText(), numeActori = txtActori.getText(),
								anLansare = spinner.getValue().toString(), genuri = "";
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
						if (genuri.isBlank()) {
							JOptionPane.showMessageDialog(null, "Genul filmului lipseste!");
						} else {
							model.addRow(new Object[] { numeFilm, numeActori, anLansare, genuri });
						}
					}
				}

			}
		});
		btnAdaugare.setBounds(10, 177, 89, 23);
		contentPane.add(btnAdaugare);

		JButton btnStergere = new JButton("Sterge");
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Nu ati selectat niciun film!");
				} else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnStergere.setBounds(347, 177, 89, 23);
		contentPane.add(btnStergere);
		setVisible(true);
	}
}
