package fun.cloudtour.config;

import cn.hutool.core.lang.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cloudtour
 * @version 1.0
 * @description id生成器
 * @date 2023/4/23 17:04
 */
@Configuration
public class IDGenConfig {

    @Value("${id.machine:0}")
    private int machineCode;

    @Value("${id.app:0}")
    private int appCode;

    // 雪花算法
    @Bean
    public Snowflake snowflake() {
        Snowflake snowflake = new Snowflake(appCode, machineCode);
        return snowflake;
    }
}
