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

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection con;
	private JTextField txtId;
	private JTextField txtNume;
	private JTextField txtVarsta;
	JTextField txtAfis;
	private ResultSet rs;

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
		String url = "jdbc:mysql://localhost:3306/test";
		con = DriverManager.getConnection(url, "root", "");
		Statement sql;
		sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JToolBar myBar = new JToolBar();
		contentPane.add(myBar, BorderLayout.NORTH);

		JButton btnFirst = new JButton();
		JButton btnPrevious = new JButton();
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.getRow() > 1) {
						rs.previous();
						updateFields();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrevious.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MovePrevious.png")));
		JButton btnNext = new JButton();
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (rs.getRow() < sizeOfTable("persoane")) {
						rs.next();
						updateFields();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		JButton btnLast = new JButton();
		JButton btnAdd = new JButton();
		JButton btnEdit = new JButton();
		JButton btnDelete = new JButton();
		JButton btnFind = new JButton();
		JButton btnSave = new JButton();
		JButton btnUndo = new JButton();
		txtAfis = new JTextField();
		txtAfis.setHorizontalAlignment(JTextField.CENTER);

		btnFirst.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MoveFirst.png")));
		btnNext.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MoveNext.png")));
		btnLast.setIcon(new ImageIcon(MainApp.class.getResource("/Images/MoveLast.png")));
		btnAdd.setIcon(new ImageIcon(MainApp.class.getResource("/Images/Add.png")));
		btnEdit.setIcon(new ImageIcon(MainApp.class.getResource("/Images/Edit.png")));
		btnDelete.setIcon(new ImageIcon(MainApp.class.getResource("/Images/Delete.png")));
		btnFind.setIcon(new ImageIcon(MainApp.class.getResource("/Images/Edit.png")));
		btnSave.setIcon(new ImageIcon(MainApp.class.getResource("/Images/save.JPG")));
		btnUndo.setIcon(new ImageIcon(MainApp.class.getResource("/Images/undo.JPG")));

		myBar.add(btnFirst);
		myBar.add(btnPrevious);
		myBar.add(txtAfis);
		myBar.add(btnNext);
		myBar.add(btnLast);
		myBar.add(btnAdd);
		myBar.add(btnEdit);
		myBar.add(btnDelete);
		myBar.add(btnFind);
		myBar.add(btnSave);
		myBar.add(btnUndo);

		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelLeft = new JPanel();
		panelCenter.add(panelLeft);
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		panelLeft.add(Box.createVerticalStrut(10));

		JLabel lblId = new JLabel("Id");
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
		rs = sql.executeQuery("select * from persoane");
		initTxtFields();

	}

	private int sizeOfTable(String table) throws SQLException {

		Statement sql = con.createStatement();
		ResultSet count = sql.executeQuery("SELECT COUNT(*) FROM " + table);
		count.next();
		int size = count.getInt(1);
		sql.close();
		count.close();
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

}
