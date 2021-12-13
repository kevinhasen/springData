package com.yee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: application
 * Description:
 * date: 2021/12/13 11:01
 * 必须要有这个应用类,不然无法扫描包
 * @author Yee
 * @since JDK 1.8
 */
@SpringBootApplication
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class,args);
    }
}
