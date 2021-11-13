package com.loyofo.core.s6_interface.e7_proxy;

import com.loyofo.core.s6_interface.e7_proxy.api.Dog;
import com.loyofo.core.s6_interface.e7_proxy.api.Hero;
import com.loyofo.core.s6_interface.e7_proxy.api.Spider;
import com.loyofo.core.s6_interface.e7_proxy.api.impl.RealDog;
import com.loyofo.core.s6_interface.e7_proxy.api.impl.RealHero;
import com.loyofo.core.s6_interface.e7_proxy.api.impl.RealSpider;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    @Test
    public void testProxyDemo() {
        Hero hero = createHero();
        heroSaveTheWorld(hero);
    }

    private void heroSaveTheWorld(Hero hero) {
        if (hero instanceof Dog) {
            System.out.println("狗头人永不为奴");
            ((Dog) hero).wang();
            hero.fight();
        } else if (hero instanceof Spider) {
            System.out.println("我是蜘蛛侠不是猪猪侠");
            ((Spider) hero).xiu();
            hero.fight();
        } else {
            System.out.println("不是超人, 等死吧");
        }
    }

    private Hero createHero() {
        int type = (int) (Math.random() * 3);
        switch (type) {
            case 1:
                return (Hero) createProxy(
                        new Object[]{new RealDog(), new RealHero()},
                        new Class[]{Dog.class, Hero.class});
            case 2:
                return (Hero) createProxy(
                        new Object[]{new RealSpider(), new RealHero()},
                        new Class[]{Spider.class, Hero.class});
            default:
                return (Hero) createProxy(
                        new Object[]{new RealHero()},
                        new Class[]{Hero.class});
        }
    }
    public Object createProxy(Object[] source, Class<?>[] interfaces) {
        ProxyHandler handler = new ProxyHandler(source);
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, handler);
    }
}
