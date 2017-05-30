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

public class TacVuChinh extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TacVuChinh frame = new TacVuChinh();
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
	public TacVuChinh() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Tác vụ chính");
		setBounds(400, 125, 459, 227);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDatPhong.setBounds(10, 11, 423, 33);
		contentPane.add(btnDatPhong);
		btnDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DatPhong.main();
			}
		});

		JButton btnHuyPhong = new JButton("H\u0169y ph\u00F2ng");
		btnHuyPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHuyPhong.setBounds(10, 99, 215, 33);
		contentPane.add(btnHuyPhong);
		btnHuyPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HuyPhong.main();
			}
		});

		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThanhToan.setBounds(10, 55, 423, 33);
		contentPane.add(btnThanhToan);
		btnThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThanhToan.main();
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(235, 143, 198, 33);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
		JButton btnDSPhong = new JButton("Xem các phòng");
		btnDSPhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDSPhong.setBounds(235, 99, 198, 33);
		contentPane.add(btnDSPhong);
		btnDSPhong.addMouseListener(new MouseAdapter() {
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
		

	}
}
