package unionfind;

public class UnionMain {
    public static void main(String[] args) {
        UnionSample unionFind = new UnionSample(10);
        unionFind.union(0, 1);
        unionFind.union(2, 3);
        unionFind.union(4, 5);
        unionFind.union(6, 7);
        unionFind.union(8, 9);
        unionFind.union(9, 6);
        unionFind.union(7, 5);
        unionFind.union(0, 2);
        unionFind.union(3, 4);
        unionFind.union(6, 1);
        unionFind.union(8, 9);
        unionFind.print();
        System.out.println();
        UnionFind unionFind1 = new UnionFind();
        unionFind1.union("a", "b");
        unionFind1.union("c", "d");
        unionFind1.union("e", "f");
        unionFind1.union("g", "h");
        unionFind1.union("i", "j");
        unionFind1.union("j", "g");
        unionFind1.union("h", "f");
        unionFind1.union("a", "c");
//        d - a , e - i
        unionFind1.union("d", "e");
        unionFind1.union("g", "b");
        unionFind1.union("i", "j");
////        h-e , b-
        unionFind1.printUnion();
//        int[] idx = {0, 1, 2, 3, 4, 5, 6, 7};
//        int[] roots = {0, 1, 2, 0, 2, 2, 3, 3};
//        int root = 5;
//        while (root != roots[root]) {
//            root = roots[root];
//        }
//        [8,8,0,0,8,4,8,8,8,8]
//        [8,8,0,0,8,4,8,8,8,8]
//        System.out.println("root - " + root);
    }
}
