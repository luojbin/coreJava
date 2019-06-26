package com.loyofo.core.s14_concurrent.e14_sync;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<Toy> exchanger = new Exchanger<>();

        // 小明有个变形金刚
        Thread ming = getPersonWithToy(exchanger, "小明", "变形金刚", 100, 3000);

        // 小红有个芭比娃娃
        Thread hong = getPersonWithToy(exchanger, "小红", "芭比娃娃", 150, 9000);

        ming.start();
        hong.start();
    }

    static Thread getPersonWithToy(Exchanger<Toy> exchanger, String name, String toyName, int price, int timeout) {
        Thread t = new Thread(() -> {
            try {
                String ct = Thread.currentThread().getName() + ": ";
                System.out.println(ct + "爸爸带我去买玩具");
                Toy toy = new Toy(toyName, price);
                System.out.println(ct + "买了一个 " + toy);
                Thread.sleep(timeout);
                System.out.println(ct + "玩了两天, 跟小伙伴换一下吧, 有人要换我的" + toyName + "吗");
                toy = exchanger.exchange(toy);
                System.out.println(ct + "换到了, 现在我有一个" + toy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setName(name);
        return t;
    }

}

class Toy {
    private String name;
    private int price;

    public Toy(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Toy{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * 已经批准的额度项下借款, 要作废
     *
     * 公司名称 哈尔滨世纪光谷网络科技有限公司
     * 授信id be73c4b2ada945cc9f82f51797a1b63c
     * 借款id 550edd742c4a46e5bfb1070b1828e0d4
     * 借款编号 2019031200001
     *
     *
     * 1. 借款状态作废
     * 2. 借款合同作废
     * 3. 授信额度恢复, 批准额度2百万 2,000,000.00
     * 4. 授信历史记录,
     */
}