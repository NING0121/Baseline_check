package com.gxa.scdx.cloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gxa.scdx.cloud.user.mapper")
public class ScdxBootCloudApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(ScdxBootCloudApplication.class, args);
    }

}
