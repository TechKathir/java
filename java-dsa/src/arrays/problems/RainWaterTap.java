package arrays.problems;

public class RainWaterTap {

    public static void main(String[] args) {
        int[] arr = {3, 0};
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int arr[]) {
        int n = arr.length;
        System.out.println("n - "+ n);
        if (n < 3) return 0;
        int unit = 0;
        int lmax = arr[0];
        int rmax = arr[n - 1];

        int left = 1;
        int right = n - 2;
        System.out.println("left - "+ left);
        System.out.println("right - "+ right);
        while (left < right) {
            System.out.println("--");
            int l = arr[left];
            int r = arr[right];
            if (lmax <= rmax) {
                if (lmax > l) {
                    System.out.println("l");
                    unit = unit + (lmax - l);
                } else {
                    lmax = l;
                }
                left++;
            } else {
                if (rmax > r) {
                    System.out.println("r");
                    unit = unit + (rmax - r);
                } else {
                    rmax = r;
                }
                right--;
            }
        }
        return unit;
    }
}
