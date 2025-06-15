package arrays.problems;

import java.util.ArrayList;
import java.util.List;

public class DiagonalPattern {

    public static void main(String[] args) {
////        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] mat = {{1, 2, 3,4}, {5, 6, 7 ,8}, {9,10,11,12}, {13,14,15,16}};
//        int[] ints = matrixDiagonally(mat);
//        int x = 0;
//        for (; x < 2; x++) {
////            System.out.print(ints[i] + ",");
//        }
        int y = 9;
        dd(--y);
        List<String> list = new ArrayList<>();
//        list.getLast()
    }
    static void dd(int d){
        System.out.println(d);
    }
//    static int factorial(int n) {
//        if (n == 1) return 1;
//        return n * factorial(n - 1);
//    }

    public static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] arr = new int[n * n];
        n -= 1;
        int arrn = arr.length - 1;
        arr[0] = mat[0][0];
        if (n == 0) {
            return arr;
        }
        arr[arrn] = mat[n][n];
        int i = 0;
        int j = 1;
        int tempi = i;
        int tempj = j;
        int count = 2;
        arr[1] = mat[0][1];
        arr[arrn - 1] = mat[n][n - 1];
        while (i != n || j != n) {
            if (tempi == j && tempj == i) {
                if (i == n || j == n) {
                    break;
                } else {
                    if (i > j) {
                        i += 1;
                        tempi = i;
                        tempj = j;
                    } else {
                        j += 1;
                        tempj = j;
                        tempi = i;
                    }
                }
            } else {
                if (tempi >= tempj) {
                    i--;
                    j++;
                } else {
                    j--;
                    i++;
                }
            }
            arr[count] = mat[i][j];
            if (tempi < n) {
                arr[arrn - count] = mat[n - i][n - j];
            }
            count++;
        }
        return arr;
    }
}
