package priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

    List<Integer> list = new ArrayList<>();

    private int getParentIdx(int currentIdx) {
        double myDouble = (double) (currentIdx - 1) / 2;
        return (int) myDouble;
    }

    public PriorityQueue(List<Integer> list) {
        list.forEach(v -> {
            insert(v);
        });
    }

    public String toString() {
        return list.toString();
    }


    public void insert(Integer integer) {
        list.add(integer);
        bubbleBottomToTop(list.size() - 1);
        System.out.println(list.toString());
    }

    public int getLastIdx() {
        return list.size() - 1;
    }

    public void poll() {
        list.set(0, list.get(getLastIdx()));
        list.remove(getLastIdx());
        List<Integer> integers = bubbleTopToBottom(0);
        System.out.println(integers.toString());
    }

    public void remove(Integer value) {
        int removeIdx = list.indexOf(value);
        if (removeIdx == getLastIdx()) return;
        swap(removeIdx, getLastIdx());
        list.remove(getLastIdx());
        Integer newVal = list.get(removeIdx);
        int parentIdx = getParentIdx(removeIdx);
        Integer parentVal = list.get(parentIdx);
        System.out.println("parentIdx - " + parentIdx);
        System.out.println("parentVal - " + parentVal);
        System.out.println("newVal - " + newVal);
        if (parentVal > newVal) {
            System.out.println("bottom to top");
            System.out.println(list.toString());
            return;
        }
        System.out.println("bubbleTopToBottom");
        List<Integer> integers = bubbleTopToBottom(removeIdx);
        System.out.println(integers.toString());
    }

    private int getRightNode(int idx) {
        return 2 * idx + 2;
    }

    private int getLeftNode(int idx) {
        return 2 * idx + 1;
    }

    private List<Integer> bubbleTopToBottom(int currentIdx) {
        System.out.println("-----------------");
        System.out.println("currentIdx - " + currentIdx);
        Integer currVal = list.get(currentIdx);
        System.out.println("currVal - " + currVal);
        int leftNode = getLeftNode(currentIdx);
        int rightNode = getRightNode(currentIdx);
        System.out.println("rightNode - " + rightNode);
        System.out.println("leftNode - " + leftNode);
        if (leftNode > getLastIdx()) {
            System.out.println("left node greater 1 - " + leftNode);
            return list;
        } else if (rightNode > getLastIdx()) {
            Integer leftVal = list.get(leftNode);
            System.out.println("leftVal - " + leftVal);
            if (leftVal < currVal) {
                System.out.println("leftVal > currVal");
                swap(leftNode, currentIdx);
                return bubbleTopToBottom(leftNode);
            } else {
                System.out.println("end 1");
                return list;
            }
        } else {
            Integer leftVal = list.get(leftNode);
            Integer rightVal = list.get(rightNode);
            System.out.println("leftVal - " + leftVal);
            System.out.println("rightVal - " + rightVal);
            Integer node = leftVal <= rightVal ? leftNode : rightNode;
            System.out.println("node - " + node);
            if (list.get(node) <= currVal) {
                swap(node, currentIdx);
                return bubbleTopToBottom(node);
            } else {
                System.out.println("end 2");
                return list;
            }
        }
    }

    private void swap(int idx1, int idx2) {
        Integer temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    private void bubbleBottomToTop(int idx) {
        if (idx == 0) return;
        Integer currentVal = list.get(idx);
        int parentIdx = getParentIdx(idx);
        System.out.println("parentIdx - " + parentIdx);
        Integer parentVal = list.get(parentIdx);
        System.out.println("parentVal - " + parentVal + " currentVal - " + currentVal);
        if (parentVal >= currentVal) {
            list.set(parentIdx, currentVal);
            list.set(idx, parentVal);
            System.out.println("------------------");
            bubbleBottomToTop(parentIdx);
        } else {
            System.out.println("not greater than child");
        }
    }

    public boolean isValidMinHeap() {
        return isValidNode(0);
    }

    private boolean isValidNode(int idx) {
        Integer parentVal = list.get(idx);
        int rightNode = getRightNode(idx);
        int leftNode = getLeftNode(idx);
        if (leftNode > getLastIdx() && rightNode > getLastIdx()) return true;
        boolean rightResult = true;
        boolean leftResult = true;
        if (rightNode < getLastIdx()) {
            rightResult = parentVal <= list.get(rightNode);
            if (rightResult) {
                rightResult = isValidNode(rightNode);
            }
        }
        if (leftNode < getLastIdx()) {
            leftResult = parentVal <= list.get(leftNode);
            if (leftResult) {
                leftResult = isValidNode(leftNode);
            }
        }
        return rightResult && leftResult;
    }

}
