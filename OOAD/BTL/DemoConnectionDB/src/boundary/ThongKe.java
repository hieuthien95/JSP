package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.LanThanhToan;
import Entity.Phong;
import Entity.PhongDangSuDung;
import control.KhachSan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.HeadlessException;

public class ThongKe extends JFrame {

	private KhachSan ks = new KhachSan();
	private JPanel contentPane;
	private JButton btnThongKeTienPhong;
	private JLabel lblNhpMPhng;
	private JButton btnThongKeTienDV;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane pane;
	private JComboBox<String> cbNamBD;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe frame = new ThongKe();
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
	public ThongKe() throws SQLException {

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
		setTitle("Thống kê");
		setBounds(400, 150, 657, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		final JComboBox cbThang = new JComboBox(thang);
		cbThang.setBounds(56, 11, 98, 20);
		contentPane.add(cbThang);
		
		Calendar cBD = Calendar.getInstance();
		int nowBD = cBD.get(Calendar.YEAR);
		String[] namBD = {(nowBD -2) + "",(nowBD -1) + "", nowBD + "" };
		
		JComboBox CbNamBD = new JComboBox(namBD);
		CbNamBD.setBounds(56, 42, 98, 20);
		contentPane.add(CbNamBD);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setBounds(10, 45, 67, 14);
		contentPane.add(lblNm);

		model = new DefaultTableModel();
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(164, 11, 467, 241);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(10, 141, 144, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		lblNhpMPhng = new JLabel("Tháng");
		lblNhpMPhng.setBounds(10, 14, 67, 14);
		contentPane.add(lblNhpMPhng);

		btnThongKeTienPhong = new JButton("Thống kê tiền phòng");
		btnThongKeTienPhong.setBounds(10, 73, 144, 23);
		contentPane.add(btnThongKeTienPhong);
		btnThongKeTienPhong.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(CbNamBD.getSelectedItem().toString());
				KhachSan ks = new KhachSan();
				try {
					ArrayList<LanThanhToan> dsltt = new ArrayList<>();
					int thangbd = Integer.parseInt(cbThang.getSelectedItem().toString());
					int nambd = Integer.parseInt(CbNamBD.getSelectedItem().toString());
					dsltt = ks.thongKeTienPhong(thangbd, nambd);

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Mã thanh toán");
					model.addColumn("Ngày thanh toán");
					model.addColumn("Tiền");

					double tien = 0;
					for (LanThanhToan p : dsltt) {
						model.addRow(new Object[] { p.getMaThanhToan(), p.getNgayThanhToan(), p.getSoTienPhong() });
						tien = tien + p.getSoTienPhong();
					}
					model.addRow(new Object[] { "", "", tien });

					table.setModel(model);

					getContentPane().add(pane);
				} catch (NumberFormatException | ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnThongKeTienDV = new JButton("Thống kê tiền DV");
		btnThongKeTienDV.setBounds(10, 107, 144, 23);
		contentPane.add(btnThongKeTienDV);
		btnThongKeTienDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<LanThanhToan> dsltt = new ArrayList<>();
					int thangbd = Integer.parseInt(cbThang.getSelectedItem().toString());
					int nambd = Integer.parseInt(CbNamBD.getSelectedItem().toString());
					dsltt = ks.thongKeTienPhong(thangbd, nambd);

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Mã thanh toán");
					model.addColumn("Ngày thanh toán");
					model.addColumn("Tiền");

					double tien = 0;
					for (LanThanhToan p : dsltt) {
						model.addRow(new Object[] { p.getMaThanhToan(), p.getNgayThanhToan(), p.getSoTienDV() });
						tien = tien + p.getSoTienDV();
					}
					model.addRow(new Object[] { "", "", tien });

					table.setModel(model);

					getContentPane().add(pane);

				} catch (NumberFormatException | ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
