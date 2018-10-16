package temp;

import org.junit.Test;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-10-16 10:22
 */
public class TempTest {
    @Test
    public void testSwitch() {
        System.out.println("1234\tABCD");
        System.out.println("1234\\tABCD");
        System.out.println("1234\\\tABCD");
        System.out.println("1234\\\\tABCD");
    }
}
