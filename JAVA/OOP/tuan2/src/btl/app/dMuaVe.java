package btl.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import btl.HoiVien;
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

public class dMuaVe extends JFrame {

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
					dMuaVe frame = new dMuaVe();
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
	public dMuaVe() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Mua vé");
		setBounds(400, 150, 350, 203);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Rap rap = Menu.nhapRapTuFile();

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setForeground(new Color(255, 255, 255));
		lblCmnd.setBounds(10, 17, 70, 14);
		contentPane.add(lblCmnd);

		JLabel lblMPhim = new JLabel("Phim");
		lblMPhim.setForeground(new Color(255, 255, 255));
		lblMPhim.setBounds(10, 58, 70, 14);
		contentPane.add(lblMPhim);

		textCmnd = new JTextField();
		textCmnd.setBounds(90, 11, 230, 26);
		contentPane.add(textCmnd);
		textCmnd.setColumns(10);

		String[] boPhim = { rap.getDsPhim().get(rap.getDsPhim().size() - 1).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 2).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 3).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 4).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 5).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 6).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 7).getTen().toString(),
				rap.getDsPhim().get(rap.getDsPhim().size() - 8).getTen().toString() };
		JComboBox cbBoPhim = new JComboBox(boPhim);
		cbBoPhim.setBounds(90, 48, 230, 26);
		contentPane.add(cbBoPhim);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setForeground(Color.WHITE);
		lblSLng.setBounds(10, 93, 70, 14);
		contentPane.add(lblSLng);

		JComboBox cbSoLuong = new JComboBox(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		cbSoLuong.setBounds(90, 83, 230, 26);
		contentPane.add(cbSoLuong);

		JButton btnMuaVe = new JButton("Mua v\u00E9");
		btnMuaVe.setForeground(new Color(204, 0, 0));
		btnMuaVe.setBounds(90, 130, 110, 23);
		contentPane.add(btnMuaVe);

		btnMuaVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int tmpHV = 0;
					for (HoiVien i : rap.getDsHoiVien())
						if (i.getCmnd() == Integer.parseInt(textCmnd.getText().toString())) {
							tmpHV = 1;

							int count1 = rap.getDsPhim().size() - 1;
							int count2 = rap.getDsPhim().size() - 8;
							for (int j = count1; j >= count2; j--) {
								if (rap.getDsPhim().get(j).getTen().equals(cbBoPhim.getSelectedItem().toString())) {

									int soLuong = Integer.parseInt(cbSoLuong.getSelectedItem().toString());
									
									for (int k = 0; k < soLuong; k++)
										rap.muaVe(i, rap.getDsPhim().get(j));

									JOptionPane.showMessageDialog(null,
											i.getTen() + " đã mua " + soLuong + " vé phim " + rap.getDsPhim().get(j).getTen().toString()
													+ ", giá " + (int)rap.getDsPhim().get(j).getGiaVe()*soLuong);
								}
							}
							try {
								Menu.ghiRapVaoFile(rap);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					if (tmpHV == 0) {
						JOptionPane.showMessageDialog(null, "CMND không đúng");
						throw new IOException();
					}
					Menu.ghiRapVaoFile(rap);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnThot = new JButton("Thoát");
		btnThot.setForeground(new Color(204, 0, 0));
		btnThot.setBounds(210, 130, 110, 23);
		contentPane.add(btnThot);
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}
}
