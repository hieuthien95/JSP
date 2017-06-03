package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.KhachTro;
import Entity.Phong;

public class XemKhach extends JFrame {

	private JPanel contentPane;
	private KhachTro p = new KhachTro();

	public XemKhach() throws ClassNotFoundException, IOException {
		
		
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
		setTitle("Danh sách khách hàng");
		setBounds(400, 125, 700, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(new BorderLayout());

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		model.addColumn("Mã khách");
		model.addColumn("Họ tên");
		model.addColumn("CMND");
		model.addColumn("Địa chỉ");

		for (KhachTro i : p.getDsKhachTro()) {
			model.addRow(new Object[] { i.getMaKhach(), i.getHoTen(), i.getCmnd(), i.getDiaChi()+ " " + i.getQuocTich()});
		}

		add(pane);
		pack();
		
		
		
		// su kien right click
		RowPopup pop = new RowPopup();
		pop.addActionListener(e -> {
			KhachTro kt = new KhachTro();
			Long cmnd = Long.parseLong(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
			String ten = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
			try {
				int reply = JOptionPane.showConfirmDialog(null, "Xác nhận xóa khách: \n" + ten + "\nCMND: " + cmnd, "",
						JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					kt.xoaKhachTro(cmnd);

					try {
						XemKhach.main();
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

	public static void main() throws ClassNotFoundException, IOException {
		XemKhach ds = new XemKhach();
		ds.setBounds(400, 150, 800, 300);
		ds.setVisible(true);
	}
}