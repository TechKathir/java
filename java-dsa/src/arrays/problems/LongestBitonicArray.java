package arrays.problems;

public class LongestBitonicArray {
    public static void main(String[] args) {
        String[] arr = {"", " ", "1", "  ", "w"};
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr) {
            System.out.println(s+" - "+ s.isBlank());
            System.out.println(s+" - "+ s.isEmpty());
            System.out.println("---");
        }  // Expected bitonic: [1,3,5,4] → length = 4

//        System.out.println("Ans - " + LongestBitonicSequence(arr.length, arr));
    }

    public static int LongestBitonicSequence(int n, int[] arr) {
        int l = 0;
        int r = 0;
        int decIdx = -1;
        boolean inc = true;
        int len = 0;
        boolean peak = false;
        int count = 0;
        while (r < n) {
            if(r-1 >= 0 && arr[r] > arr[r-1] && count == 0) count++;
            if((r+1) < n && arr[r] > arr[r+1] && count > 0) count++;
            if (inc) {
                if ((r + 1) < n && arr[r] > arr[r + 1]) {
                    inc = false;
                    decIdx = r + 1;
                    count++;
                }
            } else {
                if ((r + 1) < n && arr[r] <= arr[r + 1]) {
                    inc = true;
                    System.out.println("l-"+l);
                    System.out.println("r-"+r);
                    len = Math.max(len, r - l + 1);
                    l = decIdx;
                }
            }
            r++;
        }
        if(count <= 2) return 0;
        System.out.println("l-"+l);
        System.out.println("r-"+r);
        if (!inc) {
            len = Math.max(len, r - l);
        }
        return len;
    }
}
