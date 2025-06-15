package trees;

import java.util.Arrays;
import java.util.List;

public class BSTMain {
    public static void main(String[] args) {
        BST bst = new BST();
//        5 r-10 l-4
        bst.balanceInsert(4);
        bst.balanceInsert(3);
        bst.balanceInsert(6);
        bst.balanceInsert(2);
        bst.removeLite(6);
//        bst.balanceInsert();
//        bst.getHeight();
        System.out.println("-------");
//        bst.rotateRightToLeft();
        bst.printNew();

//        bst.insert(11);
//        bst.insert(6);
//        bst.insert(15);
//        bst.insert(3);
//        bst.insert(8);
//        bst.insert(1);
//        bst.insert(5);
//        bst.insert(13);
//        bst.insert(17);
//        bst.insert(19);
//        bst.insert(12);
//        bst.insert(14);
//        bst.insert(10);
//        bst.insert(11);
//        bst.remove(10);
//        bst.remove(20);
//        bst.print();

        List<Integer> integers = Arrays.asList(null, 1, 2, 3, 4, 5, 6, 7);
        FenwickTree fenwickTree = new FenwickTree(integers);
//        fenwickTree.print();
//        System.out.println(fenwickTree.getChildIdx(8));
//        System.out.println(fenwickTree.getTotal(4));
//        fenwickTree.pointUpdate(1,10);
//        fenwickTree.print();
//        System.out.println(fenwickTree.range(1, 3));
//        for (int i = 1; i < integers.size(); i++) {
//            System.out.println("sift - "+ fenwickTree.getParentIndex(i));
//            System.out.println("pow - "+ fenwickTree.getParentIndex2(i));
//            System.out.println("--------");
//        }
//        System.out.println(fenwickTree.getParentIndex(3));
//        System.out.println(fenwickTree.construct());
//        System.out.println(getParentIndex(12));
//        for (int i = 1; i <= integers.size(); i++) {
//            System.out.println(integers.get(i));
//        }


    }
}
