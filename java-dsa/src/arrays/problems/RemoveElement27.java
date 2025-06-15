package arrays.problems;

public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 3, 4, 5, 6, 6,6,6,6};
//        {1,3,4,5,6, 5,6,6}
        int val = 3;
//        removeElement(nums, val);
//        removeElement(nums);
        System.out.println(removeElementTwice(nums));
        ;
    }

    /*
     * equals take and store
     * count add count for same val
     * if count <= 2 ? add to index then idx++
     *
     * */
    //    remove duplicate if it appears more than twice
    public static int removeElementTwice(int[] nums) {
        int index = 1;
        int count = 1;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (val == nums[i]) {
                count++;
            } else {
                val = nums[i];
                count = 1;
            }
            if (count <= 2) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    //    for sorted array
    public static int removeElement(int[] nums) {
        int index = 1;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[index] = nums[i];
                index++;
                val = nums[i];
            }
        }
        return index;
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            System.out.println("l-" + left);
            System.out.println("r-" + right);
            if (nums[left] != val) {
                nums[index] = nums[left];
                index++;
            }
            left++;
            if (nums[right] != val) {
                nums[index] = nums[right];
                index++;
            }
            right--;
            System.out.println("---");
        }
        return index;
    }
}
