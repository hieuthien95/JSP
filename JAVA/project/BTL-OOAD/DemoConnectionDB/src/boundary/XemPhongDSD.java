package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

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

import Entity.PhongDangSuDung;

public class XemPhongDSD extends JFrame {

	private PhongDangSuDung pdsd = new PhongDangSuDung();
	private JPanel contentPane;
	private JTable table;

	public XemPhongDSD() throws ClassNotFoundException, IOException {
		
		
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
		setTitle("Phòng đang sử dụng");
		setBounds(400, 125, 700, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(new BorderLayout());

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		model.addColumn("Mã phòng");
		model.addColumn("Ngày bắt đầu");
		model.addColumn("Ngày kết thúc");
		model.addColumn("CMND");

		for (PhongDangSuDung p : pdsd.getDsPhongDangSuDung()) {
			model.addRow(new Object[] { p.getMaPhongThue(), p.getNgayBatDau(), p.getNgayKetThuc(), p.getCmnd() });
		}

		add(pane);
		pack();
		
		
		// su kien right click
				RowPopup pop = new RowPopup();
				pop.addActionListener(e -> {
					String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
					Long cmnd = Long.parseLong(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
					String ngaybd = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();

					int reply = JOptionPane.showConfirmDialog(null,
							"Xác nhận hũy phòng: " + maPhong + "\nNgười đặt: " + cmnd + "\nThời gian: " + ngaybd, null,
							JOptionPane.YES_NO_OPTION);

					if (reply == JOptionPane.YES_OPTION) {
						try {
							pdsd.huyPhong(maPhong, cmnd, ngaybd);
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						try {
							XemPhongDSD.main();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
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

	public static void main() throws ClassNotFoundException, IOException {
		XemPhongDSD ds = new XemPhongDSD();
		ds.setBounds(400, 150, 800, 300);
		ds.setVisible(true);
	}
}