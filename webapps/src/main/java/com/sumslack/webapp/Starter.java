package com.sumslack.webapp;

import antlr.expr.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.sumslack"})
public class Starter {
    public static void main(String[] args) throws UnknownHostException {
        //初始化指标
        DataUtil.init();
        ConfigurableApplicationContext run = SpringApplication.run(Starter.class, args);
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "swagger-ui.html\n\t" +
                "Doc: \t\thttp://" + ip + ":" + port + path + "doc.html\n" +
                "----------------------------------------------------------");
    }
}
