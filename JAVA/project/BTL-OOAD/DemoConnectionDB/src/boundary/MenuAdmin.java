package boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Phong;
import control.LoaiPhong;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;
	private Phong p = new Phong();
	private JTextField txtMaPhong;
	private JComboBox cbLoaiPhong;
	private JLabel lblNewLabel_2;
	private JComboBox cbSucChua;
	private JLabel lblNewLabel_3;
	private JTextField txtDonGia;
	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnXoa;
	private JButton btnCapNhat;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		
		
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
		setTitle("Quyền Admin");
		setBounds(400, 125, 665, 348);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTcVChnh = new JMenu("Tác vụ chính");
		menuBar.add(mnTcVChnh);

		JMenuItem mntmtPhng = new JMenuItem("Đặt phòng");
		mntmtPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DatPhong.main();
			}
		});
		mnTcVChnh.add(mntmtPhng);

		JMenuItem mntmThanhTon = new JMenuItem("Thanh toán");
		mntmThanhTon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ThanhToan.main();
			}
		});
		mnTcVChnh.add(mntmThanhTon);

		JMenuItem mntmHyPhng = new JMenuItem("Hũy phòng");
		mntmHyPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				HuyPhong.main();
			}
		});
		mnTcVChnh.add(mntmHyPhng);

		JMenuItem mntmXemPhng = new JMenuItem("Xem phòng");
		mntmXemPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					XemPhong.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnTcVChnh.add(mntmXemPhng);

		JMenuItem mntmThot = new JMenuItem("Thoát");
		mntmThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});

		JMenuItem mntmPhngang = new JMenuItem("Phòng đang sử dụng");
		mntmPhngang.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					XemPhongDSD.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnTcVChnh.add(mntmPhngang);
		mnTcVChnh.add(mntmThot);

		JMenu mnPhong = new JMenu("Phòng trọ");
		menuBar.add(mnPhong);

		JMenuItem mntmThmPhng = new JMenuItem("Thêm phòng");
		mntmThmPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ThemPhong.main();
			}
		});
		mnPhong.add(mntmThmPhng);

		JMenuItem mntmXaPhng = new JMenuItem("Xóa phòng");
		mntmXaPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				XoaPhong.main();
			}
		});
		mnPhong.add(mntmXaPhng);

		JMenuItem mntmCpNhtPhng = new JMenuItem("Cập nhật phòng");
		mntmCpNhtPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SuaPhong.main();
			}
		});
		mnPhong.add(mntmCpNhtPhng);

		JMenuItem mntmDanhSchPhng = new JMenuItem("Danh sách phòng");
		mntmDanhSchPhng.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					XemPhong.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnPhong.add(mntmDanhSchPhng);

		JMenu mnKhchTr = new JMenu("Khách trọ");
		menuBar.add(mnKhchTr);

		JMenuItem mntmThmKhch = new JMenuItem("Thêm khách");
		mntmThmKhch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ThemKhachTro.main();
			}
		});
		mnKhchTr.add(mntmThmKhch);

		JMenuItem mntmXaKhch = new JMenuItem("Xóa khách");
		mntmXaKhch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				XoaKhachTro.main();
			}
		});
		mnKhchTr.add(mntmXaKhch);

		JMenuItem mntmSaKhch = new JMenuItem("Cập nhật khách");
		mntmSaKhch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SuaKhach.main();
			}
		});
		mnKhchTr.add(mntmSaKhch);

		JMenuItem mntmDanhSchKhch = new JMenuItem("Danh sách khách trọ");
		mntmDanhSchKhch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					XemKhach.main();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnKhchTr.add(mntmDanhSchKhch);

		JMenuItem mntmThmNgiThu = new JMenuItem("Thêm người thuê");
		mntmThmNgiThu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ThemThanhVienThue.main();
			}
		});
		mnKhchTr.add(mntmThmNgiThu);

		JMenuItem mntmXaNgiThu = new JMenuItem("Xóa người thuê");
		mntmXaNgiThu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				XoaThanhVienThue.main();
			}
		});
		mnKhchTr.add(mntmXaNgiThu);

		JMenu mnThngK = new JMenu("Thống kê");
		mnThngK.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ThongKe.main();
			}
		});
		menuBar.add(mnThngK);

		JMenu mnTmKim = new JMenu("Tìm kiếm");
		mnTmKim.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TimKiem.main();
			}
		});
		menuBar.add(mnTmKim);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 67, 17);
		contentPane.add(lblNewLabel);

		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(97, 10, 145, 20);
		contentPane.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Loại phòng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 42, 67, 17);
		contentPane.add(lblNewLabel_1);

		String[] loaiPhong = { LoaiPhong.Thuong.getS(), LoaiPhong.CaoCap.getS() };
		cbLoaiPhong = new JComboBox(loaiPhong);
		cbLoaiPhong.setBounds(97, 41, 145, 20);
		contentPane.add(cbLoaiPhong);

		lblNewLabel_2 = new JLabel("Sức chứa");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 73, 85, 17);
		contentPane.add(lblNewLabel_2);

		String[] sucChua = { "2", "4", "6", "12" };
		cbSucChua = new JComboBox(sucChua);
		cbSucChua.setBounds(97, 72, 145, 20);
		contentPane.add(cbSucChua);

		lblNewLabel_3 = new JLabel("Đơn giá");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 104, 46, 17);
		contentPane.add(lblNewLabel_3);

		txtDonGia = new JTextField();
		txtDonGia.setBounds(97, 103, 145, 20);
		contentPane.add(txtDonGia);
		txtDonGia.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 133, 232, 23);
		contentPane.add(btnThem);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtMaPhong.getText().toString().equals("") || txtDonGia.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "Xin nhập đủ thông tin");
				else {
					boolean trungMaPhong = false;
					for (Phong i : p.getDsPhong())
						if (i.getMaPhong().equals(txtMaPhong.getText().toString())) {
							JOptionPane.showMessageDialog(null, "Trùng mã phòng");
							trungMaPhong = true;
						}

					if (trungMaPhong == false) {

						try {
							p.themPhong(
									new Phong(txtMaPhong.getText().toString(), cbLoaiPhong.getSelectedItem().toString(),
											Integer.parseInt(cbSucChua.getSelectedItem().toString()),
											Integer.parseInt(txtDonGia.getText().toString())));
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}

			}
		});

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
					Phong p = new Phong();
					for (Phong i : p.getDsPhong())
						if (i.getMaPhong().equals(maPhong)) {
							p = i;
							break;
						}
					txtMaPhong.setText(p.getMaPhong());
					txtDonGia.setText(p.getDonGia() + "");
					int chua = p.getSucChua();
					cbSucChua.setSelectedIndex((chua == 2) ? 0 : (chua == 4) ? 1 : (chua == 6) ? 2 : 3);
					String loai = p.getLoaiPhong();
					cbLoaiPhong.setSelectedIndex(loai.equals(LoaiPhong.Thuong.getS()) ? 0 : 1);
				}
			}
		});

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(252, 8, 388, 269);

		model.addColumn("Mã phòng");
		model.addColumn("Loại phòng");
		model.addColumn("Sức chứa");
		model.addColumn("Đơn giá");

		for (Phong p : p.getDsPhong()) {
			model.addRow(new Object[] { p.getMaPhong(), p.getLoaiPhong(), p.getSucChua(), p.getDonGia() });
		}

		getContentPane().add(pane);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(10, 201, 107, 23);
		contentPane.add(btnLamMoi);
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuAdmin.main();
				setVisible(false);
			}
		});

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(127, 168, 115, 23);
		contentPane.add(btnXoa);
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				int reply = JOptionPane.showConfirmDialog(null, "Xác nhận xóa phòng: " + maPhong, "",
						JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					Phong p = new Phong();
					p.xoaPhong(maPhong);
				}
			}
		});

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(10, 168, 107, 23);
		contentPane.add(btnCapNhat);
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Phong p = new Phong();
				if (txtDonGia.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "Xin nhập đủ thông tin");
				else {
					try {

						int reply = JOptionPane.showConfirmDialog(null,
								"Xác nhận cập nhật phòng: " + txtMaPhong.getText().toString(), "",
								JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							p.suaPhong(
									new Phong(txtMaPhong.getText().toString(), cbLoaiPhong.getSelectedItem().toString(),
											Integer.parseInt(cbSucChua.getSelectedItem().toString()),
											Integer.parseInt(txtDonGia.getText().toString())));
						}

					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnThoat.setBounds(127, 201, 115, 22);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});
		
		
		// su kien right click
		RowPopup pop = new RowPopup();
		pop.addActionListener(e -> {
			String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			int reply = JOptionPane.showConfirmDialog(null, "Xác nhận xóa phòng: " + maPhong, "",
					JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {
				Phong p = new Phong();
				p.xoaPhong(maPhong);
				
				MenuAdmin.main();
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
