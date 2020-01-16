import java.util.Scanner;

/**
 * This class StringWoJA consists of methods to perform various operation on string without using java Api.
 * @author Bhavesh
 *
 */
public class StringWoJA {

	/**
	 * this method is used to compare the two string values.
	 * @param str1 it is a first string for comparison.
	 * @param str2 it is a second string for comparison.
	 * @return this method returns the integer value 0 if not equals and 1 if equals.
	 */
	public static int compare(String str1, String str2) {
		char[] str1arr = str1.toCharArray();
		char[] str2arr = str2.toCharArray();

		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 == len2) {
			for (int i = 0; i < len1; i++) {
				if (str1arr[i] != str2arr[i]) {
					return 0;
				}
			}
			return 1;
		}
		return 0;
	}

	/**
	 * this method is used to reverse the string.
	 * @param str3  it is a string which is going to be reversed.
	 * @return it returns the character array of reversed string.
	 */
	public static char[] rev(String str3) {
		int len3 = str3.length();
		char str3arr[] = str3.toCharArray();
		char revarr[] = new char[len3];

		for (int i = 0; i < len3; i++) {
			revarr[i] = str3arr[len3 - i - 1];
		}
		return revarr;

	}

	/**
	 * this method is used to change the cases of string.
	 * @param str4 it is a string whose cases are going to be changed.
	 * @return it returns the character array of opposite case string.
	 */
	public static char[] oppositeCase(String str4) {
		int len4 = str4.length();
		char str4arr[] = str4.toCharArray();
		for (int i = 0; i < len4; i++) {
			if (str4arr[i] >= 'a' && str4arr[i] <= 'z') {
				str4arr[i] = (char) (str4arr[i] - 32);
			} else if (str4arr[i] >= 'A' && str4arr[i] <= 'Z') {
				str4arr[i] = (char) (str4arr[i] + 32);
			}
		}
		return str4arr;
	}


	/**
	 * this method is used to find out the largest word.
	 * @param str5  it is a string in which the largest word is to be found.
	 * @return it returns the word of largest length.
	 */
	public static String largestWord(String str5)
	{
		int max_len = 0;
		String max_str = "";
		String[] words = str5.split("\\s+");

		for(int i=0; i<words.length ; i++)
		{
			if(max_len <= words[i].length())
			{
				max_len = words[i].length();
				max_str = words[i];
			}
		}

		return max_str;
	}



	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {

			System.out.print("Enter the first string : ");
			String str1 = input.nextLine();
			System.out.print("Enter the second string : ");
			String str2 = input.nextLine();

			if (str1.charAt(0) == 10 || str2.charAt(0) == 10) {
				System.out.println("you have entered the null string");
			}

			while (true) {
				System.out.println("1. compare these two strings");
				System.out.println("2. reverse the string");
				System.out.println("3. interchange the lowercase with uppercase and vive versa");
				System.out.println("4. largest word of string");
				System.out.println("5. Exit");

				System.out.println("Enter The choice");
				int choice = input.nextInt();

				switch (choice) {

				case 1:
					int compareVal = compare(str1, str2);
					System.out.println(compareVal);
					break;

				case 2:
					char[] revarr1 = rev(str1);
					char[] revarr2 = rev(str2);
					System.out.println(revarr1);
					System.out.println(revarr2);
					break;

				case 3:
					char[] casearr1 = oppositeCase(str1);
					char[] casearr2 = oppositeCase(str2);
					System.out.println(casearr1);
					System.out.println(casearr2);
					break;

				case 4:
					String str1LargestWord = largestWord(str1);
					String str2LargestWord = largestWord(str2);
					System.out.println("The Largest Word in String 1 is : "+ str1LargestWord);
					System.out.println("The Largest Word in String 2 is : "+ str2LargestWord);
					break;


				case 5:
					System.exit(0);

				}

			}
		} catch (Exception ex) {
			System.out.println("Enter the correct information");
			input.nextLine();
		}
	}

}
