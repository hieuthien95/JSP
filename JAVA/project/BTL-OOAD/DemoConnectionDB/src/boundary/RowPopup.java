package boundary;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RowPopup extends JPopupMenu {

	private JMenuItem Xoa;

	public RowPopup() {
		Xoa = new JMenuItem("Xóa");
		add(Xoa);
	}

	public void addActionListener(ActionListener listener) {
		Xoa.addActionListener(listener);
	}
}
