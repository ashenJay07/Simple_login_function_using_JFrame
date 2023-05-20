package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.UserRegisterUtil;
import model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField pswPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("Car Rental System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSignUp = new JButton("< SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage regPage = new RegistrationPage();
				regPage.setVisible(true);
				
				dispose();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		pswPassword = new JPasswordField();
		pswPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pswPassword.setColumns(10);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String userName = txtUserName.getText().length() >= 3 ? txtUserName.getText().toLowerCase() : null;
				String password = pswPassword.getText().length() >= 3 ? pswPassword.getText() : null;
				
				if (userName == null || password == null) {
					JOptionPane.showMessageDialog(null, "Fill all the fields!");
				} if (userName.equals("admin") && password.equals("admin")) {
					AdminDashboard adminDashboard = new AdminDashboard();
					adminDashboard.setVisible(true);
					
					dispose();
				}
				else {
					User newUser = new User(userName, password);
					boolean result = UserRegisterUtil.loginUser(newUser);
					
					if (result) {
						JOptionPane.showMessageDialog(null, "User login successful!");
						
						HomePage homePage = new HomePage();
						homePage.setVisible(true);
						
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "User login unsuccessful!");
					}
				}
				
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(643, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(149, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(pswPassword, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
					.addGap(139))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(265)
					.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(255, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(pswPassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(100)
					.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
