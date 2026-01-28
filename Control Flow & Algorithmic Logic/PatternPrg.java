import java.util.Scanner;

public class PatternPrg {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("enter the number: ");
		int n = scan.nextInt();

		int i;
		int j;
		int k;
		for (i=1;i<=n;i++){
			for(k=1;k<=n-i;k++){
				System.out.print(" ");
			}
			for (j=1;j<=i;j++){
				System.out.print("* ");
			}
			System.out.println();

	}
	}
}