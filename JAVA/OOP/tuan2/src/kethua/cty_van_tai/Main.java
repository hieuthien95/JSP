package kethua.cty_van_tai;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		CongTyVanTai ct1 = new CongTyVanTai();
		ct1.themXe(new Xe("X1", "SUZUKI", 2016, "do", new TaiXe("Nguyen Van A", "TX1", "01653990370")));
		ct1.themXe(new Xe("X2", "KIA", 2016, "xanh", new TaiXe("Nguyen Van C", "TX2", "01653990370")));
		ct1.themXe(new Xe("X3", "HUYNDAI", 2016, "den", new TaiXe("Nguyen Van B", "TX3", "01653990370")));

		ct1.themXe(
				new XeTai("XTAI1", "SUZUKI", 2016, "den", 18, 18000, new TaiXe("Nguyen van A", "TXT1", "01653990370")));
		ct1.themXe(
				new XeTai("XTAI2", "SUZUKI", 2016, "do", 18, 18000, new TaiXe("Nguyen van A", "TXT1", "01653990370")));
		ct1.themXe(new XeTai("XTAI3", "SUZUKI", 2016, "Trang", 18, 18000,
				new TaiXe("Nguyen van A", "TXT1", "01653990370")));

		ct1.themXe(new XeTaxi("XT1", "KIA", 2016, "Trang", 7, 12000, new TaiXe("Nguyen van A", "TXT1", "01653990370")));
		ct1.themXe(new XeTaxi("XT2", "KIA", 2016, "Trang", 4, 12000, new TaiXe("Nguyen van A", "TXT1", "01653990370")));
		ct1.themXe(
				new XeTaxi("XT3", "KIA", 2016, "Trang", 12, 12000, new TaiXe("Nguyen van A", "TXT1", "01653990370")));

		ct1.themXe(new XeKhach("XK1", "KIA", 2016, "do", 15, "SG-NT", 200000,
				new TaiXe("Nguyen van A", "TXT1", "01653990370")));
		ct1.themXe(new XeKhach("XK2", "KIA", 2016, "do", 30, "SG-NT", 180000,
				new TaiXe("Nguyen van A", "TXT1", "01653990370")));
		ct1.themXe(new XeKhach("XK3", "KIA", 2016, "do", 60, "SG-NT", 250000,
				new TaiXe("Nguyen van A", "TXT1", "01653990370")));

//		 System.out.println(ct1.getDsXe());
//		 System.out.println(ct1.layXe("TX1"));
//		 System.out.println(ct1.layXeTaiXeNTrang());
//		 System.out.println(ct1.layXeCoTaiTrong(18));
//		 System.out.println(ct1.layXeTaxi());
//		 System.out.println(ct1.layXeKhach());
		
		ct1.writeObjToFile();

	}
}
