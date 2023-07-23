import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class MissingElement {
	    public static List<Integer> findMissingNumbers(int[] arrNum) {
	        List<Integer> missingNumbers = new ArrayList<>();

	        int n = arrNum.length;
	        int prev = arrNum[0];

	        for (int i = 1; i < n; i++) {
	            int current = arrNum[i];

	            // Check if there is a gap between the current and previous element
	            while (prev < current - 1) {
	                prev++;
	                missingNumbers.add(prev);
	            }

	            prev = current;
	        }

	        return missingNumbers;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number of elements in the array: ");
	        int n = scanner.nextInt();

	        int[] arrNum = new int[n];
	        System.out.println("Enter the elements of the array in ascending order:");
	        for (int i = 0; i < n; i++) {
	            arrNum[i] = scanner.nextInt();
	        }

	        List<Integer> missingNumbers = findMissingNumbers(arrNum);
	        System.out.println("Missing numbers in the array:");
	        for (int missingNumber : missingNumbers) {
	            System.out.print(missingNumber + " ");
	        }

	        scanner.close();
	    }
	}
