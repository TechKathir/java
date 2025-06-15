package arrays.patterns;

public class Diagonally {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int idx = 0;
        while(arr.length > idx){
            System.out.println(arr[idx]);
            idx++;
        }
//        System.out.println(v);
//        for(int i = 1; i<= 500;i++){
//            matrixDiagonally(generate(1));
//        }
//        int[][] generate = generate(89);
//        int[] ints =
//        for(int i : ints){
//            System.out.print(i + ",");
//        }
//        for(int i = 0; i< generate.length;i++){
//            for(int j = 0; j< generate[i].length;j++){
//                System.out.print(generate[i][j] + ",");
//            }
//            System.out.println("");
//        }
    }

    public static int[][] generate(int val){
        int[][] mat = new int[val][val];
        int count =    1;
        for(int i = 0; i< val;i++){
            for(int j = 0; j< val;j++){
                mat[i][j] = count++;
            }
        }
        return mat;
    }

    public static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int row = 0;
        int col = 1;
        int[] start = {0, 0};
        int[] curr = {0,0};
        int n2= n*n;
        int[] arr = new int[n2];
        n-=1;
        int idx = 0;
        while(idx <= n2){
            arr[idx] = mat[curr[row]][curr[col]];
            if(start[row] == curr[col] && start[col] == curr[row]){
                // down
                if((curr[row] > 0 || curr[col] == n) && curr[row] < n){
                    start[row] = curr[row]+1;
                    start[col] = curr[col];
                    curr[row] = start[row];
                    idx++;
                    // Right
                }else if (curr[col] >= 0 && curr[col] < n){
                    start[col] = curr[col]+1;
                    start[row] = curr[row];
                    curr[col] = start[col];
                    idx++;
                }else{
                    break;
                }
            }else{
                if(start[row] > start[col]){
                    curr[row] = curr[row]-1;
                    curr[col] = curr[col]+1;
                }else{
                    curr[row] = curr[row]+1;
                    curr[col] = curr[col]-1;
                }
                idx++;
            }
        }
        return arr;
    }
}
