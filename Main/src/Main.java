import main.AfterLast4Array;
import main.Only1and4;
import test.After4Test1;
import test.After4Test2;
import test.Only1and4Test;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(AfterLast4Array.getAfter4(new int[]{1, 6, 5, 4, 2, 3, 3})));
        new After4Test1();
        new After4Test2(new int[]{1, 6, 5, 4, 2, 3, 3},new int[]{4, 3, 7, 5, 4, 4, 3, 2});
        System.out.println(Only1and4.only1And4(new int[]{1, 1, 4, 4, 4, 1, 4, 1}));
        new Only1and4Test(new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true);

    }
}
