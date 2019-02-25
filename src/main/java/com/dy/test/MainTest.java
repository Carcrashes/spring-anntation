package com.dy.test;

import com.dy.bean.Person;
import com.dy.config.MainConfigure;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;

public class MainTest {

    public static void main(String[] args) {

        /**
         * 编程式开发
         * 1.通过ClassPathXmlApplicationContext获取ApplicationContext容器对象
         * 2.通过bean的id获取person对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/beans.xml");
        Object person=(Person) applicationContext.getBean("person");
        System.out.println(person.toString());
         */


        /**
         *声明式获取bean
         * 1.通过AnnotationConfigApplicationContext(MainConfigure.class)获取ApplicationContext容器对象
         * 2.通过MainConfigure方法名person获取person对象
         */
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(MainConfigure.class);
        Object person=applicationContext.getBean("person");
        System.out.println(person.toString());

        //根据类获取容器组件名称
        String []strs= applicationContext.getBeanNamesForType(Person.class);
        for (String str:strs){
            System.out.println(str);
        }
    }
}
