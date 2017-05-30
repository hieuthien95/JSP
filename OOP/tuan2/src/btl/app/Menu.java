package btl.app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import btl.Rap;
import javax.swing.ImageIcon;

public class Menu {

	JFrame frame;

	public static void ghiRapVaoFile(Rap r) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
		oos.writeObject(r);
		oos.close();
	}

	public static Rap nhapRapTuFile() throws IOException, ClassNotFoundException {
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("data.txt"));
		Rap r = (Rap) ios.readObject();
		ios.close();
		return r;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public Menu() throws ClassNotFoundException, IOException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, IOException {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 0, 0));
		frame.setBounds(400, 100, 552, 283);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Menu");
		frame.getContentPane().setLayout(null);

		JLabel lblBanner = new JLabel("LOTTE CINEMA");
		lblBanner.setForeground(new Color(255, 255, 255));
		lblBanner.setFont(new Font("Lithos Pro Regular", Font.BOLD, 47));
		lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanner.setBounds(20, 11, 506, 55);
		frame.getContentPane().add(lblBanner);

		// phim
		JButton btnPhim = new JButton("");
		btnPhim.setIcon(new ImageIcon("btnPhim.jpg"));
		btnPhim.setForeground(new Color(204, 0, 0));
		btnPhim.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		btnPhim.setBounds(10, 77, 516, 71);
		frame.getContentPane().add(btnPhim);
		btnPhim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QLPhim.main();
			}
		});

		// nhan vien
		JButton btnNhanVien = new JButton("");
		btnNhanVien.setIcon(new ImageIcon("btnNhanVien.jpg"));
		btnNhanVien.setForeground(new Color(204, 0, 0));
		btnNhanVien.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		btnNhanVien.setBounds(274, 159, 252, 71);
		frame.getContentPane().add(btnNhanVien);
		btnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QLNhanVien.main();
			}
		});

		// hoivien
		JButton btnHoiVien = new JButton("");
		btnHoiVien.setIcon(new ImageIcon("btnHoiVien.jpg"));
		btnHoiVien.setForeground(new Color(204, 0, 0));
		btnHoiVien.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		btnHoiVien.setBounds(10, 159, 252, 71);
		frame.getContentPane().add(btnHoiVien);
		btnHoiVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QLHoiVien.main();
			}
		});

	}
}
