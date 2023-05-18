package fun.cloudtour.service;

import fun.cloudtour.model.LoginForm;
import fun.cloudtour.model.LoginUser;

public interface LoginService {

    /**
     * 会员的登录
     *
     * @param loginForm 登录的表单参数
     * @return 登录的结果
     */
    LoginUser login(LoginForm loginForm);
}

