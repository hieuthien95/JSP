package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Phong;
import Entity.PhongDangSuDung;
import control.KhachSan;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JTable;
import java.awt.Font;

public class DatPhong extends JFrame {

	private Phong p=new Phong();

	private JPanel contentPane;
	private JComboBox cbMaPhong;
	private JButton btnDatPhong;
	private JLabel lblNewLabel;
	private JTextField txtCmnd;
	private JLabel lblNgyBD;
	private JLabel lblNgyKt;
	private JButton btnThemKhach;
	private JLabel label;
	private JComboBox<String> cbNgayBD;
	private JComboBox<String> cbThangBD;
	private JComboBox<String> cbNamBD;
	private JLabel label_1;
	private JLabel label_2;
	private JSpinner sphhBD;
	private JSpinner spmmBD;
	private JSpinner sphhKT;
	private JSpinner spmmKT;
	private JComboBox<String> cbNgayKT;
	private JLabel label_3;
	private JComboBox<String> cbThangKT;
	private JLabel label_4;
	private JComboBox<String> cbNamKT;
	private JLabel label_5;
	private JComboBox<String> cbaaKT;
	private JComboBox<String> cbaaBD;
	private JButton btnHuy;

	private JTable table1;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatPhong frame = new DatPhong();
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
	public DatPhong() throws SQLException {
		

		
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
		setTitle("Đặt phòng");
		setBounds(400, 125, 649, 549);
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

		Vector<String> hourKT = new Vector<String>();
		for (int i = 0; i <= 12; i++)
			if (i < 10)
				hourKT.add("0" + i);
			else
				hourKT.add("" + i);
		SpinnerListModel hourKTModel = new SpinnerListModel(hourKT);

		Vector<String> minuteKT = new Vector<String>();
		for (int i = 0; i <= 50; i = i + 10)
			if (i < 10)
				minuteKT.add("0" + i);
			else
				minuteKT.add("" + i);
		SpinnerListModel minuteKTModel = new SpinnerListModel(minuteKT);

		Vector<String> ngayKT = new Vector<String>();
		for (int i = 1; i <= 31; i++)
			if (i < 10)
				ngayKT.add("0" + i);
			else
				ngayKT.add("" + i);

		Vector<String> thangKT = new Vector<String>();
		for (int i = 1; i <= 12; i++)
			if (i < 10)
				thangKT.add("0" + i);
			else
				thangKT.add("" + i);

		Calendar cKT = Calendar.getInstance();
		int nowKT = cKT.get(Calendar.YEAR);
		String[] namKT = { nowKT + "", (nowKT + 1) + "" };
		contentPane.setLayout(null);

		sphhBD = new JSpinner(hourBDModel);
		sphhBD.setBounds(74, 70, 46, 20);
		contentPane.add(sphhBD);

		label = new JLabel(":");
		label.setBounds(130, 73, 7, 14);
		contentPane.add(label);

		spmmBD = new JSpinner(minuteBDModel);
		spmmBD.setBounds(143, 70, 46, 20);
		contentPane.add(spmmBD);

		String[] loaiPhongBD = { "AM", "PM" };
		cbaaBD = new JComboBox(loaiPhongBD);
		cbaaBD.setBounds(208, 70, 61, 20);
		contentPane.add(cbaaBD);

		cbNgayBD = new JComboBox<String>(ngayBD);
		cbNgayBD.setBounds(74, 101, 46, 20);
		contentPane.add(cbNgayBD);

		cbThangBD = new JComboBox<String>(thangBD);
		cbThangBD.setBounds(143, 101, 46, 20);
		contentPane.add(cbThangBD);

		cbNamBD = new JComboBox(namBD);
		cbNamBD.setBounds(209, 101, 60, 20);
		contentPane.add(cbNamBD);

		label_1 = new JLabel("/");
		label_1.setBounds(130, 104, 14, 14);
		contentPane.add(label_1);

		label_2 = new JLabel("/");
		label_2.setBounds(198, 104, 14, 14);
		contentPane.add(label_2);

		sphhKT = new JSpinner(hourKTModel);
		sphhKT.setBounds(74, 132, 46, 20);
		contentPane.add(sphhKT);

		spmmKT = new JSpinner(minuteKTModel);
		spmmKT.setBounds(143, 132, 46, 20);
		contentPane.add(spmmKT);

		String[] loaiPhongKT = { "AM", "PM" };
		cbaaKT = new JComboBox(loaiPhongKT);
		cbaaKT.setBounds(208, 132, 61, 20);
		contentPane.add(cbaaKT);

		cbNgayKT = new JComboBox<String>(ngayKT);
		cbNgayKT.setBounds(74, 163, 46, 20);
		contentPane.add(cbNgayKT);

		label_3 = new JLabel("/");
		label_3.setBounds(130, 166, 14, 14);
		contentPane.add(label_3);

		cbThangKT = new JComboBox<String>(thangKT);
		cbThangKT.setBounds(143, 163, 46, 20);
		contentPane.add(cbThangKT);

		label_4 = new JLabel("/");
		label_4.setBounds(198, 166, 14, 14);
		contentPane.add(label_4);

		cbNamKT = new JComboBox(namKT);
		cbNamKT.setBounds(209, 163, 60, 20);
		contentPane.add(cbNamKT);

		label_5 = new JLabel(":");
		label_5.setBounds(130, 135, 7, 14);
		contentPane.add(label_5);

		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(10, 42, 67, 14);
		contentPane.add(lblNewLabel_1);

		Vector<String> dsMaPhong = new Vector<String>();
		for (Phong i : p.getDsPhong())
			dsMaPhong.add(i.getMaPhong());

		cbMaPhong = new JComboBox<String>(dsMaPhong);
		cbMaPhong.setBounds(74, 39, 195, 20);
		contentPane.add(cbMaPhong);

		lblNewLabel = new JLabel("CMND");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);

