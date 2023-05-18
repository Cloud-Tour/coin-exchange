package fun.cloudtour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/13 20:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class ,args) ;
    }
}
