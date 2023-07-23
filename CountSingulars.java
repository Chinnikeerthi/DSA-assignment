import java.util.Scanner;
public class CountSingulars {
	public static int noOfSingulars(int[] a) {
		int[] sockcount=new int[101];
		for(int i:a) {
			sockcount[i]++;
		}
	int noofsingle=0;
	for(int count:sockcount) {
		if(count%2 !=0) {
			noofsingle++;
		}
	}
	return noofsingle;
}
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of socks:");
		int n=sc.nextInt();
		int a[]=new int[n];
            System.out.print("Enter the socks ids:");
for(int i=0;i<n;i++) {
	a[i]=sc.nextInt();
}
int noofsingle=noOfSingulars(a);
System.out.println("No of singular socks=" + noofsingle);
sc.close();

	}

	}


