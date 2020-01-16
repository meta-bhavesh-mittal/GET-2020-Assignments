import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * this class is used to perform various operations on students grades.
 * @author Bhavesh
 *
 */
public class MarkSheet {

	/**
	 * it is a method to calculate average grade of all students.
	 * @param grade the grade of all students is passed as argument.
	 * @param numOfStudent the number of student is given as argument to function.
	 * @return it returns the average grade.
	 */
	public static float averageGrade(float grade[], int numOfStudent) {
		float totalGrade = 0;
		float avgGrade = 0;
		for (int i = 0; i < numOfStudent; i++) {
			totalGrade += grade[i];
		}
		avgGrade = (float)(totalGrade/numOfStudent);

		DecimalFormat decimalformat = new DecimalFormat();
		decimalformat.setMaximumFractionDigits(2);
		avgGrade = Float.valueOf(decimalformat.format(avgGrade));

		return avgGrade;
	}

	/**
	 * it is a method to calculate maximum grade of all students.
	 * @param grade  the grade of all students is passed as argument.
	 * @param numOfStudent  the number of student is given as argument to function.
	 * @return it returns the maximum grade.
	 */
	public static float maximumGrade(float grade[], int numOfStudent) {
		float maxGrade = 0;
		for (int i = 0; i < numOfStudent; i++) {
			if (grade[i] > maxGrade) {
				maxGrade = grade[i];
			}
		}
		DecimalFormat decimalformat = new DecimalFormat();
		decimalformat.setMaximumFractionDigits(2);
		maxGrade = Float.valueOf(decimalformat.format(maxGrade));
		return maxGrade;
	}

	/**
	 * it is a method to calculate minimum grade of all students.
	 * @param grade  the grade of all students is passed as argument.
	 * @param numOfStudent  the number of student is given as argument to function.
	 * @return it returns the minimum grade.
	 */
	public static float minimumGrade(float grade[], int numOfStudent) {
		float minGrade = grade[0];
		for (int i = 0; i < numOfStudent; i++) {
			if (grade[i] < minGrade) {
				minGrade = grade[i];
			}
		}
		DecimalFormat decimalformat = new DecimalFormat();
		decimalformat.setMaximumFractionDigits(2);
		minGrade = Float.valueOf(decimalformat.format(minGrade));
		return minGrade;
	}

	/**
	 * it is a method to calculate percentage of students passed.
	 * @param grade  the grade of all students is passed as argument.
	 * @param numOfStudent  the number of student is given as argument to function.
	 * @return it returns the percentage of students passed as float.
	 */
	public static float percentageStuPassed(float grade[], int numOfStudent) {
		float perStuPass = 0;
		int count = 0;
		for (int i = 0; i < numOfStudent; i++) {
			if (grade[i] >= 40) {
				count++;
			}
		}
		perStuPass = (float) ((count * 100) / numOfStudent);

		DecimalFormat decimalformat = new DecimalFormat();
		decimalformat.setMaximumFractionDigits(2);
		perStuPass = Float.valueOf(decimalformat.format(perStuPass));

		return perStuPass;
	}



	public static void main(String[] args) {

		int numOfStudent;
		Scanner input = new Scanner(System.in);

		try {
			System.out.println("Enter the number of students : ");
			numOfStudent = input.nextInt();

			if (numOfStudent <= 0) {
				System.out.println("Enter the correct information (number of students should be positive)");
				return;
			}

			float grade[] = new float[numOfStudent];

			System.out.println("Enter the students grades : ");

			for (int i = 0; i < numOfStudent; i++) {
				grade[i] = input.nextFloat();
				if (grade[i] < 0 || grade[i] > 100) {
					System.out.println("Enter the correct Information (grade should be between 0 to 100)");
					return;
				}
			}

			float avgGrade = averageGrade(grade, numOfStudent);
			float maxGrade = maximumGrade(grade, numOfStudent);
			float minGrade = minimumGrade(grade, numOfStudent);
			float perStuPass = percentageStuPassed(grade, numOfStudent);

			System.out.println("Average Of All Grades are : " + avgGrade);
			System.out.println("Maximum Of All Grades are : " + maxGrade);
			System.out.println("Minimum Of All Grades are : " + minGrade);
			System.out.println("Percentage of Students Passed : " + perStuPass);

		} catch (Exception ex) {
			System.out.println("Enter the correct information");
			input.nextLine();
		}
	}

}
