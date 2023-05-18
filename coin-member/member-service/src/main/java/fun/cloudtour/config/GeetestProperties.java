package fun.cloudtour.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author cloudtour
 * @version 1.0
 * @description 极验自动装配
 * @date 2023/4/20 23:28
 */
@Data
@ConfigurationProperties(prefix = "geetest")
public class GeetestProperties {

    /**
     * 极验的ID
     */
    private String geetestId ;

    /**
     * 极验的key
     */
    private String geetestKey ;
}
