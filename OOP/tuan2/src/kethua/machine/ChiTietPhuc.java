package kethua.machine;

import java.util.ArrayList;

public class ChiTietPhuc extends ChiTiet {
	ArrayList<ChiTiet> dsCT = new ArrayList<ChiTiet>();
	//private static double tien = 0;

	public int getSoLuongChiTietThanhPhan() {
		int count = 0;
		for (ChiTiet i : dsCT)
			count++;
		return count;
	}

	public void setSoLuongChiTietThanhPhan(int soLuongChiTietThanhPhan) {
		int count = 0;
		for (ChiTiet i : dsCT)
			count++;
		soLuongChiTietThanhPhan = count;
	}

	public ArrayList<ChiTiet> getDsCT() {
		return dsCT;
	}

	public void setDsCT(ArrayList<ChiTiet> dsCT) {
		this.dsCT = dsCT;
	}

	public ChiTietPhuc() {
		super();
	}

	public ChiTietPhuc(String maSo) {
		super(maSo);
		dsCT = new ArrayList<ChiTiet>();
	}

	public boolean themChiTiet(ChiTiet ct) {
		for (ChiTiet i : dsCT)
			if (i.getMaSo().equals(ct.getMaSo()))
				return false;
		return dsCT.add(ct);
	}

	public ChiTiet timChiTiet(String maSo) {
		for (ChiTiet i : dsCT)
			if (i.getMaSo().equals(maSo))
				return i;
			else if (i instanceof ChiTietPhuc) {
				ChiTiet tmp = ((ChiTietPhuc) i).timChiTiet(maSo);
				if (tmp != null)
					return tmp;
			}
		return null;
	}

	@Override
	public double tinhTien() {
		for (ChiTiet i : dsCT)
			if (i instanceof ChiTietPhuc)
				May.tien = May.tien + ((ChiTietPhuc) i).tinhTien();
			else
				May.tien = May.tien + ((ChiTietDon) i).tinhTien();
		//return May.tien;
		return May.tien;
	}

	@Override
	public String toString() {
		return "ChiTietPhuc [MaSo=" + this.getMaSo() + "]";
	}

}
