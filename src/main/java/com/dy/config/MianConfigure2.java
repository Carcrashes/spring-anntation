package com.dy.config;


import com.dy.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MianConfigure2 {


    //默认是单实例 可以通过@Scope改变

    /**
     *@see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype:多实例
     *@see ConfigurableBeanFactory#SCOPE_SINGLETON singleton 单实例
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request:同一个请求创建一个实例
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session:同一个session创建一个实例
     *
     * @Scope:调整作用域
     * singleton:单实例每次在ioc容器启动会调用方法创建对象添加到容器中,以后每次取值相当于从容器中获取对象(map.get())
     * prototype:多实例在ioc容器启动时候不会取调用方法创建对象添加到ioc容器,每次获取bean对象,才会调用方法获取
     *
     * @Lazy :
     * 懒加载:容器启动时候不加载对象,第一次使用(获取)Bean创建对象,并初始化
     *      单实例:默认在容器启动时候创建对象添加容器中
     *
     */
    @Bean("person")
    //@Scope("prototype")
    @Lazy
    public Person person(){
        System.out.println("容器创建person...");
        return  new Person("dl",12);
    }
}