		txtCmnd = new JTextField();
		txtCmnd.setBounds(74, 8, 195, 20);
		contentPane.add(txtCmnd);
		txtCmnd.setColumns(10);

		lblNgyBD = new JLabel("Ngày BĐ");
		lblNgyBD.setBounds(10, 73, 53, 14);
		contentPane.add(lblNgyBD);

		lblNgyKt = new JLabel("Ngày KT");
		lblNgyKt.setBounds(10, 135, 46, 14);
		contentPane.add(lblNgyKt);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBounds(9, 194, 133, 23);
		contentPane.add(btnDatPhong);
		btnDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachSan ks = new KhachSan();

				String ngayBD = sphhBD.getValue().toString() + ":" + spmmBD.getValue().toString() + " "
						+ cbaaBD.getSelectedItem().toString() + " " + cbNgayBD.getSelectedItem().toString() + "/"
						+ cbThangBD.getSelectedItem().toString() + "/" + cbNamBD.getSelectedItem().toString();
				String ngayKT = sphhKT.getValue().toString() + ":" + spmmKT.getValue().toString() + " "
						+ cbaaKT.getSelectedItem().toString() + " " + cbNgayKT.getSelectedItem().toString() + "/"
						+ cbThangKT.getSelectedItem().toString() + "/" + cbNamKT.getSelectedItem().toString();

				if (txtCmnd.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "Phải nhập đầy đủ");
				else if (txtCmnd.getText().toString().length()<9)
					JOptionPane.showMessageDialog(null, "CMND phải từ 9 ký tự");
				else
					try {
						ks.datPhong(Long.parseLong(txtCmnd.getText().toString()), cbMaPhong.getSelectedItem().toString(), ngayBD, ngayKT);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(156, 262, 113, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		btnThemKhach = new JButton("Thêm khách");
		btnThemKhach.setBounds(10, 228, 133, 23);
		contentPane.add(btnThemKhach);
		btnThemKhach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemKhachTro.main();
			}
		});

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(279, 8, 344, 277);
		

		model.addColumn("Mã phòng");
		model.addColumn("Loại phòng");
		model.addColumn("Sức chứa");
		model.addColumn("Đơn giá");

		for (Phong p : p.getDsPhong()) {
			model.addRow(new Object[] { p.getMaPhong(), p.getLoaiPhong(), p.getSucChua(), p.getDonGia()});
		}

		getContentPane().add(pane);
		
		
		
		

		DefaultTableModel model1 = new DefaultTableModel();
		table1 = new JTable(model1);

		JScrollPane pane1 = new JScrollPane(table1);
		pane1.setBounds(10, 296, 613, 203);

		model1.addColumn("Mã phòng");
		model1.addColumn("Ngày bắt đầu");
		model1.addColumn("Ngày kết thúc");
		model1.addColumn("CMND");

		PhongDangSuDung pdsd = new PhongDangSuDung();
		for (PhongDangSuDung p : pdsd.getDsPhongDangSuDung()) {
			model1.addRow(new Object[] { p.getMaPhongThue(), p.getNgayBatDau(), p.getNgayKetThuc(), p.getCmnd() });
		}

		getContentPane().add(pane1);
		
		JLabel lblNewLabel_2 = new JLabel("Phòng đang sử dụng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(279, 139, 166, 30);
		contentPane.add(lblNewLabel_2);
		
		btnHuy = new JButton("Hũy phòng");
		btnHuy.setBounds(156, 228, 113, 23);
		contentPane.add(btnHuy);
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				HuyPhong.main();
			}
		});
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(10, 262, 133, 23);
		contentPane.add(btnLamMoi);
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DatPhong.main();
				setVisible(false);
			}
		});
		
		JButton btnKT = new JButton("Kiểm tra");
		btnKT.setBounds(156, 194, 113, 23);
		contentPane.add(btnKT);
		btnKT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String ngayBD = sphhBD.getValue().toString() + ":" + spmmBD.getValue().toString() + " "
						+ cbaaBD.getSelectedItem().toString() + " " + cbNgayBD.getSelectedItem().toString() + "/"
						+ cbThangBD.getSelectedItem().toString() + "/" + cbNamBD.getSelectedItem().toString();
				String ngayKT = sphhKT.getValue().toString() + ":" + spmmKT.getValue().toString() + " "
						+ cbaaKT.getSelectedItem().toString() + " " + cbNgayKT.getSelectedItem().toString() + "/"
						+ cbThangKT.getSelectedItem().toString() + "/" + cbNamKT.getSelectedItem().toString();

				try {
					new KhachSan().kiemTra(cbMaPhong.getSelectedItem().toString(), ngayBD, ngayKT);
				} catch (SQLException | ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
		// su kien right click
		RowPopup pop = new RowPopup();
		pop.addActionListener(e -> {
			String maPhong = table1.getModel().getValueAt(table1.getSelectedRow(), 0).toString();
			Long cmnd = Long.parseLong(table1.getModel().getValueAt(table1.getSelectedRow(), 3).toString());
			String ngaybd = table1.getModel().getValueAt(table1.getSelectedRow(), 1).toString();

			int reply = JOptionPane.showConfirmDialog(null,
					"Xác nhận hũy phòng: " + maPhong + "\nNgười đặt: " + cmnd + "\nThời gian: " + ngaybd, null,
					JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {
				try {
					pdsd.huyPhong(maPhong, cmnd, ngaybd);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				DatPhong.main();
				setVisible(false);
			}
		});

		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (SwingUtilities.isRightMouseButton(e))
					pop.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}


