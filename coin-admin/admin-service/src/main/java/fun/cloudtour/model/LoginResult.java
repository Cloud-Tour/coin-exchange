package fun.cloudtour.model;

import fun.cloudtour.domain.SysMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

/**
 * @author cloudtour
 * @version 1.0
 * @description 登录的返回值
 * @date 2023/4/12 17:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {

    /**
     * 登录产生的token
     */
    private String token ;

    /**
     * 前端的菜单数据
     */
    private List<SysMenu> menus ;

    /**
     * 权限数据
     */
    private List<SimpleGrantedAuthority> authorities ;

}
