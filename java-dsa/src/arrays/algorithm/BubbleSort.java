package arrays.algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
//        bubbleSort(arr);
//        System.out.println();
//        loop(arr, 0, arr.length);
//        insertionSort(arr, 0, arr.length - 1);
//        loop(arr, 0, arr.length);
//        mergeSort(arr, 0, arr.length - 1);
//
//        for (int i : arr) {
//            System.out.print(i + ",");
//        }

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return; // Base case

        int pivotIndex = partition(arr, l, r);
        System.out.println("pivotIndex - " + pivotIndex);
        quickSort(arr, l, pivotIndex - 1); // Sort left half
//        quickSort(arr, pivotIndex + 1, r); // Sort right half
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r]; // Using last element as pivot (Lomuto Partition)
        int i = l - 1; // Index for smaller elements
        for (int j = l; j < r; j++) {
            System.out.println("i-"+i+" j-"+j);
            if (arr[j] < pivot) { // Move smaller elements to left
                i++;
                swap(arr, i, j);
                for (int i1 = 0; i1 < arr.length; i1++) {
                    System.out.print(arr[i1] + ",");
                }
                System.out.println();
            }
        }
        // Place pivot in correct position
        swap(arr, i + 1, r);
        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.print(arr[i1] + ",");
        }
        System.out.println("\ni-" + i);
        return i + 1; // Return pivot index
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static void quickSort(int[] arr, int l, int r) {
//        if ((r - l) <= 0) return;
//
//        int start = l;
//        int end = r;
//
//        int pivot = arr[l];
//
//        while (l <= r) {
//            if (arr[l] <= pivot && l < end) {
//                l++;
//            } else if (arr[r] > pivot) {
//                r--;
//            }
//            if (l < r && arr[l] > pivot && arr[r] <= pivot) {
//                int temp = arr[l];
//                arr[l] = arr[r];
//                arr[r] = temp;
//            }
//        }
//
//        int temp = arr[start];
//        arr[start] = arr[r];
//        arr[r] = temp;
//        for (int i : arr) {
//            System.out.print(i + ",");
//        }
//        System.out.println();
//        quickSort(arr, start, r - 1);
//        quickSort(arr, r + 1, end);
//    }


    public static void mergeSort(int[] arr, int l, int h) {
        int[] temp = new int[h + 1];
        originalSort(arr, l, h, temp);
    }

    public static void originalSort(int[] arr, int l, int h, int[] temp) {
        if (l >= h) return;
        int mid = (l + h) / 2;
        originalSort(arr, l, mid, temp);
        originalSort(arr, mid + 1, h, temp);
        mergeArray(arr, l, mid, h, temp);
    }


    public static void mergeArray(int[] arr, int low, int mid, int high, int[] temp) {
        int left = low;
        int right = mid + 1;
        int idx = 0;
        while (left <= mid && right <= high) {
            if (arr[left] >= arr[right]) {
                temp[idx] = arr[right];
                right++;
            } else {
                temp[idx] = arr[left];
                left++;
            }
            idx++;
        }
        while (left <= mid) {
            temp[idx] = arr[left];
            left++;
            idx++;
        }
        while (right <= high) {
            System.out.println("--" + idx);
            temp[idx] = arr[right];
            right++;
            idx++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public static void insertionSort(int[] arr, int idx, int size) {
        if (idx >= size) return;
        insertionSwap(arr, idx + 1);
        insertionSort(arr, ++idx, size);
    }

    public static void insertionSwap(int[] arr, int idx) {
        if (idx < 1) return;
        if (arr[idx - 1] > arr[idx]) {
            int temp = arr[idx];
            arr[idx] = arr[idx - 1];
            arr[idx - 1] = temp;
        }
        insertionSwap(arr, --idx);
    }

    public static void loop(int[] arr, int idx, int length) {
        if (idx > (length - 1)) return;
        System.out.print(arr[idx] + ",");
        loop(arr, ++idx, length);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            swapRecrussion(arr, 0, arr.length - (i + 1));
        }
    }

    public static void swapRecrussion(int[] arr, int j, int maxIdx) {
        if (j > (maxIdx - 1)) return;
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
        swapRecrussion(arr, ++j, maxIdx);
    }
}

