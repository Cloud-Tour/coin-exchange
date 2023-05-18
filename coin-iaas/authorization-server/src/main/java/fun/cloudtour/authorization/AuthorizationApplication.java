package fun.cloudtour.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cloudtour
 * @version 1.0
 * @description 鉴权管理服务启动类
 * @date 2023/4/11 15:57
 */
@SpringBootApplication
public class AuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class, args);
    }
}
