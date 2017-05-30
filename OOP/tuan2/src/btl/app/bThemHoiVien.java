package btl.app;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import btl.HoiVien;
import btl.Rap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class bThemHoiVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtCmnd;
	private JTextField txtSDT;
	private JButton btnThot;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bThemHoiVien frame = new bThemHoiVien();
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
	public bThemHoiVien() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Thêm hội viên");
		setBounds(400, 150, 291, 154);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTenHV = new JLabel("T\u00EAn h\u1ED9i vi\u00EAn");
		lblTenHV.setForeground(new Color(255, 255, 255));
		lblTenHV.setBounds(10, 11, 86, 14);
		contentPane.add(lblTenHV);

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setForeground(new Color(255, 255, 255));
		lblCmnd.setBounds(10, 36, 86, 14);
		contentPane.add(lblCmnd);

		JLabel lblSdt = new JLabel("SDT");
		lblSdt.setForeground(new Color(255, 255, 255));
		lblSdt.setBounds(10, 61, 86, 14);
		contentPane.add(lblSdt);

		txtTen = new JTextField();
		txtTen.setBounds(90, 8, 175, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtCmnd = new JTextField();
		txtCmnd.setBounds(90, 33, 175, 20);
		contentPane.add(txtCmnd);
		txtCmnd.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setBounds(90, 58, 175, 20);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);

		JButton btnThm = new JButton("Thêm");
		btnThm.setForeground(new Color(204, 0, 0));
		btnThm.setBounds(90, 86, 87, 23);
		contentPane.add(btnThm);
		btnThm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Rap rap = Menu.nhapRapTuFile();

					if (txtTen.getText().toString().equals("") || txtSDT.getText().toString().equals("")
							|| txtCmnd.getText().toString().equals(""))
						throw new ClassNotFoundException();

						for (HoiVien i : rap.getDsHoiVien())
							if (i.getCmnd() == Integer.parseInt(txtCmnd.getText().toString()))
								throw new IOException();

					rap.themHoiVien(new HoiVien(Integer.parseInt(txtCmnd.getText().toString()),
							txtTen.getText().toString(), txtSDT.getText().toString()));

					Menu.ghiRapVaoFile(rap);
					JOptionPane.showMessageDialog(null, "Thêm hội viên "
							+ rap.getDsHoiVien().get(rap.getDsHoiVien().size() - 1).getTen() + " thành công");
					txtTen.setText("");
					txtCmnd.setText("");
					txtSDT.setText("");

				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Trùng CMND với người trong danh sách");
					e1.printStackTrace();
				} catch (ClassNotFoundException e2){
					JOptionPane.showMessageDialog(null, "Phải nhập đầy đủ các trường");
					e2.printStackTrace();
				}

			}
		});

		btnThot = new JButton("Thoát");
		btnThot.setForeground(new Color(204, 0, 0));
		btnThot.setBounds(187, 86, 78, 23);
		contentPane.add(btnThot);
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}
}
