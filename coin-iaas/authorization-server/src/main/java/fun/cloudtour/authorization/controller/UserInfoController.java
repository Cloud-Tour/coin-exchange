package fun.cloudtour.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/11 17:03
 */
@RestController
public class UserInfoController {

    /**
     * 获取该用户的对象
     * @param principal
     * @return
     */
    @GetMapping("/user/info")
    public Principal usrInfo(Principal principal){ // 此处的principal 由OAuth2.0 框架自动注入
        return principal ;
    }
}
