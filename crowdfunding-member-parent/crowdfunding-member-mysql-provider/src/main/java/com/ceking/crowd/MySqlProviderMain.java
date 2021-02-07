package com.ceking.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ceking.crowd.mapper")
@SpringBootApplication
public class MySqlProviderMain {
	public static void main(String[] args) {
		SpringApplication.run(MySqlProviderMain.class, args);
	}
}