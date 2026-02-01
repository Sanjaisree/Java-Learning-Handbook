package controlflow.algorithmic.logic;

public class SieverPrimenumber {

    public static void main(String[] args) {

        int n = 1000;

        
        boolean[] isPrime = new boolean[n + 1];

        
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        
        isPrime[0] = false;
        isPrime[1] = false;

        
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}

    

