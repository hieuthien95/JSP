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

import Entity.KhachTro;
import Entity.Phong;
import Entity.PhongDangSuDung;
import control.KhachSan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ValueTimKiem extends JFrame {

	private Phong p=new Phong();
	private KhachSan ks = new KhachSan();
	private PhongDangSuDung pdsd = new PhongDangSuDung();
	
	private JPanel contentPane;
	private JButton btnTim;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValueTimKiem frame = new ValueTimKiem();
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
	public ValueTimKiem() throws SQLException {
		
		
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
		setTitle("Tìm kiếm");
		setBounds(400, 150, 380, 118);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(new BorderLayout());

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		model.addColumn("Mã khách");
		model.addColumn("CMND");
		model.addColumn("Tên");
		model.addColumn("Địa chỉ");
		model.addColumn("Quốc tịch");

		for (KhachTro i: TimKiem.dsKhachTro) {
			model.addRow(new Object[] { i.getMaKhach(), i.getCmnd(), i.getHoTen(), i.getDiaChi(), i.getQuocTich()});
		}

		add(pane);
		pack();
		
		
		
		// su kien right click
		RowPopup pop = new RowPopup();
		pop.addActionListener(e -> {
			KhachTro kt = new KhachTro();
			Long cmnd = Long.parseLong(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			String ten = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
			try {
				int reply = JOptionPane.showConfirmDialog(null, "Xác nhận xóa khách: \n" + ten + "\nCMND: " + cmnd, "",
						JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					kt.xoaKhachTro(cmnd);

					try {
						ValueTimKiem.main();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
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
