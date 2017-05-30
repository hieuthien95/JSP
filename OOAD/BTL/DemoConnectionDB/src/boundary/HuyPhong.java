package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Phong;
import Entity.PhongDangSuDung;

public class HuyPhong extends JFrame {

	private Phong p = new Phong();
	private PhongDangSuDung pdsd = new PhongDangSuDung();
	private JPanel contentPane;
	private JComboBox cbMaPhong;
	private JButton btnHuy;
	private JTextField txtCmnd;
	private JSpinner sphhBD;
	private JSpinner spmmBD;
	private JComboBox<String> cbNamBD;
	private JComboBox<String> cbThangBD;
	private JComboBox<String> cbNgayBD;
	JComboBox<String> cbNgayDat;
	boolean chon = false;

	private JComboBox<String> cbaaBD;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuyPhong frame = new HuyPhong();
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
	public HuyPhong() throws SQLException {

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
		setTitle("Hũy phòng");
		setBounds(400, 150, 751, 289);
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

		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(10, 17, 55, 14);
		contentPane.add(lblNewLabel_1);

		Vector<String> dsMaPhong = new Vector<String>();
		for (Phong i : p.getDsPhong())
			dsMaPhong.add(i.getMaPhong());

		JLabel label = new JLabel("Ngày BĐ");
		label.setBounds(10, 73, 53, 14);
		contentPane.add(label);

		sphhBD = new JSpinner(hourBDModel);
		sphhBD.setBounds(66, 71, 46, 20);
		contentPane.add(sphhBD);

		label = new JLabel(":");
		label.setBounds(122, 74, 7, 14);
		contentPane.add(label);

		spmmBD = new JSpinner(minuteBDModel);
		spmmBD.setBounds(135, 71, 46, 20);
		contentPane.add(spmmBD);

		String[] loaiPhongBD = { "AM", "PM" };
		cbaaBD = new JComboBox(loaiPhongBD);
		cbaaBD.setBounds(200, 71, 62, 20);
		contentPane.add(cbaaBD);

		cbNgayBD = new JComboBox<String>(ngayBD);
		cbNgayBD.setBounds(66, 102, 46, 20);
		contentPane.add(cbNgayBD);

		cbThangBD = new JComboBox<String>(thangBD);
		cbThangBD.setBounds(135, 102, 46, 20);
		contentPane.add(cbThangBD);

		cbNamBD = new JComboBox(namBD);
		cbNamBD.setBounds(201, 102, 61, 20);
		contentPane.add(cbNamBD);

		cbMaPhong = new JComboBox<String>(dsMaPhong);
		cbMaPhong.setBounds(66, 14, 115, 20);
		contentPane.add(cbMaPhong);

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(10, 45, 46, 14);
		contentPane.add(lblCmnd);

		txtCmnd = new JTextField();
		txtCmnd.setBounds(66, 42, 196, 20);
		contentPane.add(txtCmnd);
		txtCmnd.setColumns(10);

		JLabel label_1 = new JLabel("/");
		label_1.setBounds(122, 105, 7, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("/");
		label_2.setBounds(189, 105, 7, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Ngày BĐ");
		label_3.setBounds(10, 136, 53, 14);
		contentPane.add(label_3);

		cbNgayDat = new JComboBox<String>();
		cbNgayDat.setBounds(66, 133, 196, 20);
		contentPane.add(cbNgayDat);

		btnHuy = new JButton("H\u0169y");
		btnHuy.setBounds(10, 167, 119, 23);
		contentPane.add(btnHuy);
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtCmnd.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "Phải nhập đầy đủ");
				else {
					try {
						if (!chon) {
							int reply = JOptionPane.showConfirmDialog(
									null, "Xác nhận hũy phòng: " + cbMaPhong.getSelectedItem().toString()
											+ "\nNgười đặt: " + txtCmnd.getText().toString(),
									null, JOptionPane.YES_NO_OPTION);

							if (reply == JOptionPane.YES_OPTION) {
								String ngayBD = sphhBD.getValue().toString() + ":" + spmmBD.getValue().toString() + " "
										+ cbaaBD.getSelectedItem().toString() + " "
										+ cbNgayBD.getSelectedItem().toString() + "/"
										+ cbThangBD.getSelectedItem().toString() + "/"
										+ cbNamBD.getSelectedItem().toString();
								pdsd.huyPhong(cbMaPhong.getSelectedItem().toString(),
										Long.parseLong(txtCmnd.getText().toString()), ngayBD);

								HuyPhong.main();
								setVisible(false);
							}
						} else {
							int reply = JOptionPane.showConfirmDialog(
									null, "Xác nhận hũy phòng: " + cbMaPhong.getSelectedItem().toString()
											+ "\nNgười đặt: " + txtCmnd.getText().toString(),
									null, JOptionPane.YES_NO_OPTION);

							if (reply == JOptionPane.YES_OPTION) {
								pdsd.huyPhong(cbMaPhong.getSelectedItem().toString(),
										Long.parseLong(txtCmnd.getText().toString()),
										cbNgayDat.getSelectedItem().toString());

								cbNgayDat.removeAllItems();
								for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
									if (i.getMaPhongThue().equals(cbMaPhong.getSelectedItem().toString()))
										cbNgayDat.addItem(i.getNgayBatDau().toString());
								cbNgayDat.removeAllItems();
								chon = false;

								HuyPhong.main();
								setVisible(false);
							}

						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(143, 167, 119, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JButton btnChon = new JButton(">>");
		btnChon.setBounds(200, 14, 62, 20);
		contentPane.add(btnChon);
		btnChon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbNgayDat.removeAllItems();
				for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
					if (i.getMaPhongThue().equals(cbMaPhong.getSelectedItem().toString()))
						cbNgayDat.addItem(i.getNgayBatDau().toString());
				chon = true;
			}
		});

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(272, 14, 453, 225);

		model.addColumn("Mã phòng");
		model.addColumn("Ngày bắt đầu");
		model.addColumn("Ngày kết thúc");
		model.addColumn("CMND");

		for (PhongDangSuDung p : pdsd.getDsPhongDangSuDung()) {
			model.addRow(new Object[] { p.getMaPhongThue(), p.getNgayBatDau(), p.getNgayKetThuc(), p.getCmnd() });
		}

		getContentPane().add(pane);

		// su kien right click
		RowPopup pop = new RowPopup();
		pop.addActionListener(e -> {
			String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			Long cmnd = Long.parseLong(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
			String ngaybd = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();

			int reply = JOptionPane.showConfirmDialog(null,
					"Xác nhận hũy phòng: " + maPhong + "\nNgười đặt: " + cmnd + "\nThời gian: " + ngaybd, null,
					JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {
				try {
					pdsd.huyPhong(maPhong, cmnd, ngaybd);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				HuyPhong.main();
				setVisible(false);
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (SwingUtilities.isRightMouseButton(e))
					pop.show(e.getComponent(), e.getX(), e.getY());
			}
		});

	}
}


