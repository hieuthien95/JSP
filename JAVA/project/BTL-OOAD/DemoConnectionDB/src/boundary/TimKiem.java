package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.KhachTro;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;

import java.awt.Color;

public class TimKiem extends JFrame {

	public static ArrayList<KhachTro> dsKhachTro;

	private KhachTro p = new KhachTro();

	private JPanel contentPane;
	private JButton btnTim;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiem frame = new TimKiem();
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
	public TimKiem() throws SQLException {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Tìm kiếm");
		setBounds(400, 150, 380, 118);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCmndTn = new JLabel("CMND / Tên khách");
		lblCmndTn.setBounds(10, 14, 103, 14);
		contentPane.add(lblCmndTn);

		textField = new JTextField();
		textField.setBounds(129, 11, 225, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(241, 42, 113, 23);
		contentPane.add(btnTim);
		btnTim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dsKhachTro = null;
				dsKhachTro = new ArrayList<KhachTro>();

				String regex = "(^-)*\\d+(.\\d+)*";// Vẫn có trường hợp .5
													// tương đương 0.5 nhưng
													// mình chưa viết cái
													// này :D

				if (textField.getText().toString().matches(regex)) {
					for (KhachTro i : p.getDsKhachTro())
						if (i.getCmnd() == Integer.parseInt(textField.getText().toString()))
							dsKhachTro.add(i);
				} else {
					for (KhachTro i : p.getDsKhachTro()) {
						try {
							dsKhachTro = i.timKiem(textField.getText().toString());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

				if (dsKhachTro.isEmpty())
					JOptionPane.showMessageDialog(null, "Không có kết quả nào phù hợp");
				else
					ValueTimKiem.main();
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(129, 42, 102, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}
}
