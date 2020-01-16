import java.util.Scanner;

/**
 * this class is used to calculate the area of different shapes.
 * @author Bhavesh
 *
 */
public class Area {

	static Scanner input = new Scanner(System.in);

	/**
	 * it is a method to calculate the area of triangle.
	 * @return it returns the area as double.
	 */
	public static double areaOfTriangle() {

		System.out.print("Enter the width of triangle : ");
		double width = input.nextDouble();
		System.out.print("Enter the height of triangle : ");
		double height = input.nextDouble();
		double area = (width * height) / 2;
		return area;

	}

	/**
	 * it is a method to calculate the area of rectangle.
	 * @return it returns the area as double.
	 */
	public static double areaOfRectangle() {

		System.out.print("Enter the width of rectangle : ");
		double width = input.nextDouble();
		System.out.print("Enter the height of rectangle : ");
		double height = input.nextDouble();
		double area = (width * height);
		return area;

	}

	/**
	 * it is a method to calculate the area of square.
	 * @return it returns the area as double.
	 */
	public static double areaOfSquare() {

		System.out.print("Enter the width of square : ");
		double width = input.nextDouble();
		double area = (width * width);
		return area;

	}

	/**
	 * it is a method to calculate the area of circle.
	 * @return it returns the area as double.
	 */
	public static double areaOfCircle() {

		System.out.print("Enter the radius of circle : ");
		double radius = input.nextDouble();
		double area = ((22 * radius * radius) / 7);
		return area;

	}

	public static void main(String[] args) {

		while (true) {

			System.out.println("1. Area of Triangle");
			System.out.println("2. Area of Rectangle");
			System.out.println("3. Area of Square");
			System.out.println("4. Area of Circle");
			System.out.println("5. Exit");

			System.out.println("Enter the choice");
			try {

				int choice = input.nextInt();

				switch (choice) {

				case 1:
					double areaTriangle = areaOfTriangle();
					System.out.println("the area of triangle is : "
							+ areaTriangle);
					break;

				case 2:
					double areaRectangle = areaOfRectangle();
					System.out.println("the area of rectangle is : "
							+ areaRectangle);
					break;

				case 3:
					double areaSquare = areaOfSquare();
					System.out.println("the area of Square is : " + areaSquare);
					break;

				case 4:
					double areaCircle = areaOfCircle();
					System.out.println("the area of circle is : " + areaCircle);
					break;

				case 5:
					System.exit(0);
				}

			} catch (Exception ex) {
				System.out.println("Enter the correct information");
				input.nextLine();
			}
		}
	}

}
