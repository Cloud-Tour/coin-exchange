package fun.cloudtour.config;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/27 21:14
 */
@Configuration
public class IdConfig {

    @Value("${snow.app.id:1}")
    private Integer appId ;

    @Value("${snow.data.id:1}")
    private Integer dataId ;
    /**
     * 雪花算法
     * @return
     */
    @Bean
    public Snowflake snowflake(){
        Snowflake snowflake = new Snowflake(appId,dataId);
        return snowflake ;
    }
}

