package hashtable;

public class HashMain {

    public static void main(String[] args) {
//        HashTable hashTable = new HashTable();
//        hashTable.putSeparateChanning(1, 10);
//        hashTable.putSeparateChanning(2, 1023);
//        hashTable.putSeparateChanning(3, 1043);
//        hashTable.putSeparateChanning(4, 0);
//        hashTable.putLinearProbing(2, 2);
//        hashTable.putLinearProbing(1, 10);
//        hashTable.putLinearProbing(3, 3);
//        hashTable.putLinearProbing(200, 3);
//        hashTable.putLinearProbing(8, 8);
//        hashTable.putLinearProbing(5, 5);
//        hashTable.print();
//        System.out.println(hashTable.size);
//        hashTable.print();
//        key - 21 val - 2
//        key - 1 val - 2
//        key - 22 val - 2
//        key - 23 val - 2
//        key - 24 val - 2
//        key - null val - null
//        key - null val - null
        HashTableLinearProb prob = new HashTableLinearProb();
        prob.insert(1, 2);
        prob.insert(21, 2);
        prob.insert(22, 2);
        prob.insert(23, 2);
//        prob.insert(24, 2);
        prob.remove(22);
        prob.remove(23);
//        prob.remove(24);
        prob.insert(22, 2);
        prob.insert(22, 10);
//        prob.insert(22, 11);
        prob.print();
    }


}
