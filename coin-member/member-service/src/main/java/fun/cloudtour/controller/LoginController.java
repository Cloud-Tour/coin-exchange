package fun.cloudtour.controller;

import fun.cloudtour.model.LoginForm;
import fun.cloudtour.model.LoginUser;
import fun.cloudtour.model.R;
import fun.cloudtour.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cloudtour
 * @version 1.0
 * @description 登录控制器
 * @date 2023/4/21 11:15
 */
@RestController
@Api(tags = "登录的控制器")
public class LoginController {

    @Autowired
    private LoginService loginService ;

    @PostMapping("/login")
    @ApiOperation(value = "会员的登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginForm",value = "登录的表单参数")
    })
    public R<LoginUser> login(@RequestBody @Validated LoginForm loginForm){
        LoginUser loginUser =  loginService.login(loginForm) ;
        return R.ok(loginUser) ;
    }
}

