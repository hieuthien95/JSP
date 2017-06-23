package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.LanThuePhong;
import Entity.Phong;
import Entity.ThanhVienThue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

import java.util.Calendar;
import java.util.Vector;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ThemThanhVienThue extends JFrame {

	private Phong p = new Phong();
	private ThanhVienThue tvt = new ThanhVienThue();
	private LanThuePhong ltp = new LanThuePhong();

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JButton btnThem;
	private JTextField txtCmnd;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemThanhVienThue frame = new ThemThanhVienThue();
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
	public ThemThanhVienThue() throws SQLException {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Thêm thành viên thuê");
		setBounds(400, 150, 291, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Vector<String> hourBD = new Vector<String>();
		for (int i = 0; i <= 12; i++)
			if (i < 10)
				hourBD.add("0" + i);
			else
				hourBD.add("" + i);
		SpinnerListModel hourBDModel = new SpinnerListModel(hourBD);

		Vector<String> minuteBD = new Vector<String>();
		for (int i = 0; i <= 50; i = i + 10)
			if (i < 10)
				minuteBD.add("0" + i);
			else
				minuteBD.add("" + i);
		SpinnerListModel minuteBDModel = new SpinnerListModel(minuteBD);

		Vector<String> ngayBD = new Vector<String>();
		for (int i = 1; i <= 31; i++)
			if (i < 10)
				ngayBD.add("0" + i);
			else
				ngayBD.add("" + i);

		Vector<String> thangBD = new Vector<String>();
		for (int i = 1; i <= 12; i++)
			if (i < 10)
				thangBD.add("0" + i);
			else
				thangBD.add("" + i);

		Calendar cBD = Calendar.getInstance();
		int nowBD = cBD.get(Calendar.YEAR);
		String[] namBD = { nowBD + "", (nowBD + 1) + "" };

		JLabel lblNewLabel = new JLabel("Họ tên");
		lblNewLabel.setBounds(10, 11, 67, 14);
		contentPane.add(lblNewLabel);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(67, 8, 196, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CMND");
		lblNewLabel_1.setBounds(10, 42, 67, 14);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("Mã phòng");
		label.setBounds(10, 73, 67, 14);
		contentPane.add(label);

		Vector<String> dsMaPhong = new Vector<String>();
		for (Phong i : p.getDsPhong())
			dsMaPhong.add(i.getMaPhong());
		final JComboBox<String> cbMaPhong = new JComboBox<String>(dsMaPhong);
		cbMaPhong.setBounds(67, 70, 196, 20);
		contentPane.add(cbMaPhong);

		txtCmnd = new JTextField();
		txtCmnd.setColumns(10);
		txtCmnd.setBounds(67, 39, 196, 20);
		contentPane.add(txtCmnd);

		JLabel label_1 = new JLabel(":");
		label_1.setBounds(123, 104, 7, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("/");
		label_2.setBounds(123, 135, 7, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("/");
		label_3.setBounds(190, 135, 7, 14);
		contentPane.add(label_3);

		final JComboBox<String> cbNamBD = new JComboBox<String>(namBD);
		cbNamBD.setBounds(202, 132, 61, 20);
		contentPane.add(cbNamBD);

		String[] loaiPhongBD = { "AM", "PM" };
		final JComboBox<String> cbaaBD = new JComboBox<String>(loaiPhongBD);
		cbaaBD.setBounds(201, 101, 62, 20);
		contentPane.add(cbaaBD);

		final JSpinner spmmBD = new JSpinner(minuteBDModel);
		spmmBD.setBounds(136, 101, 46, 20);
		contentPane.add(spmmBD);

		final JComboBox<String> cbThangBD = new JComboBox<String>(thangBD);
		cbThangBD.setBounds(136, 132, 46, 20);
		contentPane.add(cbThangBD);

		final JComboBox<String> cbNgayBD = new JComboBox<String>(ngayBD);
		cbNgayBD.setBounds(67, 132, 46, 20);
		contentPane.add(cbNgayBD);

		final JSpinner sphhBD = new JSpinner(hourBDModel);
		sphhBD.setBounds(67, 101, 46, 20);
		contentPane.add(sphhBD);

		JLabel label_4 = new JLabel("Ngày BD");
		label_4.setBounds(10, 100, 53, 14);
		contentPane.add(label_4);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 163, 120, 23);
		contentPane.add(btnThem);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (txtCmnd.getText().toString().length() < 9)
					JOptionPane.showMessageDialog(null, "CMND phải từ 9 ký tự");
				else {
					boolean thanhcong = false;
					String ngayBD = sphhBD.getValue().toString() + ":" + spmmBD.getValue().toString() + " "
							+ cbaaBD.getSelectedItem().toString() + " " + cbNgayBD.getSelectedItem().toString() + "/"
							+ cbThangBD.getSelectedItem().toString() + "/" + cbNamBD.getSelectedItem().toString();
					for (LanThuePhong i : ltp.getDsLanThuePhong())
						if (i.getNgayBatDau().equals(ngayBD)
								&& i.getMaPhongThue().equals(cbMaPhong.getSelectedItem().toString())) {
							try {
								tvt.themThanhVienThuePhong(
										new ThanhVienThue(Long.parseLong(txtCmnd.getText().toString()),
												txtHoTen.getText().toString(), i.getMaLanThuePhong()));

								thanhcong = true;
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}

						}
					if (!thanhcong)
						JOptionPane.showMessageDialog(null, "Mã phòng không khớp với ngày đặt");
				}

			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(140, 163, 123, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}
}
