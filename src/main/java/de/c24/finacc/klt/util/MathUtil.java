package de.c24.finacc.klt.util;

/**
 *
 * @author Sarkhan Rasullu
 */
public final class MathUtil {

    /**
     * non-param constructor
     */
    private MathUtil() {

    }

    /**
     * isPrime
     * @return prime or not
     * @param num
     */
    public static boolean isPrime(int num) {
        boolean res = true;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                res = false;
                break;
            }
        }
       return res;
    }
}
