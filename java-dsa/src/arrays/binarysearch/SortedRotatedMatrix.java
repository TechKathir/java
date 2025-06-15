package arrays.binarysearch;

public class SortedRotatedMatrix {

    public static void main(String[] args) {
//        int[][] arr = {{500, 501, 502, 503, 504, 505}, {400, 401, 402, 403}, {300, 301, 0, 10, 20, 30}, {200, 201, 202, 203, 50, 60}, {100, 101, 102, 1, 2, 3}};
//        int[] start = findStart(arr);
//        System.out.println(start[0] + " - " + start[1]);
        int[] arr= {1,2,3,1};
        System.out.println(findPeakElement(arr));
    }

    public static  int findPeakElement(int[] arr) {
        int n = arr.length-1;
        int s = 0;
        int e = n;
        while (s<e){
            int mid = s+(e-s)/2;
            if(mid < n && arr[mid] < arr[mid+1]){
                s = mid+1;
            }else if(mid > 0 && arr[mid] < arr[mid-1]){
                e = mid-1;
            }else{
                return arr[mid];
            }
        }
        return arr[e];
    }

    public static int[] findStart(int[][] mt){
        int ps = 0;
        int pe = mt.length-1;
        int[] arr = {0,0};
        while(ps<=pe){
            int mid = ps+(pe-ps)/2;
            int currRowN = mt[mid].length-1;
            System.out.println("mid - "+ mid);
            if(mt[mid][0] > mt[mid][currRowN]){
                arr[1] = findStartChild(mt[mid]);
                arr[0] = mid;
                return arr;
            }
            if(mid < currRowN){
                if(mt[mid][currRowN] > mt[mid+1][0]){
                    arr[0] = mid+1;
//                    arr[1] = 0;
                    return arr;
                }
            }
            if(mid > 0){
                int n = mt[mid-1].length-1;
                if(mt[mid][0] < mt[mid-1][n]){
                    arr[0] = mid;
//                    arr[1] = 0;
                    return arr;
                }
            }
//            int psRowN = mt[ps].length-1;
            if(mt[ps][0] > mt[mid][currRowN]){
                System.out.println("yes - "+ mid);
                pe = mid-1;
            }else{
                ps = mid+1;
            }
        }
        arr[0] = -1;
        arr[1] = -1;
        return arr;
    }

    public static int findStartChild(int[] arr){
        int n = arr.length-1;
        int s = 0;
        int e = n;
        while(s<e){
            int mid = s+(e-s)/2;
            if(mid > n && arr[mid] > arr[mid+1]){
                return mid+1;
            }
            if(mid > 0 && arr[mid] < arr[mid-1]){
                return mid;
            }
            if(arr[s] > arr[mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return e;
    }
}
