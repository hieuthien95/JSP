package boundary;

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

public class QuyenNhanVien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuyenNhanVien frame = new QuyenNhanVien();
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
	public QuyenNhanVien() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Quản lý");
		setBounds(400, 125, 459, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnXemCacPhong = new JButton("Xem c\u00E1c ph\u00F2ng");
		btnXemCacPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXemCacPhong.setBounds(229, 55, 204, 33);
		contentPane.add(btnXemCacPhong);
		btnXemCacPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					XemPhong.main();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDatPhong.setBounds(229, 187, 204, 33);
		contentPane.add(btnDatPhong);
		btnDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DatPhong.main();
			}
		});

		JButton btnHuyPhong = new JButton("H\u0169y ph\u00F2ng");
		btnHuyPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHuyPhong.setBounds(229, 231, 204, 33);
		contentPane.add(btnHuyPhong);
		btnHuyPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HuyPhong.main();
			}
		});

		JButton btnThanhToan = new JButton("Thanh tóan");
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThanhToan.setBounds(10, 231, 206, 33);
		contentPane.add(btnThanhToan);
		btnThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThanhToan.main();
			}
		});

		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThongKe.setBounds(229, 143, 204, 33);
		contentPane.add(btnThongKe);
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThongKe.main();
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(229, 275, 204, 33);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});

		JButton btnThemKhachTro = new JButton("Thêm khách trọ");
		btnThemKhachTro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThemKhachTro.setBounds(10, 11, 206, 33);
		contentPane.add(btnThemKhachTro);
		btnThemKhachTro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemKhachTro.main();
			}
		});

		JButton btnXoaKhachTro = new JButton("Xóa khách trọ");
		btnXoaKhachTro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoaKhachTro.setBounds(10, 55, 206, 33);
		contentPane.add(btnXoaKhachTro);
		btnXoaKhachTro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaKhachTro.main();
			}
		});

		JButton btnSuaThongTinKhac = new JButton("Sửa thông tin khách");
		btnSuaThongTinKhac.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuaThongTinKhac.setBounds(10, 99, 206, 33);
		contentPane.add(btnSuaThongTinKhac);
		btnSuaThongTinKhac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuaKhach.main();
			}
		});

		JButton btnXemPhongDsd = new JButton("Xem phòng ĐSD");
		btnXemPhongDsd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXemPhongDsd.setBounds(229, 99, 204, 33);
		contentPane.add(btnXemPhongDsd);
		btnXemPhongDsd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					XemPhongDSD.main();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnThemTVT = new JButton("Thêm thành viên thuê");
		btnThemTVT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThemTVT.setBounds(10, 143, 206, 33);
		contentPane.add(btnThemTVT);
		btnThemTVT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemThanhVienThue.main();
			}
		});

		JButton btnXoaTVT = new JButton("Xóa thành viên thuê phòng");
		btnXoaTVT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoaTVT.setBounds(10, 187, 206, 33);
		contentPane.add(btnXoaTVT);
		btnXoaTVT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaThanhVienThue.main();
			}
		});
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTimKiem.setBounds(229, 11, 204, 33);
		contentPane.add(btnTimKiem);
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TimKiem.main();
			}
		});
		
	}
}
