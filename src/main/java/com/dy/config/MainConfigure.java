package com.dy.config;

import com.dy.bean.Person;
import com.dy.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * 配置类
 * @Configuration:注解说明配置类
 * @ComponentScan(value = "com.dy") :注解说明开启自动扫描容器组件 value表示扫描包路径
 * excludeFilters={} :指定扫描时候排除那些组件 类型为Filter[] type = FilterType.ANNOTATION(排除类型) classes:排除类
 * includeFilters={} :指定扫描时候只扫描哪些组件 类型为Filter[] type = FilterType.ANNOTATION(排除类型) classes:排除类
 * 使用includeFilters 需要关闭默认扫描 即:useDefaultFilters 设置为false
 * @ComponentScans:指定扫描策略 omponentScan[]
 *
 * FilterType 参数说明:
 *  ANNOTATION:按照注解
 *  ASSIGNABLE_TYPE:按照给定类型
 *  ASPECTJ:使用ASPECTJ表达式方式
 *  REGEX:使用正则表达式
 *  CUSTOM:使用自定义方式
 *
 */

@Configuration
@ComponentScan(value = "com.dy",
       /* excludeFilters={
            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes={Controller.class})
        },*/
        includeFilters={
              //@ComponentScan.Filter(type = FilterType.ANNOTATION,classes={Controller.class}),
              //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes={BookService.class})
                @ComponentScan.Filter(type=FilterType.CUSTOM,classes = MyFilterConfigure.class)
        },useDefaultFilters= false)
/*
@ComponecntScans(value={
        @ComponentScan(
                value = "com.dy",
                excludeFilters={
                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes={Controller.class})
                },
                includeFilters={
                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes={Controller.class})
                }
        )
})*/


public class MainConfigure {

    /**
     * @Bean 相当于sping 配置文件中的bean属性注入
     * 类型:方法返回类型,方法名相当于bean属性中id或者通过@Bean(value="person") 此时根据value值为Bean的id
     */
    @Bean(value="person")
    public Person persons(){
        return  new Person("dl",25);
    }
}
