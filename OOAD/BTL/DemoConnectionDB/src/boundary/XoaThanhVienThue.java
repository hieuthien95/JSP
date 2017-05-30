package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.LanThuePhong;
import Entity.Phong;
import Entity.PhongDangSuDung;
import Entity.ThanhVienThue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JSpinner;

public class XoaThanhVienThue extends JFrame {

	private Phong p = new Phong();
	private ThanhVienThue tvt = new ThanhVienThue();
	private LanThuePhong ltp = new LanThuePhong();
	private PhongDangSuDung pdsd = new PhongDangSuDung();
	private JPanel contentPane;
	private JComboBox<String> cbMaPhong;
	private JButton btnXoa;
	private JTextField txtCmnd;
	private JSpinner sphhBD;
	private JSpinner spmmBD;
	private JComboBox<String> cbNamBD;
	private JComboBox<String> cbThangBD;
	private JComboBox<String> cbNgayBD;
	JComboBox<String> cbNgayDat;
	boolean chon = false;

	private JComboBox<String> cbaaBD;
	private JLabel lblNgyt;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XoaThanhVienThue frame = new XoaThanhVienThue();
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
	public XoaThanhVienThue() throws SQLException {
		
		
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
		setTitle("Xóa thành viên thuê");
		setBounds(400, 150, 288, 240);
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

		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(10, 17, 55, 14);
		contentPane.add(lblNewLabel_1);

		Vector<String> dsMaPhong = new Vector<String>();
		for (Phong i : p.getDsPhong())
			dsMaPhong.add(i.getMaPhong());

		JLabel label;
		lblNgyt = new JLabel("Ngày đặt");
		lblNgyt.setBounds(10, 73, 53, 14);
		contentPane.add(lblNgyt);

		sphhBD = new JSpinner(hourBDModel);
		sphhBD.setBounds(66, 71, 46, 20);
		contentPane.add(sphhBD);

		label = new JLabel(":");
		label.setBounds(122, 74, 7, 14);
		contentPane.add(label);

		spmmBD = new JSpinner(minuteBDModel);
		spmmBD.setBounds(135, 71, 46, 20);
		contentPane.add(spmmBD);

		String[] loaiPhongBD = { "AM", "PM" };
		cbaaBD = new JComboBox<String>(loaiPhongBD);
		cbaaBD.setBounds(200, 71, 62, 20);
		contentPane.add(cbaaBD);

		cbNgayBD = new JComboBox<String>(ngayBD);
		cbNgayBD.setBounds(66, 102, 46, 20);
		contentPane.add(cbNgayBD);

		cbThangBD = new JComboBox<String>(thangBD);
		cbThangBD.setBounds(135, 102, 46, 20);
		contentPane.add(cbThangBD);

		cbNamBD = new JComboBox<String>(namBD);
		cbNamBD.setBounds(201, 102, 61, 20);
		contentPane.add(cbNamBD);

		cbMaPhong = new JComboBox<String>(dsMaPhong);
		cbMaPhong.setBounds(66, 14, 115, 20);
		contentPane.add(cbMaPhong);

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(10, 45, 46, 14);
		contentPane.add(lblCmnd);

		txtCmnd = new JTextField();
		txtCmnd.setBounds(66, 42, 196, 20);
		contentPane.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(122, 105, 7, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("/");
		label_2.setBounds(189, 105, 7, 14);
		contentPane.add(label_2);
		
		JLabel lblNgyt_1 = new JLabel("Ngày đặt");
		lblNgyt_1.setBounds(10, 136, 53, 14);
		contentPane.add(lblNgyt_1);
		
		cbNgayDat = new JComboBox<String>();
		cbNgayDat.setBounds(66, 133, 196, 20);
		contentPane.add(cbNgayDat);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(10, 167, 119, 23);
		contentPane.add(btnXoa);
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (txtCmnd.getText().toString().equals(""))
					JOptionPane.showMessageDialog(null, "Phải nhập đầy đủ");
				else {
					try {
						int maThuePhong=0;
						if(!chon){
							String ngayBD = sphhBD.getValue().toString() + ":" + spmmBD.getValue().toString() + " "
								+ cbaaBD.getSelectedItem().toString() + " " + cbNgayBD.getSelectedItem().toString() + "/"
								+ cbThangBD.getSelectedItem().toString() + "/" + cbNamBD.getSelectedItem().toString();
							for(LanThuePhong i: ltp.getDsLanThuePhong())
								if(i.getNgayBatDau().equals(ngayBD))
									maThuePhong=i.getMaLanThuePhong();
							
							tvt.xoaThanhVienThue(Long.parseLong(txtCmnd.getText().toString()), maThuePhong);
						
						}
						else{
							for(LanThuePhong i: ltp.getDsLanThuePhong())
								if(i.getNgayBatDau().equals(cbNgayDat.getSelectedItem().toString()))
									maThuePhong=i.getMaLanThuePhong();
							
							tvt.xoaThanhVienThue(Long.parseLong(txtCmnd.getText().toString()), maThuePhong);
							
							cbNgayDat.removeAllItems();
							for(PhongDangSuDung i: pdsd.getDsPhongDangSuDung())
								if(i.getMaPhongThue().equals(cbMaPhong.getSelectedItem().toString()))
									cbNgayDat.addItem(i.getNgayBatDau().toString());
							chon=false;
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(143, 167, 119, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
		JButton btnChon = new JButton(">>");
		btnChon.setBounds(200, 14, 62, 20);
		contentPane.add(btnChon);
		btnChon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbNgayDat.removeAllItems();
				for(LanThuePhong i: ltp.getDsLanThuePhong())
					if(i.getMaPhongThue().equals(cbMaPhong.getSelectedItem().toString()))
						cbNgayDat.addItem(i.getNgayBatDau().toString());
				chon=true;
			}
		});
		
	}
}
