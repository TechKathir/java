package arrays.problems;

public class Rotate90 {
//(3,8)= > (8,3)
    public static void main(String[] args) {

        int[] arr = {1,2,4};
        rotate(arr, 1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    public static void rotate(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        if(k == 0) {
            System.out.println("no rotation");
            return;
        }
        int[] leftHalf = new int[k];
        int[] rightHalf = new int[n-k];
        for(int i = 0;i < k; i++){
            leftHalf[i] = arr[i];
        }
        for(int i = 0;i < (n-k); i++){
            rightHalf[i] = arr[k+i];
        }
//        for(int v: rightHalf){
//            System.out.print(v+" ");
//        }
//        System.out.println();
//        for(int v: leftHalf){
//            System.out.print(v+" ");
//        }
        for(int i = 0; i< (n-k) ;i++){
            arr[i] = rightHalf[i];
        }
        for(int i = 0; i < k;i++){
            arr[(n-k)+i] = leftHalf[i];
        }
    }

    public static void reverse(int[][] mat, int c){
        int s = 0;
        int e = mat.length-1;
        while (s<e){
            int temp = mat[s][c];
            mat[s][c] = mat[e][c];
            mat[e][c] = temp;
            e--;
            s++;
        }
    }

    public static void swap(int[][] mat){
        int n = mat.length;
        for(int r = 0; r< n;r++){
            for(int c = r;c<n;c++){
                int temp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = temp;
            }
        }
    }
}
