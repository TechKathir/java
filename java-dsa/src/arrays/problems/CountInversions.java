package arrays.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {10, 12, 454, 6, 1, 8, 3, 1, 2, 3, 2, 8, 7, 1};
        int[] temp = new int[arr.length];
    }

    static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (high <= low) return;
        int center = (high + low) / 2;
        mergeSort(arr, low, center, temp);
        mergeSort(arr, center + 1, high, temp);
        rearrange(arr, low, high, center, temp);
    }

    static int[] arr(){
        List<List<Integer>> lists =new ArrayList<>();
        lists.add(List.of(1,3));
        List<Integer> integers = new ArrayList<>(List.of(1,3));
        return new int[]{1, 4};
    }


    static void rearrange(int[] arr, int low, int high, int center, int[] temp) {
        int l = low;
        int r = center + 1;
        int idx = low;
        while (l <= center && r <= high) {
            if (arr[l] <= arr[r]) {
                temp[idx] = arr[l];
                idx++;
                l++;
            } else {
//                c+=(r-l);
                temp[idx] = arr[r];
                idx++;
                r++;
            }
        }
        Set<Integer> f = new HashSet<>();
        while (l <= center) {
            temp[idx] = arr[l];
            idx++;
            l++;
        }
        while (r <= high) {
            temp[idx] = arr[r];
            idx++;
            r++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    static int inversionCount(int[] arr) {

        return 0;
    }
}

/*
    mergeSort(arr[], low, high):
         if(high<=low) return;
         center = high/2;
         mergeSort(arr, low, center);
         mergeSort(arr, center+1, high);
         rearrange(arr, low, high, center)


    rearrange(arr[], low, high, center):
         temp[] = high-low;
         idx=0;
         l=low;
         r=center+1;

         while(l<= center && r <= high){
            if(l < r) temp[idx]=arr[l] idx++ l++
            else temp[idx]=arr[r] idx++ r++
         }
         while(l <= center){
            temp[idx]=arr[l] idx++ l++
         }
         while(r <= high){
            temp[idx]=arr[r] idx++ r++
         }
         for(low to high) update
*/