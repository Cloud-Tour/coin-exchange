package fun.cloudtour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author cloudtour
 * @version 1.0
 * @description 定时任务启动类
 * @date 2023/5/2 13:06
 */
@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients
public class TaskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskServiceApplication.class,args) ;
    }
}