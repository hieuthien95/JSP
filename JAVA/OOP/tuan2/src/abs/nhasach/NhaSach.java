package abs.nhasach;

import java.util.ArrayList;

public class NhaSach {
	ArrayList<Sach> dsSach = new ArrayList<>();
	ArrayList<Dia> dsDia = new ArrayList<>();

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	public ArrayList<Dia> getDsDia() {
		return dsDia;
	}

	public void setDsDia(ArrayList<Dia> dsDia) {
		this.dsDia = dsDia;
	}

	public ArrayList<SachNgoaiNgu> inSachDia() {
		ArrayList<SachNgoaiNgu> dsNN = new ArrayList<>();
		for (Sach i : dsSach) {
			if (i instanceof SachNgoaiNgu)
				for (Dia j : dsDia)
						if(j.getMaDia().equals(((SachNgoaiNgu) i).getMaDia()))
							if(j.getSoLuong()==0){
								dsNN.add((SachNgoaiNgu) i);
								break;
							}
		}
		return dsNN;

	}

}
