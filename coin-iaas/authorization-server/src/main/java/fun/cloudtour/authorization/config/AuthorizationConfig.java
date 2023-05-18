package fun.cloudtour.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * @author cloudtour
 * @version 1.0
 * @description 鉴权服务配置类
 * @date 2023/4/11 15:59
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    public PasswordEncoder passwordEncoder ;

    @Autowired
    private AuthenticationManager authenticationManager ;

    @Autowired
    private UserDetailsService userDetailsService ;

//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory ;
    /**
     * 配置第三方客户端
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("coin-api") // 第三方客户端的名称
                .secret(passwordEncoder.encode("coin-secret")) //  第三方客户端的密钥
                .scopes("all") //第三方客户端的授权范围
                .authorizedGrantTypes("password","refresh_token")
                .accessTokenValiditySeconds(7 * 24 *3600) // token的有效期
                .refreshTokenValiditySeconds(30 * 24 * 3600)// refresh_token的有效期
                .and()
                .withClient("inside-app")
                .secret(passwordEncoder.encode("inside-secret"))
                .authorizedGrantTypes("client_credentials")
                .scopes("all")
                .accessTokenValiditySeconds(Integer.MAX_VALUE) ;
        super.configure(clients);
    }

    /**
     * 设置授权管理器和UserDetailsService
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(jwtTokenStore()) //设置token 存储在哪里
                .tokenEnhancer(jwtAccessTokenConverter()) ;
        super.configure(endpoints);
    }

    /**
     * jwtTokenStore
     * @return
     */
    public  TokenStore jwtTokenStore(){
        JwtTokenStore jwtTokenStore = new JwtTokenStore(jwtAccessTokenConverter());
        return jwtTokenStore ;
    }

    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter() ;
        // 读取classpath 下面的密钥文件
        ClassPathResource classPathResource = new ClassPathResource("coinexchange.jks");
        // 获取KeyStoreFactory
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,"coinexchange".toCharArray()) ;
        // 给JwtAccessTokenConverter 设置一个密钥对
        tokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair("coinexchange","coinexchange".toCharArray()));
        return  tokenConverter ;
    }

//    public TokenStore redisTokenStore(){
//        return new RedisTokenStore(redisConnectionFactory) ;
//    }
}