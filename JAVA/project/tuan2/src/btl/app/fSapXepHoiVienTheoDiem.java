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

import btl.HoiVien;
import btl.Phim;
import btl.Rap;

public class fSapXepHoiVienTheoDiem extends JFrame {

	private JPanel contentPane;
	
	public fSapXepHoiVienTheoDiem() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Điểm tích lũy");
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
		model.addColumn("Điểm");
		model.addColumn("Cấp độ");

		TableColumn column = null;
		for (int i = 0; i < 4; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 1)
				column.setPreferredWidth(200);
			else
				column.setPreferredWidth(100);
		}

		for (HoiVien p : Rap.sapXepTangDiemHV(rap.getDsHoiVien())) {
			model.addRow(new Object[] { p.getCmnd(), p.getTen(), p.getDiemTichLuy(), p.getCapDoHoiVien() });
		}
		
		add(pane, BorderLayout.CENTER);
		pack();
	}

	public static void main() throws ClassNotFoundException, IOException {
		fSapXepHoiVienTheoDiem ds= new fSapXepHoiVienTheoDiem();
		ds.setBounds(400, 150, 500, 200);
		ds.setVisible(true);
	}
}