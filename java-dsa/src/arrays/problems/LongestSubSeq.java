package arrays.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubSeq {
    public static void main(String[] args) {
        int[] arr = {6, -15, -64, 11, -45, 22, -73, -2, 71, 7, 6, -15, -64, 11, -45, 22, -73, -2, 71, 7};
        System.out.println(longestSubarray(arr, -14));
    }

    public static int longestSubarray(int[] arr, int k) {
        Map<Double, Integer> map = new HashMap<>();
        double sum = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.get(sum) == null) {
                map.put(sum, i);
            }
            if (sum == k) {
                System.out.println("len1 - " + (i + 1));
                length = i + 1;
            } else {
                double reqVal = sum - k;
                Integer integer = map.get(reqVal);
                if (integer != null) {
                    System.out.println("i - " + i + "old - " + integer);
                    int len = (i - integer);
                    if (len > length) {
                        System.out.println("len - " + len);
                        length = len;
                    }
                }
            }
        }
        System.out.println(map.toString());
        return length;
    }
}
