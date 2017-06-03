package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entity.Quyen;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Login {

	JFrame frame;
	private JTextField txtID;
	private JPasswordField txtPassword;
	private Quyen q = new Quyen();
	
	private KeyAdapter press = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
			{
				login();
			} 	
				
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public Login() throws ClassNotFoundException, IOException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, IOException {

		frame = new JFrame();
		frame.getContentPane().addKeyListener(press);
		frame.setBackground(new Color(176, 224, 230));
		frame.setBounds(400, 100, 449, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Đăng nhập");
		frame.getContentPane().setLayout(null);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.addKeyListener(press);
		txtID.setBounds(180, 68, 169, 29);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.addKeyListener(press);
		txtPassword.setBounds(180, 112, 169, 29);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(95, 157, 122, 40);
		frame.getContentPane().add(btnLogin);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login();

			}
		});
		
		JButton btnHuy = new JButton("Thoát");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHuy.setBounds(227, 157, 122, 40);
		frame.getContentPane().add(btnHuy);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(95, 75, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(95, 119, 86, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblQunLKhch = new JLabel("Quản lý khách sạn");
		lblQunLKhch.setForeground(Color.BLUE);
		lblQunLKhch.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblQunLKhch.setBounds(79, 11, 352, 46);
		frame.getContentPane().add(lblQunLKhch);
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	protected void login() {
		if (txtID.getText().toString().equals("") || txtPassword.getText().toString().equals(""))
			JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ");
		else {
			String quyen = q.login(txtID.getText().toString(), txtPassword.getText().toString());
			if (quyen.equals("admin")) {
				frame.setVisible(false);
				MenuAdmin.main();
			} else if (quyen.equals("nhanvien")) {
				frame.setVisible(false);
				MenuNhanVien.main();
			} else
				JOptionPane.showMessageDialog(null, "Sai thông tin");
		}
	}
}
