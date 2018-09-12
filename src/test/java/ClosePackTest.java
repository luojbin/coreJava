import org.junit.Test;

/**
 * Created by Ung8023
 * 测试java中的闭包
 */

public class ClosePackTest {
    public static void main(String[] args) {
        Food food = new Food();

        for (int i = 0; i < 21; i++) {
            food.getEat().eat();
            food.currentNum();
        }
        //在内部类是public修饰时，可以通过以下方式
        // Food foodPub = new Food();
        // EatActive eat = foodPub.new EatActive();
        // eat.eat();
    }

    @Test
    public void test() throws Exception{
        String variable = "Outer Method Variable";
        new Thread(new Runnable() {
            String variable = "Runnable Class Member";
            public void run() {
                String variable = "Run Method Variable";
                System.out.println("variable->" + variable);
                System.out.println("this.variable->" + this.variable);
                System.out.println("this.variable->" + ClosePackTest.this.variable);
            }
        }).start();
        Thread.sleep(3000);
    }

    String variable = "outer class variable";
    @Test
    public void test2() {
        String variable = "Outer Method Variable";
        new Thread(() ->{
                System.out.println("variable->\t\t" + variable);
                System.out.println("this.variable->\t" + this.variable);
        }).start();
    }
}

class Food {
    public static final String name = "Food";
    private static int num = 10;

    public Food() {
        System.out.println("Food 构造方法: Delicious Food");
    }

    public Active getEat() {
        return new EatActive();
    }

    private class EatActive implements Active {
        public EatActive() {
            System.out.println("EatActive 构造方法");
        }

        @Override
        public void eat() {
            if (num <= 0) {
                System.out.println("吃货，已经吃没了");
                return;
            }
            num--;
            System.out.println("吃货，你吃了一份了");
        }
    }

    public void currentNum() {
        System.out.println("还剩:" + num + "份");
    }
}

interface Active {

    void eat();
}

