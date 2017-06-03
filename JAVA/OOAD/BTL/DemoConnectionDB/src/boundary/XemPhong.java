package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

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

public class XemPhong extends JFrame {

	private JPanel contentPane;
	private Phong p = new Phong();

	public XemPhong() throws ClassNotFoundException, IOException {
		
		
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
		setTitle("Danh sách phòng");
		setBounds(400, 125, 700, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(new BorderLayout());

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		model.addColumn("Mã phòng");
		model.addColumn("Loại phòng");
		model.addColumn("Sức chứa");
		model.addColumn("Đơn giá");

		for (Phong p : p.getDsPhong()) {
			model.addRow(new Object[] { p.getMaPhong(), p.getLoaiPhong(), p.getSucChua(), p.getDonGia()});
		}

		add(pane);
		pack();
	}

	public static void main() throws ClassNotFoundException, IOException {
		XemPhong ds = new XemPhong();
		ds.setBounds(400, 150, 800, 300);
		ds.setVisible(true);
	}
}