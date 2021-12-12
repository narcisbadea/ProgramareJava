package Problema1;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.swing.JScrollPane;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblTime;
	Timer timer;
	Calendar curent;
	private JScrollPane scrollPane;
	JTree tree;

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

	/**
	 * Create the frame.
	 */
	public MainApp() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTime = new JLabel("00:00:00");
		lblTime.setBounds(345, 49, 81, 14);
		contentPane.add(lblTime);

		tree = new JTree();
		tree.setBounds(10, 74, 416, 189);

		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		root.removeAllChildren();
		model.reload();
		model.setRoot(null);

		JButton btnOpenXML = new JButton("Open XML");
		btnOpenXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.dir")));
				file.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("xml","xml");
				file.addChoosableFileFilter(filter);
				int result = file.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					try {
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document document = builder.parse(selectedFile.getAbsolutePath());
						Element elt = document.getDocumentElement();

						DefaultMutableTreeNode mutableTreeNode = new DefaultMutableTreeNode(elt.getNodeName());
						DefaultTreeModel treeModel = new DefaultTreeModel(mutableTreeNode);

						tree.setModel(treeModel);
						rec(elt, mutableTreeNode);
					} catch (Exception e2) {
						System.out.println(e.toString());
					}
				}

			}
		});
		btnOpenXML.setBounds(12, 45, 131, 23);
		contentPane.add(btnOpenXML);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 79, 414, 294);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(tree);

		timer = new Timer();
		timer.schedule(new updateTime(), 0, 1000);
	}

	class updateTime extends TimerTask {
		public void run() {
			curent = Calendar.getInstance();
			String time = curent.get(Calendar.HOUR_OF_DAY) + ":" + curent.get(Calendar.MINUTE) + ":"
					+ curent.get(Calendar.SECOND);
			lblTime.setText(time);
		}
	}

	public static void rec(Node root, DefaultMutableTreeNode mutableTreeNode) {
		if (root != null) {
			Node childNode = root.getFirstChild();
			while (childNode != null) {
				if (childNode.getNodeType() == Node.TEXT_NODE && !childNode.getNodeValue().trim().isEmpty()) {
					DefaultMutableTreeNode tree_child = new DefaultMutableTreeNode(childNode.getNodeValue().trim());
					mutableTreeNode.add(tree_child);
				} else if (childNode.getNodeType() != Node.TEXT_NODE) {
					DefaultMutableTreeNode tree_child = new DefaultMutableTreeNode(childNode.getNodeName().trim());
					mutableTreeNode.add(tree_child);
					rec(childNode, tree_child);
				}
				childNode = childNode.getNextSibling();
			}
		}

	}
}
