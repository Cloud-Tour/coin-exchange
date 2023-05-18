package fun.cloudtour.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import fun.cloudtour.domain.SysMenu;
import fun.cloudtour.domain.SysPrivilege;
import fun.cloudtour.model.RolePrivilegesParam;
import fun.cloudtour.service.SysMenuService;
import fun.cloudtour.service.SysPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.SysRolePrivilege;
import fun.cloudtour.mapper.SysRolePrivilegeMapper;
import fun.cloudtour.service.SysRolePrivilegeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class SysRolePrivilegeServiceImpl extends ServiceImpl<SysRolePrivilegeMapper, SysRolePrivilege> implements SysRolePrivilegeService{
    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Autowired
    private SysRolePrivilegeService sysRolePrivilegeService;

    /**
     * 查询角色的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> findSysMenuAndPrivileges(Long roleId) {
        List<SysMenu> list = sysMenuService.list(); // 查询所有的菜单
        // 我们在页面显示的是二级菜单,以及二级菜单包含的权限
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        List<SysMenu> rootMenus = list.stream()
                .filter(sysMenu -> sysMenu.getParentId() == null)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(rootMenus)) {
            return Collections.emptyList();
        }
        // 查询所有的二级菜单
        List<SysMenu> subMenus = new ArrayList<>();
        for (SysMenu rootMenu : rootMenus) {
            subMenus.addAll(getChildMenus(rootMenu.getId(), roleId, list));
        }
        return subMenus;
    }

    /**
     * 查询菜单的子菜单 (递归)
     *
     * @param parentId 父菜单的ID
     * @param roleId   当前查询的角色的ID
     * @return
     */
    private List<SysMenu> getChildMenus(Long parentId, Long roleId, List<SysMenu> sources) {
        List<SysMenu> childs = new ArrayList<>();
        for (SysMenu source : sources) {
            if (source.getParentId() == parentId) { // 找儿子
                childs.add(source);
                source.setChilds(getChildMenus(source.getId(), roleId, sources)); // 给该儿子设置儿子
                List<SysPrivilege> sysPrivileges = sysPrivilegeService.getAllSysPrivilege(source.getId(), roleId);
                source.setSysPrivileges(sysPrivileges); // 该儿子可能包含权限
            }
        }
        return childs;
    }


    /**
     * 给角色授权权限
     *
     * @param rolePrivilegesParam
     * @return
     */
    @Transactional
    @Override
    public boolean grantPrivileges(RolePrivilegesParam rolePrivilegesParam) {
        Long roleId = rolePrivilegesParam.getRoleId(); // 角色Id
        //1 先删除之前该角色的权限
        sysRolePrivilegeService.remove(new LambdaQueryWrapper<SysRolePrivilege>().eq(SysRolePrivilege::getRoleId, roleId));
        // 移除之前的值成功
        List<Long> privilegeIds = rolePrivilegesParam.getPrivilegeIds();
        if (!CollectionUtils.isEmpty(privilegeIds)) {
            List<SysRolePrivilege> sysRolePrivileges = new ArrayList<>();
            for (Long privilegeId : privilegeIds) {
                SysRolePrivilege sysRolePrivilege = new SysRolePrivilege();
                sysRolePrivilege.setRoleId(rolePrivilegesParam.getRoleId());
                sysRolePrivilege.setPrivilegeId(privilegeId);
                sysRolePrivileges.add(sysRolePrivilege);
            }
            // 2 新增新的值
            boolean b = sysRolePrivilegeService.saveBatch(sysRolePrivileges);
            return b;
        }
        // 2 新增该角色的权限
        return true ;
    }
}
