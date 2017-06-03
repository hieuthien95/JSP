package demo.lab2;
public class BangDiem {

	private double toan;
	private double ly;
	private double hoa;
	
	public BangDiem(double t, double l, double h)
	{
		toan = t;
		ly = l;
		hoa = h;
	}
	
	public double tinhTong()
	{
		return toan + ly + hoa;
	}
	
	public boolean saoCungDuoc() {
		
		boolean dk1 = (toan + ly + hoa) > 18;
		boolean dk2 = (toan >= 5) && (ly >= 5) && (hoa >= 5);
		
		return (dk1 && dk2);
	}
	
	public boolean isPassed() {
		
		if (((toan + ly + hoa) > 18) && ((toan >= 5) && (ly >= 5) && (hoa >= 5)))
			return true;
		else
			return false;
	}
	
	public void setToan(double t)
	{
		toan = t;
	}
	
	public double getToan()
	{
		return toan;
	}

	public double getLy() {
		return ly;
	}

	public void setLy(double ly) {
		this.ly = ly;
	}

	public double getHoa() {
		return hoa;
	}

	public void setHoa(double hoa) {
		this.hoa = hoa;
	}
	
	
	
}
