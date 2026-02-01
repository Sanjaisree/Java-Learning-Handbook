package controlflow.algorithmic.logic;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("enter num: ");
		int n=sc.nextInt();
        printPrime(n);
    }
    
	public static void printPrime(int n){
        for(int i=2;i<=n;i++){
            if (isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
    public static boolean isPrime(int num){
        if (num<1){
            return false;
        }
        for (int j=2;j*j<=num;j++){
            if (num%j==0){
                return false;
            }
        
        }
        return true;       
    
    
}
}