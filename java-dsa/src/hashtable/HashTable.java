package hashtable;

import java.util.LinkedList;
import java.util.Objects;

public class HashTable {
    private double LOAD_FACTOR = 0.65;
    private int capacity = 3;
    private double threshold;
    private LinkedList<Node>[] table;
    private Node[] openTable;

    int size;

    public HashTable() {
        threshold = capacity * LOAD_FACTOR;
        table = new LinkedList[capacity];
        openTable = new Node[capacity];
    }

    private int getHashCode(int hashKey) {
        return (hashKey & 0x7FFFFFFF) % capacity;
    }

    public boolean contains(Integer key) {
        int index = getHashCode(key.hashCode());
        LinkedList<Node> nodes = table[index];
        if (nodes == null) return false;
        for (Node node : nodes) {
            if (node.key.equals(key)) return true;
        }
        return false;
    }

    private Integer getPositive(Integer hashKey) {
        return hashKey & 0x7FFFFFFF;
    }

    private int calculateOpenAddress(Integer hashKey, int x) {
        int A = 1;
        return (hashKey + (A * x)) % capacity;
    }

    private Integer getOpenAddressHashKey(Integer key) {
        int keyHash = getPositive(key.hashCode());
        int x = 0;
        int index = calculateOpenAddress(keyHash, x);
        while (openTable[index] != null && !Objects.equals(openTable[index].key, key)) {
            x++;
//            System.out.println("index - " + index);
            index = calculateOpenAddress(keyHash, x);
        }
        return index;
    }


    public void putLinearProbing(Integer key, Integer value) {
        System.out.println("size - " + size);
        System.out.println("threshold - " + threshold);
        System.out.println("capacity - " + capacity);
        if (key >= threshold) resizeLinearProbing();
        Integer openAddressIdx = getOpenAddressHashKey(key);
        if (openTable[openAddressIdx] == null) {
            openTable[openAddressIdx] = new Node(key, value);
            if (++size > threshold) {
                System.out.println("resize");
                resizeLinearProbing();
            }
        } else {
            openTable[openAddressIdx].value = value;
        }
    }

    private void resizeLinearProbing() {
        capacity = capacity * 2;
        threshold = capacity * LOAD_FACTOR;
        System.out.println("c - " + capacity);
        System.out.println("t - " + threshold);
        System.out.println("open len - " + openTable.length);
        Node[] newOpenTable = new Node[capacity];
        for (Node node : openTable) {
            System.out.println("---");
            if (node != null) {
                Integer idx = getOpenAddressHashKey(node.hashcode);
                newOpenTable[idx] = node;
            }
        }
        openTable = newOpenTable;
        System.out.println("openTable - " + openTable.length);
    }

    public void putSeparateChanning(Integer key, Integer value) {
        System.out.println("key = " + key);
        Node node = new Node(key, value);
        int index = getHashCode(key.hashCode());
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        Node foundNode = getNode(key, table[index]);
        if (foundNode == null) {
            table[index].add(node);
            ++size;
            if (size > threshold) {
                System.out.println("resize");
                resize();
            }
        } else {
            node.value = value;
        }
    }

    private void resize() {
//        print();
        capacity = capacity * 2;
        threshold = capacity * LOAD_FACTOR;
        LinkedList<Node>[] newHashTable = new LinkedList[capacity];
        for (LinkedList<Node> nodeLinkedList : table) {
            if (nodeLinkedList == null) return;

            for (Node node : nodeLinkedList) {
                int idx = getHashCode(node.hashcode);
                if (newHashTable[idx] == null) {
                    newHashTable[idx] = new LinkedList<>();
                }
                newHashTable[idx].add(node);
            }
        }
        table = newHashTable;
//        print(newHashTable);
    }

    public void print() {
        for (int i = 0; i < openTable.length; i++) {
            if (openTable[i] == null) {
                System.out.println(i + " - null");
            } else {
                System.out.println(i + " - " + openTable[i].value);
            }
//            if (table[i] == null) {
//                System.out.println("null");
//            } else {
//                for (Node node : table[i]) {
//                    System.out.println(node.key + " hash - " + node.hashcode);
//                }
//            }
            System.out.println("----------");
        }
    }

    public void print(LinkedList<Node>[] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i);
            if (table[i] == null) {
                System.out.println("null");
            } else {
                for (Node node : table[i]) {
                    System.out.println(node.key + " hash - " + node.hashcode);
                }
            }
            System.out.println("----------");
        }
    }

    private LinkedList<Node> getLinkedList(Integer key) {
        int index = getHashCode(key.hashCode());
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        return table[index];
    }

    private Node getNode(Integer key, LinkedList<Node> list) {
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    public Integer get(Integer key) {
        int index = getHashCode(key.hashCode());
        LinkedList<Node> nodes = table[index];
        if (nodes == null) {
            System.out.println("node null");
            return null;
        }

        for (Node v : nodes) {
            if (v.key.equals(key)) {
                return v.value;
            }
        }
        return null;
    }


    private class Node {
        Integer hashcode;
        Integer value;
        Integer key;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.hashcode = key.hashCode();
        }
    }
}
