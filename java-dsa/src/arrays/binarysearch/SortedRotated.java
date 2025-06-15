package arrays.binarysearch;

public class SortedRotated {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
    }

    public static int peakElement(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        while(s<e){
            int mid = s+(e-s)/2;
            System.out.println("mid-"+ mid);
            boolean left = false;
            boolean right = false;
            if(mid+1 >= n){
                right = true;
            }else if(arr[mid] > arr[mid+1]){
                right = true;
            }
            if(mid-1 < 0){
                left = true;
            }else if(arr[mid] > arr[mid-1]){
                left = true;
            }
            if(right && left) return mid;
            if(!right){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return -1;
    }

    public static int findPeak(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n - 1;
        if (arr[s] < arr[e]) return 0;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mid + 1 < n && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (mid - 1 > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] == arr[s] && arr[e] == arr[mid]) {
                if (s + 1 < n && arr[s] > arr[s + 1]) {
                    return s + 1;
                }
                s++;
                if (e - 1 > 0 && arr[e] < arr[e - 1]) {
                    return e;
                }
                e--;
            } else if (arr[mid] < arr[e]) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return e;
    }

    public static int maximumElementDuplicate(int[] arr) {
        int n = arr.length;
        int e = n - 1;
        int s = 0;
        if (n == 1) return arr[s];
        if (arr[e] > arr[s]) return arr[e];
        while (s < e) {
            int mid = s + (e - s) / 2;
            System.out.println("mid - " + mid);
            System.out.println("s - " + s + " e - " + e);
            if ((mid + 1) < n && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if ((mid - 1 >= 0) && arr[mid] < arr[mid - 1]) {
                return arr[mid - 1];
            }
            if (arr[s] == arr[mid] && arr[e] == mid) {
                if (arr[s] > arr[s + 1]) {
                    return arr[s];
                }
                s++;
                if (arr[e] < arr[e - 1]) {
                    return arr[e - 1];
                }
                e--;
            } else if (arr[s] > arr[mid]) {
                e = mid - 1;
            } else {
                s = mid;
            }
        }
        return s;
    }

    public static int maximumElement(int[] arr) {
        int n = arr.length;
        int e = n - 1;
        int s = 0;
        if (n == 1) return arr[s];
        if (arr[e] > arr[s]) return arr[e];
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] < arr[mid - 1]) {
                return arr[mid - 1];
            }
            if (arr[s] > arr[mid]) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return -1;
    }
}
