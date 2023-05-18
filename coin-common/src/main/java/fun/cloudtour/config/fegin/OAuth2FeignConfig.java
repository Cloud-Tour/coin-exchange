package fun.cloudtour.config.fegin;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import fun.cloudtour.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/24 0:27
 */
@Slf4j
public class OAuth2FeignConfig implements RequestInterceptor {

    /**
     * Called for every request. Add data using methods on the supplied {@link RequestTemplate}.
     *
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {
        // 1 从request里面获取之前的Authorizaton头
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        String header = null;
        if (requestAttributes == null) { // 代表之前是有请求的上下文,我们可以进行Token的传递
            log.info("无法获取token,因为没有上下文的环境");
            header = "bearer " + Constants.INSIDE_TOKEN;
        }else{
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            header = request.getHeader(HttpHeaders.AUTHORIZATION);
        }

        if (!StringUtils.isEmpty(header)){
            template.header(HttpHeaders.AUTHORIZATION, header);
            log.info("本次传递的token为{}", header);
        }
    }
}

