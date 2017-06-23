package abs.nhasach;

public class Main {

	public static void main(String []args){
		NhaSach ns1 = new NhaSach();
		ns1.getDsSach().add(new SachNgoaiNgu("sach1", "S01", "", "", 2015, 100, 50000, "", "D01"));
		ns1.getDsSach().add(new SachNgoaiNgu("sach2", "S02", "", "", 2014, 100, 60000, "", "D02"));
		ns1.getDsSach().add(new SachNgoaiNgu("sach3", "S03", "", "", 2013, 100, 70000, "", "D03"));
		ns1.getDsSach().add(new SachNgoaiNgu("sach4", "S04", "", "", 2012, 100, 80000, "", "D04"));
		ns1.getDsSach().add(new SachNgoaiNgu("sach5", "S05", "", "", 2011, 100, 90000, "", "D05"));
		
		ns1.getDsDia().add(new DiaNhac("dia1", "D01", 50000, 1, 120));
		ns1.getDsDia().add(new DiaNhac("dia2", "D02", 50000, 0, 121));
		ns1.getDsDia().add(new DiaNhac("dia3", "D03", 50000, 1, 122));
		ns1.getDsDia().add(new DiaNhac("dia4", "D04", 50000, 0, 123));
		ns1.getDsDia().add(new DiaNhac("dia5", "D05", 50000, 1, 124));
		
		System.out.println(ns1.inSachDia());
		
	}
}
