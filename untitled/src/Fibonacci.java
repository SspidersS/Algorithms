import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Long> memo = new HashMap<>();
   //Часова складність:O(n)      Просторова складність:O(1)
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
    //Часова складність:O(2ⁿ)     Просторова складність:	O(n) (глибина рекурсії)
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    //Часова складність:O(n)     Просторова складність:	O(n) (для збереження обчислених значень)
    public static long fibonacciDP(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        long result = fibonacciDP(n - 1) + fibonacciDP(n - 2);
        memo.put(n, result);
        return result;
    }
}
