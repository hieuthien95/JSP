package btl.app;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import btl.NhanVien;
import btl.Rap;
import btl.enums.ChucVuNhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class bThemNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtCmnd;
	private JTextField txtSDT;
	private JTextField txtThongTin;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bThemNhanVien frame = new bThemNhanVien();
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
	public bThemNhanVien() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Thêm nhân viên");
		setBounds(400, 150, 297, 252);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTen = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblTen.setForeground(new Color(255, 255, 255));
		lblTen.setBounds(10, 11, 86, 14);
		contentPane.add(lblTen);

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setForeground(new Color(255, 255, 255));
		lblCmnd.setBounds(10, 36, 86, 14);
		contentPane.add(lblCmnd);

		JLabel lblSdt = new JLabel("SDT");
		lblSdt.setForeground(new Color(255, 255, 255));
		lblSdt.setBounds(10, 61, 86, 14);
		contentPane.add(lblSdt);

		JLabel lblThongTin = new JLabel("Th\u00F4ng tin");
		lblThongTin.setForeground(new Color(255, 255, 255));
		lblThongTin.setBounds(10, 86, 86, 14);
		contentPane.add(lblThongTin);

		JLabel lblChucVu = new JLabel("Ch\u1EE9c v\u1EE5");
		lblChucVu.setForeground(new Color(255, 255, 255));
		lblChucVu.setBounds(10, 154, 86, 14);
		contentPane.add(lblChucVu);

		txtTen = new JTextField();
		txtTen.setBounds(90, 8, 181, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtCmnd = new JTextField();
		txtCmnd.setBounds(90, 33, 181, 20);
		contentPane.add(txtCmnd);
		txtCmnd.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setBounds(90, 58, 181, 20);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);

		txtThongTin = new JTextField();
		txtThongTin.setBounds(90, 86, 181, 54);
		contentPane.add(txtThongTin);
		txtThongTin.setColumns(10);

		String[] chucvu = { ChucVuNhanVien.NHANVIEN.getS(), ChucVuNhanVien.QUANLY.getS(),
				ChucVuNhanVien.GIAMDOC.getS() };
		JComboBox cbChucVu = new JComboBox(chucvu);
		cbChucVu.setBounds(90, 151, 181, 20);
		contentPane.add(cbChucVu);

		JButton btnThm = new JButton("Thêm");
		btnThm.setForeground(new Color(204, 0, 0));
		btnThm.setBounds(90, 179, 92, 23);
		contentPane.add(btnThm);
		btnThm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Rap rap = Menu.nhapRapTuFile();

					if (txtTen.getText().toString().equals("") || txtSDT.getText().toString().equals("")
							|| txtCmnd.getText().toString().equals("")
							|| cbChucVu.getSelectedItem().toString().equals(""))
						throw new ClassNotFoundException();

					for (NhanVien i : rap.getDsNhanVien())
						if (i.getCmnd() == Integer.parseInt(txtCmnd.getText().toString()))
							throw new IOException();

					rap.themNhanVien(new NhanVien(Integer.parseInt(txtCmnd.getText().toString()),
							txtTen.getText().toString(), txtSDT.getText().toString(), txtThongTin.getText().toString(),
							cbChucVu.getSelectedItem().toString()));

					Menu.ghiRapVaoFile(rap);
					JOptionPane.showMessageDialog(null, "Thêm nhân viên "
							+ rap.getDsNhanVien().get(rap.getDsNhanVien().size() - 1).getTen() + " thành công");
					txtTen.setText("");
					txtCmnd.setText("");
					txtSDT.setText("");
					txtThongTin.setText("");
					cbChucVu.setSelectedIndex(0);

				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Trùng CMND với người trong danh sách");
					e1.printStackTrace();
				} catch (ClassNotFoundException e2) {
					JOptionPane.showMessageDialog(null, "Phải nhập đầy đủ các trường");
					e2.printStackTrace();
				}

			}
		});

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setForeground(new Color(204, 0, 0));
		btnThot.setBounds(193, 179, 78, 23);
		contentPane.add(btnThot);
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}
}
