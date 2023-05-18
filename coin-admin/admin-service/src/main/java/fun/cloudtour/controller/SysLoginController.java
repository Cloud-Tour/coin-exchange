package fun.cloudtour.controller;

import fun.cloudtour.model.LoginResult;
import fun.cloudtour.service.SysLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cloudtour
 * @version 1.0
 * @description 登录控制器
 * @date 2023/4/12 17:49
 */
@RestController
@Api(tags = "登录的控制器")
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "后台管理人员登录")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "username", value = "用户名称"),
                    @ApiImplicitParam(name = "password", value = "用户的密码"),
            }
    )
    public LoginResult login(
            @RequestParam(required = true) String username, // 用户名称
            @RequestParam(required = true) String password  // 用户的密码
    ) {
        return loginService.login(username, password);
    }

}
