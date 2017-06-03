package boundary;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Phong;
import control.LoaiPhong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ThemPhong2 extends JFrame {

	private Phong p = new Phong();
	private JPanel contentPane;
	private JTextField txtMaPhong;
	private JComboBox cbLoaiPhong;
	private JLabel lblNewLabel_2;
	private JComboBox cbSucChua;
	private JLabel lblNewLabel_3;
	private JTextField txtDonGia;
	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnChon;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemPhong2 frame = new ThemPhong2();
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
	public ThemPhong2() throws SQLException {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Thêm phòng");
		setBounds(400, 150, 666, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String[] loaiPhong = { LoaiPhong.Thuong.getS(), LoaiPhong.CaoCap.getS() };

		String[] sucChua = { "2", "4", "6", "12" };

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		model.addColumn("Mã phòng");
		model.addColumn("Loại phòng");
		model.addColumn("Sức chứa");
		model.addColumn("Đơn giá");

		for (Phong p : p.getDsPhong()) {
			model.addRow(new Object[] { p.getMaPhong(), p.getLoaiPhong(), p.getSucChua(), p.getDonGia() });
		}
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 46, 99, 84, 11, 0};
				gbl_panel.rowHeights = new int[]{0, 20, 7, 27, 25, 23, 24, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
										
												JLabel lblNewLabel = new JLabel("Tên phòng");
												GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
												gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
												gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
												gbc_lblNewLabel.gridx = 1;
												gbc_lblNewLabel.gridy = 1;
												panel.add(lblNewLabel, gbc_lblNewLabel);
												lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
										
												txtMaPhong = new JTextField();
												GridBagConstraints gbc_txtMaPhong = new GridBagConstraints();
												gbc_txtMaPhong.fill = GridBagConstraints.HORIZONTAL;
												gbc_txtMaPhong.anchor = GridBagConstraints.SOUTH;
												gbc_txtMaPhong.insets = new Insets(0, 0, 5, 5);
												gbc_txtMaPhong.gridx = 2;
												gbc_txtMaPhong.gridy = 1;
												panel.add(txtMaPhong, gbc_txtMaPhong);
												txtMaPhong.setColumns(10);
										
												btnChon = new JButton(">>");
												GridBagConstraints gbc_btnChon = new GridBagConstraints();
												gbc_btnChon.fill = GridBagConstraints.HORIZONTAL;
												gbc_btnChon.anchor = GridBagConstraints.NORTH;
												gbc_btnChon.insets = new Insets(0, 0, 5, 5);
												gbc_btnChon.gridx = 3;
												gbc_btnChon.gridy = 1;
												panel.add(btnChon, gbc_btnChon);
												btnChon.setFont(new Font("Tahoma", Font.PLAIN, 8));
												btnChon.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
														Phong p = new Phong();
														for (Phong i : p.getDsPhong())
															if (i.getMaPhong().equals(maPhong)) {
																p = i;
																break;
															}
														txtMaPhong.setText(p.getMaPhong());
														txtDonGia.setText(p.getDonGia() + "");
														int chua = p.getSucChua();
														cbSucChua.setSelectedIndex((chua == 2) ? 0 : (chua == 4) ? 1 : (chua == 6) ? 2 : 3);
														String loai = p.getLoaiPhong();
														cbLoaiPhong.setSelectedIndex(loai.equals(LoaiPhong.Thuong.getS()) ? 0 : 1);
													}
												});
								
										lblNewLabel_3 = new JLabel("Đơn giá");
										GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
										gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
										gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
										gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
										gbc_lblNewLabel_3.gridx = 1;
										gbc_lblNewLabel_3.gridy = 2;
										panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
										lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
								
										txtDonGia = new JTextField();
										GridBagConstraints gbc_txtDonGia = new GridBagConstraints();
										gbc_txtDonGia.fill = GridBagConstraints.HORIZONTAL;
										gbc_txtDonGia.gridwidth = 2;
										gbc_txtDonGia.anchor = GridBagConstraints.SOUTH;
										gbc_txtDonGia.insets = new Insets(0, 0, 5, 5);
										gbc_txtDonGia.gridx = 2;
										gbc_txtDonGia.gridy = 2;
										panel.add(txtDonGia, gbc_txtDonGia);
										txtDonGia.setColumns(10);
						
								lblNewLabel_2 = new JLabel("Sức chứa");
								GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
								gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
								gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_2.gridx = 1;
								gbc_lblNewLabel_2.gridy = 3;
								panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
								lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
						cbSucChua = new JComboBox(sucChua);
						GridBagConstraints gbc_cbSucChua = new GridBagConstraints();
						gbc_cbSucChua.gridwidth = 2;
						gbc_cbSucChua.fill = GridBagConstraints.HORIZONTAL;
						gbc_cbSucChua.anchor = GridBagConstraints.NORTH;
						gbc_cbSucChua.insets = new Insets(0, 0, 5, 5);
						gbc_cbSucChua.gridx = 2;
						gbc_cbSucChua.gridy = 3;
						panel.add(cbSucChua, gbc_cbSucChua);
												
														JLabel lblNewLabel_1 = new JLabel("Loại phòng");
														GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
														gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHWEST;
														gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
														gbc_lblNewLabel_1.gridx = 1;
														gbc_lblNewLabel_1.gridy = 4;
														panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
														lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
												cbLoaiPhong = new JComboBox(loaiPhong);
												GridBagConstraints gbc_cbLoaiPhong = new GridBagConstraints();
												gbc_cbLoaiPhong.gridwidth = 2;
												gbc_cbLoaiPhong.fill = GridBagConstraints.HORIZONTAL;
												gbc_cbLoaiPhong.anchor = GridBagConstraints.NORTH;
												gbc_cbLoaiPhong.insets = new Insets(0, 0, 5, 5);
												gbc_cbLoaiPhong.gridx = 2;
												gbc_cbLoaiPhong.gridy = 4;
												panel.add(cbLoaiPhong, gbc_cbLoaiPhong);
												
														btnThem = new JButton("Thêm");
														GridBagConstraints gbc_btnThem = new GridBagConstraints();
														gbc_btnThem.gridwidth = 3;
														gbc_btnThem.fill = GridBagConstraints.HORIZONTAL;
														gbc_btnThem.anchor = GridBagConstraints.NORTH;
														gbc_btnThem.insets = new Insets(0, 0, 5, 5);
														gbc_btnThem.gridx = 1;
														gbc_btnThem.gridy = 5;
														panel.add(btnThem, gbc_btnThem);
														btnThem.addMouseListener(new MouseAdapter() {
															@Override
															public void mouseClicked(MouseEvent e) {
																if (txtMaPhong.getText().toString().equals("") || txtDonGia.getText().toString().equals(""))
																	JOptionPane.showMessageDialog(null, "Xin nhập đủ thông tin");
																else {
																	boolean trungMaPhong = false;
																	for (Phong i : p.getDsPhong())
																		if (i.getMaPhong().equals(txtMaPhong.getText().toString())) {
																			JOptionPane.showMessageDialog(null, "Trùng mã phòng");
																			trungMaPhong = true;
																		}

																	if (trungMaPhong == false) {

																		try {
																			p.themPhong(
																					new Phong(txtMaPhong.getText().toString(), cbLoaiPhong.getSelectedItem().toString(),
																							Integer.parseInt(cbSucChua.getSelectedItem().toString()),
																							Integer.parseInt(txtDonGia.getText().toString())));
																		} catch (NumberFormatException | SQLException e1) {
																			// TODO Auto-generated catch block
																			e1.printStackTrace();
																		}

																	}

																}

															}
														});
										
												btnCapNhat = new JButton("Cập nhật");
												GridBagConstraints gbc_btnCapNhat = new GridBagConstraints();
												gbc_btnCapNhat.gridwidth = 2;
												gbc_btnCapNhat.insets = new Insets(0, 0, 5, 5);
												gbc_btnCapNhat.anchor = GridBagConstraints.NORTH;
												gbc_btnCapNhat.fill = GridBagConstraints.HORIZONTAL;
												gbc_btnCapNhat.gridx = 1;
												gbc_btnCapNhat.gridy = 6;
												panel.add(btnCapNhat, gbc_btnCapNhat);
												btnCapNhat.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														Phong p = new Phong();
														if (txtDonGia.getText().toString().equals(""))
															JOptionPane.showMessageDialog(null, "Xin nhập đủ thông tin");
														else {
															try {

																int reply = JOptionPane.showConfirmDialog(null,
																		"Xác nhận cập nhật phòng: " + txtMaPhong.getText().toString(), "",
																		JOptionPane.YES_NO_OPTION);

																if (reply == JOptionPane.YES_OPTION) {
																	p.suaPhong(
																			new Phong(txtMaPhong.getText().toString(), cbLoaiPhong.getSelectedItem().toString(),
																					Integer.parseInt(cbSucChua.getSelectedItem().toString()),
																					Integer.parseInt(txtDonGia.getText().toString())));
																}

															} catch (NumberFormatException e1) {
																e1.printStackTrace();
															}

														}
													}
												});
																				
																						btnLamMoi = new JButton("Làm mới");
																						GridBagConstraints gbc_btnLamMoi = new GridBagConstraints();
																						gbc_btnLamMoi.insets = new Insets(0, 0, 5, 5);
																						gbc_btnLamMoi.fill = GridBagConstraints.HORIZONTAL;
																						gbc_btnLamMoi.anchor = GridBagConstraints.NORTH;
																						gbc_btnLamMoi.gridx = 3;
																						gbc_btnLamMoi.gridy = 6;
																						panel.add(btnLamMoi, gbc_btnLamMoi);
																						btnLamMoi.addMouseListener(new MouseAdapter() {
																							@Override
																							public void mouseClicked(MouseEvent e) {
																								ThemPhong2.main();
																								setVisible(false);
																							}
																						});
																		
																				btnXoa = new JButton("Xóa");
																				GridBagConstraints gbc_btnXoa = new GridBagConstraints();
																				gbc_btnXoa.gridwidth = 2;
																				gbc_btnXoa.insets = new Insets(0, 0, 5, 5);
																				gbc_btnXoa.anchor = GridBagConstraints.SOUTH;
																				gbc_btnXoa.fill = GridBagConstraints.HORIZONTAL;
																				gbc_btnXoa.gridx = 1;
																				gbc_btnXoa.gridy = 7;
																				panel.add(btnXoa, gbc_btnXoa);
																				btnXoa.addMouseListener(new MouseAdapter() {
																					@Override
																					public void mouseClicked(MouseEvent e) {
																						String maPhong = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
																						int reply = JOptionPane.showConfirmDialog(null, "Xác nhận xóa phòng: " + maPhong, "",
																								JOptionPane.YES_NO_OPTION);

																						if (reply == JOptionPane.YES_OPTION) {
																							Phong p = new Phong();
																							p.xoaPhong(maPhong);
																						}
																					}
																				});
																						
																								JButton btnThoat = new JButton("Thoát");
																								GridBagConstraints gbc_btnThoat = new GridBagConstraints();
																								gbc_btnThoat.anchor = GridBagConstraints.NORTH;
																								gbc_btnThoat.insets = new Insets(0, 0, 5, 5);
																								gbc_btnThoat.fill = GridBagConstraints.HORIZONTAL;
																								gbc_btnThoat.gridx = 3;
																								gbc_btnThoat.gridy = 7;
																								panel.add(btnThoat, gbc_btnThoat);
																						btnThoat.addMouseListener(new MouseAdapter() {
																							@Override
																							public void mouseClicked(MouseEvent e) {
																								setVisible(false);
																							}
																						});

		getContentPane().add(pane);

	}
}
