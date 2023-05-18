package fun.cloudtour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cloudtour
 * @version 1.0
 * @description 财务系统启动类
 * @date 2023/4/25 15:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FinanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceServiceApplication.class ,args) ;
    }
}
