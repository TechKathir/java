package arrays.strings;

public class StringMain {
    public static void main(String[] args) {
        String d = "abaacc";
        for (int i = 0; i < d.length(); i++) {
            for (int i1 = i; i1 < d.length(); i1++) {
                for (int j = i; j <= i1; j++) {
                    System.out.print(d.charAt(j)+",");
                }
                System.out.println();
            }
        }
    }

    public int getInt(char c){
        switch (c){
            case 'a': return 1;
            default: return 0;
        }
    }
}
