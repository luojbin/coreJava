package com.loyofo.spring.demo;

import com.loyofo.spring.bean.ManPerson;
import com.loyofo.spring.bean.WomanPerson;
import com.loyofo.spring.config.TopConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = TopConfig.class)
public class SpringDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TopConfig.class);
        System.out.println("获取了 ac");
        ManPerson man = ac.getBean(ManPerson.class);
        Assert.assertNotNull(man);
    }
    // @Autowired
    // private ManPerson man;
    //
    // @Autowired
    // private WomanPerson woman;
    // @Test
    // public void testP() {
    //     Assert.assertNotNull(man);
    //     Assert.assertNotNull(woman);
    // }
}
