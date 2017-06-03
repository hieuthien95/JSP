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

import btl.Phim;
import btl.Rap;

public class aXemDSPhim extends JFrame {

	private JPanel contentPane;

	public aXemDSPhim() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Danh sách phim");
		setBounds(400, 125, 700, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(new BorderLayout());

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		Rap rap = Menu.nhapRapTuFile();

		model.addColumn("Tên");
		model.addColumn("Thể loại");
		model.addColumn("Thời lượng");
		model.addColumn("Đánh giá");
		model.addColumn("Định dạng");
		model.addColumn("Giá");
		model.addColumn("Doanh thu");

		TableColumn column = null;
		for (int i = 0; i < 6; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0 || i == 1)
				column.setPreferredWidth(200);
			else
				column.setPreferredWidth(100);
		}

		Collections.sort(rap.getDsPhim(), new Comparator<Phim>() {
			@Override
			public int compare(Phim o1, Phim o2) {
				return -(o1.getMaSo() - o2.getMaSo());
			}
		});

		for (Phim p : rap.getDsPhim()) {
			model.addRow(new Object[] { p.getTen(), p.getTheLoai(), p.getThoiLuong(), p.getDanhGia(), p.getDinhDang(),
					(int) p.getGiaVe(), (int) p.getDoanhThu() });
		}

		add(pane);
		pack();
	}

	public static void main() throws ClassNotFoundException, IOException {
		aXemDSPhim ds = new aXemDSPhim();
		ds.setBounds(400, 150, 900, 400);
		ds.setVisible(true);
	}
}