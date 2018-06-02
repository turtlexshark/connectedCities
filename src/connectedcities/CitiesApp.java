package connectedCities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Dimension;

public class CitiesApp extends JFrame {

	private static final long serialVersionUID = -8712166821956106023L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CitiesApp frame = new CitiesApp();
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
	public CitiesApp() {
		setResizable(false);
		setMinimumSize(new Dimension(450, 350));
		setBounds(new Rectangle(80, 0, 0, 0));

		Cities cities = new Cities();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTextPane textPane = new JTextPane();
		textPane.setAutoscrolls(false);
		textPane.setDisabledTextColor(Color.BLACK);
		textPane.setEnabled(false);
		textPane.setEditable(false);
		contentPane.add(textPane);

		Panel panel = new Panel();
		panel.setVisible(false);
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblFrom = new JLabel("From:");
		panel.add(lblFrom, BorderLayout.NORTH);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setToolTipText("Select a start point");
		comboBox.setMaximumRowCount(14);
		comboBox.addItem("SEA");
		comboBox.addItem("SFR");
		comboBox.addItem("LA");
		comboBox.addItem("LV");
		comboBox.addItem("PHO");
		comboBox.addItem("OKC");
		comboBox.addItem("DAL");
		comboBox.addItem("MIN");
		comboBox.addItem("MIL");
		comboBox.addItem("CHI");
		comboBox.addItem("NOR");
		comboBox.addItem("NYC");
		comboBox.addItem("WDC");
		comboBox.addItem("MIA");
		panel.add(comboBox);

		Panel panel_1 = new Panel();
		panel_1.setVisible(false);
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblTo = new JLabel("To:");
		panel_1.add(lblTo, BorderLayout.NORTH);

		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.setToolTipText("Select an end point");
		comboBox1.setMaximumRowCount(14);
		comboBox1.addItem("SEA");
		comboBox1.addItem("SFR");
		comboBox1.addItem("LA");
		comboBox1.addItem("LV");
		comboBox1.addItem("PHO");
		comboBox1.addItem("OKC");
		comboBox1.addItem("DAL");
		comboBox1.addItem("MIN");
		comboBox1.addItem("MIL");
		comboBox1.addItem("CHI");
		comboBox1.addItem("NOR");
		comboBox1.addItem("NYC");
		comboBox1.addItem("WDC");
		comboBox1.addItem("MIA");
		panel_1.add(comboBox1);

		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setVisible(true);
				if (comboBox.getSelectedIndex() != comboBox1.getSelectedIndex()) {
					textPane.setText(
							cities.shortestPath(comboBox.getSelectedIndex(), comboBox1.getSelectedIndex()).toString());
				}
				if (comboBox.getSelectedIndex() == comboBox1.getSelectedIndex()) {
					textPane.setText("Just stay where you are. You're already there...");
				}
			}
		});
		btnGo.setVisible(false);
		contentPane.add(btnGo, BorderLayout.SOUTH);

		JMenuItem mntmShowConnectingCities = new JMenuItem("Show Connecting Cities");
		mntmShowConnectingCities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				textPane.setVisible(true);
				btnGo.setVisible(false);
				textPane.setText(cities.connectedCities());
			}
		});
		mnMenu.add(mntmShowConnectingCities);

		JMenuItem mntmGetShortestPath = new JMenuItem("Get Shortest Path");
		mntmGetShortestPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setVisible(false);
				panel.setVisible(true);
				panel_1.setVisible(true);
				btnGo.setVisible(true);
			}
		});
		mnMenu.add(mntmGetShortestPath);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnMenu.add(mntmExit);
	}
}
