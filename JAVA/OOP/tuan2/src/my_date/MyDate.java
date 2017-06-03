package my_date;

public class MyDate {
	public static final int daysOfYear = 365;
	public static final int monthsOfYear = 12;

	private static int currentYear = 2016;

	private int ngay;
	private int thang;
	private int nam;

	public static int getCurrentYear() {
		return currentYear;
	}

	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		if (ngay > 0 && ngay < 31)
			this.ngay = ngay;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		if (thang > 0 && thang < 13)
			this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public MyDate() {
	}

	public MyDate(int ngay, int thang, int nam) {
		super();
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public MyDate(int ngay, int thang, int nam, int curentYear) {
		super();
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
		MyDate.currentYear = curentYear;
	}

	public boolean kiemTraHopLy() {
		if (this.nam < 0 || this.thang > 12 || this.ngay > 31 || this.ngay < 0 || this.thang < 0)
			return false;
		else {
			if (this.thang == 2 && this.ngay > 29)
				return false;
			else if (this.thang == 1 || this.thang == 3 || this.thang == 5 || this.thang == 7 || this.thang == 8
					|| this.thang == 10 || this.thang == 12) {
				if (this.ngay > 31)
					return false;
				else
					return true;
			} else if (this.thang == 4 || this.thang == 6 || this.thang == 9 || this.thang == 11)
				if (this.ngay > 30)
					return false;
				else
					return true;
		}
		return true;
	}

	public MyDate congNgayThangNam(MyDate A) {
		MyDate C = new MyDate();
		C.nam = this.nam + A.nam;
		C.thang = this.thang + A.thang;
		C.ngay = this.ngay + A.ngay;

		if (C.thang > 12) {
			C.thang = C.thang - 12;
			C.nam = C.nam + 1;
		}
		if (C.thang == 2) {
			if (C.ngay > 29) {
				C.ngay = C.ngay - 29;
				C.thang = C.thang + 1;
			}
		} else if (C.thang == 1 || C.thang == 3 || C.thang == 5 || C.thang == 7 || C.thang == 8 || C.thang == 10
				|| C.thang == 12) {
			if (C.ngay > 31) {
				C.ngay = C.ngay - 31;
				C.thang = C.thang + 1;

				if (C.thang > 12) {
					C.thang = C.thang - 12;
					C.nam = C.nam + 1;
				}
			}
		} else if (C.thang == 4 || C.thang == 6 || C.thang == 9 || C.thang == 11) {
			if (C.ngay > 30) {
				C.ngay = C.ngay - 30;
				C.thang = C.thang + 1;

				if (C.thang > 12) {
					C.thang = C.thang - 12;
					C.nam = C.nam + 1;
				}
			}
		}
		return C;
	}

	public MyDate truNgayThangNam(MyDate A) {
		return A;
		// NgayThangNam C = new NgayThangNam();
		// if (this.nam < A.nam)
		// return C;
		// else if (this.nam == A.nam && this.thang < A.thang)
		// return C;
		// else if (this.nam == A.nam && this.thang == A.thang && this.ngay <
		// A.ngay)
		// return C;
		//
		// C.nam=this.nam-A.nam;
		// C.thang=this.thang-A.thang;
		// C.ngay=this.ngay-A.ngay;
		//
		// if(C.ngay<0)
		// C.thang=C.thang-1;
		// if(C.thang<0){
		// C.nam=C.nam-1;
		// }
	}

	public boolean soSanhNTN(MyDate A) {
		if (this.nam == A.nam && this.thang == A.thang && this.ngay == A.ngay)
			return true;
		return false;

	}

	@Override
	public String toString() {
		return ngay / 10 + "" + ngay % 10 + "/" + thang / 10 + "" + thang % 10 + "/" + nam;
	}

	public static int daysOfMonth(int thang) {
		if (thang == 2)
			return 29;
		else if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12)
			return 31;
		else
			return 30;
	}

}
