package hashtable;

public class HashTableLinearProb {
    private final Double LOAD_FACTOR = 0.65;
    private final Integer INITIAL_CAPACITY = 7;
    private final Integer DELETED = -1;
    private Integer[] keys;
    private Integer[] values;
    private double threshold;
    private Integer capacity;
    private int size;

    private double getNewThreshold() {
        return capacity * LOAD_FACTOR;
    }

    public HashTableLinearProb() {
        this.keys = new Integer[INITIAL_CAPACITY];
        this.values = new Integer[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
        this.threshold = getNewThreshold();
        this.size = 0;
    }

    private Integer normalizeIndex(Integer hashKey) {
//        0x7FFFFFFF convert to large positvive number which is 2's complement of hashkey
        return hashKey & 0x7FFFFFFF;
    }

    private Integer getHashIdx(Integer key, int x) {
        return (key.hashCode() + x) % capacity;
    }

    public void print() {
        for (int i = 0; i < keys.length; i++) {
            System.out.println("key - " + keys[i] + " val - " + values[i]);
        }
    }

    public void insert(Integer key, Integer value) {
        System.out.println("---");
//        if (size >= threshold) return;
        int x = 0;
        int index = getHashIdx(key, x);
        int firstDeleteIdx = -1;
        while (true) {
            if (keys[index] == null) {
                if (firstDeleteIdx == -1) {
                    keys[index] = key;
                    values[index] = value;
                    System.out.println("1 INSERT - " + index);
                } else {
                    keys[firstDeleteIdx] = key;
                    values[firstDeleteIdx] = value;
                    System.out.println("2 INSERT - " + index);
                }
                size++;
                return;
            } else if (keys[index] == key) {
                if (firstDeleteIdx == -1) {
                    values[index] = value;
                    System.out.println("1 EQUALS - " + index);
                } else {
                    keys[firstDeleteIdx] = keys[index];
                    values[firstDeleteIdx] = value;
                    keys[index] = DELETED;
                    values[index] = null;
                    System.out.println("2 EQUALS - " + index);
                }
                return;
            } else if (keys[index] == -1) {
                System.out.println("INSIDE -1");
                if (firstDeleteIdx == -1) {
                    System.out.println("DELETE - " + index);
                    firstDeleteIdx = index;
                }
            }
            System.out.println("INCREMENT");
            index = getHashIdx(key, x++);
        }
    }

    public void remove(Integer key) {
        System.out.println("---- R");
        int x = 0;
        Integer index = getHashIdx(key, x);
        while (true) {
            if (keys[index] == null) {
                System.out.println("NOT FOUND");
                return;
            } else if (keys[index] == DELETED) {
                System.out.println("DELETED - " + index);
                index = getHashIdx(key, ++x);
            } else if (keys[index] == key) {
                System.out.println("REMOVE - " + index);
                keys[index] = DELETED;
                values[index] = null;
                return;
            } else {
                System.out.println("INCREMENT");
                index = getHashIdx(key, ++x);
            }
        }
    }

}
