package problem;

import java.util.HashSet;
import java.util.Set;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1MultipleOf3Or5 {

    public static void main(String[] args) {

        int sum = sumOfMultipleOf3Or5(1000);
        System.out.println("Sum: "+ sum);
    }

    public static int sumOfMultipleOf3Or5(int limit) {

        if (limit < 3) return 0;

        Set<Integer> sum = new HashSet<>();

        // to limit iteration
        int maxLimit = Math.abs(limit / 3);
        for (int i = 1; i <= maxLimit; i++) {

            int m = 3 * i;
            if (m < limit) sum.add(m);

            int n = 5 * i;
            if (n < limit) sum.add(n);
        }

        return sum.parallelStream().reduce(Integer::sum).get();
    }
}
