
public class Triangle {
	public String getArea(double side1, double side2, double side3) {
		double semiPerimeter = (side1 + side2 + side3) / 2.0;
		double area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
		return String.valueOf(area);
	}
}
