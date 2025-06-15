package arrays.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public static void main(String[] args) {
//        int[] list = {2, 2, 2, 2, 2};
        int[] f = {1000000000, 1000000000, 1000000000, 1000000000};
//        sort(f);
//        for (int i = 0; i < f.length; i++) {
//            System.out.println(i);
//        }
        System.out.println(fourSum(f, -294967296).toString());
//        System.out.println(2000000000 < -294967296);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
//                System.out.println("con 1 - " + nums[i] + " i-" + i);
                continue;
            }
            int one = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
//                    System.out.println("con 2 - " + nums[j] + " j-" + j);
                    continue;
                }
                long two = nums[j] + nums[i];
                int left = j + 1;
                int right = n;
                while (left < right) {
//                    System.out.println("l-" + left + " r-" + right);
                    if (left != (j + 1) && nums[left] == nums[left - 1]) {
//                        System.out.println("l-" + left);
                        left++;
                        continue;
                    }
                    if (right != n && nums[right] == nums[right + 1]) {
//                        System.out.println("r-" + right);
                        right--;
                        continue;
                    }
                    long total = two + nums[right] + nums[left];
                    if (total < target) {
                        left++;
                    } else if (total > target) {
                        right--;
                    } else {
                        List<Integer> integers = Arrays.asList(one, nums[j], nums[left], nums[right]);
                        quadruplets.add(integers);
                        left++;
                        right--;
                    }
                }
            }
//            System.out.println("-----");
        }
        return quadruplets;
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int idx = j;
                if (nums[i] > nums[idx]) {
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                }
            }
        }
    }
}
//[0, 0, -2, 2]
//[1, -2, -1, 2]
