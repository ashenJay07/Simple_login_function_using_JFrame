package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import database.UserRegisterUtil;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setTitle("Car Rental System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(152)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		Object[][] dataSet = UserRegisterUtil.selectAllStocks();
		
		table.setModel(new DefaultTableModel(
			dataSet,
			new String[] {
				"User Id", "User Name", "Full Name", "User Type", "Address", "Phone No"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
