package com.sxd.server.mytime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.sxd.server.mytime")
@SpringBootApplication
public class MyTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTimeApplication.class, args);
    }
}

