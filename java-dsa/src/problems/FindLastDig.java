package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FindLastDig {
    public static void main(String[] args) {
//        System.out.println(getLastDigit("3", "5"));
//        System.out.println(reverseDigits(10000));
//        System.out.println(reverseExponentiation(4));
//        System.out.println("divisor - " + gcd(24, 9));
//        System.out.println(isPrime(13));;
//        System.out.println(armstrongNumber(372));
//        System.out.println(isPalindrome(21));
//        System.out.println(floorSqrt(6));
        System.out.println(isPerfectNumber(2));
    }

    static boolean isPerfectNumber(int n) {
        if (n == 1) return false;
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    sum += i;
                } else {
                    sum += i;
                    sum += (n / i);
                }
            }
        }
        return sum == n;
    }

    public static int floorSqrt(int n) {
        int sqr = 1;
        while ((sqr * sqr) <= n) {
            sqr++;
        }
        return sqr;
    }

    public static boolean isPalindrome(int n) {
        if (n <= 9) return true;
        int reverse = 0;
        int copy = n;
        while (n > 9) {
            reverse += (n % 10);
            reverse *= 10;
            n = n / 10;
        }
        reverse += n;
        return reverse == copy;
    }

    static boolean armstrongNumber(int n) {
        int val = 0;
        int copy = n;
        while (n > 9) {
            int qb = n % 10;
            val += (qb * qb * qb);
            n = n / 10;
        }
        int qb = n % 10;
        val += (qb * qb * qb);
        return copy == val;
    }

    static boolean isPrime(int n) {
        if (n == 1) return false;
        int count = 2;
        while (count <= n) {
            if (n % count == 0 && n != count) {
                return false;
            }
            count++;
        }
        return true;
    }

    public static List<Integer> printDivisors(int n) {
        int count = 1;
        List<Integer> divisors = new ArrayList<>();
        while (count <= n) {
            if (n % count == 0) divisors.add(count);
            count++;
        }
        return divisors;
    }

    public static int gcd(int a, int b) {
        int reminder = 1;
        int divisor = a;
        int divident = b;
        if (a > b) {
            divisor = b;
            divident = a;
        }
        while (reminder != 0) {
            reminder = divident % divisor;
            if (reminder == 0) return divisor;
            else {
                divident = divisor;
                divisor = reminder;
            }
        }
        return divisor;
    }


    public static int reverseDigits(int n) {
        int opp = 0;
        while (n > 0) {
            System.out.println(n);
            opp *= 10;
            opp += n % 10;
            n /= 10;
        }
        return opp;
    }

    public static int reverseExponentiation(int n) {
        if (n == 10) return 10;
        int base = n;
        int power = n;
        while (power > 1) {
            n *= base;
            System.out.println(n);
            power--;
        }
        return n;
    }

    static int getLastDigit(String a, String b) {
        int bInt = Integer.valueOf(b);
        BigInteger base = new BigInteger(a);
        BigInteger finalVal = BigInteger.ONE;
        BigInteger finalValMod = BigInteger.ONE;
        while (bInt != 0) {
            finalVal = finalVal.multiply(base);
            finalValMod = finalValMod.multiply(base).mod(BigInteger.TEN);
            System.out.println("finalVal - " + finalVal);
            System.out.println("finalValMod - " + finalValMod);
            bInt--;
            System.out.println("----");
        }
//        System.out.println("final - " + finalVal);
//        System.out.println("finalVal - " + finalVal.mod(BigInteger.TEN));
        return finalVal.mod(BigInteger.TEN).intValue();
    }

}
