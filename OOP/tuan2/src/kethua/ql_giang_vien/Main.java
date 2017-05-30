package kethua.ql_giang_vien;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, IOException {

		QuanLyGiangVien ql1 = new QuanLyGiangVien();

		CoHuu ch1 = new CoHuu("CH1", "Huynh Van A", new Date(95, 1, 1), HocVi.GIAOSU, new Date(106, 2, 1), null, 12);
		CoHuu ch2 = new CoHuu("CH2", "Huynh Van A", new Date(95, 1, 1), HocVi.CUNHAN, new Date(113, 2, 1), null, 12);
		CoHuu ch3 = new CoHuu("CH3", "Huynh Van A", new Date(95, 1, 1), HocVi.PHOGIAOSU, new Date(116, 2, 1), null, 12);
		CoHuu ch4 = new CoHuu("CH4", "Nguyen Van A", new Date(95, 1, 1), HocVi.THACSI, new Date(114, 2, 1), null, 12);
		CoHuu ch5 = new CoHuu("CH5", "Huynh Van A", new Date(95, 1, 1), HocVi.TIENSI, new Date(116, 2, 1), null, 12);

		BanCoHuu bch1 = new BanCoHuu("BCH1", "Huynh Van A", new Date(95, 1, 1), HocVi.CUNHAN, new Date(111, 2, 1),
				null);
		BanCoHuu bch2 = new BanCoHuu("BCH2", "Huynh Van A", new Date(95, 1, 1), HocVi.GIAOSU, new Date(116, 2, 1),
				null);
		BanCoHuu bch3 = new BanCoHuu("BCH3", "Huynh Van A", new Date(95, 1, 1), HocVi.PHOGIAOSU, new Date(113, 2, 1),
				null);
		BanCoHuu bch4 = new BanCoHuu("BCH4", "Huynh Van A", new Date(95, 1, 1), HocVi.GIAOSU, new Date(112, 2, 1),
				null);
		BanCoHuu bch5 = new BanCoHuu("BCH5", "Huynh Van A", new Date(95, 1, 1), HocVi.TIENSI, new Date(115, 2, 1),
				null);

		ThinhGiang tg1 = new ThinhGiang("TG1", "Nguyen Van A", new Date(95, 1, 1), HocVi.TIENSI, new Date(115, 2, 1),
				null, "HK1", 12);
		ThinhGiang tg2 = new ThinhGiang("TG2", "Nguyen Van B", new Date(95, 1, 1), HocVi.CUNHAN, new Date(114, 2, 1),
				null, "HK1", 12);
		ThinhGiang tg3 = new ThinhGiang("TG3", "Bguyen Van C", new Date(95, 1, 1), HocVi.THACSI, new Date(116, 2, 1),
				null, "HK1", 12);
		ThinhGiang tg4 = new ThinhGiang("TG4", "Nguyen Van D", new Date(95, 1, 1), HocVi.GIAOSU, new Date(111, 2, 1),
				null, "HK1", 12);

		// 2
		ql1.themGiangVien(ch1);
		ql1.themGiangVien(ch2);
		ql1.themGiangVien(ch3);
		ql1.themGiangVien(ch4);
		ql1.themGiangVien(ch5);

		ql1.themGiangVien(bch1);
		ql1.themGiangVien(bch2);
		ql1.themGiangVien(bch3);
		ql1.themGiangVien(bch4);
		ql1.themGiangVien(bch5);

		ql1.themGiangVien(tg1);
		ql1.themGiangVien(tg2);
		ql1.themGiangVien(tg3);
		ql1.themGiangVien(tg4);

		// 4
		for (GiangVien i : ql1.getDsGiangVien())
			if (i instanceof CoHuu)
				System.out.println(((CoHuu) i).tinhLuong());
			else if (i instanceof BanCoHuu)
				System.out.println(((BanCoHuu) i).tinhLuong());
		// 5
		for (GiangVien i : ql1.getDsGiangVien())
			if (i instanceof ThinhGiang)
				System.out.println(((ThinhGiang) i).tinhThuLao());

		// 7
		System.out.println(ql1.layDSThinhGiangTS1());
		// 8
		System.out.println(ql1.layDSBanCoHuuThS3());
		// 9
		System.out.println(ql1.layDSCoHuuNoThS());
		// 10
		System.out.println(ql1.layDSThacSi());
		// 11
		System.out.println(ql1.layDSThacSiCoHuuN());
		// 12
		System.out.println(ql1.sapXepCoHuuTheoLuong());
		// 14
		System.out.println(ql1.layDSCoHuu10());
		// 15
		System.out.println(bch1.ktNghienCuuKH(580));
		System.out.println(ch1.ktNghienCuuKH(560));
		// 16
		System.out.println(ch1.ktHoanThanhNV(560, 12));
		System.out.println(bch1.ktHoanThanhNV(560, 12));
		// 17
		System.out.println(ql1.layDSKhongHoanThanh(560, 12));
		// 18
		FileWriter fw = new FileWriter(new File("input.txt"));
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(ql1.getDsGiangVien().toString());
		bw.close();
		// 18
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("input1.txt"));
		oos.writeObject(ql1);
		oos.close();

	}
}
