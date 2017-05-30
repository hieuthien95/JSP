package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Phong;
import control.LoaiPhong;
import control.KhachSan;

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

public class SuaPhong extends JFrame {

	private Phong p = new Phong();
	private JPanel contentPane;
	private JTextField txtMaPhong;
	private JComboBox cbLoaiPhong;
	private JLabel lblNewLabel_2;
	private JComboBox cbSucChua;
	private JLabel lblNewLabel_3;
	private JTextField txtDonGia;
	private JButton btnCapNhat;
	private JLabel lblNhpMPhng;
	private JButton btnChon;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaPhong frame = new SuaPhong();
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
	public SuaPhong() throws SQLException {
		
		
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
		setTitle("Sửa phòng");
		setBounds(400, 150, 811, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã phòng");
		lblNewLabel.setBounds(10, 47, 67, 14);
		contentPane.add(lblNewLabel);

		txtMaPhong = new JTextField();
		txtMaPhong.setEnabled(false);
		txtMaPhong.setBounds(87, 44, 145, 20);
		contentPane.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Loại phòng");
		lblNewLabel_1.setBounds(10, 78, 67, 14);
		contentPane.add(lblNewLabel_1);

		cbLoaiPhong = new JComboBox(new Object[] { LoaiPhong.Thuong.getS(), LoaiPhong.CaoCap.getS() });
		cbLoaiPhong.setBounds(87, 75, 145, 20);
		contentPane.add(cbLoaiPhong);

		lblNewLabel_2 = new JLabel("Sức chứa");
		lblNewLabel_2.setBounds(10, 109, 67, 14);
		contentPane.add(lblNewLabel_2);

		String[] sucChua = { "2", "4", "6", "12" };
		cbSucChua = new JComboBox(sucChua);
		cbSucChua.setBounds(87, 106, 145, 20);
		contentPane.add(cbSucChua);

		lblNewLabel_3 = new JLabel("Đơn giá");
		lblNewLabel_3.setBounds(10, 140, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtDonGia = new JTextField();
		txtDonGia.setBounds(87, 137, 145, 20);
		contentPane.add(txtDonGia);
		txtDonGia.setColumns(10);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(10, 165, 103, 23);
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
				
				SuaPhong.main();
				setVisible(false);

			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(129, 165, 103, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		lblNhpMPhng = new JLabel("Chọn phòng");
		lblNhpMPhng.setBounds(10, 14, 67, 14);
		contentPane.add(lblNhpMPhng);

		Vector<String> VMaPhong = new Vector<String>();
		for (Phong i : p.getDsPhong())
			VMaPhong.add(i.getMaPhong());
		final JComboBox cbMaPhong = new JComboBox(VMaPhong);
		cbMaPhong.setBounds(87, 11, 95, 20);
		contentPane.add(cbMaPhong);

		btnChon = new JButton(">>");
		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnChon.setBounds(186, 11, 46, 20);
		contentPane.add(btnChon);
		btnChon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Phong p = new Phong();
				for (Phong i : p.getDsPhong())
					if (i.getMaPhong().equals(cbMaPhong.getSelectedItem().toString())) {
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
		});

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(242, 11, 543, 211);

		model.addColumn("Mã phòng");
		model.addColumn("Loại phòng");
		model.addColumn("Sức chứa");
		model.addColumn("Đơn giá");

		for (Phong p : p.getDsPhong()) {
			model.addRow(new Object[] { p.getMaPhong(), p.getLoaiPhong(), p.getSucChua(), p.getDonGia() });
		}

		getContentPane().add(pane);
	}
}
