package com.haibo.test;

import com.xdbigdata.framework.mybatis.MybatisApplication;
import com.xdbigdata.framework.web.WebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Import({MybatisApplication.class, WebApplication.class})
@MapperScan("com.haibo.test.mapper")
@EnableScheduling
public class Application {

	public static void main(String[] args)  {
		SpringApplication.run(Application.class, args);
	}

}
