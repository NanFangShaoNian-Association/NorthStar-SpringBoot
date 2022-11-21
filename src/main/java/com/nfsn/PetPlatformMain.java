package com.nfsn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: PetPlatformMain
 * @Author: 团子tz
 * @CreateTime: 2022/10/30 20:37
 * @Description: 想想此类的作用，写在这里吧。
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.nfsn.**.mapper"})
public class PetPlatformMain {
    public static void main(String[] args) {
        SpringApplication.run(PetPlatformMain.class,args);
        System.out.println("test");
    }
}
