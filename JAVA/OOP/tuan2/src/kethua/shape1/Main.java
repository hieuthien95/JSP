package kethua.shape1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Hinh> dsHinh = new ArrayList<>();
		dsHinh.add(new Hinh("red", true));
		dsHinh.add(new HinhCN("red", true, 2, 3));
		dsHinh.add(new HinhTron("red", true, 2));
		dsHinh.add(new HinhVuong("blue", true, 2));

		System.out.println(dsHinh);

		System.out.println(tinhTongDTMauDo(dsHinh));

		System.out.println(layHinhCoDTMax(dsHinh));
		
		System.out.println(themHVvHCN(dsHinh, dsHinh.get(1)));
		
		for(Hinh i: dsHinh)
			if(i instanceof HinhTron)
			System.out.println(((HinhTron) i).getRadius());

	}

	public static ArrayList<Hinh> themHVvHCN(ArrayList<Hinh> dsHinh, Hinh hinh) {
		if (hinh instanceof HinhVuong)
			dsHinh.add(hinh);
		else if (hinh instanceof HinhCN) 
			dsHinh.add(0, hinh);
		return dsHinh;
	}

	public static Hinh layHinhCoDTMax(ArrayList<Hinh> dsHinh) {
		Hinh hinhMax = dsHinh.get(0);
		for (Hinh i : dsHinh)
			if (i.getArea() > hinhMax.getArea())
				hinhMax = i;
		return hinhMax;
	}

	public static double tinhTongDTMauDo(ArrayList<Hinh> dsHinh) {
		double tongdt = 0;
		for (Hinh i : dsHinh)
			if (i.getColor().equals("red"))
				tongdt += i.getArea();
		return tongdt;
	}
}
