package test;

import main.AfterLast4Array;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class After4Test2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 6, 5, 4, 2, 3, 3}, new int[]{2, 3, 3}},
                {new int[]{4, 3, 7, 5, 4, 4, 3, 2}, new int[]{3, 2}}
        });
    }

    private final int[] in;
    private final int[] out;

    public After4Test2(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private AfterLast4Array afterLast4Test2;

    @Before
    public void startTest() {
        afterLast4Test2 = new AfterLast4Array();
    }

    @Test
    public void testAfterLast4() {
        Assert.assertArrayEquals(out, AfterLast4Array.getAfter4(in));
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        AfterLast4Array.getAfter4(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }
}
