package kethua.xe_bus;

public class TuyenDuong {
	private String diemBatDau;
	private String diemKetThuc;
	private double giaVe;

	public String getDiemBatDau() {
		return diemBatDau;
	}

	public void setDiemBatDau(String diemBatDau) {
		this.diemBatDau = diemBatDau;
	}

	public String getDiemKetThuc() {
		return diemKetThuc;
	}

	public void setDiemKetThuc(String diemKetThuc) {
		this.diemKetThuc = diemKetThuc;
	}

	public double getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}

	public TuyenDuong() {
		super();
	}

	public TuyenDuong(String diemBatDau, String diemKetThuc, double giaVe) {
		super();
		this.diemBatDau = diemBatDau;
		this.diemKetThuc = diemKetThuc;
		this.giaVe = giaVe;
	}

	@Override
	public String toString() {
		return "TuyenDuong [diemBatDau=" + diemBatDau + ", diemKetThuc="
				+ diemKetThuc + ", giaVe=" + giaVe + "]";
	}

	// public static TuyenDuong layTuyeDuongGiaCaoNhat(){
	// TuyenDuong max=this.getDsTuyeDuong().get(0);
	// for(TuyenDuong i:Xe.getDsTuyeDuong())
	// if(i.getGiaVe()>max.getGiaVe())
	// max=i;
	// return max;
	// }
	//
	// public static ArrayList<TuyenDuong> layDSTDGiaNhoHon(double gia){
	// ArrayList<TuyenDuong> dsTmp= new ArrayList<>();
	// for(TuyenDuong i:Xe.getDsTuyeDuong())
	// if(i.getGiaVe()<gia)
	// dsTmp.add(i);
	// return dsTmp;
	// }
	//
	// public static ArrayList<TuyenDuong> sapXepGiaTuyenDuong(){
	// ArrayList<TuyenDuong> dsTD= new ArrayList<TuyenDuong>();
	// dsTD=Xe.getDsTuyeDuong();
	//
	// Collections.sort(dsTD, new Comparator<TuyenDuong>() {
	// @Override
	// public int compare(TuyenDuong td1, TuyenDuong td2) {
	// if (td1.getGiaVe() > td2.getGiaVe())
	// return 1;
	// else if (td1.getGiaVe() == td2.getGiaVe())
	// return 0;
	// else
	// return -1;
	// }
	// });
	// Xe.setDsTuyeDuong(dsTD);
	// return Xe.getDsTuyeDuong();
	// }
	//
	// public static ArrayList<TuyenDuong> layDSCoDiemBD(String str){
	// ArrayList<TuyenDuong> dsTmp= new ArrayList<>();
	// for(TuyenDuong i:Xe.getDsTuyeDuong())
	// if(i.getDiemBatDau().equals(str))
	// dsTmp.add(i);
	// return dsTmp;
	// }

}
