package frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.UserRegisterUtil;
import model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationPage extends JFrame {

	private JPanel layout;
	private JTextField txtUserName;
	private JTextField txtFullName;
	private JLabel lblConfirmPassword;
	private JLabel lblUserType;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField pswPassword;
	private JPasswordField pswConfirmPassword;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JLabel lblPhone;
	private JTextField txtPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage frame = new RegistrationPage();
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
	public RegistrationPage() {
		setTitle("Car Rental System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		layout = new JPanel();
		layout.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(layout);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUserName.setColumns(10);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFullName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		pswPassword = new JPasswordField();
		pswPassword.setColumns(10);
		pswPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		pswConfirmPassword = new JPasswordField();
		pswConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pswConfirmPassword.setColumns(10);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = txtUserName.getText().length() >= 3 ? txtUserName.getText().toLowerCase() : null;
				String fullName = txtFullName.getText().length() >= 3 ? txtFullName.getText() : null;
				String userType = rdbtnMale.isSelected() ? "male" : "female";
				String address = txtAddress.getText().length() >= 3 ? txtAddress.getText() : null;
				String phone = txtPhone.getText().length() >= 3 ? txtPhone.getText() : null;
				String password = pswPassword.getText().length() >= 3 ? pswPassword.getText() : null;
				String confirmPassword = pswConfirmPassword.getText().length() >= 3 ? pswConfirmPassword.getText() : null;
				
				if (userName == null || fullName == null || address == null || phone == null || password == null || confirmPassword == null) {
					JOptionPane.showMessageDialog(null, "Fill all the fields!");
				}
				else if (phone.length() != 10) {
					JOptionPane.showMessageDialog(null, "Invalid phone number!");
				}
				else if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null, "Password mismatch!");
				}
				else {
					User newUser = new User(userName, fullName, userType, address, phone, password);
					boolean result = UserRegisterUtil.registerNewUser(newUser);
					
					if (result) {
						JOptionPane.showMessageDialog(null, "User registered successfully!!");
						
						HomePage homePage = new HomePage();
						homePage.setVisible(true);
						
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "User registration unsuccessfully!!");
					}
				}
				
				
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSignIn = new JButton("< SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
				
				dispose();
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		
		lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		GroupLayout gl_layout = new GroupLayout(layout);
		gl_layout.setHorizontalGroup(
			gl_layout.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layout.createSequentialGroup()
					.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layout.createSequentialGroup()
							.addGap(149)
							.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_layout.createSequentialGroup()
									.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
									.addGap(38)
									.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_layout.createSequentialGroup()
									.addGap(168)
									.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layout.createSequentialGroup()
									.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layout.createSequentialGroup()
									.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_layout.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_layout.createSequentialGroup()
											.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
											.addGap(38)
											.addComponent(pswPassword, 320, 320, 320))
										.addGroup(gl_layout.createSequentialGroup()
											.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(pswConfirmPassword, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_layout.createSequentialGroup()
										.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addGap(116)))))
						.addGroup(gl_layout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		gl_layout.setVerticalGroup(
			gl_layout.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_layout.createSequentialGroup()
					.addGap(27)
					.addComponent(btnSignIn)
					.addGap(45)
					.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(pswPassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblConfirmPassword, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(pswConfirmPassword, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		layout.setLayout(gl_layout);
	}
}
