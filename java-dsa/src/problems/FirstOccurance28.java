package problems;

public class FirstOccurance28 {
    public static void main(String[] args) {
        String haystack = "aabaaabaac";
        String needle = "aabaac";
        System.out.println(strStr(haystack, needle));
        ;
    }

    public static int strStr(String haystack, String needle) {
        int idx = -1;
        int currIdx = 0;
        for (int i = 0; i < haystack.length(); i++) {
            System.out.println("P = " + i);
            currIdx = 0;
            idx = -1;
            if (needle.charAt(0) == haystack.charAt(i)) {
                currIdx++;
                idx = i;
                if (needle.length() == currIdx) {
                    System.out.println("MATCHED");
                    break;
                }
                if (haystack.length() == i + 1) break;
                for (int i1 = i + 1; i1 < haystack.length(); i1++) {
                    System.out.println(i1);
                    if (needle.charAt(currIdx) == haystack.charAt(i1)) {
                        currIdx++;
                    } else {
                        break;
                    }
                    if (needle.length() == currIdx) {
                        System.out.println("----matched----");
                        break;
                    }
                }
                if (needle.length() == currIdx) {
                    System.out.println("MATCHED");
                    break;
                }
            }
        }

        if (needle.length() != (currIdx)) {
            return -1;
        }
        return idx;
    }
    /*
     * index = 0
     * str = "" if char same append value
     * if next value is not same make str to  "" and idx = -1
     * if lenght == str.length ,check is equals, if equals ruturn idx
     *
     * */
}
