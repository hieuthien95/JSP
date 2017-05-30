package circle;

public class Main {

	public static void main(String []args){
		
		Circle c2 = new Circle(3);
		System.out.println(Circle.getNumberOfCircles()+ ", " + c2.getCV()+", " + c2.getR());
		Circle c3 = new Circle(4);
		System.out.println(Circle.getNumberOfCircles()+ ", " + c3.getCV()+", " + c3.getR());
		
		System.out.println(Circle.getNumberOfCircles());
		
	}
}
