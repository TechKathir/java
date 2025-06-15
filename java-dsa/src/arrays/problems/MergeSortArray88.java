package arrays.problems;

public class MergeSortArray88 {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 7, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        int m = 3;
        int n = 3;
        int f = Integer.MIN_VALUE;
        mergeOptimal(nums1, m, nums2, n);
    }

    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int place = (n + m) - 1;
        System.out.println("p-" + place);
        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[place] = nums1[left];
                left--;
            } else {
                nums1[place] = nums2[right];
                right--;
            }
            place--;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int i = 0;
        int[] arr = new int[n + m];
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                arr[i] = nums1[left];
                left++;
            } else {
                arr[i] = nums2[right];
                right++;
            }
            i++;
        }
        while (left < n) {
            arr[i] = nums1[left];
            i++;
            left++;
        }
        while (right < m) {
            arr[i] = nums2[right];
            i++;
            right++;
        }
    }

}

/**
 * Tests
 * num1 with 0 and n as 1 -> dont need to sort
 * num1 lenght a and n as 0 -> dont need to sort
 * static void quickSort(int arr[], int l, int r) {
 *         if (l >= r) return;
 *
 *         int partition = partition(arr, l, r);
 *         int temp = arr[l];
 *         arr[l] = arr[partition];
 *         arr[partition] = temp;
 *
 *         quickSort(arr, l, partition - 1);
 *         quickSort(arr, partition + 1, r);
 *     }
 *
 *     static int partition(int arr[], int l, int r) {
 *         int pivot = arr[l];
 *         while (l < r) {
 *             while (arr[l] <= pivot && l < r) {
 *                 l++;
 *             }
 *             while (arr[r] > pivot && r >= l) {
 *                 r--;
 *             }
 *             if (l < r) {
 *                 int temp = arr[l];
 *                 arr[l] = arr[r];
 *                 arr[r] = temp;
 *             }
 *         }
 *         return r;
 *     }
 */