package com.sicau.springbootgraduationproject;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.sicau.*.*.mapper")
@Slf4j
public class SpringbootGraduationprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGraduationprojectApplication.class, args);
        log.info("舞台已搭建，请开始你的表演");
    }

}
