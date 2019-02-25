package com.dy.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义过滤注入类
 */
public class MyFilterConfigure implements TypeFilter{
    /**
     *
     * @param metadataReader :读取到当前正在扫描类的信息
     * @param metadataReaderFactory :可以获取其他任何类信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata=metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类信息
        ClassMetadata classMetadata=metadataReader.getClassMetadata();
        //获取类的资源信息(类路径)
        Resource resource=metadataReader.getResource();

        //获取资源类名
        String strName=classMetadata.getClassName();
        System.out.println("--->"+strName);
        //自定义过滤规则
        if(strName.contains("Book")){
            return true;
        }
        return false;
    }
}
