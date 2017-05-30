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

public class QLPhim extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLPhim frame = new QLPhim();
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
	public QLPhim() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Quản lý phim");
		setBounds(400, 125, 374, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDSPhim = new JButton("Danh sách phim");
		btnDSPhim.setForeground(new Color(204, 0, 0));
		btnDSPhim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDSPhim.setBounds(10, 113, 338, 40);
		contentPane.add(btnDSPhim);
		btnDSPhim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aXemDSPhim.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnHanhDong = new JButton("Danh sách phim hành động");
		btnHanhDong.setForeground(new Color(204, 0, 0));
		btnHanhDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHanhDong.setBounds(10, 164, 338, 40);
		contentPane.add(btnHanhDong);
		btnHanhDong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					eDSPhimHanhDong.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnDoanhThu = new JButton("5 Phim theo doanh thu");
		btnDoanhThu.setForeground(new Color(204, 0, 0));
		btnDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoanhThu.setBounds(10, 215, 338, 40);
		contentPane.add(btnDoanhThu);
		btnDoanhThu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					eDSPhimDoanhThuCao.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnThmPhim = new JButton("Thêm phim");
		btnThmPhim.setForeground(new Color(204, 0, 0));
		btnThmPhim.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThmPhim.setBounds(10, 62, 338, 40);
		contentPane.add(btnThmPhim);
		btnThmPhim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bThemPhim.main();
			}
		});

		JButton btnRating = new JButton("5 Phim theo rating");
		btnRating.setForeground(new Color(204, 0, 0));
		btnRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRating.setBounds(10, 266, 338, 40);
		contentPane.add(btnRating);
		btnRating.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					eDSPhimRatingCao.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnGiaVe = new JButton("Tăng dần giá vé");
		btnGiaVe.setForeground(new Color(204, 0, 0));
		btnGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGiaVe.setBounds(10, 317, 338, 40);
		contentPane.add(btnGiaVe);
		btnGiaVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					fSapXepPhimTheoGia.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnMuaVe = new JButton("Bán vé");
		btnMuaVe.setForeground(new Color(204, 0, 0));
		btnMuaVe.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMuaVe.setBounds(10, 11, 338, 40);
		contentPane.add(btnMuaVe);
		btnMuaVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dBanVe.main();
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(new Color(204, 0, 0));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(10, 368, 338, 40);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
	}
}
