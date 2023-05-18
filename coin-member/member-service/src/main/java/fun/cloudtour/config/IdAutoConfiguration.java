package fun.cloudtour.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/21 15:00
 */
@Configuration
@EnableConfigurationProperties(IdProperties.class)
public class IdAutoConfiguration {

    private static IdProperties idProperties;

    /**
     * 发请求的工具
     */
    private static RestTemplate restTemplate = new RestTemplate();

    public IdAutoConfiguration(IdProperties idProperties) {
        IdAutoConfiguration.idProperties = idProperties;
    }

    /**
     * 用户信息的实名认证
     *
     * @param realName 用户的真实信息
     * @param cardNum  用户的身份证号
     * @return 验证的结果
     */
    public static boolean check(String realName, String cardNum) {

        /**
         * 本次请求是AppCode的形式验证: Authorization:APPCODE 自己的AppCode
         *  -H Authorization:APPCODE 自己的AppCode
         */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "APPCODE " + idProperties.getAppCode());

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                //%s 是变量,
                String.format(idProperties.getUrl(), cardNum, realName),
                HttpMethod.GET,
                new HttpEntity<>(null, httpHeaders),
                String.class
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String body = responseEntity.getBody();
            JSONObject jsonObject = JSON.parseObject(body);
            String status = jsonObject.getString("status");
            if ("01".equals(status)) { // 验证成功
                return true;
            }
        }
        return false;
    }
}