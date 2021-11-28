package Problema1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtId;
	private JTextField txtNume;
	private JTextField txtVarsta;
	private JTextField txtAfis;

	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnFind;
	private JButton btnSave;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnFirst;
	private JButton btnUndo;

	private JLabel lblId;

	private JToolBar myBar;

	private ResultSet rs;
	private boolean editMode = false;
	private boolean insertMode = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainApp() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = sql.executeQuery("select * from persoane");

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					rs.close();
					con.close();
					sql.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		myBar = new JToolBar();
		contentPane.add(myBar, BorderLayout.NORTH);

		lblId = new JLabel("Id");

		btnFirst = new JButton();
		btnFirst.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MoveFirst.png")));
		myBar.add(btnFirst);

		btnPrevious = new JButton();
		btnPrevious.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MovePrevious.png")));
		myBar.add(btnPrevious);

		txtAfis = new JTextField();
		txtAfis.setHorizontalAlignment(JTextField.CENTER);
		myBar.add(txtAfis);

		btnNext = new JButton();
		btnNext.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MoveNext.png")));
		myBar.add(btnNext);

		btnLast = new JButton();
		btnLast.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MoveLast.png")));
		myBar.add(btnLast);

		btnAdd = new JButton();
		btnAdd.setIcon(new ImageIcon(MainApp.class.getResource("/Images/Add.png")));
		myBar.add(btnAdd);

		btnEdit = new JButton();
		btnEdit.setIcon(new ImageIcon(MainApp.class.getResource("/Images/Edit.png")));
		myBar.add(btnEdit);

		btnDelete = new JButton();
		btnDelete.setIcon(new ImageIcon(MainApp.class.getResource("/Images/Delete.png")));
		myBar.add(btnDelete);

		btnFind = new JButton();
		btnFind.setIcon(new ImageIcon(MainApp.class.getResource("/Images/find.JPG")));
		myBar.add(btnFind);

		btnSave = new JButton();
		btnSave.setIcon(new ImageIcon(MainApp.class.getResource("/Images/save.JPG")));
		myBar.add(btnSave);

		btnUndo = new JButton();
		btnUndo.setIcon(new ImageIcon(MainApp.class.getResource("/Images/undo.JPG")));
		myBar.add(btnUndo);

		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (editMode || insertMode) {
						disableEdit();
						if (insertMode) {

							rs.first();
							updateFields();

						}
						insertMode = false;
						editMode = false;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String wanted = JOptionPane.showInputDialog("Numele: ");
				try {
					while (!rs.first()) {
						rs.previous();
					}
					while (!rs.getString(2).equals(wanted)) {
						rs.next();
					}
					btnPrevious.setEnabled(rs.getRow() > 1);
					btnFirst.setEnabled(rs.getRow() > 1);
					btnLast.setEnabled(rs.getRow() < sizeOfTable("persoane"));
					btnNext.setEnabled(rs.getRow() < sizeOfTable("persoane"));

					updateFields();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					updateFields();
					btnNext.setEnabled(true);
					btnLast.setEnabled(true);
					if (rs.getRow() == 1) {
						btnFirst.setEnabled(false);
						btnPrevious.setEnabled(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.getRow() > 1) {
						rs.previous();
						updateFields();
						btnNext.setEnabled(true);
						btnLast.setEnabled(true);
						if (rs.getRow() == 1) {
							btnFirst.setEnabled(false);
							btnPrevious.setEnabled(false);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (rs.getRow() < sizeOfTable("persoane")) {
						rs.next();
						updateFields();
						btnFirst.setEnabled(true);
						btnPrevious.setEnabled(true);
						if (rs.getRow() == sizeOfTable("persoane")) {
							btnNext.setEnabled(false);
							btnLast.setEnabled(false);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.last();
					updateFields();
					btnFirst.setEnabled(true);
					btnPrevious.setEnabled(true);
					if (rs.getRow() == sizeOfTable("persoane")) {
						btnNext.setEnabled(false);
						btnLast.setEnabled(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMode = true;
				try {
					addRegister();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				enableEdit();
			}
		});

		;

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = JOptionPane.showConfirmDialog(null, "Sunteti sigur?");
					if (a == JOptionPane.YES_OPTION) {
						rs.deleteRow();
						updateFields();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editMode || insertMode) {
					try {
						rs.updateString(2, txtNume.getText());
						rs.updateInt(3, Integer.parseInt(txtVarsta.getText()));
						if (insertMode) {
							rs.insertRow();
							insertMode = false;
							txtId.setVisible(true);
							lblId.setVisible(true);
							rs.last();
							updateFields();
						}

						if (editMode) {
							rs.updateRow();
							updateFields();
							editMode = false;
						}
						disableEdit();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editMode = true;
				enableEdit();
			}
		});

		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelLeft = new JPanel();
		panelCenter.add(panelLeft);
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		panelLeft.add(Box.createVerticalStrut(10));

		panelLeft.add(lblId);
		panelLeft.add(Box.createVerticalStrut(7));

		JLabel lblNume = new JLabel("Nume");
		panelLeft.add(lblNume);
		panelLeft.add(Box.createVerticalStrut(7));

		JLabel lblVarsta = new JLabel("Varsta");
		panelLeft.add(lblVarsta);

		JPanel panelRight = new JPanel();
		panelCenter.add(panelRight);
		panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
		panelRight.add(Box.createVerticalStrut(10));

		txtId = new JTextField();
		panelRight.add(txtId);
		txtId.setColumns(10);
		panelRight.add(Box.createVerticalStrut(4));

		txtNume = new JTextField();
		panelRight.add(txtNume);
		txtNume.setColumns(10);
		panelRight.add(Box.createVerticalStrut(4));

		txtVarsta = new JTextField();
		panelRight.add(txtVarsta);
		txtVarsta.setColumns(10);
		initTxtFields();

		btnFirst.setEnabled(false);
		btnPrevious.setEnabled(false);
		txtAfis.setEditable(false);
		txtId.setEditable(false);
		txtNume.setEditable(false);
		txtVarsta.setEditable(false);

	}

	private void addRegister() throws SQLException {
		rs.moveToInsertRow();
		txtNume.setEditable(true);
		txtVarsta.setEditable(true);
		updateFields();

	}

	private int sizeOfTable(String table) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement sql = con.createStatement();
		ResultSet count = sql.executeQuery("SELECT COUNT(*) FROM " + table);
		count.next();
		int size = count.getInt(1);
		sql.close();
		count.close();
		con.close();
		return size;
	}

	private void updateFields() throws SQLException {
		txtId.setText(String.valueOf(rs.getInt(1)));
		txtNume.setText(rs.getString(2));
		txtVarsta.setText(String.valueOf(rs.getInt(3)));
		int size = sizeOfTable("persoane");
		int curentRow = rs.getRow();
		txtAfis.setText(String.valueOf(curentRow) + "/" + String.valueOf(size));
	}

	private void initTxtFields() throws SQLException {
		rs.next();
		updateFields();
	}

	private void enableEdit() {
		txtId.setVisible(false);
		lblId.setVisible(false);
		txtNume.setEditable(true);
		txtVarsta.setEditable(true);
		btnFirst.setEnabled(false);
		btnPrevious.setEnabled(false);
		btnNext.setEnabled(false);
		btnLast.setEnabled(false);
		btnAdd.setEnabled(false);
		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);
		btnFind.setEnabled(false);
	}

	private void disableEdit() throws SQLException {
		txtId.setVisible(true);
		lblId.setVisible(true);
		txtNume.setEditable(false);
		txtVarsta.setEditable(false);
		if (rs.getRow() != 1) {
			btnFirst.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		if (rs.getRow() != sizeOfTable("persoane")) {
			btnNext.setEnabled(true);
			btnLast.setEnabled(true);
		}
		btnAdd.setEnabled(true);
		btnEdit.setEnabled(true);
		btnDelete.setEnabled(true);
		btnFind.setEnabled(true);
	}

}
