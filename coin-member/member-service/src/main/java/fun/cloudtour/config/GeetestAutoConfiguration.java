package fun.cloudtour.config;

import fun.cloudtour.geetest.GeetestLib;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/20 23:32
 */
@Configuration
@EnableConfigurationProperties(GeetestProperties.class)
public class GeetestAutoConfiguration {

    private GeetestProperties geetestProperties ;

    public GeetestAutoConfiguration(GeetestProperties geetestProperties){
        this.geetestProperties = geetestProperties ;
    }

    @Bean
    public GeetestLib geetestLib(){
        GeetestLib geetestLib = new GeetestLib(geetestProperties.getGeetestId(), geetestProperties.getGeetestKey());
        return geetestLib ;
    }
}

