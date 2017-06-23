package kethua.qlsv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import btl.Rap;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		LopHoc ql = new LopHoc("51303", "CNTT");
		ql.themSV(new SinhVien("Thien", new DiaChi("Thai phien", "11", "278"), 52));
		ql.themSV(new SinhVien("Thinh", new DiaChi("Thai phien", "11", "279"), 52));
		ql.themSV(new SinhVien("Thi", new DiaChi("Thai phien", "11", "280"), 52));

		ArrayList<Diem> dsDiem1 = new ArrayList<>();
		ArrayList<Diem> dsDiem2 = new ArrayList<>();
		ArrayList<Diem> dsDiem3 = new ArrayList<>();

		dsDiem1.add(new Diem("1", "Toan", 1));
		dsDiem1.add(new Diem("1", "Ly", 1));
		dsDiem1.add(new Diem("1", "Hoa", 1));

		dsDiem2.add(new Diem("1", "Toan", 5));
		dsDiem2.add(new Diem("1", "Ly", 10));
		dsDiem2.add(new Diem("1", "Hoa", 5));

		dsDiem2.add(new Diem("1", "Toan", 1));
		dsDiem2.add(new Diem("1", "Ly", 1));
		dsDiem2.add(new Diem("1", "Hoa", 5));

		ql.getDsSV().get(0).setDsDiem(dsDiem1);
		ql.getDsSV().get(1).setDsDiem(dsDiem2);
		ql.getDsSV().get(2).setDsDiem(dsDiem3);

		ghiRapVaoFile(ql);

		LopHoc ql1 = nhapRapTuFile();
		
		System.out.println(ql.getDsSV());

		// System.out.println(ql1.getDsSV());

		// System.out.println(ql1.getDsSV().get(0).xepLoaiSV());

		// System.err.println(ql1.layDiemCaoNhatTrongHK("1"));

		// ql1.thongTinSVSX();

		// System.out.println(ql1.sapXepDSSVBTBTLGiam());

	}
	
	public static void ghi(LopHoc r) throws FileNotFoundException, IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("txtx.txt"));
		oos.writeObject(r);
		oos.close();		
	}
	
	public static LopHoc nhap() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("txt.txt"));
		LopHoc lh = (LopHoc)ois.readObject();
		ois.close();
		return lh;
	}
	
	

	public static void ghiRapVaoFile(LopHoc r) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
		oos.writeObject(r);
		oos.close();
	}

	public static LopHoc nhapRapTuFile() throws IOException, ClassNotFoundException {
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("data.txt"));
		LopHoc r = (LopHoc) ios.readObject();
		ios.close();
		return r;
	}
}
