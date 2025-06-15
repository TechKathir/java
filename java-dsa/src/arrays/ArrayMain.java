package arrays;

public class ArrayMain {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 0, 0};
//        Map<Integer, Integer> map  = new HashMap<>();
////        integerIntegerMap.size()
////        map.remove()
//        Integer i = map.get(1);
//        System.out.println(longestOnes(arr, 1));
    }

    public static int longestOnes(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeros = 0;
        while (r < arr.length) {
            if (arr[r] == 0) zeros++;
            if (zeros <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            } else {
                if ((r - l + 1) <= maxLen) {
                    r++;
                } else {
                    if (arr[l] == 0) zeros--;
                    l++;
                }
            }
        }
        return maxLen;
    }

    public static int quickselect(int[] arr, int k) {
        return getSmallest(arr, k, arr.length - 1);
    }

    public static int getSmallest(int[] arr, int k, int pvtIdx) {
        int pivot = formatPivot(arr, pvtIdx);
        if ((pivot + 1) == k) return arr[pivot];
        if ((pivot + 1) > k) {
            System.out.println("pivot - " + (pivot - 1));
            return getSmallest(arr, k, pivot - 1);
        }
        System.out.println("pivot - " + (arr.length - 1));
        return getSmallest(arr, k, arr.length - 1);
    }

    public static int formatPivot(int[] arr, int pvtIdx) {
        int pivot = arr[pvtIdx];
        int n = arr.length - 1;
        int idx = 0;
        for (int i = 0; i < pvtIdx; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, idx);
                idx++;
            }

        }
        swap(arr, idx, pvtIdx);
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
        return idx;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static int search(int[] arr, int s, int e, int t, boolean start) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (start) {
                if (t > arr[mid]) {
                    s = mid + 1;
                } else if (t <= arr[mid]) {
                    e = mid - 1;
                }
            } else {
                if (t >= arr[mid]) {
                    s = mid + 1;
                } else if (t < arr[mid]) {
                    e = mid - 1;
                }
            }
        }
        if (start) {
            if (arr[s] == t) return s;
        } else {
            if (arr[e] == t) return e;
        }
        return -1;
    }


}
