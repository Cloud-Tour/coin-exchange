package fun.cloudtour.service.impl;

import fun.cloudtour.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.SysMenu;
import fun.cloudtour.mapper.SysMenuMapper;
import fun.cloudtour.service.SysMenuService;
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService{

    @Autowired
    private SysRoleService sysRoleService ;

    @Autowired
    private SysMenuMapper sysMenuMapper ;
    /**
     * 通过用户的id 查询用户的菜单数据
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> getMenusByUserId(Long userId) {
        // 1 如果该用户是超级管理员->>拥有所有的菜单
        if(sysRoleService.isSuperAdmin(userId)){
            return list() ; // 查询所有
        }
        // 2 如果该用户不是超级管理员->>查询角色->查询菜单
        return sysMenuMapper.selectMenusByUserId(userId);
    }
}
