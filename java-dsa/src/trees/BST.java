package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private final String RIGHT_RIGHT = "rr";
    private final String LEFT_RIGHT = "lr";
    private final String LEFT_LEFT = "ll";
    private final String RIGHT_LEFT = "rl";

    private Node root;

    public void removeLite(int val) {
        root = removeNodeLite(val, root);
    }

    public void balanceInsert(int val) {
        System.out.println(val + " -----");
        root = balanceAddToNode(val, root, null);
    }

    private Node balanceAddToNode(int val, Node node, Node parent) {
        if (node == null) {
            node = createNodeWithParent(val, parent);
        } else {
            if (val > node.value) {
                node.right = balanceAddToNode(val, node.right, node);
            } else {
                node.left = balanceAddToNode(val, node.left, node);
            }
        }
        return balanceNode(node);
    }


    private Node balanceNode(Node node) {
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);
        int balancedFactor = Math.abs(rHeight - lHeight);
        System.out.println(node.value + " BF- " + balancedFactor);
        if (balancedFactor > 1) {
            String rotationType = getRotationType(node);
            System.out.println(rotationType);
            if (rotationType.equals(RIGHT_RIGHT)) {
                node = rotateRightToLeft(node);
                printLR(node);
            } else if (rotationType.equals(LEFT_LEFT)) {
                node = rotateLeftToRight(node);
                printLR(node);
            } else if (rotationType.equals(RIGHT_LEFT)) {
                node = rotateLeftToRight(node.right);
                printLR(node);
                node = rotateRightToLeft(node.parent);
                printLR(node);
            } else if (rotationType.equals(LEFT_RIGHT)) {
                node = rotateRightToLeft(node.left);
                printLR(node);
                node = rotateLeftToRight(node.parent);
                printLR(node);
            }
        }
        return node;
    }

    private String getRotationType(Node node) {
        if (node.right != null && node.right.right != null) return RIGHT_RIGHT;
        if (node.left != null && node.left.left != null) return LEFT_LEFT;
        if (node.left != null && node.left.right != null) return LEFT_RIGHT;
        return RIGHT_LEFT;
    }

    public int getHeight(Node node) {
        return calculateHeight(node);
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int left = calculateHeight(node.left);
        int right = calculateHeight(node.right);
        return Math.max(left, right) + 1;
//
//        if (node.left != null) {
//            left += calculateHeight(node.left, left, 0);
//        }
//
//        if (node.right != null) {
//            right += calculateHeight(node.right, 0, right);
//        }
//
//        if (node.left != null) left += 1;
//        if (node.right != null) right += 1;
//
////        Node rightNode1 = node.right;
////        Node leftNode1 = node.left;
////        Integer rightVal = rightNode1 != null ? rightNode1.value : null;
////        Integer leftVal = leftNode1 != null ? leftNode1.value : null;
//
////        System.out.println(node.value + " r-" + rightVal + " l-" + leftVal);
//
//        int max = Math.max(left, right);
////        System.out.println(node.value + " L-" + left + " R-" + right + " max-" + max);
////        System.out.println("----");
//        return max;
    }


    private Node removeNodeLite(int val, Node node) {
        if (node == null) return null;

        if (val > node.value) {
            node.right = removeNodeLite(val, node.right);
        } else if (val < node.value) {
            node.left = removeNodeLite(val, node.left);
        } else {
            boolean leftNull = node.left == null;
            boolean rightNull = node.right == null;
            if (leftNull) {
                return node.right;
            } else if (rightNull) {
                return node.left;
            }
            Node leftLargest = findRightLeaf(node.left);
            node.value = leftLargest.value;
            node.left = removeNodeLite(val, node.left);
        }
        return balanceNode(node);
    }

    public void remove(int val) {
        Node node = root;
        if (node == null) return;

        boolean leftNull = node.left == null;
        boolean rightNull = node.right == null;
//        case 1
        if (leftNull && rightNull) {
            root = null;
        } else if (node.value == val && (leftNull || rightNull)) { // case 2&3
            if (leftNull) {
                node = node.right;
                root = node;
                System.out.println("root right");
            } else {
                node = node.left;
                root = node;
                System.out.println("root left");
            }
        } else if (val >= node.value) { // case 2/3/4
            removeNode(val, node.right, root, false);
        } else {
            removeNode(val, node.left, root, true);
        }
    }

    public void removeNode(int val, Node node, Node parent, boolean left) {
        if (node == null) {
            System.out.println("null node");
            return;
        }
        boolean leftNull = node.left == null;
        boolean rightNull = node.right == null;
        System.out.println("leftNull - " + leftNull);
        System.out.println("rightNull - " + rightNull);
        System.out.println("parent L - " + left);

        //        case 1 both leaf nodes are empty
        if (leftNull && rightNull) {
            if (val == node.value) {
                if (left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                System.out.println("leaf remove");
            }
        } else if (node.value == val && (leftNull || rightNull)) {
            if (leftNull) {
                node = node.right;
            } else {
                node = node.left;
            }
            if (left) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            System.out.println("right/left remove");
        } else if (val > node.value) {
            removeNode(val, node.right, node, false);
            System.out.println(val + ">=" + node.value);
        } else if (val < node.value) {
            System.out.println(val + "<" + node.value);
            removeNode(val, node.left, node, true);
        } else {
            Node leftLargestLeaf = findRightLeaf(node.left);
            System.out.println("leftLargestLeaf - " + leftLargestLeaf.value);
            Node newNode = createNode(leftLargestLeaf.value);
            newNode.left = node.left;
            newNode.right = node.right;
            if (left) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            removeNode(leftLargestLeaf.value, newNode.left, newNode, true);
            System.out.println("dd");
        }
    }

    private Node findRightLeaf(Node node) {
        if (node.right == null) return node;
        return findRightLeaf(node.right);
    }

    public Integer find(int val) {
        Node found = findVal(val, root);
        return found != null ? found.value : null;
    }

    private Node findVal(int val, Node node) {
        if (node == null) return null;
        if (node.value == val) return node;
        if (val > node.value) return findVal(val, node.right);
        return findVal(val, node.left);
    }

    public void insert(int val) {
        root = addToNode(val, root);
    }

    private Node addToNode(int val, Node node) {
        if (node == null) {
            node = createNode(val);
        } else {
            if (val > node.value) {
                node.right = addToNode(val, node.right);
            } else {
                node.left = addToNode(val, node.left);
            }
        }
        return node;
    }

    public Node rotateLeftToRight(Node root) {
        Node newRoot = root.left;
        newRoot.parent = root.parent;
        root.parent = newRoot;
        root.left = newRoot.right;
        newRoot.right = root;
        root = newRoot;
        if (root.parent != null) {
            if (root.value > root.parent.value) {
                root.parent.right = root;
            } else {
                root.parent.left = root;
            }
        }
        return root;
    }

    public Node rotateRightToLeft(Node root) {
        Node newRoot = root.right;
        newRoot.parent = root.parent;
        root.parent = newRoot;
        root.right = newRoot.left;
        newRoot.left = root;
        root = newRoot;
        if (root.parent != null) {
            if (root.value > root.parent.value) {
                root.parent.right = root;
            } else {
                root.parent.left = root;
            }
        }
        return root;
    }

    public void print() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.value + ",");
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
    }

    public void printNew() {
        if (root == null) return;
        loop(root);
    }

    private void printLR(Node node) {
        Node right = node.right;
        Node left = node.left;
        Integer rightVal = right != null ? right.value : null;
        Integer leftVal = left != null ? left.value : null;
        System.out.println(node.value + " r-" + rightVal + " l-" + leftVal);
    }

    public void loop(Node node) {
        Node right = node.right;
        Node left = node.left;
        printLR(node);
        if (left != null) loop(node.left);
        if (right != null) loop(node.right);
    }

    private void tree(Node node, Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.value + ",");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    private void tree(Node node, String text) {
        if (node == null) return;
        Integer right = null;
        if (node.right != null) {
            right = node.right.value;
        }
        Integer left = null;
        if (node.left != null) {
            left = node.left.value;
        }
        System.out.println(node.value + " R-" + right + " L-" + left);
        tree(node.right, "right");
        tree(node.left, "left");
    }

    private Node createNode(int val) {
        Node node = new Node();
        node.value = val;
        return node;
    }

    private Node createNodeWithParent(int val, Node parent) {
        Node node = new Node();
        node.value = val;
        node.parent = parent;
        return node;
    }


    private class Node {
        int value;
        Node right;
        Node parent;
        Node left;
    }

}
