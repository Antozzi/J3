package main;

public class Only1and4 {

    public static boolean only1And4(int[] arr) {
        boolean i1 = false, i4 = false;
        for (int j : arr) {
            if (j == 1) i1 = true;
            else if (j == 4) i4 = true;
            else return false;
        }
        return i1 && i4;
    }
}
