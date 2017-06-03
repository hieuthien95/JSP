package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Phong;
import control.LoaiPhong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class ThemPhong extends JFrame {

	private Phong p = new Phong();
	private JPanel contentPane;
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
					ThemPhong frame = new ThemPhong();
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
	public ThemPhong() throws SQLException {

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
		setTitle("Thêm phòng");
		setBounds(400, 150, 666, 344);
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
		lblNewLabel_2.setBounds(10, 73, 67, 17);
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

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(127, 201, 115, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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
		pane.setBounds(252, 8, 388, 286);

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
				ThemPhong.main();
				setVisible(false);
			}
		});

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(127, 167, 115, 23);
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

		
		// su kien right click
				RowPopup pop = new RowPopup();
				pop.addActionListener(e -> {
					String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
					int reply = JOptionPane.showConfirmDialog(null, "Xác nhận xóa phòng: " + maPhong, "",
							JOptionPane.YES_NO_OPTION);

					if (reply == JOptionPane.YES_OPTION) {
						Phong p = new Phong();
						p.xoaPhong(maPhong);
						
						ThemPhong.main();
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
