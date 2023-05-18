package fun.cloudtour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cloudtour
 * @version 1.0
 * @description 撮合系统
 * @date 2023/4/30 20:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MatchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchServiceApplication.class ,args) ;
    }
}

