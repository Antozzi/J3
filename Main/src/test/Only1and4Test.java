package test;

import main.Only1and4;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Only1and4Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true},
                {new int[]{8, 8, 7, 7, 7, 3, 5, 1}, false},
                {new int[]{1, 4, 8, 7}, false}
        });
    }
    private final int[] in;
    private final boolean out;

    public Only1and4Test(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private Only1and4 only1and4Test;

    @Before
    public void startTest() {
        only1and4Test = new Only1and4();
    }

    @Test
    public void testOnly1And4() {
        Assert.assertEquals(Only1and4.only1And4(in), out);
    }
}
