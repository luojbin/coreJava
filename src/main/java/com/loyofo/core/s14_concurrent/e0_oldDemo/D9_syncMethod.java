package com.loyofo.core.s14_concurrent.e0_oldDemo;

/**
 * 当多个线程并发操作同一资源时，由于线程切换时机不确定，导致代码执行顺序出现了混乱，严重时可能会导致系统瘫痪。
 * <p>
 * 当一个方法被 synchronized 修饰后那么该方法称为同步方法。多个线程不能同时访问内部。
 * 在方法上使用 synchronized 后，同步监视器对象为当前方法所属对象，即:this
 * <p>
 * 若不加 synchronized, 可能会出现这样的情况(不是必然出现):
 * 当桌子上还剩1个豆子, 线程1进入方法, 此时 beans == 1, 不满足异常条件, 准备执行 beans--;
 * 此时切换到线程2, 因为线程1还未执行 beans--, 线程2看到的 beans 仍然等于 1, 不满足异常条件, 准备执行 beans--;
 * 再次切换到线程1, 线程1继续执行 beans--, 执行后 beans == 0;
 * 再次切换到线程2, 线程2继续执行 beans--, 执行后 beans == -1;
 * 此后无论线程1或线程2, 进入方法后 beans 都小于0, 无法满足异常条件, 无限执行 beans--;
 * <p>
 * 若加了 synchronized, 会按一下逻辑执行:
 * 当桌子上还剩1个豆子, 线程1进入方法, 此时 beans == 1, 不满足异常条件, 准备执行 beans--;
 * 此时尝试切换线程2, 但该方法已被线程1获取了锁, 线程2无法进入, 线程2只能挂起, 等待线程1执行完成;
 * 再次切换到线程1, 线程1继续执行 beans--, 执行后 beans == 0;
 * 再次切换到线程2, 线程2发现 beans == 0, 满足异常条件, 抛出异常, 结束线程2;
 * 再次切换到线程1, 线程1发现 beans == 0, 满足异常条件, 抛出异常, 结束线程1;
 * <p>
 * Thread.yield() 表示告知线程调度器, 可以重新分配 cpu 时间, 以重现线程切换
 */
public class D9_syncMethod {
    public static void main(String[] args) {
        final Table table = new Table();
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    // 请求线程切换
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    // 请求线程切换
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t1.start();
        t2.start();

    }
}

class Table {
    //桌子上有20个豆子
    private int beans = 20;

    // 添加 synchronized 以避免线程安全问题
    public synchronized int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了!");
        }
        // 请求线程切换
        Thread.yield();
        return beans--;
    }
}








