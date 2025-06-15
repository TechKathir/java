package arrays.problems;

public class Triplet {
    public static void main(String[] args) {
        int[] arr = {56, 1, 16, 8, 7, 65, 2, 67};
        int[][] d = new int[2][3];
        d[4]  = new int[]{1, 2};
        System.out.println(hasTripletSum(arr, 167));
    }

    public static boolean hasTripletSum(int arr[], int target) {

        for(int i = 0; i< arr.length;i++){
            for(int j = i; j< arr.length-1;j++){
                int idx = j+1;
                if(arr[i] > arr[idx]){
                    int temp = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = temp;
                }
            }
        }

        for(int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+", ");
        }

        System.out.println("");
        boolean  matched = false;
        for(int i = 0; i< arr.length;i++){
            int val1 = arr[i];
            int left = 0;
            int right = arr.length - 1;

            while(left < right){
                if(left == i){
                    left++;
                }else if (right == i){
                    right--;
                }else{
                    int val2 = arr[left];
                    int val3 = arr[right];
                    int total = val1+val2+val3;

                    if(total > target){
                        right--;
                    } else if(total < target){
                        left++;
                    }else {
                        matched = true;
                        break;
                    }
                }
            }
            if(matched) break;
        }
        return matched;
    }
}
