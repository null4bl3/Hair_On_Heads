//package haironheads;
//
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//public class LoginGui implements ActionListener {
//
//	LoginConnector lC;
//	
//	// Fields
//	private JFrame frame;
//	private JPanel pane;
//	private JLabel userLabel;
//	private JLabel passLabel;
//	private JButton loginButton;
//	private JTextField userTF;
//	private JTextField passTF;
//	private String username;
//	private String password;
//
//	public LoginGui() {
//
//		frame = new JFrame();
//		pane = new JPanel();
//
//		// User name
//		userLabel = new JLabel("Enter Username");
//		pane.add(userLabel);
//		userTF = new JTextField(15);
//		pane.add(userTF);
//
//		// Password
//		passLabel = new JLabel("Enter Password");
//		pane.add(passLabel);
//		passTF = new JTextField(15);
//		pane.add(passTF);
//
//		// Button
//		loginButton = new JButton("Login");
//		pane.add(loginButton);
//
//		// Action Listeners
//		loginButton.addActionListener(this);
//
//		pane.setLayout(new FlowLayout());
//
//		frame.add(pane);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("Login");
//		frame.setSize(250, 200);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//	}
//
//	public static void main(String[] args) {
//
//		LoginGui main = new LoginGui();
//	}
//
//	public static void loginSuccess() {
//		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(null, "Logged in");
//	}
//
//	public static void LoginFailed() throws Exception {
//		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(null, "Login failed");
//
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == loginButton) {
//			username = userTF.getText();
//			password = passTF.getText();
//			try {
//				lC.login(username, password);
//
//			} catch (Exception e1) { // TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//
//	}
//
//}
