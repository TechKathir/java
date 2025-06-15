package arrays.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,5,6,8,9,12,16,17};
//        System.out.println(search(arr, 7));
        List<String>  list = new ArrayList<>();
//        list.set()

        int[][] d = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(d, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int s = 0;
        int e = m - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int[] arr = matrix[mid];
            int n = arr.length;
            int l = arr[0];
            int r = arr[n - 1];
            if (target < l) {
                e = mid - 1;
            } else if (target > r) {
                s = mid + 1;
            } else {
                return search(arr, target);
            }
        }
        return false;
    }

    public static boolean search(int[] arr, int v) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] > v) {
                e = mid - 1;
            } else if (arr[mid] < v) {
                s = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
