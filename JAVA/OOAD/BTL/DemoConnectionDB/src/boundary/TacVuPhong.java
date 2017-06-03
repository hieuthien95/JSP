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

public class TacVuPhong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TacVuPhong frame = new TacVuPhong();
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
	public TacVuPhong() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Phòng");
		setBounds(400, 125, 459, 185);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnXemCacPhong = new JButton("Xem c\u00E1c ph\u00F2ng");
		btnXemCacPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXemCacPhong.setBounds(227, 55, 206, 33);
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

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(227, 99, 206, 33);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JButton btnThemPhongMoi = new JButton("Thêm phòng mới");
		btnThemPhongMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThemPhongMoi.setBounds(10, 11, 423, 33);
		contentPane.add(btnThemPhongMoi);
		btnThemPhongMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemPhong.main();
			}
		});

		JButton btnXoaPhongCu = new JButton("Xóa phòng củ");
		btnXoaPhongCu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoaPhongCu.setBounds(10, 55, 207, 33);
		contentPane.add(btnXoaPhongCu);
		btnXoaPhongCu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaPhong.main();
			}
		});

		JButton btnSuaThongTinPhong = new JButton("Sửa thông tin phòng");
		btnSuaThongTinPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSuaThongTinPhong.setBounds(10, 99, 207, 33);
		contentPane.add(btnSuaThongTinPhong);
		btnSuaThongTinPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuaPhong.main();
			}
		});
		

	}
}
