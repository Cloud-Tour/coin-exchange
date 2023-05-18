package fun.cloudtour.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

/**
 * @author cloudtour
 * @version 1.0
 * @description web安全配置类
 * @date 2023/4/11 16:00
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 注入一个验证管理器
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 资源的放行
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // 关闭scrf
        http.authorizeRequests().anyRequest().authenticated();
    }


//    /**
//     * 创建一个测试的UserDetail
//     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        User user = new User("admin", "123456", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))) ;
//        inMemoryUserDetailsManager.createUser(user);
//        return inMemoryUserDetailsManager;
//    }

    /**
     * 密码加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }
}
