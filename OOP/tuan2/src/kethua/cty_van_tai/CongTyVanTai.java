package kethua.cty_van_tai;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CongTyVanTai implements Serializable{
	private ArrayList<Xe> dsXe;

	public ArrayList<Xe> getDsXe() {
		return dsXe;
	}

	public void setDsXe(ArrayList<Xe> dsXe) {
		this.dsXe = dsXe;
	}

	public CongTyVanTai() {
		super();
		dsXe = new ArrayList<>();
	}

	//2
	public boolean themXe(Xe x) {
		for (Xe i : dsXe)
			if (i.getMa().equals(x.getMa()))
				return false;
		return dsXe.add(x);
	}

	//3
	public Xe layXe(String maTX) {
		for (Xe i : dsXe)
			if (i.getTaiXe().getMaso().equals(maTX))
				return i;
		return null;
	}

	//4
	public ArrayList<Xe> layXeTaiXeNTrang() {
		ArrayList<Xe> dsx = new ArrayList<>();
		for (Xe i : dsXe)
			if (i instanceof XeTai)
				if (i.getTaiXe().getTen().charAt(0) == 'N' && i.getMau().equals("Trang"))
					dsx.add(i);
		return dsx;
	}

	//5
	public ArrayList<Xe> layXeCoTaiTrong(double kg) {
		ArrayList<Xe> dsx = new ArrayList<>();
		for (Xe i : dsXe)
			if (i instanceof XeTai)
				if (((XeTai) i).getTrongLuong() >= kg)
					dsx.add(i);
		return dsx;
	}

	//6
	public ArrayList<Xe> layXeTaxi() {
		ArrayList<Xe> dsx = new ArrayList<>();
		for (Xe i : dsXe)
			if (i instanceof XeTaxi)
				if (((XeTaxi) i).getSoChoNgoi() == 7)
					dsx.add(i);
		return dsx;
	}

	//7
	public ArrayList<Xe> layXeKhach() {
		ArrayList<Xe> dsx = new ArrayList<>();
		for (Xe i : dsXe)
			if (i instanceof XeKhach)
				if (((XeKhach) i).getSoChoNgoi() > 30 && ((XeKhach) i).getGiaVe() > 200000)
					dsx.add(i);
		return dsx;
	}
	
	//8
	public void writeObjToFile() throws FileNotFoundException, IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("input.txt"));
		oos.writeObject(layXeKhach());
	}

}
