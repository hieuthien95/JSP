package abs.shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String []args){
		ArrayList<Shape> dsS = new ArrayList<>();
		dsS.add(new Circle());
		dsS.add(new Rectangle());
		dsS.add(new Square());
		dsS.add(new Circle("white", true, 2));
		dsS.add(new Rectangle("white", true, 2,3));
		dsS.add(new Square("white", true, 2));
		
		double tong=0;
		for(Shape i:dsS)
			tong+= i.getArea();
		System.out.println(tong);
		
		double minCV=dsS.get(0).getPerimeter();
		for(Shape i:dsS)
			if(i.getPerimeter()<minCV)
				minCV=i.getPerimeter();
		System.out.println(minCV);
		
		for(Shape i:dsS)
			if(i instanceof Square)
				System.out.println(((Square) i).getSide());
		
		Collections.sort(dsS, new Comparator<Shape>() {
			@Override
			public int compare(Shape o1, Shape o2) {
				return (int) (o1.getArea()-o2.getArea());
			}
		});
		
		System.out.println(dsS);
		
		Collections.sort(dsS, new Comparator<Shape>() {
			@Override
			public int compare(Shape o1, Shape o2) {
				if(o1.getPerimeter()>o2.getPerimeter())
					return 1;
				else if(o1.getPerimeter()<o2.getPerimeter())
					return -1;
				else return 0;
			}
		});
		
		System.out.println(dsS);
		
	}
}
