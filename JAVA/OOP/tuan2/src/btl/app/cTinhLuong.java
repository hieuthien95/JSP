package btl.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import btl.NhanVien;
import btl.Rap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;

public class cTinhLuong extends JFrame {

	private JPanel contentPane;
	private JTextField textCmnd;
	private JButton btnThot;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cTinhLuong frame = new cTinhLuong();
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
	public cTinhLuong() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Tính lương");
		setBounds(400, 150, 300, 120);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setForeground(new Color(255, 255, 255));
		lblCmnd.setBounds(10, 17, 46, 14);
		contentPane.add(lblCmnd);

		textCmnd = new JTextField();
		textCmnd.setBounds(66, 11, 200, 26);
		contentPane.add(textCmnd);
		textCmnd.setColumns(10);

		JButton btnTinhLuong = new JButton("Tính");
		btnTinhLuong.setBounds(66, 48, 101, 23);
		contentPane.add(btnTinhLuong);
		btnTinhLuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rap rap = null;
				int tmp = 0;
				try {
					rap = Menu.nhapRapTuFile();
					for (NhanVien i : rap.getDsNhanVien())
						if (Integer.parseInt(textCmnd.getText().toString()) == i.getCmnd()) {
							double luong = rap.tinhLuong(i);
							JOptionPane.showMessageDialog(null, i.getTen() + " có lương: " + luong);
							tmp = 1;
						}
					if (tmp == 0)
						JOptionPane.showMessageDialog(null, "Không tìm thấy CMND");
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnThot = new JButton("Thoát");
		btnThot.setBounds(177, 48, 89, 23);
		contentPane.add(btnThot);
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
	}
}
