package btl.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import btl.Rap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;

public class dBanVe extends JFrame {

	private JPanel contentPane;
	private JTextField textMaPhim;
	private JButton btnThot;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dBanVe frame = new dBanVe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public dBanVe() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Mua vé");
		setBounds(400, 150, 320, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Rap rap = Menu.nhapRapTuFile();

		JLabel lblMPhim = new JLabel("Phim");
		lblMPhim.setForeground(new Color(255, 255, 255));
		lblMPhim.setBounds(10, 21, 70, 14);
		contentPane.add(lblMPhim);

		String[] boPhim = { rap.getDsPhim().get(rap.getDsPhim().size() - 1).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 2).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 3).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 4).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 5).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 6).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 7).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 8).getTen().toString() };
		JComboBox cbBoPhim = new JComboBox(boPhim);
		cbBoPhim.setBounds(90, 11, 200, 26);
		contentPane.add(cbBoPhim);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setForeground(Color.WHITE);
		lblSLng.setBounds(9, 54, 70, 14);
		contentPane.add(lblSLng);

		JComboBox cbSoLuong = new JComboBox(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		cbSoLuong.setBounds(90, 48, 200, 20);
		contentPane.add(cbSoLuong);

		JButton btnBan = new JButton("Bán");
		btnBan.setForeground(new Color(204, 0, 0));
		btnBan.setBounds(88, 77, 105, 23);
		contentPane.add(btnBan);

		btnBan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count1 = rap.getDsPhim().size() - 1;
				int count2 = rap.getDsPhim().size() - 8;

				for (int j = count1; j >= count2; j--) {
					if (rap.getDsPhim().get(j).getTen().equals(cbBoPhim.getSelectedItem().toString())) {

						int soLuong = Integer.parseInt(cbSoLuong.getSelectedItem().toString());
						
						for (int i = 0; i < soLuong; i++)
							rap.muaVe(rap.getDsPhim().get(j));

						JOptionPane.showMessageDialog(null,
								"Đã bán " +  soLuong +" vé phim " + rap.getDsPhim().get(j).getTen().toString() + ", giá "
										+ (int)rap.getDsPhim().get(j).getGiaVe() * soLuong);
					}
				}
				try {
					Menu.ghiRapVaoFile(rap);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnThot = new JButton("Thoát");
		btnThot.setForeground(new Color(204, 0, 0));
		btnThot.setBounds(203, 77, 85, 23);
		contentPane.add(btnThot);
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}
}
