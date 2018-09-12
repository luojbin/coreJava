import com.loyofo.core.s6_interface.e0_demo.Employee;
import com.loyofo.core.s6_interface.e0_demo.EmpployeeAgeComparator;
import com.loyofo.core.s6_interface.e0_demo.EmpployeeNameComparator;

import java.util.*;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-08-23 11:18
 */
public class Test implements Comparable<Test>{

    private int instanceCompare(String o1, String e2) {
        return o1.length() - e2.length();
    }

    @Override
    public int compareTo(Test o1) {
        return 1;
    }

    private static int staticCompare(String o1, String e2) {
        return o1.length() - e2.length();
    }

    @org.junit.Test
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

        // TODO_LUOJBIN:
        System.out.println();
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

    @org.junit.Test
    public void testMethonReference() {
        String[] arr = new String[]{"apple", "pear", "orange", "peach"};
        List<String> list = Arrays.asList(arr);

        // lambda 表达式输出
        list.forEach(s -> System.out.println(s));
        // 方法引用输出, 使用的是 对象::实例方法
        list.forEach(System.out::println);

        // 数据准备
        Test et = new Test();
        Employee e = new Employee("aa", 12, "df");
        Employee f = new Employee("aa", 12, "df");
        Employee g = new Employee("aa", 12, "df");
        Employee[] es = {e,f,g};

        //region Description
        Test et1 = new Test();
        Test et2 = new Test();
        Test et3 = new Test();
        Test[] ets ={et1, et2, et3};

        /*
         * Arrays.sort(array, Comparator)
         * 此处需要一个 Comparator, 然后会调用其中的 compare (t1, t2) 方法, 是一个双参数方法
         * 传统方式是传入一个匿名内部类, 实现 compare(t1,t2) 方法
         */
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        /*
         * 但其实有用的部分, 只是 compare 方法的方法体, 其余内容都是为了满足语法需要的结构
         * 为了减少格式代码, 提高可读性, 可以将方法体以 lambda 表达式的形式给出
         * 这里可以使用一个 lambda 表达式, 该表达式的内容, 将成为 compare(t1, t2) 方法的方法体
         * 此处的 lambda 表达式, 参数列表与 Comparator.compare 方法保持一致, 因为两者是等价的.
         */
        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
        /* 类型明确时, 可以省略参数类型声明 */
        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());



        /*
         * 函数式接口
         * 在上例中, lambda 并没有明确告知它要替代哪一个方法, 但是却能知道它就是 compare 方法
         * 这是因为 Arrays.sort(arr, Comparator) 中, Comparator 就只有一个 compare 方法
         * 这种只有一个抽象方法的接口, 才能唯一确定 lambda 到底是谁, 因此 lambda 也只能用来替代这种只有一个方法的接口
         * 这样的接口, 原本需要的对象可以被一个函数替代, 称为函数式接口
         */

        // 类名::静态方法
        // 需要: new Comparator().compare(String s1, String s2)
        // 提供: Test.staticCompare(String s1, String s2)
        // staticCompare(s1, s2), 与 Comparator.compare(s1, s2) 一样
        System.out.println("===========类型::静态方法=========");
        Arrays.sort(arr, Test::staticCompare);
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Test.staticCompare(o1, o2);
            }
        });

        // 对象::实例方法
        // 需要: new Comparator().compare(String s1, String s2)
        // 提供: new Test().instanceCompare(String o1, String e2)
        // instanceCompare(s1, s2), 与 Comparator.compare(s1, s2) 一样
        System.out.println("===========对象::实例方法=========");
        Arrays.sort(arr, new Test()::instanceCompare);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return new Test().instanceCompare(o1, o2);
            }
        });

        // 类名::实例方法
        // 需要: new Comparator().compare(String s1, String s2)
        // 提供: s1.compareTo(String, s2)
        // s1.compareTo(s2), 这与 Comparator.compare(s1, s2) 不同, 但也有 s1, s2 两个部分
        // 因此在执行时, 会将 Comparator.compare(s1, s2) 的第一个参数作为这个方法的调用方, 第二个参数作为方法参数
        System.out.println("===========类型::实例方法=========");
        Arrays.sort(arr, String::compareTo);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Arrays.sort(es, Employee::compareTo);
        Arrays.sort(es, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareTo(o2);
            }
        });

        Arrays.sort(es, Employee::compareToBYname);
        Arrays.sort(es, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareToBYname(o2);
            }
        });
        Arrays.sort(ets, Test::compareTo);
        Arrays.sort(ets, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return o1.compareTo(o2);
            }
        });

        // String s = "sss";
        // Arrays.sort(arr, s::compareTo);

        // Arrays.sort(arr, s1, s2 ->)
        // lambda 表达式截取
        list.forEach(s -> System.out.println(s.substring(2)));
    }

    public void sort(String[] arr, Comparator<String> c){
        Arrays.sort(arr, c);
    }
    public static void staticSort(String[] arr, Comparator<String> c){
        Arrays.sort(arr, c);
    }

    @org.junit.Test
    public void teststr() {
        int a = 1;
    }

    @org.junit.Test
    public void testLam() {

    }
}


