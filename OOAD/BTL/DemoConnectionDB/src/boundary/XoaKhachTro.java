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

import Entity.KhachTro;
import Entity.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.Color;

public class XoaKhachTro extends JFrame {

	private KhachTro kt = new KhachTro();
	private JPanel contentPane;
	private JButton btnXoa;
	private JTextField txtCmnd;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XoaKhachTro frame = new XoaKhachTro();
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
	public XoaKhachTro() throws SQLException {

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
		setTitle("Xóa khách");
		setBounds(400, 150, 703, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CMND");
		lblNewLabel_1.setBounds(10, 11, 67, 14);
		contentPane.add(lblNewLabel_1);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(242, 8, 435, 254);

		model.addColumn("Mã khách");
		model.addColumn("Họ tên");
		model.addColumn("CMND");
		model.addColumn("Địa chỉ");

		for (KhachTro i : kt.getDsKhachTro()) {
			model.addRow(
					new Object[] { i.getMaKhach(), i.getHoTen(), i.getCmnd(), i.getDiaChi() + " " + i.getQuocTich() });
		}

		getContentPane().add(pane);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(10, 36, 103, 23);
		contentPane.add(btnXoa);
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtCmnd.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "Xin nhập đủ thông tin");
				else {
					for (KhachTro i : kt.getDsKhachTro())
						if (i.getCmnd() == Integer.parseInt(txtCmnd.getText().toString()))
							try {
								int reply = JOptionPane
										.showConfirmDialog(
												null, "Xác nhận xóa khách: \n" + i.getHoTen() + "\nĐ/c: "
														+ i.getDiaChi() + " " + i.getQuocTich(),
												"", JOptionPane.YES_NO_OPTION);

								if (reply == JOptionPane.YES_OPTION) {
									kt.xoaKhachTro(i.getCmnd());
								}

							} catch (SQLException e1) {
								e1.printStackTrace();
							}
				}

				XoaKhachTro.main();
				setVisible(false);
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(129, 36, 103, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		txtCmnd = new JTextField();
		txtCmnd.setColumns(10);
		txtCmnd.setBounds(87, 8, 145, 20);
		contentPane.add(txtCmnd);

		// su kien right click
		RowPopup pop = new RowPopup();
		pop.addActionListener(e -> {
			Long cmnd = Long.parseLong(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
			String ten = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
			try {
				int reply = JOptionPane.showConfirmDialog(null,
						"Xác nhận xóa khách: \n" + ten + "\nCMND: " + cmnd ,
						"", JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					kt.xoaKhachTro(cmnd);
					
					XoaKhachTro.main();
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
