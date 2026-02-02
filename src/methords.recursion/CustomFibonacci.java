package methords.recursion;

import java.util.Arrays;

public class CustomFibonacci {

    static long[] memo;


    static long fibonacci(int n) {


        if (n == 0)
            return 0;
        if (n == 1)
            return 1;


        if (memo[n] != -1)
            return memo[n];


        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {

        int n = 40;


        memo = new long[n + 1];
        Arrays.fill(memo, -1);

        System.out.println("Fibonacci of " + n + " = " + fibonacci(n));
    }
}
