package kethua.ct_van_chuyen_TB_DT;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		CongTyVanChuyen ct1 = new CongTyVanChuyen("CT1", "Thien Su Co.");

		DienThoai dt1 = new DienThoai("DT1", "Nokia", 2014, "278 Thai Phien", "Bui Hieu Thien", 3);
		DienThoai dt2 = new DienThoai("DT2", "Samsung", 2014, "278 Thai Phien", "Bui Hieu Thien", 1);
		DienThoai dt3 = new DienThoai("DT3", "iphone", 2014, "278 Thai Phien", "Bui Hieu Thien", 5);
		DienThoai dt4 = new DienThoai("DT4", "LG", 2014, "278 Thai Phien", "Bui Hieu Thien", 2);
		ct1.themThietBi(dt1);
		ct1.themThietBi(dt2);
		ct1.themThietBi(dt3);
		ct1.themThietBi(dt4);

		MayTinh mt1 = new MayTinh("MT1", "Probook", 2016, "278 Thai Phien", "Bui Hieu Thien", LoaiMay.XACHTAY);
		MayTinh mt2 = new MayTinh("MT2", "Probook", 2016, "278 Thai Phien", "Bui Hieu Thien", LoaiMay.DEBAN);
		MayTinh mt3 = new MayTinh("MT3", "Probook", 2016, "278 Thai Phien", "Bui Hieu Thien", LoaiMay.XACHTAY);
		MayTinh mt4 = new MayTinh("MT4", "Probook", 2016, "278 Thai Phien", "Bui Hieu Thien", LoaiMay.DEBAN);
		ct1.themThietBi(mt1);
		ct1.themThietBi(mt2);
		ct1.themThietBi(mt3);
		ct1.themThietBi(mt4);

		System.out.println(ct1.getDsDT() + "\n" + ct1.getDsMT());

		System.out.println(ct1.filterChiPhiVC(20000, 55000));

		System.out.println(ct1.tongChiPhi());
		
		ct1.writeToFile("input.txt", 20000, 55000);

	}
}
