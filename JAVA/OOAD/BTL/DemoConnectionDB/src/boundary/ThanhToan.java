package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.LanThuePhong;
import Entity.Phong;
import Entity.PhongDangSuDung;
import control.KhachSan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class ThanhToan extends JFrame {

	private Phong p=new Phong();
	private KhachSan ks = new KhachSan();
	private LanThuePhong pdsd = new LanThuePhong();
	
	private JPanel contentPane;
	private JComboBox<String> cbMaPhong;
	private JButton btThanhToan;
	private JTextField txtTienDV;
	private JTextField txtGioThue;
	private JComboBox<String> cbNgayDat;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan frame = new ThanhToan();
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
	public ThanhToan() throws SQLException {
		
		
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
		setTitle("Thanh toán");
		setBounds(400, 150, 686, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(10, 14, 67, 14);
		contentPane.add(lblNewLabel_1);

		Vector<String> dsMaPhong = new Vector<String>();
		for (Phong i : p.getDsPhong())
			dsMaPhong.add(i.getMaPhong());

		cbMaPhong = new JComboBox<String>(dsMaPhong);
		cbMaPhong.setBounds(87, 11, 91, 20);
		contentPane.add(cbMaPhong);

		JLabel lblTinDv = new JLabel("Tiền DV");
		lblTinDv.setBounds(10, 69, 67, 14);
		contentPane.add(lblTinDv);

		JLabel lblGiThu = new JLabel("Giờ thuê");
		lblGiThu.setBounds(10, 97, 67, 14);
		contentPane.add(lblGiThu);

		txtTienDV = new JTextField();
		txtTienDV.setBounds(87, 66, 145, 20);
		contentPane.add(txtTienDV);
		txtTienDV.setColumns(10);

		txtGioThue = new JTextField();
		txtGioThue.setColumns(10);
		txtGioThue.setBounds(87, 94, 145, 20);
		contentPane.add(txtGioThue);

		cbNgayDat = new JComboBox<String>();
		cbNgayDat.setBounds(87, 38, 145, 20);
		contentPane.add(cbNgayDat);

		lblNewLabel = new JLabel("Ngày đặt");
		lblNewLabel.setBounds(10, 41, 67, 14);
		contentPane.add(lblNewLabel);

		btThanhToan = new JButton("Thanh toán");
		btThanhToan.setBounds(10, 122, 103, 23);
		contentPane.add(btThanhToan);
		btThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean coP = false;
					for (LanThuePhong i : pdsd.getDsLanThuePhong())
						if (i.getMaPhongThue().equals(cbMaPhong.getSelectedItem().toString())) {
							ks.thanhToan(cbMaPhong.getSelectedItem().toString(),
									cbNgayDat.getSelectedItem().toString(),
									Double.parseDouble(txtTienDV.getText().toString()),
									Integer.parseInt(txtGioThue.getText().toString()), 2);
							coP = true;
							break;
						}

					if (coP == false)
						JOptionPane.showMessageDialog(null, "Không tìm thấy mã phòng");

				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				ThanhToan.main();
				setVisible(false);
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(129, 122, 103, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JButton btnChon = new JButton(">>");
		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnChon.setBounds(186, 11, 46, 19);
		contentPane.add(btnChon);
		btnChon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbNgayDat.removeAllItems();
				for (PhongDangSuDung i : pdsd.getDsPhongDangSuDung())
					if (i.getMaPhongThue().equals(cbMaPhong.getSelectedItem().toString()))
						cbNgayDat.addItem(i.getNgayBatDau());

			}
		});

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(242, 11, 418, 241);

		model.addColumn("Mã phòng");
		model.addColumn("Ngày bắt đầu");
		model.addColumn("Ngày kết thúc");
		model.addColumn("CMND");

		for (PhongDangSuDung p : pdsd.getDsPhongDangSuDung()) {
			model.addRow(new Object[] { p.getMaPhongThue(), p.getNgayBatDau(), p.getNgayKetThuc(), p.getCmnd() });
		}

		getContentPane().add(pane);
		
		
		
		
	}
}
