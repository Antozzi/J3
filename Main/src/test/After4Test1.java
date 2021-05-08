package test;

import main.AfterLast4Array;
import org.junit.Before;
import org.junit.Test;

public class After4Test1 {

    private AfterLast4Array afterLast4ArrayTest1;

    @Before
    public void startTest() {
        afterLast4ArrayTest1 = new AfterLast4Array();
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4ArrayEx() {
        AfterLast4Array.getAfter4(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }
}
