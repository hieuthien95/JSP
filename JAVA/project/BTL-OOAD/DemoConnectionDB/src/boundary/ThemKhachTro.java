package boundary;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.KhachTro;
import Entity.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;

public class ThemKhachTro extends JFrame {

	private KhachTro kt = new KhachTro();
	private JPanel contentPane;
	private JTextField txtHoTen;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtQuocTich;
	private JButton btnThem;
	private JTextField txtCmnd;
	private JTextField txtDiaChi;
	private JButton btnCapNhat;
	private JButton btnChon;
	private JTextField txtMaKhach;
	private JButton btnLamMoi;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemKhachTro frame = new ThemKhachTro();
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
	public ThemKhachTro() throws SQLException {

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
		setTitle("Thêm khách");
		setBounds(400, 150, 711, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Họ tên");
		lblNewLabel.setBounds(10, 11, 67, 14);
		contentPane.add(lblNewLabel);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(87, 8, 142, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CMND");
		lblNewLabel_1.setBounds(10, 42, 67, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Quốc tịch");
		lblNewLabel_3.setBounds(10, 104, 67, 14);
		contentPane.add(lblNewLabel_3);

		txtQuocTich = new JTextField();
		txtQuocTich.setBounds(87, 101, 145, 20);
		contentPane.add(txtQuocTich);
		txtQuocTich.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 132, 222, 23);
		contentPane.add(btnThem);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtHoTen.getText().toString().equals("") || txtQuocTich.getText().toString().equals("")
						|| txtDiaChi.getText().toString().equals("") || txtCmnd.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "Xin nhập đủ thông tin");
				else if (txtCmnd.getText().toString().length() < 9)
					JOptionPane.showMessageDialog(null, "CMND phải từ 9 ký tự");
				else {
					try {
						kt.themKhachTro(new KhachTro(txtHoTen.getText().toString(),
								Long.parseLong(txtCmnd.getText().toString()), txtDiaChi.getText().toString(),
								txtQuocTich.getText().toString()));
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(129, 200, 103, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		txtCmnd = new JTextField();
		txtCmnd.setColumns(10);
		txtCmnd.setBounds(87, 39, 86, 20);
		contentPane.add(txtCmnd);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(87, 70, 145, 20);
		contentPane.add(txtDiaChi);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(242, 8, 446, 249);

		model.addColumn("Mã khách");
		model.addColumn("Họ tên");
		model.addColumn("CMND");
		model.addColumn("Địa chỉ");

		for (KhachTro i : kt.getDsKhachTro()) {
			model.addRow(
					new Object[] { i.getMaKhach(), i.getHoTen(), i.getCmnd(), i.getDiaChi() + " " + i.getQuocTich() });
		}

		getContentPane().add(pane);

		txtMaKhach = new JTextField();
		pane.setColumnHeaderView(txtMaKhach);
		txtMaKhach.setEnabled(false);
		txtMaKhach.setColumns(10);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(10, 166, 109, 23);
		contentPane.add(btnXoa);
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cmnd = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();

				for (KhachTro i : kt.getDsKhachTro())
					if (i.getCmnd() == Integer.parseInt(cmnd))
						try {
							int reply = JOptionPane
									.showConfirmDialog(null,
											"Xác nhận xóa khách: \n" + i.getHoTen() + "\nCMND: " + cmnd + "\nĐ/c: "
													+ i.getDiaChi() + " " + i.getQuocTich(),
											"", JOptionPane.YES_NO_OPTION);

							if (reply == JOptionPane.YES_OPTION) {
								kt.xoaKhachTro(i.getCmnd());
							}

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
			}
		});

		btnChon = new JButton(">>");
		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnChon.setBounds(183, 39, 46, 20);
		contentPane.add(btnChon);
		btnChon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cmnd = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
				KhachTro kh = new KhachTro();
				for (KhachTro i : kt.getDsKhachTro())
					if (i.getCmnd() == Integer.parseInt(cmnd)) {
						kh = i;
						break;
					}

				txtMaKhach.setText(kh.getMaKhach() + "");
				txtHoTen.setText(kh.getHoTen());
				txtCmnd.setText(kh.getCmnd() + "");
				txtDiaChi.setText(kh.getDiaChi());
				txtQuocTich.setText(kh.getQuocTich());
			}
		});

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(129, 166, 103, 23);
		contentPane.add(btnCapNhat);
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachTro kt = new KhachTro();
				if (txtCmnd.getText().toString().length() < 9)
					JOptionPane.showMessageDialog(null, "CMND phải từ 8 ký tự");
				else {
					try {
						int reply = JOptionPane.showConfirmDialog(null,
								"Xác nhận xóa khách: \n" + txtHoTen.getText().toString() + "\nCMND: "
										+ txtCmnd.getText().toString() + "\nĐ/c: " + txtDiaChi.getText().toString()
										+ " " + txtQuocTich.getText().toString(),
								"", JOptionPane.YES_NO_OPTION);

						if (reply == JOptionPane.YES_OPTION) {
							kt.suaKhachTro(new KhachTro(Integer.parseInt(txtMaKhach.getText().toString()),
									txtHoTen.getText().toString(), Long.parseLong(txtCmnd.getText().toString()),
									txtDiaChi.getText().toString(), txtQuocTich.getText().toString()));
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(10, 201, 107, 23);
		contentPane.add(btnLamMoi);
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemKhachTro.main();
				setVisible(false);
			}
		});

		// su kien right click
		RowPopup pop = new RowPopup();
		pop.addActionListener(e -> {
			Long cmnd = Long.parseLong(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
			String ten = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
			try {
				int reply = JOptionPane.showConfirmDialog(null, "Xác nhận xóa khách: \n" + ten + "\nCMND: " + cmnd, "",
						JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					kt.xoaKhachTro(cmnd);

					ThemKhachTro.main();
					setVisible(false);
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
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
