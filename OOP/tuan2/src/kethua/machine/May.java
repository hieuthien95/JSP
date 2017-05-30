package kethua.machine;

import java.util.ArrayList;

public class May {
	public static double tien = 0;
	ArrayList<ChiTiet> dsChiTiet = new ArrayList<ChiTiet>();

	public May() {
		super();
	}

	public ArrayList<ChiTiet> getDsChiTiets() {
		return dsChiTiet;
	}

	public void setDsChiTiets(ArrayList<ChiTiet> dsChiTiets) {
		this.dsChiTiet = dsChiTiets;
	}

	@Override
	public String toString() {
		return "May [dsChiTiets=" + dsChiTiet + "]";
	}

	public boolean themChiTiet(ChiTiet ct) {
		for (ChiTiet i : dsChiTiet)
			if (i.getMaSo().equals(ct.getMaSo()))
				return false;
		return dsChiTiet.add(ct);
	}

	public ChiTiet timChiTiet(String maSo) {
		for(ChiTiet i:dsChiTiet)
			if(i.getMaSo().equals(maSo))
				return i;
			else if(i instanceof ChiTietPhuc){
				ChiTiet tmp = ((ChiTietPhuc)i).timChiTiet(maSo);
				if(tmp!=null)
					return tmp;
			}
		return null;
	}

	public double tinhTien() {
		
		for(ChiTiet i : dsChiTiet)
			if(i instanceof ChiTietPhuc)
				tien = tien + ((ChiTietPhuc)i).tinhTien();
			else 
				tien = tien + ((ChiTietDon)i).tinhTien();
		return tien;
	}

}
