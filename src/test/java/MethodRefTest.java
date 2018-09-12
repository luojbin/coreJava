import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-11 16:32
 */
public class MethodRefTest {

    // 定义一个实例方法, 参数列表和返回值 同抽象方法一致
    public int compareWithLength(String s1, String s2){
        return s1.length()-s2.length();
    }

    // 定义一个静态方法, 参数列表和返回值, 同抽象方法一致
    public static int staticCompareWithLength(String s1, String s2){
        return s1.length()-s2.length();
    }

    @Test
    public void testSort1() {
        String[] strs = new String[]{"a", "ab", "abc"};
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
    }

    @Test
    public void testSort2() {
        String[] strs = new String[]{"a", "ab", "abc"};
        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());
    }

    @Test
    public void testSort3() {
        String[] strs = new String[]{"a", "ab", "abc"};
        Arrays.sort(strs, MethodRefTest::staticCompareWithLength);

        Arrays.sort(strs, (s1, s2) -> MethodRefTest.staticCompareWithLength(s1, s2));

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return MethodRefTest.staticCompareWithLength(o1, o2);
            }
        });
    }

    @Test
    public void testSort4() {
        String[] strs = new String[]{"a", "ab", "abc"};
        MethodRefTest test = new MethodRefTest();
        Arrays.sort(strs, test::compareWithLength);

        Arrays.sort(strs, (s1, s2) -> test.compareWithLength(s1, s2));

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return test.compareWithLength(o1, o2);
            }
        });
    }

    @Test
    public void testSort5() {
        String[] strs = new String[]{"a", "ab", "abc"};
        MethodRefTest test = new MethodRefTest();
        Arrays.sort(strs, String::compareToIgnoreCase);

        Arrays.sort(strs, (s1, s2) -> s1.compareToIgnoreCase(s2));

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
    }


}
