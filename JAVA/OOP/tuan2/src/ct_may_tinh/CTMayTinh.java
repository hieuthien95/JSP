package ct_may_tinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CTMayTinh {
	private String ten;
	private String diachi;
	private ArrayList<MayTinh> dsmt;
	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public ArrayList<MayTinh> getDsmt() {
		return dsmt;
	}
	public void setDsmt(ArrayList<MayTinh> dsmt) {
		this.dsmt = dsmt;
	}
	
	public CTMayTinh() {
		super();
		this.dsmt = new ArrayList<MayTinh>();
	}
	
	public CTMayTinh(String ten, String diachi) {
		super();
		this.ten = ten;
		this.diachi = diachi;
		this.dsmt = new ArrayList<MayTinh>();
	}
	
	public boolean themMayTinh(MayTinh A){
		for(MayTinh i: this.dsmt)
			if(i.getMaso().equals(A.getMaso()))
				return false;
		this.dsmt.add(A);
		return true;
	}
	
	public ArrayList<MayTinh> layDSMTKM(){
		ArrayList<MayTinh> dstemp= new ArrayList<MayTinh>();
		for(MayTinh i : this.dsmt)
			if(i.getDspk().size()>=2)
				dstemp.add(i);
		return dstemp;			
	}
	
	@Override
	public String toString() {
		return "CTMayTinh [ten=" + ten + ", diachi=" + diachi + ", dsmt="
				+ dsmt + "]";
	}
	
	public ArrayList<MayTinh> sapXepGiaMTTangDan(){
		Collections.sort(dsmt, new Comparator<MayTinh>() {
			@Override
			public int compare(MayTinh mt1, MayTinh mt2) {
				if (mt1.getGiaban() > mt2.getGiaban())
					return 1;
				else if (mt1.getGiaban() == mt2.getGiaban())
					return 0;
				else
					return -1;
			}
		});
		return dsmt;		
	}
	
}
