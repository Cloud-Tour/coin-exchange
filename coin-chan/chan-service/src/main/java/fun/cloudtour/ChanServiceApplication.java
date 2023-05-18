package fun.cloudtour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.tio.core.Tio;
import org.tio.websocket.common.WsResponse;
import org.tio.websocket.starter.EnableTioWebSocketServer;
import org.tio.websocket.starter.TioWebSocketServerBootstrap;

import java.util.Date;

/**
 * @author cloudtour
 * @version 1.0
 * @description 推送服务
 * @date 2023/5/1 23:53
 */
@SpringBootApplication
@EnableTioWebSocketServer // 开启tio的websocket
public class ChanServiceApplication {

    @Autowired
    private TioWebSocketServerBootstrap bootstrap ;

    public static void main(String[] args) {
        SpringApplication.run(ChanServiceApplication.class ,args) ;
    }

}