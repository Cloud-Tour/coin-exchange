package fun.cloudtour.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/21 15:00
 */
@ConfigurationProperties(prefix = "identify")
@Data
public class IdProperties {

    /**
     * 对应你购买的appKey
     */
    private String appKey ;

    /**
     * 对应你购买的appSecret
     */
    private String appSecret ;


    /**
     * 对应你购买的appCode
     */
    private String appCode ;

    /**
     * 认证的url地址
     * 身份认证的URL地址  // https://idcert.market.alicloudapi.com/idcard?idCard=%s&name=%s
     */
    private String url ;
}

