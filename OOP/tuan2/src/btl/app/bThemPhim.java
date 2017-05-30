package btl.app;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import btl.Phim;
import btl.Rap;
import btl.enums.DinhDang;
import btl.enums.TheLoai;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bThemPhim extends JFrame {
	ArrayList<String> dsTheLoai = new ArrayList<>();

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtThoiLuong;
	private JTextField txtMota;
	private JTextField txtGia;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bThemPhim frame = new bThemPhim();
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
	public bThemPhim() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Thêm phim");
		setBounds(400, 150, 290, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTnPhim = new JLabel("Tên Phim");
		lblTnPhim.setForeground(new Color(255, 255, 255));
		lblTnPhim.setBounds(10, 11, 86, 14);
		contentPane.add(lblTnPhim);

		JLabel lblnhGi = new JLabel("\u0110\u00E1nh gi\u00E1");
		lblnhGi.setForeground(new Color(255, 255, 255));
		lblnhGi.setBounds(10, 92, 86, 14);
		contentPane.add(lblnhGi);

		JLabel lblThiLng = new JLabel("Th\u1EDDi l\u01B0\u1EE3ng");
		lblThiLng.setForeground(new Color(255, 255, 255));
		lblThiLng.setBounds(10, 39, 86, 14);
		contentPane.add(lblThiLng);

		JLabel lblMT = new JLabel("M\u00F4 t\u1EA3");
		lblMT.setForeground(new Color(255, 255, 255));
		lblMT.setBounds(10, 165, 86, 14);
		contentPane.add(lblMT);

		JLabel lblGiV = new JLabel("Gi\u00E1 v\u00E9");
		lblGiV.setForeground(new Color(255, 255, 255));
		lblGiV.setBounds(10, 64, 86, 14);
		contentPane.add(lblGiV);

		JLabel lblTheLoai = new JLabel("Th\u1EC3 lo\u1EA1i");
		lblTheLoai.setForeground(new Color(255, 255, 255));
		lblTheLoai.setBounds(10, 114, 86, 14);
		contentPane.add(lblTheLoai);

		JLabel lblDinhDang = new JLabel("\u0110\u1ECBnh d\u1EA1ng");
		lblDinhDang.setForeground(new Color(255, 255, 255));
		lblDinhDang.setBounds(10, 140, 86, 14);
		contentPane.add(lblDinhDang);

		txtTen = new JTextField();
		txtTen.setBounds(90, 8, 174, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		String[] danhGia = { "1", "2", "3", "4", "5" };
		JComboBox txtDanhGia = new JComboBox(danhGia);
		txtDanhGia.setBounds(90, 89, 174, 20);
		contentPane.add(txtDanhGia);

		txtThoiLuong = new JTextField();
		txtThoiLuong.setBounds(90, 36, 174, 20);
		contentPane.add(txtThoiLuong);
		txtThoiLuong.setColumns(10);

		txtMota = new JTextField();
		txtMota.setBounds(90, 165, 174, 60);
		contentPane.add(txtMota);
		txtMota.setColumns(10);

		txtGia = new JTextField();
		txtGia.setBounds(90, 64, 174, 20);
		contentPane.add(txtGia);
		txtGia.setColumns(10);

		String[] theLoai = { TheLoai.HANHDONG.getS(), TheLoai.COTRANG.getS(), TheLoai.HAI.getS(),
				TheLoai.HOATHINH.getS(), TheLoai.KHOAHOCVIENTUONG.getS(), TheLoai.KINHDI.getS(), TheLoai.TAMLY.getS(),
				TheLoai.TINHCAM.getS() };
		JComboBox cbTheLoai = new JComboBox(theLoai);
		cbTheLoai.setBounds(90, 114, 126, 20);
		contentPane.add(cbTheLoai);

		String[] dinhdang = { DinhDang.DD.getS(), DinhDang.DDD.getS(), DinhDang.DDDDX.getS() };
		JComboBox cbDinhDang = new JComboBox(dinhdang);
		cbDinhDang.setBounds(90, 140, 126, 20);
		contentPane.add(cbDinhDang);

		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThm.setForeground(new Color(204, 0, 0));
		btnThm.setBounds(90, 239, 86, 23);
		contentPane.add(btnThm);
		btnThm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Rap rap = Menu.nhapRapTuFile();

					if (txtTen.getText().toString().equals("") || txtGia.getText().toString().equals("")
							|| txtDanhGia.getSelectedItem().toString().equals("")
							|| txtThoiLuong.getText().toString().equals("") || cbTheLoai == null
							|| cbDinhDang.getSelectedItem().toString().equals(""))
						throw new IOException();
					rap.themPhim(new Phim(rap.getDsPhim().size() + 1, txtTen.getText().toString(),
							Integer.parseInt(txtDanhGia.getSelectedItem().toString()),
							Integer.parseInt(txtThoiLuong.getText().toString()), txtMota.getText().toString(),
							Double.parseDouble(txtGia.getText().toString()), dsTheLoai,
							cbDinhDang.getSelectedItem().toString()));

					Menu.ghiRapVaoFile(rap);
					JOptionPane.showMessageDialog(null,
							"Thêm phim " + rap.getDsPhim().get(rap.getDsPhim().size() - 1).getTen() + " thành công");
					txtTen.setText("");
					txtGia.setText("");
					txtMota.setText("");
					txtDanhGia.setSelectedIndex(0);
					txtThoiLuong.setText("");
					cbTheLoai.setSelectedIndex(0);
					cbDinhDang.setSelectedIndex(0);
					dsTheLoai = new ArrayList<>();

				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Phải nhập các trường bắt buộc");
					e1.printStackTrace();
				}

			}
		});

		JButton btnThot = new JButton("Thoát");
		btnThot.setForeground(new Color(204, 0, 0));
		btnThot.setBounds(186, 239, 78, 23);
		contentPane.add(btnThot);
		btnThot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JButton btnThemTL = new JButton("+");
		btnThemTL.setForeground(new Color(204, 0, 0));
		btnThemTL.setBounds(223, 114, 41, 19);
		contentPane.add(btnThemTL);
		btnThemTL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (dsTheLoai.size() == 0) {
					dsTheLoai.add(cbTheLoai.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Đã thêm, danh sách thể loại hiện tai: " + dsTheLoai);
				} else
					for (String i : dsTheLoai)
						if (i.equals(cbTheLoai.getSelectedItem().toString())) {
							JOptionPane.showMessageDialog(null, "Thể loại đã có trong danh sách");
							break;
						} else {
							dsTheLoai.add(cbTheLoai.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, "Đã thêm, danh sách thể loại hiện tai: " + dsTheLoai);
						}

			}
		});

		JButton btnThemDD = new JButton("+");
		btnThemDD.setForeground(new Color(204, 0, 0));
		btnThemDD.setBounds(223, 140, 41, 19);
		contentPane.add(btnThemDD);
		btnThemDD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//setVisible(false);
			}
		});

	}
}
