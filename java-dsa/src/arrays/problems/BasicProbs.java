package arrays.problems;

import java.util.*;

public class BasicProbs {
    public static void main(String[] args) {
        int d = 5 / 2;
        int[][] r = new int[2][2];
//        System.out.println(d);
//        String a = "10";
//        String b = "10";
//        new BigInteger(a).modPow(new BigInteger(b), new BigInteger("10")).intValue();
//        int d = 12, j;
//        System.out.println(j);
//        System.out.println(numberofElementsInIntersection(a,b));
//        Set<Integer> integers = new HashSet<>();
//        System.out.println(removeDuplicates(b));
//        System.out.println(kthElement(a, b, 7));
//        int d = 10;
//        double ff = 10;
//        int[] k = {10, 5, 2, 7, 1, -10};
//        System.out.println(longestSubarray(k, 15));
//        System.out.println(myAtoi("1231231231311133"));
//        System.out.println(getValue(6,2));
        printSm(5);
//        int t = 5/2;
//        System.out.println(t);
    }


    static void printSm(int n) {
        int max = (n * 2);
        for (int i = 1; i < max; i++) {
            int temp = i <= n ? i : (max - i);
            for (int i1 = 0; i1 <= (n-temp); i1++) {
                System.out.print("* ");
            }
            for (int i1 = 1; i1 < (2*(temp-1)+1); i1++) {
                System.out.print("  ");
            }
            for (int i1 = 0; i1 <= (n-temp); i1++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static int getValue(int n, int r) {
        int res = 1;
        n -= 1;
        r -= 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int myAtoi(String s) {
        int n = s.length();
        long total = 0;
        boolean minus = false;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (minus && total >= 2147483648f) {
                return -2147483648;
            } else if (total >= 2147483647f) {
                return 2147483647;
            }
            if (Character.isDigit(ch)) {
                int d = ch - '0';
                total = (total + d) * 10;
            } else if (ch == '-') {
                minus = true;
            } else if (ch == '+') {
                total = 0;
            } else {
                break;
            }
        }
        if (minus) {
            return (int) (total * -1) / 10;
        } else {
            return (int) (total / 10);
        }
    }

    public static int longestSubarray(int[] arr, int k) {
        int longest = 0;
        int currentCount = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            currentCount += 1;
            for (int j = (i + 1); j < arr.length; j++) {
                System.out.println("j - " + j);
//                sum += arr[j];
//                currentCount += 1;
//                if (sum == k && currentCount > longest) {
//                    longest = currentCount;
//                }
            }
//            System.out.println("currentCount - " + currentCount);
//            System.out.println("sum - " + sum);
            sum = 0;
            currentCount = 0;
            break;
        }
        return longest;
    }

    public static int kthElement(int a[], int b[], int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        while (left < a.length && right < b.length) {
            if (a[left] <= b[right]) {
                count++;
                if (count == k) {
                    return a[left];
                }
                left++;
            } else {
                count++;
                if (count == k) {
                    return b[right];
                }
                right++;
            }
        }
        System.out.println("left - " + left);
        System.out.println("right - " + right);
        System.out.println("count - " + count);
        while (left < a.length) {
            count++;
            if (count == k) {
                return a[left];
            }
            left++;
        }

        while (right < b.length) {
            count++;
            if (count == k) {
                return b[right];
            }
            right++;
        }
        return -1;
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 1) return 1;
        int[] distinct = new int[arr.length];
        distinct[0] = arr[0];
        int count = 1;
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            if (arr[left] == arr[right]) {
                right++;
            } else {
                distinct[count] = arr[right];
                left = right;
                right++;
                count++;

            }
        }
        for (int i = 0; i < count; i++) {
            arr[i] = distinct[i];
        }
        return count;
    }


    public static int numberofElementsInIntersection(int a[], int b[]) {
        int count = 0;
        if (a.length == 1 && b.length == 1) {
            if (a[0] == b[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        Arrays.sort(a);

        for (int i = 0; i < b.length; i++) {
            if (b[i] != 62) {
                continue;
            }
            System.out.println(b[i]);
            if (a.length == 1) {
                if (a[0] == b[i]) {
                    return 1;
                } else {
                    continue;
                }
            }

            int left = 0;
            int right = a.length - 1;
            int target = b[i];
            while (left <= right) {
                System.out.println("l - " + left);
                System.out.println("r - " + right);
                int leftVal = a[left];
                int rightVal = a[right];
                if (leftVal == target) {
                    count++;
                    System.out.println(target);
                    break;
                }
                if (rightVal == target) {
                    System.out.println(target);
                    count++;
                    break;
                }
                if (leftVal < target && rightVal > target) {
                    left++;
                    right--;
                } else {
                    break;
                }
            }
        }
        System.out.println("---");
        return count;
    }

    static boolean twoSum(int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer key = arr[i];
            if (map.get(key) == null) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (key < target) {
                Integer requried = target - key;
                if (requried.equals(key)) {
                    Integer val = map.get(requried);
                    if (val > 1) {
                        return true;
                    }
                } else {
                    Integer val2 = map.get(requried);
                    if (val2 != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<Integer> rotateArray(List<Integer> arr, int k) {
        List<Integer> rotate = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (i < k) {
                rotate.add(arr.get(i));
            } else {
                arr.set(i - k, arr.get(i));
            }
        }
        int start = arr.size() - k;
        for (int i = 0; i < rotate.size(); i++) {
            arr.set(start + i, rotate.get(i));
        }
        return arr;
    }

    static int missingNumber(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                int idx = j + 1;
                if (arr[i] > arr[idx]) {
                    int temp = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return (i + 1);
            }
        }
        return (arr.length + 1);
    }

    public static void getMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int minValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        Map<Integer, Integer> p = new HashMap<>();
        p.put(min, max);
    }
}
