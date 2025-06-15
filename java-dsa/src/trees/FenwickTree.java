package trees;

import java.util.List;

public class FenwickTree {

    private final List<Integer> list;

    public FenwickTree(List<Integer> list) {
        this.list = list;
        construct();
    }

    private static int LSB(int n) {
        return (int) ((Math.log(n & -n) / Math.log(2)) + 1);
    }

    private static int lsbToBinary(int lsb) {
        return 1 << (lsb - 1);
    }

    public static int getParentIndex(int i) {
        return (i + getResponsible(i));
    }

    public static int getChildIdx(int i) {
        return (i - getResponsible(i));
    }

    public static int getResponsible(int i) {
        return (int) Math.pow(2, LSB(i) - 1);
    }


    public static int getParentIndex2(int i) {
        return i + lsbToBinary(LSB(i));
    }

//    private int LSBtoBinary(int lsb) {
//
//    }


//    public static void main(String[] args) {
//        System.out.println(getParentIndex(4));
////        System.out.println(lsbToBinary(LSB(8)));
////        System.out.println(getParentIndex(8));
////        System.out.println(factorial(LSB(8), 1));
//    }

    public void construct() {
        for (int i = 1; i < list.size(); i++) {
            int parentIndex = getParentIndex(i);
//            System.out.println("parentIndex - " + parentIndex);
            if (parentIndex >= list.size()) {
//                System.out.println("greater - " + (i));
            } else {
                Integer added = list.get(i) + list.get(parentIndex);
//                System.out.println("currVal - " + list.get(i) + "parentVal - " + list.get(parentIndex) + "added -" + added);
                list.set(parentIndex, added);
            }
        }
    }

    public void print() {
        System.out.println(list.toString());
    }


    public int getTotal(int idx) {
        if (idx == 0) return 0;
        int sum = 0;
        int childIdx = idx;
        while (childIdx != 0) {
            sum = sum + list.get(childIdx);
            System.out.println("childIdx - " + childIdx);
            childIdx = getChildIdx(childIdx);
        }
        return sum;
    }

    public int range(int start, int end) {
        int a = getTotal(start - 1);
//        int a = 0;
        int b = getTotal(end);
        System.out.println("a - " + a);
        System.out.println("b - " + b);
        return b - a;
    }

    private void update(int idx, int val) {
        int parentIdx = getParentIndex(idx);
        while (parentIdx < list.size()) {
            list.set(parentIdx, list.get(parentIdx) + val);
            parentIdx = getParentIndex(parentIdx);
        }
    }

    public void pointUpdate(int idx, int value) {
        if (idx >= list.size()) return;
        int oldVal = list.get(idx);
        System.out.println("old - " + oldVal);
        list.set(idx, value);
        int diff = value - oldVal;
        System.out.println("diff - " + diff);
        update(idx, diff);
//        System.out.println("diff - " + diff);
    }


/**
 * construct
 * get parentIndex = i + lSB(i)
 * */
}
