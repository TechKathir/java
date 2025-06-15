package problems;

import java.math.BigInteger;
import java.util.*;

public class PrimeNumber {


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 4, 3};
        int[] f = new int[1];
        int d = 7/2;
        System.out.println(d);
//        System.out.println(countTriplet2(arr));
//        System.out.println(countTriplet(arr));
//        sieveOfEratosthenes(10);
    }


    static int countTriplet2(int arr[]) {
        Map<Integer,Integer> v = new HashMap<>();
        int count = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 1; i--) {
            int left = 0;
            int right = i - 1;
            int target = arr[i];
            while (left < right) {
                int total = arr[left] + arr[right];
                if (total < target) {
                    left++;
                } else if (total > target) {
                    right--;
                } else {
                    left++;
                    right--;
                    count++;
                }
            }
        }
        return count;
    }


    static int countTriplet(int[] arr) {
        int count = 0;
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = (i + 1); j < n; j++) {
                int target = arr[i] + arr[j];
                if (set.contains(target)) {
                    count++;
                    lists.add(List.of(arr[i], arr[j]));
                }
                ;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (List<Integer> list : lists) {
            int v = list.get(0) + list.get(1);
            String str = list.toString() + "-" + v;
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        for (String string : map.keySet()) {
            System.out.println(string + " - " + map.get(string));
        }
        return count;
    }

//    static ArrayList<Integer> findTwoElement(int[] arr) {
//        int n = arr.length;
//        int nSum = (n*(n+1))/2;
//        int n2Sum = (n*(n+1)*(2*n+1))/6;
//        int nRange = 0;
//        int n2Range = 0;
//        System.out.println("nSum-"+nSum);
//        System.out.println("n2Sum-"+n2Sum);
//        for (int i : arr) {
//            nRange+=i;
//            n2Range+=(i*i);
//        }
//        System.out.println("nRange-"+ nRange);
//        System.out.println("n2Range-"+ n2Range);
//        int xSubY = nSum-nRange;
//        double xAddY = (n2Sum-n2Range);
//        xAddY = xAddY/xSubY;
//        double x = (xAddY+xSubY)/2;
//        System.out.println("x-"+x);
//        double y = -(xSubY-x);
//        System.out.println("y-"+y);
////        return new ArrayList<>(List.of(x, y));
//    }

    static BigInteger getCount(int n) {
        return BigInteger.valueOf((long) n * (n + 1)).divide(BigInteger.valueOf(2));
    }

    static BigInteger getCount2(int n) {
        return BigInteger.valueOf(n * (n + 1) * (2L * n + 1)).divide(BigInteger.valueOf(6));
    }

    public static boolean isPrimeSqrt(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        int[] box = new int[n + 1];
        primeBox(box, n);
        for (int i = 2; i <= n; i++) {
            if (box[i] == 1) {
                primes.add(i);
            }
        }
        System.out.println(primes.toString());
        return primes;
    }

    static void primeBox(int[] box, int v){
        int n = box.length;
        for(int i = 2; i<n; i++){
            box[i] = 1;
        }
        for (int i = 0; i < box.length; i++) {
            System.out.print(box[i]+",");
        }
        System.out.println();
        for(int i = 2; i <= Math.sqrt(v);i++){
            if(box[i] == 1){
                for(int j = i*i; j <= v; j+=i){
                    box[j]=0;
                }
            }
        }
    }


}

/**
 * x-y = 2
 * x2-y2 = 3
 * (x+y) (x-y) = 3/2
 */