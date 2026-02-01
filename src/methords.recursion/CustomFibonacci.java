package methords.recursion;

import java.util.Arrays;

public class CustomFibonacci {

    // Static memoization array
    static long[] memo;

    // Recursive Fibonacci with memoization
    static long fibonacci(int n) {

        // Base cases
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // If already calculated, return from memo
        if (memo[n] != -1)
            return memo[n];

        // Store and return result
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {

        int n = 40;   // Change value as needed

        // Initialize memo array
        memo = new long[n + 1];
        Arrays.fill(memo, -1);

        System.out.println("Fibonacci of " + n + " = " + fibonacci(n));
    }
}
