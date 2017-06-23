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

public class QLNhanVien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNhanVien frame = new QLNhanVien();
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
	public QLNhanVien() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Quản lý nhân viên");
		setBounds(400, 125, 335, 306);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDSNhanVien = new JButton("Danh sách nhân viên");
		btnDSNhanVien.setForeground(new Color(204, 0, 0));
		btnDSNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDSNhanVien.setBounds(10, 113, 299, 40);
		contentPane.add(btnDSNhanVien);
		btnDSNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aXemDSNhanVien.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnNhanVienQL = new JButton("Danh sách nhân viên QL");
		btnNhanVienQL.setForeground(new Color(204, 0, 0));
		btnNhanVienQL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNhanVienQL.setBounds(10, 164, 299, 40);
		contentPane.add(btnNhanVienQL);
		btnNhanVienQL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					eDSNhanVienQL.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnTinhLuong = new JButton("Tính lương nhân viên");
		btnTinhLuong.setForeground(new Color(204, 0, 0));
		btnTinhLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTinhLuong.setBounds(10, 62, 299, 40);
		contentPane.add(btnTinhLuong);
		btnTinhLuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cTinhLuong.main();
			}
		});

		JButton btnThemNhanVien = new JButton("Thêm nhân viên");
		btnThemNhanVien.setForeground(new Color(204, 0, 0));
		btnThemNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThemNhanVien.setBounds(10, 11, 299, 40);
		contentPane.add(btnThemNhanVien);
		btnThemNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bThemNhanVien.main();
			}
		});
		
		JButton button = new JButton("Thoát");
		button.setForeground(new Color(204, 0, 0));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 215, 299, 40);
		contentPane.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
	}
}
