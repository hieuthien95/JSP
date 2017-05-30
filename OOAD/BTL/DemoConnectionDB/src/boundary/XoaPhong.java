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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class XoaPhong extends JFrame {

	private Phong p = new Phong();
	private JPanel contentPane;
	private JComboBox cbMaPhong;
	private JButton btnXoa;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XoaPhong frame = new XoaPhong();
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
	public XoaPhong() throws SQLException {

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
		setTitle("Xóa phòng");
		setBounds(400, 150, 701, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Chọn phòng");
		lblNewLabel_1.setBounds(10, 14, 67, 14);
		contentPane.add(lblNewLabel_1);

		Vector<String> dsMaPhong = new Vector<String>();
		for (Phong i : p.getDsPhong())
			dsMaPhong.add(i.getMaPhong());

		cbMaPhong = new JComboBox<String>(dsMaPhong);
		cbMaPhong.setBounds(87, 11, 145, 20);
		contentPane.add(cbMaPhong);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(242, 8, 433, 270);

		model.addColumn("Mã phòng");
		model.addColumn("Loại phòng");
		model.addColumn("Sức chứa");
		model.addColumn("Đơn giá");

		for (Phong p : p.getDsPhong()) {
			model.addRow(new Object[] { p.getMaPhong(), p.getLoaiPhong(), p.getSucChua(), p.getDonGia() });
		}

		getContentPane().add(pane);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(10, 42, 109, 23);
		contentPane.add(btnXoa);
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Xác nhận xóa phòng: " + cbMaPhong.getSelectedItem().toString(), "", JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					Phong p = new Phong();
					p.xoaPhong(cbMaPhong.getSelectedItem().toString());
				}

				XoaPhong.main();
				setVisible(false);
			}
		});

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(129, 42, 103, 23);
		contentPane.add(btnThoat);
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

				XoaPhong.main();
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
