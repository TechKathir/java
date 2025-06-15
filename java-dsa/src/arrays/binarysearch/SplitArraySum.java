package arrays.binarysearch;

public class SplitArraySum {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(splitArray(arr, 2));
    }

    public static int splitArray(int[] arr, int k) {
        int n = arr.length-1;
        int s = 0;
        int e = 0;
        for(int i = 0; i <= n; i++){
            e+=arr[i];
            if(s < arr[i]){
                s = arr[i];
            }
        }
        while(s<e){
            int mid = s + (e-s)/2;
            int split = 0;
            int sum = 0;
            for(int i = 0; i <= n; i++){
                sum+=arr[i];
                if(sum > mid){
                    sum = arr[i];
                    split++;
                }
            }
            split++;
            System.out.println(mid + " - "+ split);
            if(split > k){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return e;
    }
}
