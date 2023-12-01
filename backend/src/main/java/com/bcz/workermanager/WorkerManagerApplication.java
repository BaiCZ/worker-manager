package com.bcz.workermanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bcz.workermanager.mapper")
public class WorkerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkerManagerApplication.class, args);
    }

}
