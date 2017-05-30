package btl.app;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class QLHoiVien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLHoiVien frame = new QLHoiVien();
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
	public QLHoiVien() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Quản lý hội viên");
		setBounds(400, 125, 351, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnThemHoiVien = new JButton("Thêm hội viên");
		btnThemHoiVien.setForeground(new Color(204, 0, 0));
		btnThemHoiVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThemHoiVien.setBounds(10, 62, 315, 40);
		contentPane.add(btnThemHoiVien);
		btnThemHoiVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bThemHoiVien.main();
			}
		});

		JButton btnGiamTichLuy = new JButton("Giảm dần tích lũy");
		btnGiamTichLuy.setForeground(new Color(204, 0, 0));
		btnGiamTichLuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGiamTichLuy.setBounds(10, 164, 315, 40);
		contentPane.add(btnGiamTichLuy);
		btnGiamTichLuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					fSapXepHoiVienTheoDiem.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnDSHoiVienVVIP = new JButton("Danh sách hội viên VVIP");
		btnDSHoiVienVVIP.setForeground(new Color(204, 0, 0));
		btnDSHoiVienVVIP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDSHoiVienVVIP.setBounds(10, 215, 315, 40);
		contentPane.add(btnDSHoiVienVVIP);
		btnDSHoiVienVVIP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					eDSHoiVienVVIP.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnDSHoiVien = new JButton("Danh sách hội viên");
		btnDSHoiVien.setForeground(new Color(204, 0, 0));
		btnDSHoiVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDSHoiVien.setBounds(10, 113, 315, 40);
		contentPane.add(btnDSHoiVien);
		btnDSHoiVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aXemDSHoiVien.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton button = new JButton("Thoát");
		button.setForeground(new Color(204, 0, 0));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 266, 315, 40);
		contentPane.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JButton btnMuaVe = new JButton("Mua vé");
		btnMuaVe.setForeground(new Color(204, 0, 0));
		btnMuaVe.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMuaVe.setBounds(10, 11, 315, 40);
		contentPane.add(btnMuaVe);
		btnMuaVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dMuaVe.main();
			}
		});

	}
}
