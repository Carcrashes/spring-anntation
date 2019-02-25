package com.dy.test;


import com.dy.bean.Person;
import com.dy.config.MainConfigure;
import com.dy.config.MianConfigure2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IOCTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigure.class);
        //获取所有定义的组件名称
        String [] strs=applicationContext.getBeanDefinitionNames();
        for (String str:strs){
            System.out.println(str);
        }


    }

    /**
     * MianConfigure2中的person方法的@Scope注解是singletion时候
     * applicationContext.getBean("person"):默认是单实例
     * person1==person2-->true
     * MianConfigure2中的person方法的@Scope注解是prototype时候
     *applicationContext.getBean("person"):默认是多实例
     * person1==person2-->false
     *
     */
    @Test
    public void test02(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MianConfigure2.class);
        //获取所有定义的组件名称
        String [] strs=applicationContext.getBeanDefinitionNames();
        for (String str:strs){
            System.out.println(str);
        }

        System.out.println("ioc容器创建完成");
        //测试是否是单实例
        Person person1=(Person)applicationContext.getBean("person");
        //Person person2=(Person)applicationContext.getBean("person");
        //System.out.println(person1==person2);

    }
}
