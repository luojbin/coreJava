import com.loyofo.core.s6_interface.Employee;
import com.loyofo.core.s6_interface.EmpployeeAgeComparator;
import com.loyofo.core.s6_interface.EmpployeeNameComparator;
import com.loyofo.core.s6_interface.Manager;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Envelope1_1Impl;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-08-23 11:18
 */
public class EmployeeTest {

    private int compare(String o1, String e2) {
        return o1.length() - e2.length();
    }
    private static int compareS(String o1, String e2) {
        return o1.length() - e2.length();
    }

    @Test
    public void testComparable() {
        Employee tom = new Employee("Tom", 18, "男");
        Employee jerry = new Employee("Jerry", 21, "男");
        Employee lucy = new Employee("Lucy", 16, "女");

        Employee[] list = new Employee[]{tom, jerry, lucy};

        System.out.println("排序前:");
        for (Employee employee : list){
            System.out.println(employee);
        }

        System.out.println("自动排序后:");
        Arrays.sort(list);
        for (Employee employee : list){
            System.out.println(employee);
        }

        System.out.println("按姓名比较器排序后:");
        Arrays.sort(list, new EmpployeeNameComparator());
        for (Employee employee : list){
            System.out.println(employee);
        }

        System.out.println("按年龄比较器排序后:");
        Arrays.sort(list, new EmpployeeAgeComparator());
        for (Employee employee : list){
            System.out.println(employee);
        }

        System.out.println("按匿名内部类, 名字长度排序后:");
        Arrays.sort(list, new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().length()-o2.getName().length();
            }
        });
        for (Employee employee : list){
            System.out.println(employee);
        }

        // 将方法体放在语句块中, 并显式给出 return 语句
        Comparator<Employee> compareWithLength =  (e1, e2) -> {
            return e1.getName().length()-e2.getName().length();
        };
        Arrays.sort(list, compareWithLength);

        // 如果方法体中只有一行语句, 且该行语句的结果就是要返回的结果, 则可以省略大括号 以及 reutrn 关键字
        // 编译器会自动补上大括号和 return 关键字
        Comparator<Employee> compareWithLength2 =  (e1, e2) -> e1.getName().length()-e2.getName().length();
        Arrays.sort(list, compareWithLength2);

        // Map o = (Employee e1, Employee e2) -> e1.getName().length()-e2.getName().length();
        List list1 = Arrays.asList(list);
        list1.removeIf(e -> e == null);

    }

    @Test
    public void testMethonReference() {
        String[] arr = new String[]{"apple", "pear", "orange", "peach"};
        List<String> list = Arrays.asList(arr);

        // lambda 表达式输出
        list.forEach(s -> System.out.println(s));
        // 方法引用输出, 使用的是 对象::实例方法
        list.forEach(System.out::println);

        // 排序, 使用的是 类名::实例方法
        Arrays.sort(arr, String::compareTo);

        sort(arr, EmployeeTest::compareS);

        sort(arr, this::compare);
        // Arrays.sort(arr, s1, s2 ->)
        // lambda 表达式截取
        list.forEach(s -> System.out.println(s.substring(2)));
    }

    public void sort(String[] arr, Comparator<String> c){
        Arrays.sort(arr, c);
    }



}
