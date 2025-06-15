package arrays.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MountainArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11));
        int x = peakElement(arr);
        int t = 12;
        System.out.println(arr.get(x));
        int search = searchAss(arr, t, 0, x);
        if(search != -1){
            System.out.println(search);
        }else {
            System.out.println(searchDesc(arr, t, x, arr.size()-1));
        }
    }

    public static int searchAss(ArrayList<Integer> arr, int t, int s, int e){
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr.get(mid) > t){
                e = mid-1;
            }else if(arr.get(mid) < t){
                s=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int searchDesc(ArrayList<Integer> arr, int t, int s, int e){

        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr.get(mid) > t){
                s=mid+1;
            }else if(arr.get(mid) < t){
                e = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int peakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        int s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            boolean isLeftSmaller = (mid <= 0 || arr.get(mid) > arr.get(mid - 1));
            boolean isRightSmaller = (mid >= n - 1 || arr.get(mid) > arr.get(mid + 1));

            if (isLeftSmaller && isRightSmaller) {
                return mid; // Peak element found
            }

            // If right neighbor is greater, move right
            if (!isRightSmaller) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1; // Should not reach here for valid input
    }
}
