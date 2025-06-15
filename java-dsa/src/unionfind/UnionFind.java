package unionfind;

import java.util.*;

public class UnionFind {
    List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
    List<Integer> union = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public UnionFind() {
        for (int i = 0; i < list.size(); i++) {
            union.add(i);
            size.add(1);
        }
    }

    public void union(String val1, String val2) {
        int idx1 = list.indexOf(val1);
        int idx2 = list.indexOf(val2);
        int root1 = findRootNode(idx1);
        int root2 = findRootNode(idx2);
        int rootLenght1 = size.get(root1);
        int rootLenght2 = size.get(root2);
//        System.out.println(root1 + " - " + root2);
//        System.out.println(rootLenght1 + " - " + rootLenght2);
//        System.out.println("-----");
        if (root1 == root2) return;
        if (rootLenght1 < rootLenght2) {
            union.set(root1, root2);
            incrementSize(root1, root2);
        } else {
            union.set(root2, root1);
            incrementSize(root2, root1);
        }
    }

    public void incrementSize(int from, int to) {
        size.set(to, size.get(to) + size.get(from));
//        size.set(from, 0);
    }

    public int findRootNode(int unionIdx) {
        int root = unionIdx;
        while (root != union.get(root)) {
            root = union.get(root);
        }
//        compress
        while (unionIdx != root) {
            int nextRoot = union.get(unionIdx);
            union.set(unionIdx, root);
            unionIdx = nextRoot;
        }
        return root;
    }

    public int getUnionLenght(int unionIdx) {
        return union.stream().filter(v -> v == unionIdx).toList().size();
    }

    public void printUnion() {
        List<Integer> integers = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < union.size(); i++) {
            integers.add(i);
            String root = list.get(union.get(i));
            if (!map.containsKey(root)) {
                map.put(root, 0);
            }
            map.put(root, map.get(root) + 1);
            System.out.print(list.get(i) + "-" + root + " ");
        }
        System.out.println();
        System.out.println("idx - " + integers.toString());
        System.out.println("uno - " + union.toString());
        System.out.println("siz - " + size.toString());
        System.out.println(map.toString());
    }

    /**
     * check for parent node ?  map under the parent node(root parent)
     * find the root parent to map with parent node
     * if both has parent node find the largest union
     * */

}
