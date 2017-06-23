package abs.qlnv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {


	public static void main(String []args){

		ArrayList<NhanVien> dsNV = new ArrayList<>();
		
		dsNV.add(new CoHuu("A", "", 1995, 20));
		dsNV.add(new CoHuu("B", "", 1995, 25));
		dsNV.add(new CoHuu("C", "", 1995, 30));
		dsNV.add(new CoHuu("D", "", 1995, 35));
		
		dsNV.add(new HopDong("AA", "", 1995, 50000));
		dsNV.add(new HopDong("BB", "", 1995, 60000));
		dsNV.add(new HopDong("CC", "", 1995, 70000));
		dsNV.add(new HopDong("DD", "", 1995, 80000));
		
		for(NhanVien i: dsNV)
			if(i instanceof CoHuu)
				((CoHuu) i).tinhLuong(550);
	}
	
	
}
