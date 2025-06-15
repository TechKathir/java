package arrays.algorithm;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 1, 0, 2, 0, 2};
        sortArr(arr);
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortArr(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(low, mid, arr);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(high, mid, arr);
                high--;
            }
        }
    }
}
