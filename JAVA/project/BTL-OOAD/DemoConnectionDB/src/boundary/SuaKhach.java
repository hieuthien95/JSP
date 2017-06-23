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
import control.KhachSan;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

public class SuaKhach extends JFrame {

	private KhachTro kt = new KhachTro();
	private JPanel contentPane;
	private JButton btnCapNhat;
	private JTextField txtHoTen;
	private JTextField txtCmnd;
	private JTextField txtDiaChi;
	private JTextField txtQuocTich;
	private JTextField txtCmndNhap;
	private JLabel lblNhpCmnd;
	private JButton btnChon;
	private JTextField txtMaKhach;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaKhach frame = new SuaKhach();
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
	public SuaKhach() throws SQLException {
		
		
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
		setTitle("Sửa khách");
		setBounds(400, 150, 718, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(10, 155, 103, 23);
		contentPane.add(btnCapNhat);
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachTro kt = new KhachTro();
				if (txtCmnd.getText().toString().length()<9)
					JOptionPane.showMessageDialog(null, "CMND phải từ 8 ký tự");
				else 
					try {
						kt.suaKhachTro(new KhachTro(Integer.parseInt(txtMaKhach.getText().toString()),
								txtHoTen.getText().toString(), Long.parseLong(txtCmnd.getText().toString()),
								txtDiaChi.getText().toString(), txtQuocTich.getText().toString()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
				SuaKhach.main();
				setVisible(false);
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(129, 155, 103, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setBounds(10, 43, 46, 14);
		contentPane.add(lblHTn);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(79, 40, 153, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(10, 71, 46, 14);
		contentPane.add(lblCmnd);

		txtCmnd = new JTextField();
		txtCmnd.setColumns(10);
		txtCmnd.setBounds(79, 68, 103, 20);
		contentPane.add(txtCmnd);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(10, 99, 46, 14);
		contentPane.add(lblaCh);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(79, 96, 153, 20);
		contentPane.add(txtDiaChi);

		JLabel lblQucTch = new JLabel("Quốc tịch");
		lblQucTch.setBounds(10, 127, 59, 14);
		contentPane.add(lblQucTch);

		txtQuocTich = new JTextField();
		txtQuocTich.setColumns(10);
		txtQuocTich.setBounds(79, 124, 153, 20);
		contentPane.add(txtQuocTich);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(242, 8, 450, 261);

		model.addColumn("Mã khách");
		model.addColumn("Họ tên");
		model.addColumn("CMND");
		model.addColumn("Địa chỉ");

		for (KhachTro i : kt.getDsKhachTro()) {
			model.addRow(
					new Object[] { i.getMaKhach(), i.getHoTen(), i.getCmnd(), i.getDiaChi() + " " + i.getQuocTich() });
		}

		getContentPane().add(pane);

		btnChon = new JButton(">>");
		btnChon.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnChon.setBounds(186, 12, 46, 20);
		contentPane.add(btnChon);
		btnChon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachTro kh = new KhachTro();
				for (KhachTro i : kt.getDsKhachTro())
					if (i.getCmnd() == Integer.parseInt(txtCmndNhap.getText().toString())) {
						kh = i;
						break;
					}

				txtMaKhach.setText(kh.getMaKhach() + "");
				txtHoTen.setText(kh.getHoTen());
				txtCmnd.setText(kh.getCmnd() + "");
				txtDiaChi.setText(kh.getDiaChi());
				txtQuocTich.setText(kh.getQuocTich());
				txtCmndNhap.setEnabled(false);
			}
		});

		txtCmndNhap = new JTextField();
		txtCmndNhap.setColumns(10);
		txtCmndNhap.setBounds(79, 12, 103, 20);
		contentPane.add(txtCmndNhap);

		lblNhpCmnd = new JLabel("Nhập CMND");
		lblNhpCmnd.setBounds(10, 15, 67, 14);
		contentPane.add(lblNhpCmnd);

		txtMaKhach = new JTextField();
		txtMaKhach.setEnabled(false);
		txtMaKhach.setColumns(10);
		txtMaKhach.setBounds(186, 68, 46, 20);
		contentPane.add(txtMaKhach);
		
	}
}
