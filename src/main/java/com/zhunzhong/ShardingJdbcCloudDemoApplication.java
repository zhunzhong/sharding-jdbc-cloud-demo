package com.zhunzhong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class ShardingJdbcCloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcCloudDemoApplication.class, args);
	}

}
