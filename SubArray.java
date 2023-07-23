
import java.util.Scanner;

public class SubArray {

	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int n = sc.nextInt();
	    	int count =0;
	    	int arr[] = new int[n];
	    	for(int i=0; i<n; i++) arr[i] = sc.nextInt();
	    	for(int i=0; i<n; i++) {
	    		int sum = 0;
	    		for (int j=i; j<n; j++) {
	    			sum = arr[j]+sum;
	    			if (sum<0) 
	    				count++;
	    		}
	    	}
	    	System.out.println(count);
	    	sc.close();
	    }
	}
