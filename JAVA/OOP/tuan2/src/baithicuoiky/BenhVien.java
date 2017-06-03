package baithicuoiky;

import java.util.ArrayList;

public class BenhVien {
	ArrayList<BenhNhan> dsBenhNhan;

	public BenhVien() {
		super();
		dsBenhNhan = new ArrayList<>();
	}

	public boolean themBenhNhan(BenhNhan bn) {
		for (BenhNhan i : dsBenhNhan)
			if (i.getCmnd().equals(bn.getCmnd()))
				return false;
		dsBenhNhan.add(bn);
		return true;
	}

	public ArrayList<BenhNhan> getDsBenhNhan() {
		return dsBenhNhan;
	}

	public void setDsBenhNhan(ArrayList<BenhNhan> dsBenhNhan) {
		this.dsBenhNhan = dsBenhNhan;
	}
	
	

}
