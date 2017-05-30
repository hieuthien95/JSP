package btl.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import btl.NhanVien;
import btl.HoiVien;
import btl.Phim;
import btl.Rap;

public class aXemDSNhanVien extends JFrame {

	private JPanel contentPane;

	public aXemDSNhanVien() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Danh sách nhân viên");
		setBounds(400, 125, 700, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(new BorderLayout());

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		table.setVisible(true);

		JScrollPane pane = new JScrollPane(table);

		Rap rap = Menu.nhapRapTuFile();

		model.addColumn("CMND");
		model.addColumn("Tên");
		model.addColumn("SĐT");
		model.addColumn("Chức vụ");
		model.addColumn("Giờ tăng ca");
		


		TableColumn column = null;
		for (int i = 0; i < 5; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 1)
				column.setPreferredWidth(200);
			else
				column.setPreferredWidth(100);
		}

		for (NhanVien p : rap.getDsNhanVien()) {
			model.addRow(new Object[] { p.getCmnd(), p.getTen(), p.getSdt(), p.getChucVuNhanVien() , p.getSoGioTangCa() });
		}

		add(pane, BorderLayout.CENTER);
		pack();
	}

	public static void main() throws ClassNotFoundException, IOException {
		aXemDSNhanVien ds = new aXemDSNhanVien();
		ds.setBounds(400, 150, 600, 200);
		ds.setVisible(true);
	}
}