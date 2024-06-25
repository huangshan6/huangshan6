package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@EnableCaching
public class DemoApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);
		ConfigurableEnvironment environment = app.getEnvironment();
		String port = environment.getProperty("server.port");
		String ip = InetAddress.getLocalHost().getHostAddress();
		String jdbcUrl = environment.getProperty("spring.datasource.url");
		log.info("\n----------------------------------------------------------\n" +
						"服务启动!\n" +
						"IP：{}\n" +
						"端口：{}\n" +
						"jdbcUrl：{}\n" +
						"----------------------------------------------------------",
				ip, port, jdbcUrl);
	}

}
