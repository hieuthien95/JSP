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

public class TacVuKhachHang extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TacVuKhachHang frame = new TacVuKhachHang();
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
	public TacVuKhachHang() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Khách hàng");
		setBounds(400, 125, 459, 228);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(227, 143, 206, 33);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JButton btnThemKhachTro = new JButton("Thêm khách trọ");
		btnThemKhachTro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThemKhachTro.setBounds(10, 11, 423, 33);
		contentPane.add(btnThemKhachTro);
		btnThemKhachTro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemKhachTro.main();
			}
		});

		JButton btnXoaKhachTro = new JButton("Xóa khách trọ");
		btnXoaKhachTro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoaKhachTro.setBounds(10, 55, 207, 33);
		contentPane.add(btnXoaKhachTro);
		btnXoaKhachTro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaKhachTro.main();
			}
		});

		JButton btnSuaThongTinKhac = new JButton("Sửa thông tin khách");
		btnSuaThongTinKhac.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuaThongTinKhac.setBounds(10, 99, 207, 33);
		contentPane.add(btnSuaThongTinKhac);
		btnSuaThongTinKhac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuaKhach.main();
			}
		});

		JButton btnThemTVT = new JButton("Thêm thành viên thuê");
		btnThemTVT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThemTVT.setBounds(227, 55, 206, 33);
		contentPane.add(btnThemTVT);
		btnThemTVT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemThanhVienThue.main();
			}
		});

		JButton btnXoaTVT = new JButton("Xóa thành viên thuê phòng");
		btnXoaTVT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoaTVT.setBounds(227, 99, 206, 33);
		contentPane.add(btnXoaTVT);
		btnXoaTVT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaThanhVienThue.main();
			}
		});
		
		JButton btnDSKhach = new JButton("Ds khách hàng");
		btnDSKhach.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDSKhach.setBounds(10, 143, 207, 33);
		contentPane.add(btnDSKhach);
		btnDSKhach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					XemKhach.main();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
