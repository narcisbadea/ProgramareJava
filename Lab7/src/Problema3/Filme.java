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
	private JTable tableFilme;

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
		setTitle("Filme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 395);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(96, 24, 68, 14);
		contentPane.add(lblFilm);

		JLabel lblActor = new JLabel("Actor");
		lblActor.setBounds(96, 49, 68, 14);
		contentPane.add(lblActor);

		txtFilm = new JTextField();
		txtFilm.setBounds(161, 18, 242, 20);
		contentPane.add(txtFilm);
		txtFilm.setColumns(10);

		txtActori = new JTextField();
		txtActori.setBounds(161, 43, 242, 20);
		contentPane.add(txtActori);
		txtActori.setColumns(10);

		JLabel lblAnLAnsare = new JLabel("An lansare");
		lblAnLAnsare.setBounds(115, 68, 78, 14);
		contentPane.add(lblAnLAnsare);

		JPanel panelGenuri = new JPanel();
		panelGenuri.setBorder(new TitledBorder(null, "Genuri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGenuri.setToolTipText("");
		panelGenuri.setBounds(115, 93, 335, 77);
		contentPane.add(panelGenuri);
		panelGenuri.setLayout(null);

		JCheckBox chckbxComedie = new JCheckBox("comedie");
		chckbxComedie.setBounds(17, 21, 97, 23);
		panelGenuri.add(chckbxComedie);

		JCheckBox chckbxDrama = new JCheckBox("drama");
		chckbxDrama.setBounds(138, 21, 97, 23);
		panelGenuri.add(chckbxDrama);

		JCheckBox chckbxRomantic = new JCheckBox("romantic");
		chckbxRomantic.setBounds(248, 21, 81, 23);
		panelGenuri.add(chckbxRomantic);

		JCheckBox chckbxIstoric = new JCheckBox("istoric");
		chckbxIstoric.setBounds(65, 47, 97, 23);
		panelGenuri.add(chckbxIstoric);

		JCheckBox chckbxActiune = new JCheckBox("actiune");
		chckbxActiune.setBounds(182, 47, 97, 23);
		panelGenuri.add(chckbxActiune);

		DefaultTableModel modelTableFilme = new DefaultTableModel();
		tableFilme = new JTable(modelTableFilme);
		modelTableFilme.addColumn("Film");
		modelTableFilme.addColumn("Actori");
		modelTableFilme.addColumn("An lansare");
		modelTableFilme.addColumn("Genuri");
		JScrollPane sp = new JScrollPane(tableFilme);
		sp.setBounds(10, 208, 553, 137);
		contentPane.add(sp);

		JSpinner spnAnLansare = new JSpinner();
		spnAnLansare.setBounds(254, 65, 56, 20);
		contentPane.add(spnAnLansare);
		spnAnLansare.setModel(new SpinnerNumberModel(2020, 2015, 2020, 1));

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
								anLansare = spnAnLansare.getValue().toString(), genuri = "";
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
							modelTableFilme.addRow(new Object[] { numeFilm, numeActori, anLansare, genuri });
						}
					}
				}

			}
		});
		btnAdaugare.setBounds(115, 174, 89, 23);
		contentPane.add(btnAdaugare);

		JButton btnStergere = new JButton("Sterge");
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableFilme.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Nu ati selectat niciun film!");
				} else {
					modelTableFilme.removeRow(tableFilme.getSelectedRow());
				}
			}
		});
		btnStergere.setBounds(361, 174, 89, 23);
		contentPane.add(btnStergere);
		setVisible(true);
	}
}
