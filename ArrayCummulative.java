
import java.util.Scanner;

public class ArrayCummulative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] a = new int[size];

    
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }

        
        int mul= 1;
        for (int i = 0; i < size; i++) {
           
                mul=mul* a[i];
                a[i] = mul;
        }
        System.out.println("Resulting array:");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
